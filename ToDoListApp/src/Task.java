import javax.swing.*;
import java.awt.*;

public class Task extends JPanel{
    private JLabel index;
    private JLabel taskTitle;
    private JButton doneBtn;

    private boolean checked;
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
    }
}
