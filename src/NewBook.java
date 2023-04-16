import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class NewBook extends JFrame implements ActionListener,KeyListener {
    JLabel bookIdL, bookNameL, authorL, publisherL, courseL,NOCL;
    JTextField bookID, bookName, author, publisher, course, NOC;
    JButton save,cancel;
    Color shadowouter = Color.WHITE;
    Color shadowinner = Color.DARK_GRAY;
    Image img;
    NewBook(){
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

        int x = 0, y = -70;
        //label for student id
        bookIdL = new JLabel(" Book ID ");
        bookIdL.setBounds(100+x,130+y,200,50);
        bookIdL.setBackground(new Color(0,0,0));
        bookIdL.setOpaque(true);
        bookIdL.setForeground(new Color(255,255,255));
        bookIdL.setFont(new Font("Arial",Font.BOLD,18));
        bookIdL.setBorder(BorderFactory.createBevelBorder(0,shadowouter,shadowinner));
        add(bookIdL);

        //Label student Name
        bookNameL = new JLabel("  Book Name ");
        bookNameL.setBounds(100+x,200+y,200,50);
        bookNameL.setBackground(new Color(0,0,0));
        bookNameL.setOpaque(true);
        bookNameL.setForeground(new Color(255,255,255));
        bookNameL.setFont(new Font("Arial",Font.BOLD,18));
        bookNameL.setBorder(BorderFactory.createBevelBorder(0,shadowouter,shadowinner));
        add(bookNameL);

        //Label father Name
        authorL = new JLabel("  Author ");
        authorL.setBounds(100+x,270+y,200,50);
        authorL.setBackground(new Color(0,0,0));
        authorL.setOpaque(true);
        authorL.setForeground(new Color(255,255,255));
        authorL.setFont(new Font("Arial",Font.BOLD,18));
        authorL.setBorder(BorderFactory.createBevelBorder(0,shadowouter,shadowinner));
        add(authorL);

        //Label course
        publisherL = new JLabel(" Publisher ");
        publisherL.setBounds(100+x,340+y,200,50);
        publisherL.setBackground(new Color(0,0,0));
        publisherL.setOpaque(true);
        publisherL.setForeground(new Color(255,255,255));
        publisherL.setFont(new Font("Arial",Font.BOLD,18));
        publisherL.setBorder(BorderFactory.createBevelBorder(0,shadowouter,shadowinner));
        add(publisherL);

        //Label branch
        courseL = new JLabel(" Course ");
        courseL.setBounds(100+x,410+y,200,50);
        courseL.setBackground(new Color(0,0,0));
        courseL.setOpaque(true);
        courseL.setForeground(new Color(255,255,255));
        courseL.setFont(new Font("Arial",Font.BOLD,18));
        courseL.setBorder(BorderFactory.createBevelBorder(0,shadowouter,shadowinner));
        add(courseL);

        NOCL = new JLabel(" No. Of Copies ");
        NOCL.setBounds(100+x,480+y,200,50);
        NOCL.setBackground(new Color(0,0,0));
        NOCL.setOpaque(true);
        NOCL.setForeground(new Color(255,255,255));
        NOCL.setFont(new Font("Arial",Font.BOLD,18));
        NOCL.setBorder(BorderFactory.createBevelBorder(0,shadowouter,shadowinner));
        add(NOCL);

        //save Button
        save = new JButton(" Save ");
        save.setBounds(100+x,590+y,200,50);
        save.setBackground(new Color(0,0,0));
        save.setOpaque(true);
        save.setForeground(new Color(255,255,255));
        save.setFont(new Font("Arial",Font.BOLD,18));
        save.setBorder(BorderFactory.createBevelBorder(0,shadowinner,shadowouter));
        save.addActionListener(this);
        save.addKeyListener(this);
        add(save);

        x+=70;
        //Book-id
        bookID = new JTextField(""+new Methods().getBookCount());
        bookID.setBounds(320+x,130+y,200,50);
        bookID.setBackground(new Color(0,0,0));
        bookID.setForeground(new Color(255,255,255));
        bookID.setFont(new Font("Arial",Font.BOLD,18));
        bookID.setEditable(false);
        bookID.setBorder(BorderFactory.createBevelBorder(0,shadowouter,shadowinner));
        add(bookID);


        //Book name
        bookName = new JTextField("");
        bookName.setBounds(320+x,200+y,200,50);
        bookName.setBackground(new Color(0,0,0));
        bookName.setForeground(new Color(255,255,255));
        bookName.setFont(new Font("Arial",Font.BOLD,18));
        bookName.setBorder(BorderFactory.createBevelBorder(0,shadowouter,shadowinner));
        add(bookName);

        //Author
        author = new JTextField("");
        author.setBounds(320+x,270+y,200,50);
        author.setBackground(new Color(0,0,0));
        author.setForeground(new Color(255,255,255));
        author.setFont(new Font("Arial",Font.BOLD,18));
        author.setBorder(BorderFactory.createBevelBorder(0,shadowouter,shadowinner));
        add(author);

        //Publisher
        publisher = new JTextField("");
        publisher.setBounds(320+x,340+y,200,50);
        publisher.setBackground(new Color(0,0,0));
        publisher.setForeground(new Color(255,255,255));
        publisher.setFont(new Font("Arial",Font.BOLD,18));
        publisher.setBorder(BorderFactory.createBevelBorder(0,shadowouter,shadowinner));
        add(publisher);

        //Course
        course = new JTextField("");
        course.setBounds(320+x,410+y,200,50);
        course.setBackground(new Color(0,0,0));
        course.setForeground(new Color(255,255,255));
        course.setFont(new Font("Arial",Font.BOLD,18));
        course.setBorder(BorderFactory.createBevelBorder(0,shadowouter,shadowinner));
        add(course);

        NOC = new JTextField("");
        NOC.setBounds(320+x,480+y,200,50);
        NOC.setBackground(new Color(0,0,0));
        NOC.setForeground(new Color(255,255,255));
        NOC.setFont(new Font("Arial",Font.BOLD,18));
        NOC.setBorder(BorderFactory.createBevelBorder(0,shadowouter,shadowinner));
        add(NOC);

        //Cancel Button
        cancel = new JButton("Cancel");
        cancel.setBounds(x+320,590+y,200,50);
        cancel.setBackground(new Color(0,0,0));
        cancel.setForeground(new Color(255,255,255));
        cancel.setFont(new Font("Arial",Font.BOLD,18));
        cancel.setBorder(BorderFactory.createBevelBorder(0,shadowinner,shadowouter));
        cancel.addActionListener(this);
        cancel.addKeyListener(this);
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
            new Methods().addBook(bookID.getText(), bookName.getText(), author.getText(), publisher.getText(), course.getText(), NOC.getText());
            this.setVisible(false);
            new Dashboard();
        }
    }
    public void keyTyped(KeyEvent e) { }
    public void keyPressed(KeyEvent e) { }
    public void keyReleased(KeyEvent e) {
        if(e.getSource() == save && e.getKeyCode() == 10) {
            new Methods().addBook(bookID.getText(), bookName.getText(), author.getText(), publisher.getText(), course.getText(),NOC.getText());
            this.setVisible(false);
            new Dashboard();
        }
        if(e.getSource() == cancel && e.getKeyCode() == 10){
            this.setVisible(false);
            new Dashboard();
        }
    }
}
