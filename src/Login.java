import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Login extends JFrame implements ActionListener, KeyListener{
    JTextField userName;
    JPasswordField password;
    JLabel userNameL,passwordL,message;
    Button login,close, signup;
    Image img;
    Login(){
        // for frame
        img = Toolkit.getDefaultToolkit().getImage("LibraryImage.jpg");
        setTitle("Library");
        setSize(650,550);
        setLocation(350,100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(650,550));
        setContentPane(new JPanel(){
            public void paintComponent(Graphics g){
                super.paintComponent(g);
                g.drawImage(img,0,0,null);
            }
        });
        pack();
//        setResizable(false);
        setIconImage(img);
        setLayout(null);

        //Label UserName
        userNameL = new JLabel("  Enter User Name:- ");
        userNameL.setBounds(100,130,200,50);
        userNameL.setBackground(new Color(0,0,0));
        userNameL.setOpaque(true);
        userNameL.setForeground(new Color(255,255,255));
        userNameL.setFont(new Font("Arial",Font.BOLD,18));
        userNameL.setBorder(BorderFactory.createBevelBorder(1,Color.RED,Color.GREEN));
        add(userNameL);


        userName = new JTextField("");
        userName.setBounds(320,130,200,50);
        userName.setBackground(new Color(0,0,0));
        userName.setForeground(new Color(255,255,255));
        userName.setFont(new Font("Arial",Font.BOLD,18));
        userName.setBorder(BorderFactory.createBevelBorder(0,Color.RED,Color.GREEN));
        add(userName);

        //password
        passwordL = new JLabel("  Enter Password:- ");
        passwordL.setBounds(100,220,200,50);
        passwordL.setBackground(new Color(0,0,0));
        passwordL.setOpaque(true);
        passwordL.setForeground(new Color(255,255,255));
        passwordL.setFont(new Font("Arial",Font.BOLD,18));
        passwordL.setBorder(BorderFactory.createBevelBorder(1,Color.RED,Color.GREEN));
        add(passwordL);

        password = new JPasswordField("");
        password.setBounds(320,220,200,50);
        password.setBackground(new Color(0,0,0));
        password.setForeground(new Color(255,255,255));
        password.setFont(new Font("Arial",Font.BOLD,18));
        password.setBorder(BorderFactory.createBevelBorder(1,Color.RED,Color.GREEN));
        add(password);

        //button login
        login = new Button("Login");
        login.setBounds(140,320,100,40);
        login.setBackground(new Color(0,0,0));
        login.setForeground(new Color(255,255,255));
        login.setFont(new Font("Arial",Font.BOLD,18));
        login.addActionListener(this);
        login.addKeyListener(this);
        add(login);

        //SignIn
        signup = new Button("SignUp");
        signup.setBounds(250,320,100,40);
        signup.setBackground(new Color(0,0,0));
        signup.setForeground(new Color(255,255,255));
        signup.setFont(new Font("Arial",Font.BOLD,18));
        signup.addActionListener(this);
        signup.addKeyListener(this);
        add(signup);

        //button close
        close = new Button("Close");
        close.setBounds(360,320,100,40);
        close.setBackground(new Color(0,0,0));
        close.setForeground(new Color(255,255,255));
        close.setFont(new Font("Arial",Font.BOLD,18));
        close.addActionListener(this);
        close.addKeyListener(this);
        add(close);

        message = new JLabel("");
        message.setBounds(150,380,300,50);
        message.setFont(new Font("Arial",Font.BOLD,18));
        add(message);

        setVisible(true);
    }
    public static void main(String[] args) {
        new Login();

    }
    @SuppressWarnings("deprecation")
    @Override
    public void actionPerformed(ActionEvent e1) {
        if(e1.getSource()==close) System.exit(0);
        if(e1.getSource()==signup) {
            this.setVisible(false);
            new SignUp();
        }
        if(e1.getSource()==login)
            if (!userName.getText().equals("") && !password.getText().equals(""))
                new Methods().login(userName.getText(), password.getText(),this);
    }
    public void keyTyped(KeyEvent e) { }
    public void keyPressed(KeyEvent e) { }
    @SuppressWarnings("deprecation")
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == 10 && e.getSource()==login)
            if(!userName.getText().equals("") && !password.getText().equals(""))
                new Methods().login(userName.getText(), password.getText(), this);

        if(e.getKeyCode() == 10 && e.getSource()==signup) {
            this.setVisible(false);
            new SignUp();
        }
        if(e.getKeyCode() == 10 && e.getSource()==close)
            System.exit(0);
    }
}