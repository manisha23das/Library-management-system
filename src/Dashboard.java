import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class Dashboard extends JFrame implements ActionListener {
    JButton newStudent,newBook,issueBook,returnBook, searchStudent, searchBook, logout;
    JPanel p;
    Font f = new Font("Arial",Font.BOLD,50);
    Font text = new Font("Arial",Font.BOLD,25);
    Color bgcolor = new Color(0, 0, 0);
    Color textColor = new Color(255,255,255);
    Image img;

    Dashboard(){
        //for frame
        setTitle("Library");
        img = Toolkit.getDefaultToolkit().getImage("LibraryImage.jpg");
        setLocation(0,0);
        setSize(1416,735);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setIconImage(img);
        setResizable(false);
        setLayout(null);

        //Panel
        p = new JPanel(){
            public void paintComponent(Graphics g){
                super.paintComponent(g);
                g.drawImage(img,0,0,null);
            }
        };
        p.setBounds(1,0,1400,700);
        p.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.WHITE,5),"DASH BOARD", TitledBorder.CENTER,TitledBorder.CENTER,f,new Color(255,200,200)));
        p.setLayout(null);
        add(p);

        int x = 15, y = 80, width = 190,height = 60;

        //Button new student
        newStudent= new JButton("New Student");
        newStudent.setBounds(x+5,10+y,width,height);
        newStudent.setBackground(bgcolor);
        newStudent.setForeground(textColor);
        newStudent.setFont(text);
        newStudent.setBorder(null);
        newStudent.addActionListener(this);
        p.add(newStudent);//for showing the button in the panel

        //button for student data
        searchStudent = new JButton("Search Student");
        searchStudent.setBounds(200+x,10+y,width,height);
        searchStudent.setBackground(bgcolor);
        searchStudent.setForeground(textColor);
        searchStudent.setFont(text);
        searchStudent.setBorder(null);
        searchStudent.addActionListener(this);
        p.add(searchStudent);//for showing the button in the frame

        //button for new book
        newBook= new JButton("New Book");
        newBook.setBounds(395+x,10+y,width,height);
        newBook.setBackground(bgcolor);
        newBook.setForeground(textColor);
        newBook.setFont(text);
        newBook.setBorder(null);
        newBook.addActionListener(this);
        p.add(newBook);//for showing the button in the frame

        //button for book details
        searchBook = new JButton("Search Book");
        searchBook.setBounds(590+x,10+y,width,height);
        searchBook.setBackground(bgcolor);
        searchBook.setForeground(textColor);
        searchBook.setFont(text);
        searchBook.setBorder(null);
        searchBook.addActionListener(this);
        p.add(searchBook);//for showing the button in the frame

        //button for issue book
        issueBook= new JButton("Issue Book");
        issueBook.setBounds(785+x,10+y,width,height);
        issueBook.setBackground(bgcolor);
        issueBook.setForeground(textColor);
        issueBook.setFont(text);
        issueBook.setBorder(null);
        issueBook.addActionListener(this);
        p.add(issueBook);//for showing the button in the frame

        //button for return book
        returnBook= new JButton("Return Book");
        returnBook.setBounds(980+x,10+y,width,height);
        returnBook.setBackground(bgcolor);
        returnBook.setForeground(textColor);
        returnBook.setFont(text);
        returnBook.setBorder(null);
        returnBook.addActionListener(this);
        p.add(returnBook);//for showing the button in the frame

        //button for statistic
        logout = new JButton("Log Out");
        logout.setBounds(1175+x,10+y,width,height);
        logout.setBackground(bgcolor);
        logout.setForeground(textColor);
        logout.setFont(text);
        logout.setBorder(null);
        logout.addActionListener(this);
        p.add(logout);//for showing the button in the frame

        setVisible(true);//for showing the frame;
    }
    @Override
    public void actionPerformed(ActionEvent e1){
        if (e1.getSource() == issueBook){
            this.setVisible(false);
            new IssueBook();
        }
        if (e1.getSource() == newStudent){
            this.setVisible(false);
            new NewStudent();
        }
        if (e1.getSource() == newBook){
            this.setVisible(false);
            new NewBook();
        }
        if (e1.getSource() == searchBook){
            this.setVisible(false);
            new SearchBook();
        }
        if (e1.getSource() == searchStudent){
            this.setVisible(false);
            new SearchStudent();
        }
        if (e1.getSource() == returnBook){
            this.setVisible(false);
            new ReturnBook();
        }
        if (e1.getSource() == logout){
            this.setVisible(false);
            new Login();
        }
    }
}
