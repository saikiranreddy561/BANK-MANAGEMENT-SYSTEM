import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.util.Random;

public class MiniStatement extends JFrame {
    MiniStatement(String pinnumber) {
        setLayout(null);
        setTitle("MINI STATEMENT");

        JLabel bank=new JLabel("XYZ BANK");
        bank.setFont(new Font("Raleway",Font.PLAIN,20));
        bank.setBounds(110,20,150,20);
        add(bank);

        JLabel card=new JLabel();
        card.setBounds(50,80,300,20);
        add(card);

        JLabel text=new JLabel();
        text.setBounds(20,100,400,300);
        add(text);

        JLabel balance=new JLabel();
        balance.setBounds(20,400,400,20);
        add(balance);


        try{
            conn c=new conn();
            ResultSet rs=c.s.executeQuery("select * from login where pinNo='"+pinnumber+"'");
            while (rs.next()){
                card.setText("Card Number: "+rs.getString("cardNumber").substring(0,4)+"XXXXXXXX"+rs.getString("cardNumber").substring(12));
            }
        }catch (Exception e1){
            System.out.println(e1);
        }

        try{
            conn c=new conn();
            int bal=0;
            ResultSet rs=c.s.executeQuery("select * from bank where pinNo='"+pinnumber+"'");
            while (rs.next()){
                text.setText(text.getText()+"<html>"+rs.getString("date")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("amount")+"<br><br>"+"<html>");
                if(rs.getString("type").equals("Deposit")){
                    bal+=Integer.parseInt(rs.getString("amount"));
                }
                else{
                    bal-=Integer.parseInt(rs.getString("amount" ));
                }

            }
            balance.setText("Your Account Balance is RS. "+bal);
        }catch (Exception e1){
            System.out.println(e1);
        }


        setSize(350,500);
        setLocation(300,0);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);

    }
    public static void main(String... args) {

    new MiniStatement("");
}
}
