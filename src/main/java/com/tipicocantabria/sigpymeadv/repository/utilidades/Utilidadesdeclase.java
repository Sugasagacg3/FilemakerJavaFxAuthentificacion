package com.tipicocantabria.sigpymeadv.repository.utilidades;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Utilidadesdeclase {

    private static <T> String atributosParaConsulta(Class<T> clase) throws IllegalAccessException {
        Field[] fields = clase.getDeclaredFields();
        int n = 0;
        try {
            for (Field field : fields) {
                n++;
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        String atributos[];
        atributos = new String[n];
        int j = 0;
        for (Field field : fields) {
            try {

                String fieldName = field.getName();

                if (fieldName != null) {
                    atributos[j] = fieldName;
                }
                j++;

            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        }
        String consulta = "Select ";

        for (Field field : fields) {
            try {
                String fieldName = field.getName();

                // System.out.println(fieldName + ":" + fieldValue);
                consulta = consulta + fieldName + ", ";
            } catch (Exception e) {
                System.out.print(e.toString());
            }

        }
        consulta = quitarUltimacoma(consulta) + " FROM " + clase.getSimpleName();

        return consulta;
    }

    // Metodo para quitar la ultima coma en las consultas Select de mostrar todo.
    // Despues del Select, añade los atributos o columnas que queremos obtener
    // separados por una coma.
    private static String quitarUltimacoma(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        return str.substring(0, str.length() - 2);
    }

    protected ArrayList<Object> maperObjeto(Class clase, ResultSet resultado) throws SQLException {

        Field[] entityFields = clase.getDeclaredFields();
        String[] fields = new String[entityFields.length];
        ResultSetMetaData metadataResultSet = resultado.getMetaData();
        ArrayList<Object> resultadoFinal = new ArrayList<>();

        try {

            while (resultado.next()) {
                Object[] fieldValores = new Object[fields.length];
                Map<String, String> map = new HashMap<String, String>();
                int numeroColumnas = metadataResultSet.getColumnCount();
				/*int numeroFilas=resultado.getRow();
					System.out.println(numeroColumnas);
				System.out.println(numeroFilas);
				*/

                for (int i = 1; i <= numeroColumnas; i++) {

                    try {
                        map.put(metadataResultSet.getColumnName(i),
                                resultado.getString(metadataResultSet.getColumnName(i)));
						/* System.out.println("Columna  " + metadataResultSet.getColumnName(i) + "  Valor  "
							+ resultado.getString(metadataResultSet.getColumnName(i)));
							*/
                    } catch (Exception e) {
                        System.out.print(e.toString());
                    }

                }resultadoFinal.add(map);
            }

        } catch (Exception e) {

        }

        return resultadoFinal;

    }
}