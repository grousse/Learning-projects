package viewer;

import org.sqlite.SQLiteDataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

public class  DataService {

    public static void getData() {
        try {
            String url = "jdbc:sqlite:" + SQLiteViewer.getFileName();
            SQLiteDataSource dataSource = new SQLiteDataSource();
            dataSource.setUrl(url);
            Connection connection = DriverManager.getConnection(url);
            Statement ps = connection.createStatement();
            ResultSet rs = ps.executeQuery(SQLiteViewer.getQuery());
            int columns = rs.getMetaData().getColumnCount();

            for(int i = 1; i <= columns; i++) {
                SQLiteViewer.getModel().addColumn(rs.getMetaData().getColumnName(i));
            }
            while(rs.next()) {
                Vector<Object> dataInDb = new Vector<>();
                for(int i = 1; i <= columns; i++) {
                    dataInDb.add(rs.getString(i));
                }
                SQLiteViewer.getModel().addRow(dataInDb);
            }
            ps.close();
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
    }
}
