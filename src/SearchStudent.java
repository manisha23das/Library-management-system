import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SearchStudent extends JFrame implements ActionListener, KeyListener {
    JLabel sStudentIdL, sStudentNameL, sFathersNameL, studentIdL, studentNameL, fathersNameL, courseL, branchL,message;
    JTextField sStudentId, sStudentName, sFathersName, studentId, studentName, fathersName, course, branch;
    JButton searchById,searchByName,cancel;
    Color shadowouter = Color.WHITE;
    Color shadowinner = Color.DARK_GRAY;
    Image img;
    SearchStudent(){
        setTitle("Library");
        img = Toolkit.getDefaultToolkit().getImage("LibraryImage.jpg");
        setSize(700,650);
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
        int x = 0, y = 0;
        //Search Bar Label
        sStudentIdL = new JLabel(" StudentId: - ");
        sStudentIdL.setBounds(50+x,10+y,170,30);
        sStudentIdL.setBackground(new Color(0,0,0));
        sStudentIdL.setOpaque(true);
        sStudentIdL.setForeground(new Color(255,255,255));
        sStudentIdL.setFont(new Font("Arial",Font.BOLD,18));
        sStudentIdL.setBorder(BorderFactory.createBevelBorder(0,shadowouter,shadowinner));
        add(sStudentIdL);

        //Get BookId
        sStudentId = new JTextField("");
        sStudentId.setBounds(220+x,10+y,300,30);
        sStudentId.setBackground(new Color(0,0,0));
        sStudentId.setForeground(new Color(255,255,255));
        sStudentId.setFont(new Font("Arial",Font.BOLD,18));
        sStudentId.setBorder(BorderFactory.createBevelBorder(0,shadowouter,shadowinner));
        add(sStudentId);

        //Search Button
        searchById = new JButton(" Search ");
        searchById.setBounds(520+x,10+y,90,30);
        searchById.setBackground(new Color(0,0,0));
        searchById.setOpaque(true);
        searchById.setForeground(new Color(255,255,255));
        searchById.setFont(new Font("Arial",Font.BOLD,18));
        searchById.setBorder(BorderFactory.createBevelBorder(0,shadowinner,shadowouter));
        searchById.addActionListener(this);
        searchById.addKeyListener(this);
        add(searchById);

        //Other Search Option
        JLabel or = new JLabel("OR");
        or.setBounds(5,40,45,30);
        or.setForeground(new Color(255,255,255));
        or.setFont(new Font("Arial",Font.BOLD,18));
        add(or);

        sStudentNameL = new JLabel(" Student Name: - ");
        sStudentNameL.setBounds(50+x,45+y,170,30);
        sStudentNameL.setBackground(new Color(0,0,0));
        sStudentNameL.setOpaque(true);
        sStudentNameL.setForeground(new Color(255,255,255));
        sStudentNameL.setFont(new Font("Arial",Font.BOLD,18));
        sStudentNameL.setBorder(BorderFactory.createBevelBorder(0,shadowouter,shadowinner));
        add(sStudentNameL);

        //Get BookId
        sStudentName = new JTextField("");
        sStudentName.setBounds(220+x,45+y,300,30);
        sStudentName.setBackground(new Color(0,0,0));
        sStudentName.setForeground(new Color(255,255,255));
        sStudentName.setFont(new Font("Arial",Font.BOLD,18));
        sStudentName.setBorder(BorderFactory.createBevelBorder(0,shadowouter,shadowinner));
        add(sStudentName);

        sFathersNameL = new JLabel(" Fathers Name: - ");
        sFathersNameL.setBounds(50+x,80+y,170,30);
        sFathersNameL.setBackground(new Color(0,0,0));
        sFathersNameL.setOpaque(true);
        sFathersNameL.setForeground(new Color(255,255,255));
        sFathersNameL.setFont(new Font("Arial",Font.BOLD,18));
        sFathersNameL.setBorder(BorderFactory.createBevelBorder(0,shadowouter,shadowinner));
        add(sFathersNameL);

        //Get BookId
        sFathersName = new JTextField("");
        sFathersName.setBounds(220+x,80+y,300,30);
        sFathersName.setBackground(new Color(0,0,0));
        sFathersName.setForeground(new Color(255,255,255));
        sFathersName.setFont(new Font("Arial",Font.BOLD,18));
        sFathersName.setBorder(BorderFactory.createBevelBorder(0,shadowouter,shadowinner));
        add(sFathersName);

        searchByName = new JButton(" Search ");
        searchByName.setBounds(520+x,80+y,90,30);
        searchByName.setBackground(new Color(0,0,0));
        searchByName.setOpaque(true);
        searchByName.setForeground(new Color(255,255,255));
        searchByName.setFont(new Font("Arial",Font.BOLD,18));
        searchByName.setBorder(BorderFactory.createBevelBorder(0,shadowinner,shadowouter));
        searchByName.addActionListener(this);
        searchByName.addKeyListener(this);
        add(searchByName);

        //if book not found message
        message = new JLabel("");
        message.setBounds(50,120,550,50);
        message.setFont(new Font("Arial",Font.BOLD,18));
        add(message);

        y+=30;
        //label for student id
        studentIdL = new JLabel(" Student ID ");
        studentIdL.setBounds(100+x,130+y,200,50);
        studentIdL.setBackground(new Color(0,0,0));
        studentIdL.setOpaque(true);
        studentIdL.setForeground(new Color(255,255,255));
        studentIdL.setFont(new Font("Arial",Font.BOLD,18));
        studentIdL.setBorder(BorderFactory.createBevelBorder(0,shadowouter,shadowinner));
        studentIdL.setVisible(false);
        add(studentIdL);

        //Label student Name
        studentNameL = new JLabel("  Student Name ");
        studentNameL.setBounds(100+x,200+y,200,50);
        studentNameL.setBackground(new Color(0,0,0));
        studentNameL.setOpaque(true);
        studentNameL.setForeground(new Color(255,255,255));
        studentNameL.setFont(new Font("Arial",Font.BOLD,18));
        studentNameL.setBorder(BorderFactory.createBevelBorder(0,shadowouter,shadowinner));
        studentNameL.setVisible(false);
        add(studentNameL);

        //Label father Name
        fathersNameL = new JLabel(" Fathers Name:- ");
        fathersNameL.setBounds(100+x,270+y,200,50);
        fathersNameL.setBackground(new Color(0,0,0));
        fathersNameL.setOpaque(true);
        fathersNameL.setForeground(new Color(255,255,255));
        fathersNameL.setFont(new Font("Arial",Font.BOLD,18));
        fathersNameL.setBorder(BorderFactory.createBevelBorder(0,shadowouter,shadowinner));
        fathersNameL.setVisible(false);
        add(fathersNameL);

        //Label course
        courseL = new JLabel(" Course ");
        courseL.setBounds(100+x,340+y,200,50);
        courseL.setBackground(new Color(0,0,0));
        courseL.setOpaque(true);
        courseL.setForeground(new Color(255,255,255));
        courseL.setFont(new Font("Arial",Font.BOLD,18));
        courseL.setBorder(BorderFactory.createBevelBorder(0,shadowouter,shadowinner));
        courseL.setVisible(false);
        add(courseL);

        //Label branch
        branchL = new JLabel(" Branch ");
        branchL.setBounds(100+x,410+y,200,50);
        branchL.setBackground(new Color(0,0,0));
        branchL.setOpaque(true);
        branchL.setForeground(new Color(255,255,255));
        branchL.setFont(new Font("Arial",Font.BOLD,18));
        branchL.setBorder(BorderFactory.createBevelBorder(0,shadowouter,shadowinner));
        branchL.setVisible(false);
        add(branchL);


        x+=70;
        //student-id textfield
        studentId = new JTextField("");
        studentId.setBounds(320+x,130+y,200,50);
        studentId.setBackground(new Color(0,0,0));
        studentId.setForeground(new Color(255,255,255));
        studentId.setFont(new Font("Arial",Font.BOLD,18));
        studentId.setBorder(BorderFactory.createBevelBorder(0,shadowouter,shadowinner));
        studentId.setVisible(false);
        add(studentId);


        //Textfield student name
        studentName = new JTextField("");
        studentName.setBounds(320+x,200+y,200,50);
        studentName.setBackground(new Color(0,0,0));
        studentName.setForeground(new Color(255,255,255));
        studentName.setFont(new Font("Arial",Font.BOLD,18));
        studentName.setBorder(BorderFactory.createBevelBorder(0,shadowouter,shadowinner));
        studentName.setVisible(false);
        add(studentName);

        //TextField father name
        fathersName = new JTextField("");
        fathersName.setBounds(320+x,270+y,200,50);
        fathersName.setBackground(new Color(0,0,0));
        fathersName.setForeground(new Color(255,255,255));
        fathersName.setFont(new Font("Arial",Font.BOLD,18));
        fathersName.setBorder(BorderFactory.createBevelBorder(0,shadowouter,shadowinner));
        fathersName.setVisible(false);
        add(fathersName);

        //TextField course
        course = new JTextField("");
        course.setBounds(320+x,340+y,200,50);
        course.setBackground(new Color(0,0,0));
        course.setForeground(new Color(255,255,255));
        course.setFont(new Font("Arial",Font.BOLD,18));
        course.setBorder(BorderFactory.createBevelBorder(0,shadowouter,shadowinner));
        course.setVisible(false);
        add(course);

        //TextField branch
        branch = new JTextField("");
        branch.setBounds(320+x,410+y,200,50);
        branch.setBackground(new Color(0,0,0));
        branch.setForeground(new Color(255,255,255));
        branch.setFont(new Font("Arial",Font.BOLD,18));
        branch.setBorder(BorderFactory.createBevelBorder(0,shadowouter,shadowinner));
        branch.setVisible(false);
        add(branch);

        //Cancel Button
        cancel = new JButton("Cancel");
        cancel.setBounds(x+320,480+y,200,50);
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
        if (e1.getSource() == searchByName)
            new Methods().searchStudentByName(sStudentName.getText(),sFathersName.getText(),this);

        if (e1.getSource() == searchById)
            new Methods().searchStudentById(sStudentId.getText(),this);
    }
    public void keyTyped(KeyEvent e) {}
    public void keyPressed(KeyEvent e) {}
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == 10 && e.getSource() == searchByName)
            new Methods().searchStudentByName(sStudentName.getText(),sFathersName.getText(),this);

        if (e.getKeyCode() == 10 && e.getSource() == searchById)
            new Methods().searchStudentById(sStudentId.getText(),this);
    }
}
