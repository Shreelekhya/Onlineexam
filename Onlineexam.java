import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;

class Onlineexam extends JFrame{
 JButton SUBMIT;
 JLabel label1,label2;
 final JTextField  text1,text2;
  Onlineexam(){
    setTitle("Login Form");
    setLayout(null);
    label1 = new JLabel();
    label1.setText("Username:");
    text1 = new JTextField(15);

    label2 = new JLabel();
    label2.setText("Password:");
    text2 = new JPasswordField(15);
    SUBMIT=new JButton("SUBMIT");
    label1.setBounds(350,100,100,20);
    text1.setBounds(450,100,200,20);
    label2.setBounds(350,130,100,20);
    text2.setBounds(450,130,200,20);
    SUBMIT.setBounds(450,160,100,20);
   add(label1);
   add(text1);
   add(label2);
   add(text2);
   add(SUBMIT);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   setVisible(true);
   setSize(1024,768);
   getContentPane().setBackground(Color.cyan);

 SUBMIT.addActionListener(new ActionListener(){
   public void actionPerformed(ActionEvent ae){
    String value1=text1.getText();
    String value2=text2.getText();
try{
           Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
           Connection con = DriverManager.getConnection("jdbc:odbc:loginpage", "shreelu", "shilpa");
           Statement st=con.createStatement();
		   //String query1="CREATE TABLE LOGINPAGE ( USERNAME VARCHAR(20),PASSWORD VARCHAR(20) )";
		   //st.executeUpdate(query1);
		   //System.out.println("table created successfully");
		   //st.executeUpdate("INSERT INTO LOGINPAGE VALUES('shreelu','shilpa')");
           ResultSet rs=st.executeQuery("select * from loginpage where username='"+value1+"' and password='"+value2+"'");
           String uname="",pass="";
           if(rs.next()){
               uname=rs.getString("username");
               pass=rs.getString("password");
			   }
 if(value1.equals("") && value2.equals("")) {
      JOptionPane.showMessageDialog(null,"Enter login name or password","Error",JOptionPane.ERROR_MESSAGE);
  }
 else if(value1.equals(uname) && value2.equals(pass)) {
    Onlinetest w=new Onlinetest();
    //w.setVisible(true);
    }
 else if (!value1.equals(uname) && !value2.equals(pass)) {
 JOptionPane.showMessageDialog(null,"Incorrect login.Try again!!","Error",JOptionPane.ERROR_MESSAGE);
     text1.setText("");
     text2.setText("");
    }
    }
	catch(ClassNotFoundException cnfe)
{
System.out.println(cnfe.getMessage());
return;
}
catch(SQLException sqle)
{
System.out.println(sqle.getMessage());
}
    catch(Exception e){}
}
 });
  }

  public static void main(String arg[]){
  Onlineexam l=new Onlineexam();
}
}
class Question1 extends JFrame implements ActionListener
{
JFrame f1;Label w1;Button b2;Label l5;Label b8,b9,b10,b11,b12;Checkbox c1,c2,c3,c4,c5,c6,c7,c8,c9,c10;
public Question1(String title)
{
super(title);
f1=new JFrame("online test");
f1.setLayout(new BorderLayout());
String info="\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n1:The worlds environment day is on june 5\n\n\n 2:In java we can use operator overloading\n\n\n3:JDBC stands for java data base connectivity\n\n\n4:throws is used when exception is occured in method\n\n\n 5:applets is concept in c:";
f1.add(new TextArea(info),BorderLayout.WEST);
w1=new Label("WELCOME TO THE ONLINE TEST");
f1.add(w1,BorderLayout.NORTH);
Font f2=new Font("Arial",Font.BOLD,19);
w1.setFont(f2);
w1.setBounds(300,100,90,30);
b2=new Button("finish");
l5=new Label("");
b2.setBounds(650,650,90,30);
f1.add(b2,BorderLayout.SOUTH);
f1.add(l5,BorderLayout.SOUTH);
b8=new Label("1:");
b9=new Label("2:");
b10=new Label("3:");
b11=new Label("4:");
b12=new Label("5:");
f1.add(b8,BorderLayout.EAST);
f1.add(b9,BorderLayout.EAST);
f1.add(b10,BorderLayout.EAST);
f1.add(b11,BorderLayout.EAST);
f1.add(b12,BorderLayout.EAST);
b8.setBounds(500,300,90,30);
b9.setBounds(500,350,90,30);
b10.setBounds(500,400,90,30);
b11.setBounds(500,450,90,30);
b12.setBounds(500,500,90,30);
c1=new Checkbox("true");
c6=new Checkbox("false");
c2=new Checkbox("true");
c7=new Checkbox("false");
c3=new Checkbox("true");
c8=new Checkbox("false");
c4=new Checkbox("true");
c9=new Checkbox("false");
c5=new Checkbox("true");
c10=new Checkbox("false");
Label la=new Label("");
c1.setBounds(600,300,90,30);
f1.add(c1,BorderLayout.EAST);
c2.setBounds(600,350,90,30);
f1.add(c2,BorderLayout.EAST);
c3.setBounds(600,400,90,30);
f1.add(c3,BorderLayout.EAST);
c4.setBounds(600,450,90,30);
f1.add(c4,BorderLayout.EAST);
c5.setBounds(600,500,90,30);
f1.add(c5,BorderLayout.EAST);
c6.setBounds(700,300,90,30);
f1.add(c6,BorderLayout.EAST);
c7.setBounds(700,350,90,30);
f1.add(c7,BorderLayout.EAST);
c8.setBounds(700,400,90,30);
f1.add(c8,BorderLayout.EAST);
c9.setBounds(700,450,90,30);
f1.add(c9,BorderLayout.EAST);
c10.setBounds(700,500,90,30);
f1.add(c10,BorderLayout.EAST);
Label t2=new Label("answer True or False");
Font f3=new Font("Arial",Font.BOLD,12);
t2.setFont(f3);
t2.setBounds(600,250,200,50);
f1.add(t2,BorderLayout.EAST);
f1.add(la,BorderLayout.EAST); 
f1.getContentPane().setBackground(Color.pink);
f1.setSize(1000,1000);
b2.addActionListener(this);
f1.setVisible(true);
}
int k=0;
Label z,x,c,v,b;
public void actionPerformed(ActionEvent ae)
{

if(ae.getSource()==b2)
{
if(c1.getState()==true && c6.getState()==false)
k++;
if(c2.getState()==false && c7.getState()==true)
k++;
if(c3.getState()==true && c8.getState()==false)
k++;
if(c4.getState()==true && c9.getState()==false)
k++;
if(c5.getState()==false && c10.getState()==true)
k++;
if(k==0)
javax.swing.JOptionPane.showMessageDialog(this,"your score is 0");
if(k==1)
javax.swing.JOptionPane.showMessageDialog(this,"your score is 1");
if(k==2)
javax.swing.JOptionPane.showMessageDialog(this,"your score is 2");
if(k==3)
javax.swing.JOptionPane.showMessageDialog(this,"your score is 3");
if(k==4)
javax.swing.JOptionPane.showMessageDialog(this,"your score is 4");
if(k==5)
javax.swing.JOptionPane.showMessageDialog(this,"your score is 5");
System.exit(0);
}
}
}
class Onlinetest extends JFrame implements ActionListener
{
Onlinetest()
{
JFrame f=new JFrame("online test");
f.setLayout(new BorderLayout());
String info ="Java Online Test Week  \n \nINSTRUCTIONS:\nThere are 5 questions in this test.All of the questions are true or false type.\n You need to select any one of the option but not both.\nAfter finishing the test you can press finish button to submit your answers.\n Score will be displayed immediatly after you press finish button.\n\n ALL THE BEST\n";
f.add(new TextArea(info),BorderLayout.WEST);
Label w=new Label("WELCOME TO THE ONLINE TEST");
f.add(w,BorderLayout.NORTH);
Font f2=new Font("Arial",Font.BOLD,19);
w.setFont(f2);
w.setBounds(300,100,90,30);
Button b1=new Button("start");
b1.setBounds(500,650,90,30);
b1.addActionListener(this);
Label b5=new Label("");
f.add(b1,BorderLayout.SOUTH);
f.add(b5,BorderLayout.SOUTH);
 Label t2=new Label("ANSWER TRUE OR FALSE");
Font f1=new Font("Arial",Font.BOLD,40);
t2.setFont(f1);
t2.setBounds(600,250,200,50);
f.add(t2,BorderLayout.EAST); 
f.getContentPane().setBackground(Color.pink);
f.setSize(1000,1000);
f.setVisible(true);
}
public void actionPerformed(ActionEvent ae)
{
String arg=(String)ae.getActionCommand();
if(arg.equals("start"))
{
Question1 w=new Question1("TEST");
}
}
}
