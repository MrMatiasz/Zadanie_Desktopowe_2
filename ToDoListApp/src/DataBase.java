import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DataBase extends MainFrame{
    public static void databaseConnect(){
        String url = "jdbc:mysql://localhost:3306/taskList";
        String username = "root";
        String password = "";

        String test;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection(url, username, password);

            Statement statement = connection.createStatement();

            ResultSet query = statement.executeQuery("select * from tasks");

            while (query.next()) {
                System.out.println(query.getInt(1) + ". " + query.getString(2)+ " " + query.getString(3));
            }

            test = query.getString(2);

            connection.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
