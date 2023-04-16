import com.toedter.calendar.*;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class Test extends JFrame {
    Date date = new Date();
    JDateChooser jd;
    Test()
    {
        Calendar cld = Calendar.getInstance();

        jd = new JDateChooser(cld.getTime());
        setTitle("Library");
        setSize(650,550);
        setLocation(350,100);
        setLayout(null); //For customising layout
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        jd.setBounds(100,130,200,50);
        jd.setBackground(new Color(0,0,0));
        jd.setOpaque(true);
        jd.setForeground(new Color(255,255,255));
        jd.setFont(new Font("Arial",Font.BOLD,18));
        jd.setBorder(BorderFactory.createBevelBorder(1,Color.RED,Color.GREEN));
//        jd.setDateFormatString("dd-MM-YYYY");
        add(jd);
        setVisible(true);
        String date=new SimpleDateFormat("dd-MM-yyyy").format(jd.getDate());
        System.out.println(date);
    }
    public static void main(String[] args) {
        new Test();
    }
}
