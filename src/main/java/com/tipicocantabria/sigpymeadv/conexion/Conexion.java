package com.tipicocantabria.sigpymeadv.conexion;
import java.sql.Connection;
import java.sql.DriverManager;

// No se te olvide introducir en Path el controlador JDBC de Filemaker

public class Conexion {

    static String bd = "prueba"; // Cambiar -prueba- por el nombre de tu base de datos
    static String url = "jdbc:filemaker://192.168.1.38/" + bd + "?SocketTimeout=3000"; // Cambiar -192.168.1.38- por tu
    // IP o dominio donde tienes
    // alijada tu base de datos
    static String userName; // cambia -prueba- por tu usuario de la base de datos
    static String password; // cambia -prueba- por tu password de la base de datos

    public static String estado;


    // metodo para establecer conexion a la base de datos
    public static Connection conexionFilemaer() {
        Connection conn = null;


        try {
            // Le indicamos cual es el controlador que tiene que utilizar
            Class.forName("com.filemaker.jdbc.Driver");
            // Creamos la conexion
            conn = DriverManager.getConnection(url, userName, password);
            estado = "si";
            System.out.println("Conectado");
            // retornamos la conexion
            return conn;

        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public static void setUserName(String userName) {
        Conexion.userName = userName;
    }

    public static void setPassword(String password) {
        Conexion.password = password;
    }
}