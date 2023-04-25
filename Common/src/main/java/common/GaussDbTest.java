package common;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GaussDbTest {
    public static void main(String... args) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            Class.forName("org.postgresql.Driver");

            connection = DriverManager.getConnection("jdbc:gaussdb://172.22.70.43:25308/cgodw", "cfps6", "infosky@65669939");
            statement = connection.prepareStatement("select * from ods_errlog where recid = 245876");
            resultSet = statement.executeQuery();

            List<String> fieldList = new ArrayList<>();
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            int columnCount = resultSetMetaData.getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                fieldList.add(resultSetMetaData.getColumnName(i).toUpperCase());
            }

            if (resultSet.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    System.out.print(fieldList.get(i - 1) + ":");
                    System.out.println(resultSet.getString(fieldList.get(i - 1)));
                }
            }

//            DatabaseMetaData metaData = connection.getMetaData();
//            ResultSet tableSet = metaData.getTables(null, null, "ods_errlog", new String[]{"TABLE"});
//            if (tableSet.next()) {
//                ResultSet columnResultSet = metaData.getColumns(null, null, "ods_errlog", null);
//                while (columnResultSet.next()) {
//                    String columnName = columnResultSet.getString("COLUMN_NAME");
//                    String columnType = columnResultSet.getString("TYPE_NAME");
//                    System.out.println(columnName + ":" + columnType);
//                }
//            }
        } catch (Exception ex) {
            System.out.println(Arrays.toString(ex.getStackTrace()));
        } finally {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }
}
