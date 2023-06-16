import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class SignUp2 extends JFrame {
    SignUp2(String formno){

        JRadioButton r1,r2,r3,r4;
        JCheckBox c1,c2,c3,c4,c5;
        JButton submit,cancel;

        setSize(800,700);
        setLocation(350,0);
        setVisible(true);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel title=new JLabel("Form - 3: Account Details...");
        title.setFont(new Font("Raleway",Font.BOLD,35));
        title.setBounds(180,20,500,35);
        add(title);

        JLabel type=new JLabel("Account Type:");
        type.setFont(new Font("Raleway",Font.BOLD,25));
        type.setBounds(100,100,200,30);
        add(type);

        r1=new JRadioButton("SavingsAccount");

        r1.setBackground(Color.WHITE);
        r1.setBounds(120,150,200,30);
        add(r1);
        r2=new JRadioButton("Fixed Deposit Account");
        r2.setBackground(Color.WHITE);
        r2.setBounds(350,150,300,30);
        add(r2);
        r3=new JRadioButton("Current Account");
        r3.setBackground(Color.WHITE);
        r3.setBounds(120,200,200,30);
        add(r3);
        r4=new JRadioButton("Recurring Deposit Account");
        r4.setBackground(Color.WHITE);
        r4.setBounds(350,200,400,30);
        add(r4);
        ButtonGroup rg=new ButtonGroup();
        rg.add(r1);
        rg.add(r2);
        rg.add(r3);
        rg.add(r4);

        JLabel card=new JLabel("Card Number :");
        card.setFont(new Font("Raleway",Font.BOLD,25));
        card.setBounds(100,250,200,35);
        add(card);
        JLabel cardno=new JLabel("XXXX-XXXX-XXXX-4512");
        cardno.setFont(new Font("Raleway",Font.BOLD,22));
        cardno.setBounds(300,250,400,35);
        add(cardno);
        JLabel carddet=new JLabel("This is your 16 digit card.no");
   //     carddet.setFont(new Font("Raleway",Font.BOLD,12));
        carddet.setBounds(100,275,350,25);
        add(carddet);

        JLabel pin=new JLabel("Pin Number :");
        pin.setFont(new Font("Raleway",Font.BOLD,25));
        pin.setBounds(100,320,200,35);
        add(pin);
        JLabel pinno=new JLabel("XXXX");
        pinno.setFont(new Font("Raleway",Font.BOLD,22));
        pinno.setBounds(300,320,200,35);
        add(pinno);
        JLabel pindet=new JLabel("This is your 4 digit pin.no");
       // pindet.setFont(new Font("Raleway",Font.BOLD,12));
        pindet.setBounds(100,345,350,25);
        add(pindet);

        JLabel services=new JLabel("Services Required:");
        services.setFont(new Font("Raleway",Font.BOLD,25));
        services.setBounds(100,385,350,35);
        add(services);
        c1=new JCheckBox("ATM Card");
        c1.setBackground(Color.WHITE);
     //   c1.setFont(new Font("Raleway",Font.BOLD,18));
        c1.setBounds(120,435,200,25);
        add(c1);
        c2=new JCheckBox("Internet Banking");
        c2.setBackground(Color.WHITE);
     //   c2.setFont(new Font("Raleway",Font.BOLD,18));
        c2.setBounds(350,435,200,25);
        add(c2);

        c3=new JCheckBox("Email & SMS Alert");
        c3.setBackground(Color.WHITE);
      //  c3.setFont(new Font("Raleway",Font.BOLD,18));
        c3.setBounds(120,460,200,25);
        add(c3);

        c4=new JCheckBox("Cheque Book");
        c4.setBackground(Color.WHITE);
      //  c4.setFont(new Font("Raleway",Font.BOLD,18));
        c4.setBounds(350,460,200,25);
        add(c4);

        c5=new JCheckBox("I here by declare that The Details provided are correct to my knowledge.");
        c5.setBackground(Color.WHITE);
       // c5.setFont(new Font("Raleway",Font.BOLD,20));
        c5.setBounds(100,500,730,25);
        add(c5);

        cancel=new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Raleway",Font.BOLD,20));
       cancel.setBounds(200,560,110,25);
        add(cancel);
        submit=new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Raleway",Font.BOLD,20));
        submit.setBounds(450,560,110,25);

        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==cancel){
                    setVisible(false);
                    new LoginPage().setVisible(true);
                }
            }});

        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                    String acctype="";
                    if(r1.isSelected()){
                        acctype="Savings Account";
                    } else if (r2.isSelected()) {
                        acctype="Fixed Deposit Account";
                    } else if (r3.isSelected()) {
                        acctype="Current Account";
                    } else if(r4.isSelected()){
                        acctype="Reccuring Deposit Account";
                    }
                    Random random=new Random();
                    String  cardno=""+Math.abs((random.nextLong() % 90000000L) +6048526500000000L);
                    String  pinno=""+Math.abs((random.nextLong() % 9000L)+1000L) ;
                    String service="";
                    if(c1.isSelected()){
                        service+=" Atm Card";
                    }if(c2.isSelected()){
                        service+=" ,Internet Banking";
                    }if(c3.isSelected()){
                        service+=" ,Email & SMS Alerts";
                    }if(c4.isSelected()){
                        service+=" ,Cheque Book";
                    }
                    try {
                        if(acctype.equals("")){
                            JOptionPane.showMessageDialog(null,"Account type is required..");
                        }
                        else{
                            conn c=new conn();
                            String query="insert into signup2 values('"+formno+"','"+acctype+"','"+cardno+"','"+pinno+"','"+service+"')";
                            String query1="insert into login values('"+formno+"','"+cardno+"','"+pinno+"')";
                            c.s.executeUpdate(query1);
                            c.s.executeUpdate(query);
                            JOptionPane.showMessageDialog(null,"Card.No: "+cardno+"\n Pin.No: "+pinno);
                            setVisible(false);
                            new Deposit(pinno).setVisible(true);
                        }

                    }catch (Exception e1){
                        System.out.println(e1);
                    }



            }
        });
        add(submit);
      cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });





    }
    public static void main(String...args){
        new SignUp2("");
    }
}
