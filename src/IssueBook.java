import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class IssueBook extends JFrame implements ActionListener,KeyListener{
    JLabel studentIdL, dateL, bookIdL, bookNameL, courseL;
    JLabel message = new JLabel("Please fill all the columns.");
    JTextField studentID, date, bookId, bookName, course;
    JButton issue,cancel;
    Color shadowouter = Color.WHITE;
    Color shadowinner = Color.DARK_GRAY;
    Image img;
    DateTimeFormatter df = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    LocalDate today = LocalDate.now();

    IssueBook(){
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
        dateL = new JLabel(" Date Of Issue ");
        dateL.setBounds(100+x,200+y,200,50);
        dateL.setBackground(new Color(0,0,0));
        dateL.setOpaque(true);
        dateL.setForeground(new Color(255,255,255));
        dateL.setFont(new Font("Arial",Font.BOLD,18));
        dateL.setBorder(BorderFactory.createBevelBorder(0,shadowinner,shadowouter));
        add(dateL);

        //Label father Name
        bookIdL = new JLabel("  Book Id ");
        bookIdL.setBounds(100+x,270+y,200,50);
        bookIdL.setBackground(new Color(0,0,0));
        bookIdL.setOpaque(true);
        bookIdL.setForeground(new Color(255,255,255));
        bookIdL.setFont(new Font("Arial",Font.BOLD,18));
        bookIdL.setBorder(BorderFactory.createBevelBorder(0,shadowinner,shadowouter));
        add(bookIdL);

        //Label course
        bookNameL = new JLabel(" Book Name ");
        bookNameL.setBounds(100+x,340+y,200,50);
        bookNameL.setBackground(new Color(0,0,0));
        bookNameL.setOpaque(true);
        bookNameL.setForeground(new Color(255,255,255));
        bookNameL.setFont(new Font("Arial",Font.BOLD,18));
        bookNameL.setBorder(BorderFactory.createBevelBorder(0,shadowinner,shadowouter));
        add(bookNameL);

        //Label branch
        courseL = new JLabel(" Course ");
        courseL.setBounds(100+x,410+y,200,50);
        courseL.setBackground(new Color(0,0,0));
        courseL.setOpaque(true);
        courseL.setForeground(new Color(255,255,255));
        courseL.setFont(new Font("Arial",Font.BOLD,18));
        courseL.setBorder(BorderFactory.createBevelBorder(0,shadowinner,shadowouter));
        add(courseL);

        //Issue Button
        issue = new JButton("Issue");
        issue.setBounds(x+100,520+y,200,50);
        issue.setBackground(new Color(0,0,0));
        issue.setForeground(new Color(255,255,255));
        issue.setFont(new Font("Arial",Font.BOLD,18));
        issue.setBorder(BorderFactory.createBevelBorder(0,shadowinner,shadowouter));
        issue.addActionListener(this);
        add(issue);

        x+=70;
        //studentid textfield
        studentID = new JTextField("");
        studentID.setBounds(320+x,130+y,200,50);
        studentID.setBackground(new Color(0,0,0));
        studentID.setForeground(new Color(255,255,255));
        studentID.setFont(new Font("Arial",Font.BOLD,18));
        studentID.setBorder(BorderFactory.createBevelBorder(0,shadowinner,shadowouter));
        add(studentID);

        //Textfield student name
        date = new JTextField(""+df.format(today));
        date.setBounds(320+x,200+y,200,50);
        date.setBackground(new Color(0,0,0));
        date.setForeground(new Color(255,255,255));
        date.setFont(new Font("Arial",Font.BOLD,18));
        date.setEditable(false);
        date.setBorder(BorderFactory.createBevelBorder(0,shadowinner,shadowouter));
        add(date);

        //TextField father name
        bookId = new JTextField("");
        bookId.setBounds(320+x,270+y,200,50);
        bookId.setBackground(new Color(0,0,0));
        bookId.setForeground(new Color(255,255,255));
        bookId.setFont(new Font("Arial",Font.BOLD,18));
        bookId.setBorder(BorderFactory.createBevelBorder(0,shadowinner,shadowouter));
        add(bookId);

        //TextField course
        bookName = new JTextField("");
        bookName.setBounds(320+x,340+y,200,50);
        bookName.setBackground(new Color(0,0,0));
        bookName.setForeground(new Color(255,255,255));
        bookName.setFont(new Font("Arial",Font.BOLD,18));
        bookName.setBorder(BorderFactory.createBevelBorder(0,shadowinner,shadowouter));
        add(bookName);

        //TextField branch
        course = new JTextField("");
        course.setBounds(320+x,410+y,200,50);
        course.setBackground(new Color(0,0,0));
        course.setForeground(new Color(255,255,255));
        course.setFont(new Font("Arial",Font.BOLD,18));
        course.setBorder(BorderFactory.createBevelBorder(0,shadowinner,shadowouter));
        add(course);

        //Cancel Button
        cancel = new JButton("Cancel");
        cancel.setBounds(x+320,520+y,200,50);
        cancel.setBackground(new Color(0,0,0));
        cancel.setForeground(new Color(255,255,255));
        cancel.setFont(new Font("Arial",Font.BOLD,18));
        cancel.setBorder(BorderFactory.createBevelBorder(0,shadowinner,shadowouter));
        cancel.addActionListener(this);
        add(cancel);

        message.setBounds(100,590+y,500,50);
        message.setBackground(new Color(0,0,0));
        message.setOpaque(true);
        message.setForeground(new Color(255,255,255));
        message.setFont(new Font("Arial",Font.BOLD,18));
        message.setVisible(false);
        message.setHorizontalAlignment(0);
        message.setBorder(BorderFactory.createBevelBorder(0,shadowinner,shadowouter));
        add(message);

        setVisible(true);
    }
    IssueBook(String bookIdC,String bookNameC,String courseC){
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
        dateL = new JLabel(" Date Of Issue ");
        dateL.setBounds(100+x,200+y,200,50);
        dateL.setBackground(new Color(0,0,0));
        dateL.setOpaque(true);
        dateL.setForeground(new Color(255,255,255));
        dateL.setFont(new Font("Arial",Font.BOLD,18));
        dateL.setBorder(BorderFactory.createBevelBorder(0,shadowinner,shadowouter));
        add(dateL);

        //Label father Name
        bookIdL = new JLabel("  Book Id ");
        bookIdL.setBounds(100+x,270+y,200,50);
        bookIdL.setBackground(new Color(0,0,0));
        bookIdL.setOpaque(true);
        bookIdL.setForeground(new Color(255,255,255));
        bookIdL.setFont(new Font("Arial",Font.BOLD,18));
        bookIdL.setBorder(BorderFactory.createBevelBorder(0,shadowinner,shadowouter));
        add(bookIdL);

        //Label course
        bookNameL = new JLabel(" Book Name ");
        bookNameL.setBounds(100+x,340+y,200,50);
        bookNameL.setBackground(new Color(0,0,0));
        bookNameL.setOpaque(true);
        bookNameL.setForeground(new Color(255,255,255));
        bookNameL.setFont(new Font("Arial",Font.BOLD,18));
        bookNameL.setBorder(BorderFactory.createBevelBorder(0,shadowinner,shadowouter));
        add(bookNameL);

        //Label branch
        courseL = new JLabel(" Course ");
        courseL.setBounds(100+x,410+y,200,50);
        courseL.setBackground(new Color(0,0,0));
        courseL.setOpaque(true);
        courseL.setForeground(new Color(255,255,255));
        courseL.setFont(new Font("Arial",Font.BOLD,18));
        courseL.setBorder(BorderFactory.createBevelBorder(0,shadowinner,shadowouter));
        add(courseL);

        //Issue Button
        issue = new JButton("Issue");
        issue.setBounds(x+100,520+y,200,50);
        issue.setBackground(new Color(0,0,0));
        issue.setForeground(new Color(255,255,255));
        issue.setFont(new Font("Arial",Font.BOLD,18));
        issue.setBorder(BorderFactory.createBevelBorder(0,shadowinner,shadowouter));
        issue.addActionListener(this);
        add(issue);

        x+=70;
        //student-id textField
        studentID = new JTextField("");
        studentID.setBounds(320+x,130+y,200,50);
        studentID.setBackground(new Color(0,0,0));
        studentID.setForeground(new Color(255,255,255));
        studentID.setFont(new Font("Arial",Font.BOLD,18));
        studentID.setBorder(BorderFactory.createBevelBorder(0,shadowinner,shadowouter));
        add(studentID);

        //TextField student name

        date = new JTextField(""+df.format(today));
        date.setBounds(320+x,200+y,200,50);
        date.setBackground(new Color(0,0,0));
        date.setForeground(new Color(255,255,255));
        date.setFont(new Font("Arial",Font.BOLD,18));
        date.setEditable(false);
        date.setBorder(BorderFactory.createBevelBorder(0,shadowinner,shadowouter));
        add(date);

        //TextField father name
        bookId = new JTextField(bookIdC);
        bookId.setBounds(320+x,270+y,200,50);
        bookId.setBackground(new Color(0,0,0));
        bookId.setForeground(new Color(255,255,255));
        bookId.setFont(new Font("Arial",Font.BOLD,18));
        bookId.setEditable(false);
        bookId.setBorder(BorderFactory.createBevelBorder(0,shadowinner,shadowouter));
        add(bookId);

        //TextField course
        bookName = new JTextField(bookNameC);
        bookName.setBounds(320+x,340+y,200,50);
        bookName.setBackground(new Color(0,0,0));
        bookName.setForeground(new Color(255,255,255));
        bookName.setFont(new Font("Arial",Font.BOLD,18));
        bookName.setEditable(false);
        bookName.setBorder(BorderFactory.createBevelBorder(0,shadowinner,shadowouter));
        add(bookName);

        //TextField branch
        course = new JTextField(courseC);
        course.setBounds(320+x,410+y,200,50);
        course.setBackground(new Color(0,0,0));
        course.setForeground(new Color(255,255,255));
        course.setFont(new Font("Arial",Font.BOLD,18));
        course.setEditable(false);
        course.setBorder(BorderFactory.createBevelBorder(0,shadowinner,shadowouter));
        add(course);

        //Cancel Button
        cancel = new JButton("Cancel");
        cancel.setBounds(x+320,520+y,200,50);
        cancel.setBackground(new Color(0,0,0));
        cancel.setForeground(new Color(255,255,255));
        cancel.setFont(new Font("Arial",Font.BOLD,18));
        cancel.setBorder(BorderFactory.createBevelBorder(0,shadowinner,shadowouter));
        cancel.addActionListener(this);
        add(cancel);

        message.setBounds(100,590+y,500,50);
        message.setBackground(new Color(0,0,0));
        message.setOpaque(true);
        message.setForeground(new Color(255,255,255));
        message.setFont(new Font("Arial",Font.BOLD,18));
        message.setVisible(false);
        message.setHorizontalAlignment(0);
        message.setBorder(BorderFactory.createBevelBorder(0,shadowinner,shadowouter));
        add(message);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e1){
        if (e1.getSource() == cancel){
            this.setVisible(false);
            new Dashboard();
        }
        if(e1.getSource() == issue){
            if(!studentID.getText().equals("") && !bookId.getText().equals("") && !bookName.getText().equals("") && !course.getText().equals("")) {
                new Methods().issueBook(studentID.getText(), bookId.getText(), bookName.getText(), course.getText());
                this.setVisible(false);
                new Dashboard();
            }
            else{
                message.setVisible(true);
            }
        }
    }
    public void keyTyped(KeyEvent e) {}
    public void keyPressed(KeyEvent e) {}
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == 10 && e.getSource() == cancel){
            this.setVisible(false);
            new Dashboard();
        }
        if(e.getKeyCode() == 10 && e.getSource() == issue){
            if(!studentID.getText().equals("") && !bookId.getText().equals("") && !bookName.getText().equals("") && !course.getText().equals("")) {
                new Methods().issueBook(studentID.getText(), bookId.getText(), bookName.getText(), course.getText());
                this.setVisible(false);
                new Dashboard();
            }
            else
                message.setVisible(true);
        }
    }
}
