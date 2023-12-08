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
    private List list;

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

        footerPanel.add(addBtn);
        this.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == addBtn){
            Task task = new Task();
            mainPanel.add(task);
            revalidate();
        }
    }
}
