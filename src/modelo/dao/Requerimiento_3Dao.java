package utp.misiontic2022.c2.p77.reto4.modelo.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import utp.misiontic2022.c2.p77.reto4.modelo.vo.Requerimiento_3;
import utp.misiontic2022.c2.p77.reto4.util.JDBCUtilities;

public class Requerimiento_3Dao {
    public ArrayList<Requerimiento_3> requerimiento3() throws SQLException {
    
        ArrayList<Requerimiento_3> registrosBS = new ArrayList<>();
        Connection conexion = JDBCUtilities.getConnection();

        try {
            String sql= " SELECT  P.ID_Proyecto as id,p.Ciudad as Ci, p.Clasificacion as Cl ,sum(c.Cantidad * mc.Precio_Unidad ) as  Costo_Proyecto" 
                       +" from  MaterialConstruccion mc natural join Compra c natural join Proyecto p " 
                       +" WHERE p.Ciudad in ('Salento','Armenia')"
                       +"GROUP  BY p.ID_Proyecto "
                       +"having Costo_Proyecto >85000 "
                       +"ORDER  BY p.Ciudad ,p.Clasificacion";

            Statement statement = conexion.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {
                Requerimiento_3 registro3 = new Requerimiento_3();
                registro3.setID_Proyecto(rs.getInt("id"));
                registro3.setCiudad(rs.getString("Ci"));
                registro3.setClasificacion(rs.getString("Cl"));
                registro3.setCostoP(rs.getInt("Costo_Proyecto"));

                registrosBS.add(registro3);
            }
            rs.close();
            statement.close();
        } catch (SQLException e) {
            System.err.println("Error en la consulta: " + e);
        }finally{
            if (conexion != null) {
                conexion.close();
            }
        }

        return registrosBS;
    }
}