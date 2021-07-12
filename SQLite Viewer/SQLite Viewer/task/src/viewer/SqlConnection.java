package viewer;

import org.sqlite.SQLiteDataSource;

import java.sql.*;

public class SqlConnection {

    public static void connect() {
        String url = "jdbc:sqlite:" + SQLiteViewer.getFileName();
        SQLiteDataSource dataSource = new SQLiteDataSource();
        dataSource.setUrl(url);
        try {
            Connection connection = DriverManager.getConnection(url);
            if (connection.isValid(3)) {
                DatabaseMetaData md = connection.getMetaData();
                ResultSet rs = md.getTables(null, null, "%", null);
                while (rs.next()) {
                    SQLiteViewer.getjComboBox().addItem(rs.getString(3));
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
