package common.maven.database;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

@SuppressWarnings("SqlResolve")
public class Test {
    public static void main(String... args) throws IOException, SQLException, ClassNotFoundException {
        gaussTest();
    }

    private static void oracleTest() throws ClassNotFoundException, IOException, SQLException {
        InputStream in = ClassLoader.getSystemResourceAsStream("system.properties");
        Properties properties = new Properties();
        properties.load(in);
        String oracleUrl = properties.getProperty("oracleUrl");
        String oracleUserName = properties.getProperty("oracleUserName");
        String oraclePassword = properties.getProperty("oraclePassword");

        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection conn = DriverManager.getConnection(oracleUrl, oracleUserName, oraclePassword);
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery("select sysdate from dual");
        if (resultSet.next()) {
            System.out.println(resultSet.getString(1));
        }
        statement.close();
        conn.close();
    }

    private static void gaussTest() throws ClassNotFoundException, IOException, SQLException {
        InputStream in = ClassLoader.getSystemResourceAsStream("system.properties");
        Properties properties = new Properties();
        properties.load(in);
        String oracleUrl = properties.getProperty("gaussDbUrl");
        String oracleUserName = properties.getProperty("gaussDbUserName");
        String oraclePassword = properties.getProperty("gaussDbPassword");

        //Class.forName("org.postgresql.Driver");
        Class.forName("com.huawei.gauss200.jdbc.Driver");
        Connection conn = DriverManager.getConnection(oracleUrl, oracleUserName, oraclePassword);
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery("select sysdate");
        if (resultSet.next()) {
            System.out.println(resultSet.getString(1));
        }
        statement.close();
        conn.close();
    }
}
