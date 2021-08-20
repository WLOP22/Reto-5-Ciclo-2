package utp.misiontic2022.c2.p77.reto4.modelo.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import utp.misiontic2022.c2.p77.reto4.modelo.vo.Requerimiento_2;
import utp.misiontic2022.c2.p77.reto4.util.JDBCUtilities;

public class Requerimiento_2Dao {
    public ArrayList<Requerimiento_2> requerimiento2() throws SQLException {
    
        ArrayList<Requerimiento_2> registrosBS = new ArrayList<>();
        Connection conexion = JDBCUtilities.getConnection();

        try {
            String sql= " SELECT  mc.ID_MaterialConstruccion as id,mc.Nombre_Material as NM ,c.Cantidad ,mc.Precio_Unidad ," 
                    +" c.Cantidad * mc.Precio_Unidad as Precio_Total "
                    +"from  MaterialConstruccion mc natural join Compra c natural join Proyecto p" 
                    +" WHERE  p.ID_Proyecto in (19, 24, 37, 39, 58, 63)"
                    + "and  mc.ID_MaterialConstruccion = c.ID_MaterialConstruccion "
                    +" ORDER  by p.ID_Proyecto  ASC ,mc.Precio_Unidad DESC ";
            Statement statement = conexion.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {
                Requerimiento_2 registro2 = new Requerimiento_2();
                registro2.setID_MaterialConstruccion(rs.getInt("id"));
                registro2.setNombreMaterial(rs.getString("NM"));
                registro2.setCantidad(rs.getInt("Cantidad"));
                registro2.setPrecioU(rs.getInt("Precio_Unidad"));
                registro2.setPrecioT(rs.getInt("Precio_Total"));

                registrosBS.add(registro2);
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