import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Transcation extends JFrame {

    Transcation(String pinnumber){

        JButton deposit,withdraaw,statement,balance,pinchange,exit,fastcash;

        setLayout(null);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("image/ATM.jpg"));
        Image i2=i1.getImage().getScaledInstance(800,850,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,800,800);
        add(image);

        JLabel text=new JLabel("Please select your Transcation");
        text.setFont(new Font("Raleway", Font.BOLD,18));
        text.setBounds(200,280,400,25);
        image.add(text);


        deposit =new JButton("Deposit");
        deposit.setBounds(190,360,100,20);
        deposit.setBackground(Color.DARK_GRAY);
        deposit.setForeground(Color.WHITE);
        image.add(deposit);

        fastcash =new JButton("Fast Cash");
        fastcash.setBounds(190,385,100,20);
        fastcash.setBackground(Color.DARK_GRAY);
        fastcash.setForeground(Color.WHITE);
        image.add(fastcash);

        pinchange =new JButton("Pin Change");
        pinchange.setBounds(190,410,100,20);
        pinchange.setBackground(Color.DARK_GRAY);
        pinchange.setForeground(Color.WHITE);
        image.add(pinchange);

        withdraaw =new JButton("Cash Withdraw");
        withdraaw.setBounds(365,360,120,20);
        withdraaw.setBackground(Color.DARK_GRAY);
        withdraaw.setForeground(Color.WHITE);
        image.add(withdraaw);

        balance =new JButton("BalanceEnquiry");
        balance.setBounds(365,385,125,20);
        balance.setBackground(Color.DARK_GRAY);
        balance.setForeground(Color.WHITE);
        image.add(balance);

        statement =new JButton("Mini Statement");
        statement.setBounds(365,410,120,20);
        statement.setBackground(Color.DARK_GRAY);
        statement.setForeground(Color.WHITE);
        image.add(statement);

        exit =new JButton("Exit");
        exit.setBounds(365,435,120,20);
        exit.setBackground(Color.DARK_GRAY);
        exit.setForeground(Color.WHITE);
        image.add(exit);


        setSize(800,800);
        setLocation(300,0);
        //setUndecorated(true);
        setVisible(true);
        statement.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==statement){

                    new MiniStatement(pinnumber).setVisible(true);
                }
            }});

        deposit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==deposit){
                    setVisible(false);
                    new Deposit(pinnumber).setVisible(true);
                }
            }});


        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==exit){
                    System.exit(0);
                }


                }


        });

        withdraaw.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==withdraaw){
                    setVisible(false);
                    new Withdraw(pinnumber).setVisible(true);
                }
            }});
        fastcash.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==fastcash){
                    setVisible(false);
                    new Fastcash(pinnumber).setVisible(true);
                }
            }});

        pinchange.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==pinchange){
                    setVisible(false);
                    new Pinchange(pinnumber).setVisible(true);
                }
            }});

        balance.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==balance){
                    setVisible(false);
                    new Balanceenquiry(pinnumber).setVisible(true);
                }
            }});


    }
    public static void main(String...args){
        new Transcation("");
    }
}
