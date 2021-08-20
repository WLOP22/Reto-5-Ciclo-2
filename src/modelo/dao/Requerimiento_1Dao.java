package utp.misiontic2022.c2.p77.reto4.modelo.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import utp.misiontic2022.c2.p77.reto4.modelo.vo.Requerimiento_1;
import utp.misiontic2022.c2.p77.reto4.util.JDBCUtilities;

public class Requerimiento_1Dao {
    public ArrayList<Requerimiento_1> requerimiento1() throws SQLException {
      
        ArrayList<Requerimiento_1> registrosBS = new ArrayList<>();
        Connection conexion = JDBCUtilities.getConnection();
        
        try {
            String sql = "SELECT l.Nombre ||' '|| l.Primer_Apellido as Lider, l.Cargo as 'Cargo',COUNT(p.ID_Lider) as 'Proyectos' "
            +" FROM Lider l inner join Proyecto p"
            +" WHERE p.Constructora ='Edificios y Edificios' "
            +" AND p.ID_Lider =l.ID_Lider "
            +" AND p.ID_Lider =l.ID_Lider"
            +" GROUP BY p.ID_Lider "
            +" ORDER BY l.Cargo,Lider ";

            Statement statement = conexion.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {
                Requerimiento_1 registro1 = new Requerimiento_1();
                registro1.setNombre(rs.getString("Lider"));
                registro1.setCargo(rs.getString("Cargo"));
                registro1.setProyectosN(rs.getInt("Proyectos"));

                registrosBS.add(registro1);
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