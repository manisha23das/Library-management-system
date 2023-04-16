import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SearchBook extends JFrame implements ActionListener, KeyListener {
    JLabel sBookIdL, sBookNameL, sBookPublisherL,bookIdL, bookNameL, authorL, publisherL, courseL,message;
    JTextField sBookId, sBookName, sBookPublisher, bookId, bookName, author, publisher, course;
    JButton searchById,searchByName,cancel,issue;
    Color shadowOuter = Color.WHITE;
    Color shadowInner = Color.DARK_GRAY;
    Image img;
    SearchBook(){
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
        sBookIdL = new JLabel(" BookId: - ");
        sBookIdL.setBounds(50+x,10+y,150,30);
        sBookIdL.setBackground(new Color(0,0,0));
        sBookIdL.setOpaque(true);
        sBookIdL.setForeground(new Color(255,255,255));
        sBookIdL.setFont(new Font("Arial",Font.BOLD,18));
        sBookIdL.setBorder(BorderFactory.createBevelBorder(0, shadowOuter, shadowInner));
        add(sBookIdL);

        //Get BookId
        sBookId = new JTextField("");
        sBookId.setBounds(200+x,10+y,300,30);
        sBookId.setBackground(new Color(0,0,0));
        sBookId.setForeground(new Color(255,255,255));
        sBookId.setFont(new Font("Arial",Font.BOLD,18));
        sBookId.setBorder(BorderFactory.createBevelBorder(0, shadowOuter, shadowInner));
        add(sBookId);

        //Search Button
        searchById = new JButton(" Search ");
        searchById.setBounds(500+x,10+y,90,30);
        searchById.setBackground(new Color(0,0,0));
        searchById.setOpaque(true);
        searchById.setForeground(new Color(255,255,255));
        searchById.setFont(new Font("Arial",Font.BOLD,18));
        searchById.setBorder(BorderFactory.createBevelBorder(0, shadowInner, shadowOuter));
        searchById.addKeyListener(this);
        searchById.addActionListener(this);
        add(searchById);

        //Other Search Option
        JLabel or = new JLabel("OR");
        or.setBounds(5,40,45,30);
        or.setForeground(new Color(255,255,255));
        or.setFont(new Font("Arial",Font.BOLD,18));
        add(or);

        sBookNameL = new JLabel(" Book Name: - ");
        sBookNameL.setBounds(50+x,45+y,150,30);
        sBookNameL.setBackground(new Color(0,0,0));
        sBookNameL.setOpaque(true);
        sBookNameL.setForeground(new Color(255,255,255));
        sBookNameL.setFont(new Font("Arial",Font.BOLD,18));
        sBookNameL.setBorder(BorderFactory.createBevelBorder(0, shadowOuter, shadowInner));
        add(sBookNameL);

        //Get BookId
        sBookName = new JTextField("");
        sBookName.setBounds(200+x,45+y,300,30);
        sBookName.setBackground(new Color(0,0,0));
        sBookName.setForeground(new Color(255,255,255));
        sBookName.setFont(new Font("Arial",Font.BOLD,18));
        sBookName.setBorder(BorderFactory.createBevelBorder(0, shadowOuter, shadowInner));
        add(sBookName);

        sBookPublisherL = new JLabel(" Publisher: - ");
        sBookPublisherL.setBounds(50+x,80+y,150,30);
        sBookPublisherL.setBackground(new Color(0,0,0));
        sBookPublisherL.setOpaque(true);
        sBookPublisherL.setForeground(new Color(255,255,255));
        sBookPublisherL.setFont(new Font("Arial",Font.BOLD,18));
        sBookPublisherL.setBorder(BorderFactory.createBevelBorder(0, shadowOuter, shadowInner));
        add(sBookPublisherL);

        //Get BookId
        sBookPublisher = new JTextField("");
        sBookPublisher.setBounds(200+x,80+y,300,30);
        sBookPublisher.setBackground(new Color(0,0,0));
        sBookPublisher.setForeground(new Color(255,255,255));
        sBookPublisher.setFont(new Font("Arial",Font.BOLD,18));
        sBookPublisher.setBorder(BorderFactory.createBevelBorder(0, shadowOuter, shadowInner));
        add(sBookPublisher);

        searchByName = new JButton(" Search ");
        searchByName.setBounds(500+x,80+y,90,30);
        searchByName.setBackground(new Color(0,0,0));
        searchByName.setOpaque(true);
        searchByName.setForeground(new Color(255,255,255));
        searchByName.setFont(new Font("Arial",Font.BOLD,18));
        searchByName.setBorder(BorderFactory.createBevelBorder(0, shadowInner, shadowOuter));
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
        bookIdL = new JLabel(" Book ID ");
        bookIdL.setBounds(100+x,130+y,200,50);
        bookIdL.setBackground(new Color(0,0,0));
        bookIdL.setOpaque(true);
        bookIdL.setForeground(new Color(255,255,255));
        bookIdL.setFont(new Font("Arial",Font.BOLD,18));
        bookIdL.setBorder(BorderFactory.createBevelBorder(0, shadowOuter, shadowInner));
        bookIdL.setVisible(false);
        add(bookIdL);

        //Label student Name
        bookNameL = new JLabel("  Book Name ");
        bookNameL.setBounds(100+x,200+y,200,50);
        bookNameL.setBackground(new Color(0,0,0));
        bookNameL.setOpaque(true);
        bookNameL.setForeground(new Color(255,255,255));
        bookNameL.setFont(new Font("Arial",Font.BOLD,18));
        bookNameL.setBorder(BorderFactory.createBevelBorder(0, shadowOuter, shadowInner));
        bookNameL.setVisible(false);
        add(bookNameL);

        //Label father Name
        authorL = new JLabel("  Author:- ");
        authorL.setBounds(100+x,270+y,200,50);
        authorL.setBackground(new Color(0,0,0));
        authorL.setOpaque(true);
        authorL.setForeground(new Color(255,255,255));
        authorL.setFont(new Font("Arial",Font.BOLD,18));
        authorL.setBorder(BorderFactory.createBevelBorder(0, shadowOuter, shadowInner));
        authorL.setVisible(false);
        add(authorL);

        //Label course
        publisherL = new JLabel(" Publisher ");
        publisherL.setBounds(100+x,340+y,200,50);
        publisherL.setBackground(new Color(0,0,0));
        publisherL.setOpaque(true);
        publisherL.setForeground(new Color(255,255,255));
        publisherL.setFont(new Font("Arial",Font.BOLD,18));
        publisherL.setBorder(BorderFactory.createBevelBorder(0, shadowOuter, shadowInner));
        publisherL.setVisible(false);
        add(publisherL);

        //Label branch
        courseL = new JLabel(" Course ");
        courseL.setBounds(100+x,410+y,200,50);
        courseL.setBackground(new Color(0,0,0));
        courseL.setOpaque(true);
        courseL.setForeground(new Color(255,255,255));
        courseL.setFont(new Font("Arial",Font.BOLD,18));
        courseL.setBorder(BorderFactory.createBevelBorder(0, shadowOuter, shadowInner));
        courseL.setVisible(false);
        add(courseL);

        //Issue
        //Cancel Button
        issue = new JButton("Issue");
        issue.setBounds(x+100,480+y,200,50);
        issue.setBackground(new Color(0,0,0));
        issue.setForeground(new Color(255,255,255));
        issue.setFont(new Font("Arial",Font.BOLD,18));
        issue.setBorder(BorderFactory.createBevelBorder(0, shadowInner, shadowOuter));
        issue.addActionListener(this);
        issue.setVisible(false);
        add(issue);

        x+=70;
        //student-id textfield
        bookId = new JTextField("");
        bookId.setBounds(320+x,130+y,200,50);
        bookId.setBackground(new Color(0,0,0));
        bookId.setForeground(new Color(255,255,255));
        bookId.setFont(new Font("Arial",Font.BOLD,18));
        bookId.setBorder(BorderFactory.createBevelBorder(0, shadowOuter, shadowInner));
        bookId.setVisible(false);
        add(bookId);


        //Textfield student name
        bookName = new JTextField("");
        bookName.setBounds(320+x,200+y,200,50);
        bookName.setBackground(new Color(0,0,0));
        bookName.setForeground(new Color(255,255,255));
        bookName.setFont(new Font("Arial",Font.BOLD,18));
        bookName.setBorder(BorderFactory.createBevelBorder(0, shadowOuter, shadowInner));
        bookName.setVisible(false);
        add(bookName);

        //TextField father name
        author = new JTextField("");
        author.setBounds(320+x,270+y,200,50);
        author.setBackground(new Color(0,0,0));
        author.setForeground(new Color(255,255,255));
        author.setFont(new Font("Arial",Font.BOLD,18));
        author.setBorder(BorderFactory.createBevelBorder(0, shadowOuter, shadowInner));
        author.setVisible(false);
        add(author);

        //TextField course
        publisher = new JTextField("");
        publisher.setBounds(320+x,340+y,200,50);
        publisher.setBackground(new Color(0,0,0));
        publisher.setForeground(new Color(255,255,255));
        publisher.setFont(new Font("Arial",Font.BOLD,18));
        publisher.setBorder(BorderFactory.createBevelBorder(0, shadowOuter, shadowInner));
        publisher.setVisible(false);
        add(publisher);

        //TextField branch
        course = new JTextField("");
        course.setBounds(320+x,410+y,200,50);
        course.setBackground(new Color(0,0,0));
        course.setForeground(new Color(255,255,255));
        course.setFont(new Font("Arial",Font.BOLD,18));
        course.setBorder(BorderFactory.createBevelBorder(0, shadowOuter, shadowInner));
        course.setVisible(false);
        add(course);

        //Cancel Button
        cancel = new JButton("Cancel");
        cancel.setBounds(x+320,480+y,200,50);
        cancel.setBackground(new Color(0,0,0));
        cancel.setForeground(new Color(255,255,255));
        cancel.setFont(new Font("Arial",Font.BOLD,18));
        cancel.setBorder(BorderFactory.createBevelBorder(0, shadowInner, shadowOuter));
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
            new Methods().searchBookByName(sBookName.getText(),sBookPublisher.getText(),this);

        if (e1.getSource() == searchById)
            new Methods().searchBookById(sBookId.getText(),this);

        if(e1.getSource() == issue){
            this.setVisible(false);
            new IssueBook(bookId.getText(),bookName.getText(),course.getText());
        }
    }
    public void keyTyped(KeyEvent e) { }
    public void keyPressed(KeyEvent e) { }
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == 10 && e.getSource() == searchByName)
            new Methods().searchBookByName(sBookName.getText(),sBookPublisher.getText(),this);

        if (e.getKeyCode() == 10 && e.getSource() == searchById)
            new Methods().searchBookById(sBookId.getText(),this);
    }
}
