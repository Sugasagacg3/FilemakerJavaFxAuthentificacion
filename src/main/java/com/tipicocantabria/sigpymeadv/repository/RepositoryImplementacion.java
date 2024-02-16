package com.tipicocantabria.sigpymeadv.repository;


import com.tipicocantabria.sigpymeadv.conexion.Conexion;
import com.tipicocantabria.sigpymeadv.repository.utilidades.Utilidadesdeclase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;




public class RepositoryImplementacion extends Utilidadesdeclase implements RepositoryInterface {

    @Override
    public <T> ArrayList<Object> metodoExecute(Class clase, String sql) throws SQLException {
        Connection cnn;
        cnn = Conexion.conexionFilemaer();
        Statement st;
        ResultSet datos = null;
        try {
            st = cnn.createStatement();
            datos = st.executeQuery(sql);

        } catch (SQLException e) {
            System.out.print(e);
        }

        ArrayList<Object> resultadoFin = maperObjeto(clase, datos);

        return resultadoFin;
    }

    @Override
    public <T> ArrayList<Object> metodoExecuteParametros(Class clase, String sql, String[] parametros)
            throws SQLException {

        Connection cnn;
        cnn = Conexion.conexionFilemaer();
        PreparedStatement st;
        ResultSet datos = null;
        try {
            st = cnn.prepareStatement(sql);

            for (int i = 0; i > parametros.length; i++) {
                st.setString(i + 1, parametros[1]);
            }
            datos = st.executeQuery();

        } catch (SQLException e) {
            System.out.print(e);
        }
        ArrayList<Object> resultadoFin = maperObjeto(clase, datos);

        return resultadoFin;
    }

    @Override
    public <T> void metodoUpdate(Class<T> clase, String sql) {

        Connection cnn;
        cnn = Conexion.conexionFilemaer();
        Statement st;

        try {
            st = cnn.createStatement();
            st.executeUpdate(sql);

        } catch (SQLException e) {
            System.out.print(e);
        }

    }

    @Override
    public <T> void metodoUpdateParametros(Class<T> clase, String sql, String[] parametros) {

        Connection cnn;
        cnn = Conexion.conexionFilemaer();
        PreparedStatement st;
        try {
            st = cnn.prepareStatement(sql);

            for (int i = 0; i < parametros.length; i++) {
                st.setString(i + 1, parametros[i]);
            }
            st.executeUpdate();

        } catch (SQLException e) {
            System.out.print(e);
        }

    }

}