package common;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@SuppressWarnings("all")
public class MultiThreadTest {
    public static void main(String[] args) throws SQLException {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:oracle:thin:@172.22.70.68:1521:orcl", "cfps6_ckg_test", "cargo");

            Connection finalConnection = connection;
            Callable<Long> callable = () -> {
                Statement statement = finalConnection.createStatement();
                statement.execute("insert into t_usr_test(recid, str) values(" + Thread.currentThread().getId() + 1 + "," + Thread.currentThread().getId() + ")");
                statement.execute("insert into t_usr_test(recid, str) values(" + Thread.currentThread().getId() + 2 + "," + Thread.currentThread().getId() + ")");
                statement.close();
                return Thread.currentThread().getId();
            };
            Callable<Long> callable2 = () -> {
                Statement statement = finalConnection.createStatement();
                statement.execute("insert into t_usr_test(recid, str) values(" + Thread.currentThread().getId() + 3 + "," + Thread.currentThread().getId() + ")");
                statement.execute("insert into t_usr_test(recid, str) values(" + Thread.currentThread().getId() + 4 + "," + Thread.currentThread().getId() + ")");
                statement.close();
                return Thread.currentThread().getId();
            };

            List<Callable<Long>> callableList = new ArrayList<>();
            callableList.add(callable);
            callableList.add(callable2);

            ExecutorService executorService = Executors.newFixedThreadPool(2);
            List<Future<Long>> result = executorService.invokeAll(callableList);

            executorService.shutdown();
        } catch (SQLException | InterruptedException ex) {
            System.out.println(Arrays.toString(ex.getStackTrace()));
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }
}
