package service;

import dao_.DAO.BasicDAO;
import utils.IOUtils;

import java.sql.SQLException;
import java.util.List;

public class BasicService {
    /**
     * Display all rows under all columns or passed columns of a table.
     * @param table name of the table for query
     * @param clazz domain class of a row in the table
     * @param columnNames names of the columns for display
     * @param <T> domain class of a row in the table
     */

    public <T> boolean displayTheList(String table, Class<T> clazz, String... columnNames) {
        String query = "SELECT ";
        String[] columnNamesInFunction = null;

        if (columnNames.length == 0) {
            query += "* FROM " + table;
            try {
                columnNamesInFunction = BasicDAO.getColumns(query);
                // If there's exception getting columns, exit the function and return false.
            } catch (SQLException throwables) {
                return false;
            }

        } else {
            columnNamesInFunction = columnNames;

            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                if (i != length - 1) {
                    query += (columnNames[i] + ", ");
                } else
                    query += columnNames[i];
            }
            query += " FROM " + table;
        }

        try {
            List<T> rows = BasicDAO.queryRows(query, clazz);
            System.out.println("++++++++++++++++++++++++++");
            IOUtils.displayColumns(columnNamesInFunction);
            IOUtils.displayResultList(rows);
            System.out.println("++++++++++++++++++++++++++");

            Thread.sleep(2000);

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } catch (InterruptedException e) {
            return true;
        }
    }
}
