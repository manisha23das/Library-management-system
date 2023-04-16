import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ReturnBook extends JFrame implements ActionListener, KeyListener {
    JLabel sStudentIdL, sStudentNameL, sFathersNameL,message;
    JLabel[] books;
    JTextField sStudentId, sStudentName, sFathersName;
    JButton searchById, searchByName, cancel;
    JButton[] return_book;
    Color shadowOuter = Color.WHITE;
    Color shadowInner = Color.DARK_GRAY;
    Image img;
    ReturnBook(){
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
        sStudentIdL.setForeground(new Color(255,255,255));
        sStudentIdL.setOpaque(true);
        sStudentIdL.setFont(new Font("Arial",Font.BOLD,18));
        sStudentIdL.setBorder(BorderFactory.createBevelBorder(0, shadowOuter, shadowInner));
        add(sStudentIdL);

        //Get BookId
        sStudentId = new JTextField("");
        sStudentId.setBounds(220+x,10+y,300,30);
        sStudentId.setBackground(new Color(0,0,0));
        sStudentId.setForeground(new Color(255,255,255));
        sStudentId.setFont(new Font("Arial",Font.BOLD,18));
        sStudentId.setBorder(BorderFactory.createBevelBorder(0, shadowOuter, shadowInner));
        add(sStudentId);

        //Search Button
        searchById = new JButton(" Search ");
        searchById.setBounds(520+x,10+y,90,30);
        searchById.setBackground(new Color(0,0,0));
        searchById.setForeground(new Color(255,255,255));
        searchById.setOpaque(true);
        searchById.setFont(new Font("Arial",Font.BOLD,18));
        searchById.setBorder(BorderFactory.createBevelBorder(0, shadowInner, shadowOuter));
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
        sStudentNameL.setForeground(new Color(255,255,255));
        sStudentNameL.setOpaque(true);
        sStudentNameL.setFont(new Font("Arial",Font.BOLD,18));
        sStudentNameL.setBorder(BorderFactory.createBevelBorder(0, shadowOuter, shadowInner));
        add(sStudentNameL);

        //Get BookId
        sStudentName = new JTextField("");
        sStudentName.setBounds(220+x,45+y,300,30);
        sStudentName.setBackground(new Color(0,0,0));
        sStudentName.setForeground(new Color(255,255,255));
        sStudentName.setFont(new Font("Arial",Font.BOLD,18));
        sStudentName.setBorder(BorderFactory.createBevelBorder(0, shadowOuter, shadowInner));
        add(sStudentName);

        sFathersNameL = new JLabel(" Fathers Name: - ");
        sFathersNameL.setBounds(50+x,80+y,170,30);
        sFathersNameL.setBackground(new Color(0,0,0));
        sFathersNameL.setOpaque(true);
        sFathersNameL.setForeground(new Color(255,255,255));
        sFathersNameL.setFont(new Font("Arial",Font.BOLD,18));
        sFathersNameL.setBorder(BorderFactory.createBevelBorder(0, shadowOuter, shadowInner));
        add(sFathersNameL);

        //Get BookId
        sFathersName = new JTextField("");
        sFathersName.setBounds(220+x,80+y,300,30);
        sFathersName.setBackground(new Color(0,0,0));
        sFathersName.setForeground(new Color(255,255,255));
        sFathersName.setFont(new Font("Arial",Font.BOLD,18));
        sFathersName.setBorder(BorderFactory.createBevelBorder(0, shadowOuter, shadowInner));
        add(sFathersName);

        searchByName = new JButton(" Search ");
        searchByName.setBounds(520+x,80+y,90,30);
        searchByName.setBackground(new Color(0,0,0));
        searchByName.setForeground(new Color(255,255,255));
        searchByName.setOpaque(true);
        searchByName.setFont(new Font("Arial",Font.BOLD,18));
        searchByName.setBorder(BorderFactory.createBevelBorder(0, shadowInner, shadowOuter));
        searchByName.addActionListener(this);
        searchByName.addKeyListener(this);
        add(searchByName);

        //if Student not found message
        message = new JLabel("");
        message.setBounds(50,120,550,50);
        message.setFont(new Font("Arial",Font.BOLD,18));
        add(message);

        String[] str = {"BookId","DOI","DOR","FINE"};
        int[] length = {150,130,130,150};
        return_book = new JButton[5];
        books = new JLabel[24];
        for(int i = 0; i < 6; i++){
            int t = 0;
            for (int j = 0; j < 4; j++){
                if(i!=0) {
                    books[i*4+j] = new JLabel(" ");
                    books[i*4+j].setBounds(10 + t, 150+(i*50), length[j], 50);
                    books[i*4+j].setBackground(new Color(0, 0, 0));
                    books[i*4+j].setForeground(new Color(255, 255, 255));
                    books[i*4+j].setOpaque(true);
                    books[i*4+j].setVisible(false);
                    books[i*4+j].setFont(new Font("Arial", Font.BOLD, 16));
                    books[i*4+j].setBorder(BorderFactory.createLineBorder(Color.WHITE,1));
                    add(books[i*4+j]);
                }
                else{
                    books[j] = new JLabel(str[j]);
                    books[j].setBounds(10 + t, 150, length[j], 50);
                    books[j].setBackground(new Color(0, 0, 0));
                    books[j].setForeground(new Color(255, 255, 255));
                    books[j].setOpaque(true);
                    books[j].setFont(new Font("Arial", Font.BOLD, 16));
                    books[j].setHorizontalAlignment(0);
                    books[j].setVisible(false);
                    books[j].setBorder(BorderFactory.createLineBorder(Color.WHITE,1));
                    add(books[j]);
                }
                t+=length[j];
            }
            if (i < 5) {
                return_book[i] = new JButton("Return");
                return_book[i].setBounds(10+t, 200 + (i * 50), 105, 50);
                return_book[i].setBackground(new Color(0, 0, 0));
                return_book[i].setForeground(new Color(255, 255, 255));
                return_book[i].setFont(new Font("Arial", Font.BOLD, 16));
                return_book[i].setBorder(BorderFactory.createLineBorder(Color.WHITE,1));
                return_book[i].addActionListener(this);
                return_book[i].addKeyListener(this);
                return_book[i].setVisible(false);
                add(return_book[i]);
            }
        }

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
        if (e1.getSource() == searchById)
            new Methods().searchById(sStudentId.getText(), this);
        if (e1.getSource() == searchByName)
            new Methods().searchByName(sStudentName.getText(), sFathersName.getText(), this);
        if (e1.getSource() == return_book[0])
            new Methods().returnBook(books[4].getText(), 1, this);
        if (e1.getSource() == return_book[1])
            new Methods().returnBook(books[8].getText(), 2, this);
        if (e1.getSource() == return_book[2])
            new Methods().returnBook(books[12].getText(), 3, this);
        if (e1.getSource() == return_book[3])
            new Methods().returnBook(books[16].getText(), 4, this);
        if (e1.getSource() == return_book[4])
            new Methods().returnBook(books[20].getText(),  5, this);
    }
    public void keyTyped(KeyEvent e) {}
    public void keyPressed(KeyEvent e) {}
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == 10 && e.getSource() == searchById)
            new Methods().searchById(sStudentId.getText(), this);
        if (e.getKeyCode() == 10 && e.getSource() == searchByName)
            new Methods().searchByName(sStudentName.getText(), sFathersName.getText(), this);
        if (e.getKeyCode() == 10 && e.getSource() == return_book[0])
            new Methods().returnBook(books[4].getText(), 1, this);
        if (e.getKeyCode() == 10 && e.getSource() == return_book[1])
            new Methods().returnBook(books[8].getText(), 2, this);
        if (e.getKeyCode() == 10 && e.getSource() == return_book[2])
            new Methods().returnBook(books[12].getText(), 3, this);
        if (e.getKeyCode() == 10 && e.getSource() == return_book[3])
            new Methods().returnBook(books[16].getText(), 5, this);
        if (e.getKeyCode() == 10 && e.getSource() == return_book[4])
            new Methods().returnBook(books[20].getText(), 5, this);
    }
}
