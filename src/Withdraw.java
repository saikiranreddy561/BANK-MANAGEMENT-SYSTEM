import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class Withdraw extends JFrame {
    Withdraw(String pinnumber){
        JTextField am;
        JButton withdraw,back;

        setVisible(true);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("image/ATM.jpg"));
        Image i2=i1.getImage().getScaledInstance(800,850,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,800,800);
        add(image);

        JLabel text=new JLabel("Enter the amount to Withdraw");
        text.setFont(new Font("Raleway",Font.BOLD,20));
        text.setBounds(200,280,300,22);
        image.add(text);

        am=new JTextField();
        am.setFont(new Font("Raleway",Font.BOLD,20));
        am.setBounds(235,320,200,25);
        image.add(am);

        withdraw=new JButton("Withdraw");
        withdraw.setBackground(Color.DARK_GRAY);
        withdraw.setForeground(Color.WHITE);
        withdraw.setBounds(385,410,100,22);
        image.add(withdraw);

        back=new JButton("Back");
        back.setBackground(Color.DARK_GRAY);
        back.setForeground(Color.WHITE);
        back.setBounds(385,438,100,22);
        image.add(back);


        setSize(800,800);
        setLocation(310,0);
        setLayout(null);

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==back){
                    setVisible(false);
                    new Transcation(pinnumber).setVisible(true);
                }
            }});

        withdraw.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==withdraw){
                    String amount=am.getText();
                    Date d=new Date();
                    if(amount.equals("")){
                        JOptionPane.showMessageDialog(null,"Enter Amount To Withdraw");
                    }
                    else{
                        try {
                            conn c = new conn();
                            String query = "insert into bank values('" + pinnumber + "','" + d + "','Withdrawl','" + amount + "')";
                            c.s.executeUpdate(query);
                            JOptionPane.showMessageDialog(null,"Rs: "+amount+" Withdrawll Successfull");
                            setVisible(false);

                        }catch(Exception e1){
                            System.out.println(e1);
                        }
                    }
                }
            }});


    }

    public static void main(String ...hii){
        new Withdraw("");
    }
}
