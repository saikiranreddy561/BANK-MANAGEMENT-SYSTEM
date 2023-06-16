import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
public class LoginPage extends JFrame{
    JButton login,signup,clear;
    JTextField cardn;
    JPasswordField pinn;
    LoginPage(){
        setLayout(null);
        setTitle("AUTOMATIC TELLER MACHINE");

        //image adding
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("image/bbb.jpg"));
        Image i2=i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel l=new JLabel(i3);
        l.setBounds(50,30,80,70);
        add(l);
        getContentPane().setBackground(Color.WHITE);

        //text adding
        JLabel text=new JLabel("Welcome To ATM ...");
        text.setFont(new Font("Arial",Font.BOLD,38));
        text.setBounds(170,50,450,40);
        add(text);

        JLabel cardno=new JLabel("Card.No:");
        cardno.setFont(new Font("Arial",Font.BOLD,20));
        cardno.setBounds(120,140,450,20);
        add(cardno);
        JTextField cardn=new JTextField();
        cardn.setBounds(220,145,200,20);
        add(cardn);

        JLabel pin =new JLabel("Pin:");
        pin.setFont(new Font("Osward",Font.BOLD,20));
        pin.setBounds(120,190,450,20);
        add(pin);
        JPasswordField pinn=new JPasswordField();
        pinn.setBounds(220,195,200,20);
        add(pinn);

        JLabel noacc=new JLabel("No Account ?");
        noacc.setBounds(278,265,400,30);
        add(noacc);

        //button adding
        JButton login =new JButton("SIGN IN");
        login.setBounds(190,230,100,30);
        login.setBackground(Color.DARK_GRAY);
        login.setForeground(Color.WHITE);
      //  login.addActionListener(this);
        add(login);
        JButton clear =new JButton("CLEAR");
        clear.setBounds(330,230,100,30);
        clear.setBackground(Color.DARK_GRAY);
        clear.setForeground(Color.WHITE);
       // clear.addActionListener(this);
        add(clear);

        JButton signup=new JButton("SIGN UP");
        signup.setBounds(260,290,100,30);
        signup.setBackground(Color.DARK_GRAY);
        signup.setForeground(Color.WHITE);
      //  signup.addActionListener(this);
        add(signup);


        //frame
        setSize(600,400);
        setVisible(true);
        setLocation(420,200);

        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==clear){
                    cardn.setText("");
                    pinn.setText("");

                }
            }});
        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                conn c=new conn();
                if(e.getSource()==login){
                    String cardnumber= cardn.getText();
                    String pinnumber=pinn.getText();
                    String query="Select * from login where cardNumber ='"+cardnumber+"' and pinNo='"+pinnumber+"'" ;
                    try{
                        ResultSet rs= c.s.executeQuery(query);
                        if(rs.next()){
                            setVisible(false);
                            new Transcation(pinnumber).setVisible(true);
                        }else{
                            JOptionPane.showMessageDialog(null,"Card number or pin is incorrect");
                        }

                    }catch(Exception e1){
                        System.out.println(e1);
                    }
                }
            }});

        signup.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==signup){
                   setVisible(false);
                   new SignUp().setVisible(true);

                }
            }});



    }
    public static void main(String ...args){
        new LoginPage();
    }
}
