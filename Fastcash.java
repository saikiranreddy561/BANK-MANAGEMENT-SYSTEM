import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.sql.ResultSet;

public class Fastcash extends JFrame {
    Fastcash(String pinnumber){
        JButton r100,r500,r1000,r2000,r5000,r10000,back;
        setLayout(null);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("image/ATM.jpg"));
        Image i2=i1.getImage().getScaledInstance(800,850,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,800,800);
        add(image);

        JLabel text=new JLabel("SELECT WITHDRAWL AMOUNT");
        text.setFont(new Font("Raleway", Font.BOLD,18));
        text.setBounds(200,280,400,25);
        image.add(text);


        r100 =new JButton("RS.100");
        r100.setBounds(190,360,100,20);
        r100.setBackground(Color.DARK_GRAY);
        r100.setForeground(Color.WHITE);
        image.add(r100);

        r500 =new JButton("Rs.500");
        r500.setBounds(190,385,100,20);
       r500.setBackground(Color.DARK_GRAY);
        r500.setForeground(Color.WHITE);
        image.add(r500);

        r1000 =new JButton("Rs.1000");
        r1000.setBounds(190,410,100,20);
        r1000.setBackground(Color.DARK_GRAY);
       r1000.setForeground(Color.WHITE);
        image.add(r1000);

        r2000 =new JButton("Rs.2000");
        r2000.setBounds(365,360,120,20);
        r2000.setBackground(Color.DARK_GRAY);
        r2000.setForeground(Color.WHITE);
        image.add(r2000);

        r5000 =new JButton("Rs.5000");
        r5000.setBounds(365,385,125,20);
        r5000.setBackground(Color.DARK_GRAY);
        r5000.setForeground(Color.WHITE);
        image.add(r5000);

        r10000 =new JButton("Rs.10000");
        r10000.setBounds(365,410,120,20);
        r10000.setBackground(Color.DARK_GRAY);
        r10000.setForeground(Color.WHITE);
        image.add(r10000);

        back =new JButton("Back");
        back.setBounds(365,435,120,20);
        back.setBackground(Color.DARK_GRAY);
        back.setForeground(Color.WHITE);
        image.add(back);


        setSize(800,800);
        setLocation(300,0);
        //setUndecorated(true);
        setVisible(true);
        r100.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String amount=((JButton)e.getSource()).getText().substring(3);
                conn c=new conn();
                try{
                    ResultSet rs=c.s.executeQuery("select * from bank where pinNo='"+pinnumber+"'");
                    int balance=0;
                    while (rs.next()){
                        if(rs.getString("type").equals("Deposit")){
                            balance+=Integer.parseInt(rs.getString("amount"));
                        }
                        else{
                            balance-=Integer.parseInt(rs.getString("amount" ));
                        }
                    }
                    if(e.getSource()!=back && balance<Integer.parseInt(amount)){
                        JOptionPane.showMessageDialog(null,"Insufficient Balance");
                        return;
                    }
                    Date date=new Date();
                    String  query ="insert into bank values('"+pinnumber+"','"+date+"','Withdrawl','"+amount+"')";
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null,"Rs. "+amount+" Withdrawl Succesful");

                    setVisible(false);
                    new Transcation(pinnumber).setVisible(true);

                }catch (Exception e1){
                    System.out.println(e1);
                }
            }


            });
        r500.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String amount=((JButton)e.getSource()).getText().substring(3);
                conn c=new conn();
                try{
                    ResultSet rs=c.s.executeQuery("select * from bank where pinNo='"+pinnumber+"'");
                    int balance=0;
                    while (rs.next()){
                        if(rs.getString("type").equals("Deposit")){
                            balance+=Integer.parseInt(rs.getString("amount"));
                        }
                        else{
                            balance-=Integer.parseInt(rs.getString("amount" ));
                        }
                    }
                    if(e.getSource()!=back && balance<Integer.parseInt(amount)){
                        JOptionPane.showMessageDialog(null,"Insufficient Balance");
                        return;
                    }
                    Date date=new Date();
                    String  query ="insert into bank values('"+pinnumber+"','"+date+"','Withdrawl','"+amount+"')";
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null,"Rs. "+amount+" Withdrawl Succesful");

                    setVisible(false);
                    new Transcation(pinnumber).setVisible(true);

                }catch (Exception e1){
                    System.out.println(e1);
                }

            }
        });
        r1000.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String amount=((JButton)e.getSource()).getText().substring(3);
                conn c=new conn();
                try{
                    ResultSet rs=c.s.executeQuery("select * from bank where pinNo='"+pinnumber+"'");
                    int balance=0;
                    while (rs.next()){
                        if(rs.getString("type").equals("Deposit")){
                            balance+=Integer.parseInt(rs.getString("amount"));
                        }
                        else{
                            balance-=Integer.parseInt(rs.getString("amount" ));
                        }
                    }
                    if(e.getSource()!=back && balance<Integer.parseInt(amount)){
                        JOptionPane.showMessageDialog(null,"Insufficient Balance");
                        return;
                    }
                    Date date=new Date();
                    String  query ="insert into bank values('"+pinnumber+"','"+date+"','Withdrawl','"+amount+"')";
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null,"Rs. "+amount+" Withdrawl Succesful");

                    setVisible(false);
                    new Transcation(pinnumber).setVisible(true);

                }catch (Exception e1){
                    System.out.println(e1);
                }

            }
        });

        r2000.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String amount=((JButton)e.getSource()).getText().substring(3);
                conn c=new conn();
                try{
                    ResultSet rs=c.s.executeQuery("select * from bank where pinNo='"+pinnumber+"'");
                    int balance=0;
                    while (rs.next()){
                        if(rs.getString("type").equals("Deposit")){
                            balance+=Integer.parseInt(rs.getString("amount"));
                        }
                        else{
                            balance-=Integer.parseInt(rs.getString("amount" ));
                        }
                    }
                    if(e.getSource()!=back && balance<Integer.parseInt(amount)){
                        JOptionPane.showMessageDialog(null,"Insufficient Balance");
                        return;
                    }
                    Date date=new Date();
                    String  query ="insert into bank values('"+pinnumber+"','"+date+"','Withdrawl','"+amount+"')";
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null,"Rs. "+amount+" Withdrawl Succesful");

                    setVisible(false);
                    new Transcation(pinnumber).setVisible(true);

                }catch (Exception e1){
                    System.out.println(e1);
                }

            }});
        r5000.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String amount=((JButton)e.getSource()).getText().substring(3);
                conn c=new conn();
                try{
                    ResultSet rs=c.s.executeQuery("select * from bank where pinNo='"+pinnumber+"'");
                    int balance=0;
                    while (rs.next()){
                        if(rs.getString("type").equals("Deposit")){
                            balance+=Integer.parseInt(rs.getString("amount"));
                        }
                        else{
                            balance-=Integer.parseInt(rs.getString("amount" ));
                        }
                    }
                    if(e.getSource()!=back && balance<Integer.parseInt(amount)){
                        JOptionPane.showMessageDialog(null,"Insufficient Balance");
                        return;
                    }
                    Date date=new Date();
                    String  query ="insert into bank values('"+pinnumber+"','"+date+"','Withdrawl','"+amount+"')";
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null,"Rs. "+amount+" Withdrawl Succesful");

                    setVisible(false);
                    new Transcation(pinnumber).setVisible(true);

                }catch (Exception e1){
                    System.out.println(e1);
                }

            }
        });
        r10000.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String amount=((JButton)e.getSource()).getText().substring(3);
                conn c=new conn();
                try{
                    ResultSet rs=c.s.executeQuery("select * from bank where pinNo='"+pinnumber+"'");
                    int balance=0;
                    while (rs.next()){
                        if(rs.getString("type").equals("Deposit")){
                            balance+=Integer.parseInt(rs.getString("amount"));
                        }
                        else{
                            balance-=Integer.parseInt(rs.getString("amount" ));
                        }
                    }
                    if(e.getSource()!=back && balance<Integer.parseInt(amount)){
                        JOptionPane.showMessageDialog(null,"Insufficient Balance");
                        return;
                    }
                    Date date=new Date();
                    String  query ="insert into bank values('"+pinnumber+"','"+date+"','Withdrawl','"+amount+"')";
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null,"Rs. "+amount+" Withdrawl Succesful");

                    setVisible(false);
                    new Transcation(pinnumber).setVisible(true);

                }catch (Exception e1){
                    System.out.println(e1);
                }

            }
        });


        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == back) {
                    setVisible(false);
                    new Transcation(pinnumber).setVisible(true);
                }
            }


        });




    }
    public static void main(String...args){
        new Fastcash("");
    }
}




