import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("ALL")
public class SignUp extends JFrame implements ActionListener, KeyListener{
    JTextField userName, confirmPassword;
    JPasswordField password;
    JLabel userNameL,passwordL,message, confirmPasswordL;
    Button signup,close;
    Image img;
    SignUp(){
        //for frame
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
        setResizable(false);
        setIconImage(img);
        setLayout(null);

        int y = -50;
        //Label UserName
        userNameL = new JLabel("  Enter User Name:- ");
        userNameL.setBounds(100,130+y,200,50);
        userNameL.setBackground(new Color(0,0,0));
        userNameL.setOpaque(true);
        userNameL.setForeground(new Color(255,255,255));
        userNameL.setFont(new Font("Arial",Font.BOLD,18));
        userNameL.setBorder(BorderFactory.createBevelBorder(1,Color.RED,Color.GREEN));
        add(userNameL);


        userName = new JTextField("");
        userName.setBounds(320,130+y,200,50);
        userName.setBackground(new Color(0,0,0));
        userName.setForeground(new Color(255,255,255));
        userName.setFont(new Font("Arial",Font.BOLD,18));
        userName.setBorder(BorderFactory.createBevelBorder(0,Color.RED,Color.GREEN));
        add(userName);

        //password
        passwordL = new JLabel("  Enter Password:- ");
        passwordL.setBounds(100,220+y,200,50);
        passwordL.setBackground(new Color(0,0,0));
        passwordL.setOpaque(true);
        passwordL.setForeground(new Color(255,255,255));
        passwordL.setFont(new Font("Arial",Font.BOLD,18));
        passwordL.setBorder(BorderFactory.createBevelBorder(1,Color.RED,Color.GREEN));
        add(passwordL);


        password = new JPasswordField("");
        password.setBounds(320,220+y,200,50);
        password.setBackground(new Color(0,0,0));
        password.setForeground(new Color(255,255,255));
        password.setFont(new Font("Arial",Font.BOLD,18));
        password.setBorder(BorderFactory.createBevelBorder(1,Color.RED,Color.GREEN));
        add(password);

        //Confirm Password
        confirmPasswordL = new JLabel(" Confirm Password:- ");
        confirmPasswordL.setBounds(100,310+y,200,50);
        confirmPasswordL.setBackground(new Color(0,0,0));
        confirmPasswordL.setOpaque(true);
        confirmPasswordL.setForeground(new Color(255,255,255));
        confirmPasswordL.setFont(new Font("Arial",Font.BOLD,18));
        confirmPasswordL.setBorder(BorderFactory.createBevelBorder(1,Color.RED,Color.GREEN));
        add(confirmPasswordL);

        confirmPassword = new JTextField("");
        confirmPassword.setBounds(320,310+y,200,50);
        confirmPassword.setBackground(new Color(0,0,0));
        confirmPassword.setForeground(new Color(255,255,255));
        confirmPassword.setFont(new Font("Arial",Font.BOLD,18));
        confirmPassword.setBorder(BorderFactory.createBevelBorder(0,Color.RED,Color.GREEN));
        add(confirmPassword);

        //button login
        signup = new Button("SignUp");
        signup.setBounds(140,410+y,100,40);
        signup.setBackground(new Color(0,0,0));
        signup.setForeground(new Color(255,255,255));
        signup.setFont(new Font("Arial",Font.BOLD,18));
        signup.addActionListener(this);
        signup.addKeyListener(this);
        add(signup);


        //button close
        close = new Button("Close");
        close.setBounds(360,410+y,100,40);
        close.setBackground(new Color(0,0,0));
        close.setForeground(new Color(255,255,255));
        close.setFont(new Font("Arial",Font.BOLD,18));
        close.addActionListener(this);
        close.addKeyListener(this);
        add(close);

        message = new JLabel("");
        message.setBounds(150,480+y,300,50);
        message.setFont(new Font("Arial",Font.BOLD,18));
        add(message);

        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e1) {
        if(e1.getSource()==close) System.exit(0);
        if(e1.getSource()==signup){
            if(confirmPassword.getText().equals(""))
                message.setText("Fill all the three columns");
            else if(password.getText().equals(confirmPassword.getText()))
                new Methods().signup(userName.getText(),confirmPassword.getText());

            else
                message.setText("Password Mismatch");
            message.setOpaque(true);
            message.setBackground(new Color(0,0,0));
            message.setForeground(new Color(255,255,255));
            message.setBorder(BorderFactory.createBevelBorder(1, Color.RED,Color.GREEN));
            message.setHorizontalAlignment(0);
        }
    }
    public void keyTyped(KeyEvent e) { }
    public void keyPressed(KeyEvent e) { }
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == 10 && e.getSource() == signup) {
            if(confirmPassword.getText().equals(""))
                message.setText("Fill all the three columns");
            else if (password.getText().equals(confirmPassword.getText()))
                new Methods().signup(userName.getText(), confirmPassword.getText());
            else
                message.setText("Password Mismatch");
            message.setOpaque(true);
            message.setBackground(new Color(0, 0, 0));
            message.setForeground(new Color(255, 255, 255));
            message.setBorder(BorderFactory.createBevelBorder(1, Color.RED, Color.GREEN));
            message.setHorizontalAlignment(0);

        }
    }
}
