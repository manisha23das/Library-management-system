import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class NewStudent extends JFrame implements ActionListener ,KeyListener{
    JLabel studentIdL,studentNameL,fatherNameL,courseL,branchL;
    JTextField studentId,studentName,fatherName,course,branch;
    JButton save,cancel;
    Color shadowouter = Color.WHITE;
    Color shadowinner = Color.DARK_GRAY;
    Image img;
    NewStudent(){
        //Frame
        setTitle("Library");
        img = Toolkit.getDefaultToolkit().getImage("LibraryImage.jpg");
        setLocation(50,10);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setIconImage(img);
        setMinimumSize(new Dimension(700,650));
        setContentPane(new JPanel(){
            public void paintComponent(Graphics g){
                super.paintComponent(g);
                g.drawImage(img,0,0,null);
            }
        });
        pack();
        setResizable(false);
        setLayout(null);

        int x = 0, y = -70;
        //label for student id
        studentIdL = new JLabel(" Student ID ");
        studentIdL.setBounds(100+x,130+y,200,50);
        studentIdL.setBackground(new Color(0,0,0));
        studentIdL.setOpaque(true);
        studentIdL.setForeground(new Color(255,255,255));
        studentIdL.setFont(new Font("Arial",Font.BOLD,18));
        studentIdL.setBorder(BorderFactory.createBevelBorder(0,shadowinner,shadowouter));
        add(studentIdL);

        //Label student Name
        studentNameL = new JLabel("  Student Name ");
        studentNameL.setBounds(100+x,200+y,200,50);
        studentNameL.setBackground(new Color(0,0,0));
        studentNameL.setOpaque(true);
        studentNameL.setForeground(new Color(255,255,255));
        studentNameL.setFont(new Font("Arial",Font.BOLD,18));
        studentNameL.setBorder(BorderFactory.createBevelBorder(0,shadowinner,shadowouter));
        add(studentNameL);

        //Label father Name
        fatherNameL = new JLabel("  Father Name ");
        fatherNameL.setBounds(100+x,270+y,200,50);
        fatherNameL.setBackground(new Color(0,0,0));
        fatherNameL.setOpaque(true);
        fatherNameL.setForeground(new Color(255,255,255));
        fatherNameL.setFont(new Font("Arial",Font.BOLD,18));
        fatherNameL.setBorder(BorderFactory.createBevelBorder(0,shadowinner,shadowouter));
        add(fatherNameL);

        //Label course
        courseL = new JLabel(" Course ");
        courseL.setBounds(100+x,340+y,200,50);
        courseL.setBackground(new Color(0,0,0));
        courseL.setOpaque(true);
        courseL.setForeground(new Color(255,255,255));
        courseL.setFont(new Font("Arial",Font.BOLD,18));
        courseL.setBorder(BorderFactory.createBevelBorder(0,shadowinner,shadowouter));
        add(courseL);

        //Label branch
        branchL = new JLabel(" Branch ");
        branchL.setBounds(100+x,410+y,200,50);
        branchL.setBackground(new Color(0,0,0));
        branchL.setOpaque(true);
        branchL.setForeground(new Color(255,255,255));
        branchL.setFont(new Font("Arial",Font.BOLD,18));
        branchL.setBorder(BorderFactory.createBevelBorder(0,shadowinner,shadowouter));
        add(branchL);

        //save Button
        save = new JButton(" Save ");
        save.setBounds(100+x,520+y,200,50);
        save.setBackground(new Color(0,0,0));
        save.setOpaque(true);
        save.setForeground(new Color(255,255,255));
        save.setFont(new Font("Arial",Font.BOLD,18));
        save.setBorder(BorderFactory.createBevelBorder(0,shadowinner,shadowouter));
        save.addActionListener(this);
        save.addKeyListener(this);
        add(save);

        x+=70;
        //Student-id
        studentId = new JTextField(""+new Methods().getStudentCount());
        studentId.setBounds(320+x,130+y,200,50);
        studentId.setBackground(new Color(0,0,0));
        studentId.setForeground(new Color(255,255,255));
        studentId.setFont(new Font("Arial",Font.BOLD,18));
        studentId.setEditable(false);
        studentId.setBorder(BorderFactory.createBevelBorder(0,shadowinner,shadowouter));
        add(studentId);

        //Student name
        studentName = new JTextField("");
        studentName.setBounds(320+x,200+y,200,50);
        studentName.setBackground(new Color(0,0,0));
        studentName.setForeground(new Color(255,255,255));
        studentName.setFont(new Font("Arial",Font.BOLD,18));
        studentName.setBorder(BorderFactory.createBevelBorder(0,shadowinner,shadowouter));
        add(studentName);

        //Fathers name
        fatherName = new JTextField("");
        fatherName.setBounds(320+x,270+y,200,50);
        fatherName.setBackground(new Color(0,0,0));
        fatherName.setForeground(new Color(255,255,255));
        fatherName.setFont(new Font("Arial",Font.BOLD,18));
        fatherName.setBorder(BorderFactory.createBevelBorder(0,shadowinner,shadowouter));
        add(fatherName);

        //Course
        course = new JTextField("");
        course.setBounds(320+x,340+y,200,50);
        course.setBackground(new Color(0,0,0));
        course.setForeground(new Color(255,255,255));
        course.setFont(new Font("Arial",Font.BOLD,18));
        course.setBorder(BorderFactory.createBevelBorder(0,shadowinner,shadowouter));
        add(course);

        //Branch
        branch = new JTextField("");
        branch.setBounds(320+x,410+y,200,50);
        branch.setBackground(new Color(0,0,0));
        branch.setForeground(new Color(255,255,255));
        branch.setFont(new Font("Arial",Font.BOLD,18));
        branch.setBorder(BorderFactory.createBevelBorder(0,shadowinner,shadowouter));
        add(branch);

        //Cancel
        cancel = new JButton("Cancel");
        cancel.setBounds(x+320,520+y,200,50);
        cancel.setBackground(new Color(0,0,0));
        cancel.setForeground(new Color(255,255,255));
        cancel.setFont(new Font("Arial",Font.BOLD,18));
        cancel.setBorder(BorderFactory.createBevelBorder(0,shadowinner,shadowouter));
        cancel.addActionListener(this);
        add(cancel);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e1){
        if (e1.getSource() == cancel){
            this.setVisible(false);
            new Dashboard();
        }
        if(e1.getSource() == save) {
            new Methods().addStudent(studentId.getText(), studentName.getText(), fatherName.getText(), course.getText(), branch.getText());
            this.setVisible(false);
            new Dashboard();
        }
    }
    public void keyTyped(KeyEvent e) { }
    public void keyPressed(KeyEvent e) { }
    public void keyReleased(KeyEvent e) {
        if (e.getSource() == cancel){
            this.setVisible(false);
            new Dashboard();
        }
        if(e.getSource() == save && e.getKeyCode() == 10) {
            new Methods().addStudent(studentId.getText(), studentName.getText(), fatherName.getText(), course.getText(), branch.getText());
            this.setVisible(false);
            new Dashboard();
        }
    }
}
