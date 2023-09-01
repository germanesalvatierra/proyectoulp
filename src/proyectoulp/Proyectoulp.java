package proyectoulp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Proyectoulp {

    public static void main(String[] args) {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            Connection conexion = DriverManager.getConnection("jdbc:mariadb://localhost:3306/proyectoulp", "root", "");
//INSERTAR 3 ALUMNOS
            /* String sql = "insert into alumno(dni,apellido,nombre,fechaNacimiento,estado) "
                    + "values(25678912,'Martinez','Ana','2000-11-23',1)";
            PreparedStatement ps = conexion.prepareStatement(sql);
            int registros = ps.executeUpdate();
            System.out.println(registros);
            sql = "insert into alumno(dni,apellido,nombre,fechaNacimiento,estado) "
                    + "values(25678123,'Mendez','Juan','2002-1-23',1)";
             ps = conexion.prepareStatement(sql);
             registros = ps.executeUpdate();
            System.out.println(registros);
            sql = "insert into alumno(dni,apellido,nombre,fechaNacimiento,estado) "
                    + "values(25678321,'Aguirre','Carlos','2004-12-23',1)";
             ps = conexion.prepareStatement(sql);
             registros = ps.executeUpdate();
            System.out.println(registros);*/
            //INSERTAR 4 MATERIAS
            /*String sql="insert into materia(nombre,anio,estado) values('Matematicas',1,1)";
           PreparedStatement ps=conexion.prepareStatement(sql);
           int registros = ps.executeUpdate();
            System.out.println(registros);
            sql="insert into materia(nombre,anio,estado) values('Progamacion 1',1,1)";
           ps=conexion.prepareStatement(sql);
            registros = ps.executeUpdate();
            System.out.println(registros);
            sql="insert into materia(nombre,anio,estado) values('Base de Datos 1',1,1)";
           ps=conexion.prepareStatement(sql);
            registros = ps.executeUpdate();
            System.out.println(registros);
            sql="insert into materia(nombre,anio,estado) values('Idioma 1',1,1)";
           ps=conexion.prepareStatement(sql);
            registros = ps.executeUpdate();
            System.out.println(registros);*/
            //INSCRIBIR 3 ALUMNOS EN 2 MATERIAS CADA UNO
            /*String sql = "insert into inscripcion(nota,idAlumno,idMateria)values(9,1,1)";
            PreparedStatement ps = conexion.prepareStatement(sql);
            int registros = ps.executeUpdate();
            System.out.println(registros);
            sql = "insert into inscripcion(nota,idAlumno,idMateria)values(10,1,2)";
            ps = conexion.prepareStatement(sql);
            registros = ps.executeUpdate();
            System.out.println(registros);
            sql = "insert into inscripcion(nota,idAlumno,idMateria)values(8,2,2)";
            ps = conexion.prepareStatement(sql);
            registros = ps.executeUpdate();
            System.out.println(registros);
            sql = "insert into inscripcion(nota,idAlumno,idMateria)values(7,2,3)";
            ps = conexion.prepareStatement(sql);
            registros = ps.executeUpdate();
            System.out.println(registros);
            sql = "insert into inscripcion(nota,idAlumno,idMateria)values(6,3,2)";
            ps = conexion.prepareStatement(sql);
            registros = ps.executeUpdate();
            System.out.println(registros);
            sql = "insert into inscripcion(nota,idAlumno,idMateria)values(7,3,3)";
            ps = conexion.prepareStatement(sql);
            registros = ps.executeUpdate();
            System.out.println(registros);*/
            //LISTAR ALUMNOS CALIFICACION>8
            String sql="select distinct a.idAlumno,nombre,apellido,dni,fechaNacimiento,estado from alumno a "
                    + "join inscripcion i on(a.idAlumno=i.idAlumno) where i.nota>8";
            PreparedStatement ps=conexion.prepareStatement(sql);
            ResultSet resultado=ps.executeQuery();
            while(resultado.next()){
                System.out.println("idAlumno: "+resultado.getInt("idAlumno"));
                System.out.println("Nombre: "+resultado.getString("nombre"));
                System.out.println("Apellido: "+resultado.getString("apellido"));
                System.out.println("D.N.I.: "+resultado.getInt("dni"));
                System.out.println("Fecha Nacimiento: "+resultado.getDate("fechaNacimiento"));
                System.out.println("Estado: "+resultado.getBoolean("estado"));
            }
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "error de carca driver" + ex.getMessage());

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "error de conexion" + ex.getMessage());
        }

    }

}
