import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class MainFrame extends JFrame implements ActionListener {
    private JPanel topPanel;
    private JPanel mainPanel;
    private JPanel footerPanel;
    static JLabel titleLab = new JLabel("toDOlist");
    private JButton addBtn;
    private JPanel task;
    private List list;

    private JLabel index;
    private JLabel taskTitle;
    private JButton doneBtn;
    private JButton detailsBtn;
    static Connection connection;

    private boolean checked;

    Border emptyBorder = BorderFactory.createEmptyBorder();
    MainFrame(){
        //frame
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(new BorderLayout());

        this.setTitle("ToDoApp");
        this.setSize(300,500);

        list = new List();

        //top panel
        topPanel = new JPanel();

        topPanel.setSize(300,100);
        topPanel.setPreferredSize(new Dimension(300,50));
        topPanel.setMaximumSize(new Dimension(300,50));
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));
        topPanel.setBackground(Color.gray);

        titleLab.setFont(new Font("Arial", Font.BOLD, 24));
        titleLab.setAlignmentX(Component.CENTER_ALIGNMENT);

        //main panel
        mainPanel = new JPanel();

        mainPanel.setPreferredSize(new Dimension(300,360));
        mainPanel.setLayout(new GridLayout(10,1, 0 ,5));
        mainPanel.setBackground(Color.darkGray);


        task = new JPanel();

        task.setPreferredSize(new Dimension(40,30));
        task.setLayout(new BorderLayout());
        task.setBackground(Color.red);

        checked = false;


        index = new JLabel("");

        index.setPreferredSize(new Dimension(20,20));
        index.setHorizontalAlignment(JLabel.CENTER);

        taskTitle = new JLabel("");

        taskTitle.setFont(new Font("Arial", Font.BOLD, 24));


        doneBtn = new JButton("Done");

        doneBtn.setPreferredSize(new Dimension(40,20));
        doneBtn.setFocusable(false);
        doneBtn.setBorder(BorderFactory.createEmptyBorder());

        detailsBtn = new JButton("details");

        detailsBtn.setPreferredSize(new Dimension(50,20));
        detailsBtn.setFocusable(false);
        detailsBtn.setBorder(BorderFactory.createEmptyBorder());


        //footer panel
        footerPanel = new JPanel();

        footerPanel.setPreferredSize(new Dimension(300,90));
        footerPanel.setMaximumSize(new Dimension(300,90));
        footerPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 10));
        footerPanel.setBackground(Color.lightGray);

        addBtn = new JButton("Add");

        addBtn.setPreferredSize(new Dimension(100,30));
        addBtn.setBorder(emptyBorder);
        addBtn.setFocusable(false);

        addBtn.addActionListener(this);


        this.add(topPanel, BorderLayout.NORTH);
        this.add(footerPanel, BorderLayout.SOUTH);
        this.add(mainPanel, BorderLayout.CENTER);

        topPanel.add(titleLab);

        mainPanel.add(task);

        task.add(index, BorderLayout.WEST);
        task.add(taskTitle, BorderLayout.CENTER);
        task.add(doneBtn, BorderLayout.EAST);
        task.add(detailsBtn, BorderLayout.EAST);


        footerPanel.add(addBtn);
        this.setVisible(true);
    }

    public void databaseConnect(){
        String url = "jdbc:mysql://localhost:3306/taskList";
        String username = "root";
        String password = "";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection(url, username, password);

            Statement statement = connection.createStatement();

            ResultSet query = statement.executeQuery("select * from tasks");

            while (query.next()) {
                System.out.println(query.getInt(1) + ". " + query.getString(2)+ " " + query.getString(3));
            }

            String test = query.getString(2);

            connection.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == addBtn){
            databaseConnect();
        }
    }
}
