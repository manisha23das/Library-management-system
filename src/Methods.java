import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

public class Methods {
    public static String URL;
    public static String USER;
    public static String PASS;
    public static String database;
    public static String table;
    Connection con = null;
    Methods(){
        URL = "jdbc:mysql://localhost";
        USER = "root";
        PASS = "Harsh";
        database = "library";
    }
    public void login(String username, String password,Login login){
        String password1 = null;
        PreparedStatement p;
        ResultSet r;
        try
        {
            con = DriverManager.getConnection(URL,USER,PASS);
            Statement st = con.createStatement();
            String sql = "CREATE DATABASE IF NOT EXISTS "+database;
            st.executeUpdate(sql);
            sql = "USE "+database;
            st.executeUpdate(sql);
            sql = "select * from users";
            p = con.prepareStatement(sql);
            r = p.executeQuery();
            while (r.next()) {
                if (username.equals(r.getString("username"))){
                    password1 = r.getString("password");
                    break;
                }
            }
        }catch (SQLException se){se.printStackTrace();}
        finally
        {
            try
            {
                if(con != null)con.close();
            }catch (SQLException e){e.printStackTrace();}
        }
        if(password.equals(password1)) {
            login.setVisible(false);
            new Dashboard();
        }
        else {
            login.message.setText("Invalid Username or Password");
            login.message.setOpaque(true);
            login.message.setBackground(new Color(0,0,0));
            login.message.setForeground(new Color(255,255,255));
            login.message.setBorder(BorderFactory.createBevelBorder(1, Color.RED,Color.GREEN));
            login.message.setHorizontalAlignment(0);
        }
    }
    public void signup(String username, String password){
        table = "users";
        try
        {
            con = DriverManager.getConnection(URL,USER,PASS);
            Statement st = con.createStatement();
            String sql = "CREATE DATABASE IF NOT EXISTS "+database;
            st.executeUpdate(sql);
            sql = "USE "+database;
            st.executeUpdate(sql);
            sql = "INSERT INTO "+table+" VALUES('"+username+"','"+password+"');";
            st.executeUpdate(sql);
        }catch (SQLException se){se.printStackTrace();}
        finally
        {
            try
            {
                if(con != null)con.close();
            }catch (SQLException e){e.printStackTrace();}
        }
        new Login().setVisible(true);
    }
    public void addBook(String bookId, String bookName, String author, String publisher, String course, String NOC){
        int n = Integer.parseInt(NOC);
        try
        {
            con = DriverManager.getConnection(URL,USER,PASS);
            Statement st = con.createStatement();
            String sql = "CREATE DATABASE IF NOT EXISTS "+database;
            st.executeUpdate(sql);
            sql = "USE library";
            st.executeUpdate(sql);
            sql = "INSERT INTO books VALUES('"+bookId+"','"+bookName+"','"+author+"','"+publisher+"','"+course+"','"+n+"');";
            st.executeUpdate(sql);
        }catch (SQLException se){se.printStackTrace();}
        finally
        {
            try
            {
                if(con != null)con.close();
            }catch (SQLException e){e.printStackTrace();}
        }
    }
    public void addStudent(String studentId, String studentName, String fathersName, String course, String branch){
        table = "students";
        try
        {
            con = DriverManager.getConnection(URL,USER,PASS);
            Statement st = con.createStatement();
            String sql = "CREATE DATABASE IF NOT EXISTS "+database;
            st.executeUpdate(sql);
            sql = "USE "+database;
            st.executeUpdate(sql);
            sql = "INSERT INTO "+table+" VALUES('"+studentId+"','"+studentName+"','"+fathersName+"','"+course+"','"+branch+"');";
            st.executeUpdate(sql);
        }catch (SQLException se){se.printStackTrace();}
        finally
        {
            try
            {
                if(con != null)con.close();
            }catch (SQLException e){e.printStackTrace();}
        }
    }
    public void searchBookByName(String bookName, String publisher, SearchBook sb) {
        String[] books = new String[5];
        PreparedStatement p;
        ResultSet r;
        boolean flag = false;
        try
        {
            con = DriverManager.getConnection(URL,USER,PASS);
            Statement st = con.createStatement();
            String sql = "CREATE DATABASE IF NOT EXISTS "+database;
            st.executeUpdate(sql);
            sql = "USE "+database;
            st.executeUpdate(sql);
            sql = "select * from books";
            p = con.prepareStatement(sql);
            r = p.executeQuery();
            while (r.next()) {
                if (bookName.equals(r.getString("bookname")) && publisher.equals(r.getString("publisher"))){
                    books[0] = r.getString("bookid");
                    books[1] = r.getString("bookname");
                    books[2] = r.getString("author");
                    books[3] = r.getString("publisher");
                    books[4] = r.getString("course");
                    flag = true;
                    break;
                }
            }
        }catch (SQLException se){se.printStackTrace();}
        finally
        {
            try
            {
                if(con != null)con.close();
            }catch (SQLException e){e.printStackTrace();}
        }
        if(!flag){
            sb.message.setText("Book not found");
            sb.message.setOpaque(true);
            sb.message.setBackground(new Color(0,0,0));
            sb.message.setForeground(new Color(255,255,255));
            sb.message.setBorder(BorderFactory.createBevelBorder(1, Color.RED,Color.GREEN));
            sb.message.setHorizontalAlignment(0);
        }
        else {
            sb.bookIdL.setVisible(true); sb.bookId.setVisible(true);
            sb.bookNameL.setVisible(true);sb.bookName.setVisible(true);
            sb.authorL.setVisible(true);sb.author.setVisible(true);
            sb.publisherL.setVisible(true);sb.publisher.setVisible(true);
            sb.courseL.setVisible(true);sb.course.setVisible(true);
            sb.issue.setVisible(true);
            sb.bookId.setText(books[0]);
            sb.bookName.setText(books[1]);
            sb.author.setText(books[2]);
            sb.publisher.setText(books[3]);
            sb.course.setText(books[4]);
        }
    }
    public void searchBookById(String bookId, SearchBook sb) {
        String[] books = new String[5];
        PreparedStatement p;
        ResultSet r;
        boolean flag = false;
        try
        {
            con = DriverManager.getConnection(URL,USER,PASS);
            Statement st = con.createStatement();
            String sql = "CREATE DATABASE IF NOT EXISTS "+database;
            st.executeUpdate(sql);
            sql = "USE "+database;
            st.executeUpdate(sql);
            sql = "select * from books";
            p = con.prepareStatement(sql);
            r = p.executeQuery();
            while (r.next()) {
                if (bookId.equals(r.getString("bookid"))){
                    books[0] = r.getString("bookid");
                    books[1] = r.getString("bookname");
                    books[2] = r.getString("author");
                    books[3] = r.getString("publisher");
                    books[4] = r.getString("course");
                    flag = true;
                    break;
                }
            }
        }catch (SQLException se){se.printStackTrace();}
        finally
        {
            try
            {
                if(con != null)con.close();
            }catch (SQLException e){e.printStackTrace();}
        }
        if(!flag){
            sb.message.setText("Book not found");
            sb.message.setOpaque(true);
            sb.message.setBackground(new Color(0,0,0));
            sb.message.setForeground(new Color(255,255,255));
            sb.message.setBorder(BorderFactory.createBevelBorder(1, Color.RED,Color.GREEN));
            sb.message.setHorizontalAlignment(0);
        }
        else {
            sb.bookIdL.setVisible(true); sb.bookId.setVisible(true);
            sb.bookNameL.setVisible(true);sb.bookName.setVisible(true);
            sb.authorL.setVisible(true);sb.author.setVisible(true);
            sb.publisherL.setVisible(true);sb.publisher.setVisible(true);
            sb.courseL.setVisible(true);sb.course.setVisible(true);
            sb.issue.setVisible(true);
            sb.bookId.setText(books[0]);
            sb.bookName.setText(books[1]);
            sb.author.setText(books[2]);
            sb.publisher.setText(books[3]);
            sb.course.setText(books[4]);
        }
    }
    public void searchStudentByName(String studentName, String fathersName, SearchStudent sb) {
        String[] students = new String[5];
        PreparedStatement p;
        ResultSet r;
        boolean flag = false;
        try
        {
            con = DriverManager.getConnection(URL,USER,PASS);
            Statement st = con.createStatement();
            String sql = "CREATE DATABASE IF NOT EXISTS "+database;
            st.executeUpdate(sql);
            sql = "USE "+database;
            st.executeUpdate(sql);
            sql = "select * from students";
            p = con.prepareStatement(sql);
            r = p.executeQuery();
            while (r.next()) {
                if (studentName.equals(r.getString("studentname")) && fathersName.equals(r.getString("fathersname"))){
                    students[0] = r.getString("studentid");
                    students[1] = r.getString("studentname");
                    students[2] = r.getString("fathersname");
                    students[3] = r.getString("course");
                    students[4] = r.getString("branch");
                    flag = true;
                    break;
                }
            }
        }catch (SQLException se){se.printStackTrace();}
        finally
        {
            try
            {
                if(con != null)con.close();
            }catch (SQLException e){e.printStackTrace();}
        }
        if(!flag){
            sb.message.setText("Students not found");
            sb.message.setOpaque(true);
            sb.message.setBackground(new Color(0,0,0));
            sb.message.setForeground(new Color(255,255,255));
            sb.message.setBorder(BorderFactory.createBevelBorder(1, Color.RED,Color.GREEN));
            sb.message.setHorizontalAlignment(0);
        }
        else {
            sb.studentIdL.setVisible(true); sb.studentId.setVisible(true);
            sb.studentNameL.setVisible(true);sb.studentName.setVisible(true);
            sb.fathersNameL.setVisible(true);sb.fathersName.setVisible(true);
            sb.courseL.setVisible(true);sb.course.setVisible(true);
            sb.branchL.setVisible(true);sb.branch.setVisible(true);

            sb.studentId.setText(students[0]);
            sb.studentName.setText(students[1]);
            sb.fathersName.setText(students[2]);
            sb.branch.setText(students[4]);
            sb.course.setText(students[3]);
        }
    }
    public void searchStudentById(String studentId, SearchStudent sb) {
        String[] students = new String[5];
        PreparedStatement p;
        ResultSet r;
        boolean flag = false;
        try
        {
            con = DriverManager.getConnection(URL,USER,PASS);
            Statement st = con.createStatement();
            String sql = "CREATE DATABASE IF NOT EXISTS "+database;
            st.executeUpdate(sql);
            sql = "USE "+database;
            st.executeUpdate(sql);
            sql = "select * from students";
            p = con.prepareStatement(sql);
            r = p.executeQuery();
            while (r.next()) {
                if (studentId.equals(r.getString("studentid"))){
                    students[0] = r.getString("studentid");
                    students[1] = r.getString("studentname");
                    students[2] = r.getString("fathersname");
                    students[3] = r.getString("course");
                    students[4] = r.getString("branch");
                    flag = true;
                    break;
                }
            }
        }catch (SQLException se){se.printStackTrace();}
        finally
        {
            try
            {
                if(con != null)con.close();
            }catch (SQLException e){e.printStackTrace();}
        }
        if(!flag){
            sb.message.setText("Student not found");
            sb.message.setOpaque(true);
            sb.message.setBackground(new Color(0,0,0));
            sb.message.setForeground(new Color(255,255,255));
            sb.message.setBorder(BorderFactory.createBevelBorder(1, Color.RED,Color.GREEN));
            sb.message.setHorizontalAlignment(0);
        }
        else {
            sb.studentNameL.setVisible(true); sb.studentName.setVisible(true);
            sb.studentIdL.setVisible(true);sb.studentId.setVisible(true);
            sb.fathersNameL.setVisible(true);sb.fathersName.setVisible(true);
            sb.branchL.setVisible(true);sb.branch.setVisible(true);
            sb.courseL.setVisible(true);sb.course.setVisible(true);

            sb.studentId.setText(students[0]);
            sb.studentName.setText(students[1]);
            sb.fathersName.setText(students[2]);
            sb.branch.setText(students[4]);
            sb.course.setText(students[3]);
        }
    }
    public int getStudentCount(){
        int count = 0;
        PreparedStatement p;
        ResultSet r;

        try
        {
            con = DriverManager.getConnection(URL,USER,PASS);
            Statement st = con.createStatement();
            String sql = "CREATE DATABASE IF NOT EXISTS "+database;
            st.executeUpdate(sql);
            sql = "USE "+database;
            st.executeUpdate(sql);
            sql = "select * from students";
            p = con.prepareStatement(sql);
            r = p.executeQuery();
            while (r.next())  count++;
        }catch (SQLException se){se.printStackTrace();}
        finally
        {
            try
            {
                if(con != null)con.close();
            }catch (SQLException e){e.printStackTrace();}
        }
        return count+1001;
    }
    public int getBookCount(){
        int count = 0;
        PreparedStatement p;
        ResultSet r;

        try
        {
            con = DriverManager.getConnection(URL,USER,PASS);
            Statement st = con.createStatement();
            String sql = "CREATE DATABASE IF NOT EXISTS "+database;
            st.executeUpdate(sql);
            sql = "USE "+database;
            st.executeUpdate(sql);
            sql = "select * from books";
            p = con.prepareStatement(sql);
            r = p.executeQuery();
            while (r.next())  count++;
        }catch (SQLException se){se.printStackTrace();}
        finally
        {
            try
            {
                if(con != null)con.close();
            }catch (SQLException e){e.printStackTrace();}
        }
        return count+1001;
    }
    public void issueBook(String studentId, String bookId, String bookName, String course){
        PreparedStatement p;
        ResultSet r;
        try
        {
            con = DriverManager.getConnection(URL,USER,PASS);
            Statement st = con.createStatement();
            String sql = "CREATE DATABASE IF NOT EXISTS "+database;
            st.executeUpdate(sql);
            sql = "USE "+database;
            st.executeUpdate(sql);
            Calendar c = Calendar.getInstance();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            String doi = df.format(c.getTime());
            c.setTime(new Date());
            c.add(Calendar.DATE, 15);
            String dor = df.format(c.getTime());
            sql = "INSERT INTO bookissued VALUES('"+studentId+"','"+bookId+"','"+bookName+"','"+course+"','"+doi+"','"+dor+"','0');";
            st.executeUpdate(sql);
            sql = "select numberofcopies from books where bookid = '"+bookId+"'";
            p = con.prepareStatement(sql);
            r = p.executeQuery();
            int n = Integer.parseInt(r.getString("numberofcopies"));
            n--;
            sql = "update books set numberofcopies = "+n+";";
            st.executeUpdate(sql);
        }catch (SQLException se){

        }
        finally
        {
            try
            {
                if(con != null)con.close();
            }catch (SQLException e){e.printStackTrace();}
        }
    }
    public void searchByName(String studentName, String fathersName, ReturnBook rb) {
        String[][] students = new String[4][4];
        String studentId = "";
        PreparedStatement p;
        ResultSet r;
        boolean flag = false;
        int count = 0;
        try
        {
            con = DriverManager.getConnection(URL,USER,PASS);
            Statement st = con.createStatement();
            String sql = "CREATE DATABASE IF NOT EXISTS "+database;
            st.executeUpdate(sql);
            sql = "USE "+database;
            st.executeUpdate(sql);
            sql = "select * from students where studentname = '"+studentName+"' && fathersname = '"+fathersName+"'";
            p = con.prepareStatement(sql);
            r = p.executeQuery();
            if (r.next())
                studentId = r.getString("studentid");
            sql = "update bookissued set fine = (select curdate()) - DOR;";
            st.executeUpdate(sql);
            sql = "update bookissued set fine = 0 where fine < 0;";
            st.executeUpdate(sql);
            sql = "select * from bookissued where studentid = '"+studentId+"'";
            p = con.prepareStatement(sql);
            r = p.executeQuery();
            while (r.next()) {
                students[count][0] = r.getString("bookid");
                students[count][1] = r.getString("DOI");
                students[count][2] = r.getString("DOR");
                students[count][3] = r.getString("FINE");
                flag = true;
                count++;
            }
        }catch (SQLException se){se.printStackTrace();}
        finally
        {
            try
            {
                if(con != null)con.close();
            }catch (SQLException e){e.printStackTrace();}
        }
        if(!flag){
            rb.message.setText("Student record not found");
            rb.message.setOpaque(true);
            rb.message.setBackground(new Color(0,0,0));
            rb.message.setForeground(new Color(255,255,255));
            rb.message.setBorder(BorderFactory.createBevelBorder(1, Color.RED,Color.GREEN));
            rb.message.setHorizontalAlignment(0);
        }
        else {
            for(int i = 0; i <= count; i++) {
                if(i<count)
                    rb.return_book[i].setVisible(true);
                for (int j = 0; j < 4; j++) {
                    if (i != 0) {
                        rb.books[i * 4 + j].setVisible(true);
                        rb.books[i * 4 + j].setText(students[i-1][j]);
                        rb.books[i * 4 + j].setHorizontalAlignment(0);
                    } else {
                        rb.books[j].setVisible(true);
                        rb.books[j].setHorizontalAlignment(0);
                    }
                }
            }
        }
    }
    public void searchById(String studentId, ReturnBook rb) {
        String[][] students = new String[4][4];
        PreparedStatement p;
        ResultSet r;
        boolean flag = false;
        int count = 0;
        try
        {
            con = DriverManager.getConnection(URL,USER,PASS);
            Statement st = con.createStatement();
            String sql = "CREATE DATABASE IF NOT EXISTS "+database;
            st.executeUpdate(sql);
            sql = "USE "+database;
            st.executeUpdate(sql);
            sql = "update bookissued set fine = (select curdate()) - DOR;";
            st.executeUpdate(sql);
            sql = "update bookissued set fine = 0 where fine < 0;";
            st.executeUpdate(sql);
            sql = "select * from bookissued where studentid = '"+studentId+"'";
            p = con.prepareStatement(sql);
            r = p.executeQuery();
            while (r.next()) {
                    students[count][0] = r.getString("bookid");
                    students[count][1] = r.getString("DOI");
                    students[count][2] = r.getString("DOR");
                    students[count][3] = r.getString("FINE");
                    flag = true;
                    count++;
            }
        }catch (SQLException se){se.printStackTrace();}
        finally
        {
            try
            {
                if(con != null)con.close();
            }catch (SQLException e){e.printStackTrace();}
        }
        if(!flag){
            rb.message.setText("Student record not found");
            rb.message.setOpaque(true);
            rb.message.setBackground(new Color(0,0,0));
            rb.message.setForeground(new Color(255,255,255));
            rb.message.setBorder(BorderFactory.createBevelBorder(1, Color.RED,Color.GREEN));
            rb.message.setHorizontalAlignment(0);
        }
        else {
            for(int i = 0; i <= count; i++) {
                if(i<count)
                    rb.return_book[i].setVisible(true);
                for (int j = 0; j < 4; j++) {
                    if (i != 0) {
                        rb.books[i * 4 + j].setVisible(true);
                        rb.books[i * 4 + j].setText(students[i-1][j]);
                        rb.books[i * 4 + j].setHorizontalAlignment(0);
                    } else {
                        rb.books[j].setVisible(true);
                        rb.books[j].setHorizontalAlignment(0);
                    }
                }
            }
        }
    }
    public void returnBook(String bookId, int n, ReturnBook rb){
        String studentId  = rb.sStudentId.getText();
        PreparedStatement p;
        ResultSet r;
        String studentName = rb.sStudentName.getText();
        String fathersName  = rb.sFathersName.getText();
        try
        {
            con = DriverManager.getConnection(URL,USER,PASS);
            Statement st = con.createStatement();
            String sql = "CREATE DATABASE IF NOT EXISTS "+database;
            st.executeUpdate(sql);
            sql = "USE library";
            st.executeUpdate(sql);
            if(studentId.equals("")) {
                sql = "select * from students where studentname = '" + studentName + "' && fathersname = '" + fathersName + "'";
                p = con.prepareStatement(sql);
                r = p.executeQuery();
                if (r.next())
                    studentId = r.getString("studentid");
            }
            sql = "delete from bookissued where studentid = '"+studentId+"' && bookid = '"+bookId+"'";
            st.executeUpdate(sql);
            rb.books[n*4].setText("");
            rb.books[n*4+1].setText("");
            rb.books[n*4+2].setText("");
            rb.books[n*4+3].setText("");
        }catch (SQLException se){se.printStackTrace();}
        finally
        {
            try
            {
                if(con != null)con.close();
            }catch (SQLException e){e.printStackTrace();}
        }
    }
}