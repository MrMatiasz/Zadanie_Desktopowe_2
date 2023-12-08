import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Task extends JPanel{
    private JLabel index;
    private JLabel taskTitle;
    private JButton doneBtn;

    private boolean checked;

    static Connection connection;
    Task(){
        this.setPreferredSize(new Dimension(40,30));
        this.setLayout(new BorderLayout());
        this.setBackground(Color.red);

        index = new JLabel("");

        index.setPreferredSize(new Dimension(20,20));
        index.setHorizontalAlignment(JLabel.CENTER);

        taskTitle = new JLabel("");

        taskTitle.setFont(new Font("Arial", Font.BOLD, 24));

        doneBtn = new JButton("Done");

        doneBtn.setPreferredSize(new Dimension(40,20));
        doneBtn.setFocusable(false);
        doneBtn.setBorder(BorderFactory.createEmptyBorder());

        this.add(index, BorderLayout.WEST);
        this.add(taskTitle, BorderLayout.CENTER);
        this.add(doneBtn, BorderLayout.EAST);

        databaseConnect(taskTitle);
    }

    public void databaseConnect(JLabel siur){
        String url = "jdbc:mysql://localhost:3306/taskList";
        String username = "root";
        String password = "";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection(url, username, password);

            Statement statement = connection.createStatement();

            ResultSet query = statement.executeQuery("select * from tasks");

            while (query.next()) {
                siur.setText(query.getString(2));
            }

            connection.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
