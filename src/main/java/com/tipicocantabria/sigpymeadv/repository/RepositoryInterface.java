package com.tipicocantabria.sigpymeadv.repository;


import java.sql.SQLException;
import java.util.ArrayList;

public interface RepositoryInterface {




    <T> ArrayList<Object> metodoExecute(Class clase, String sql) throws SQLException;
    <T> ArrayList<Object> metodoExecuteParametros(Class clase, String sql, String[] parametros) throws SQLException;



    public  <T> void metodoUpdate(Class<T> clase, String sql);
    public  <T> void metodoUpdateParametros(Class<T> clase, String sql, String[] parametros);
}