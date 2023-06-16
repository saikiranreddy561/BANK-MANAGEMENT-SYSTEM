import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Balanceenquiry extends JFrame {
    JButton back;
    Balanceenquiry(String pinnumber){
        setLayout(null);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("image/ATM.jpg"));
        Image i2=i1.getImage().getScaledInstance(800,850,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,800,800);
        add(image);


        back=new JButton("Back");
        back.setBackground(Color.DARK_GRAY);
        back.setForeground(Color.WHITE);
        back.setBounds(365,435,100,20);
        image.add(back);

        conn c=new conn();
        int balance = 0;
        try {
            ResultSet rs = c.s.executeQuery("select * from bank where pinNo='" + pinnumber + "'");
            // int balance = 0;
            while (rs.next()) {
                if (rs.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
        }catch (Exception e1){
            System.out.println(e1);
        }

        JLabel text=new JLabel("Your Account Balance is:");
        text.setFont(new Font("Raleway",Font.BOLD,18));
        text.setBounds(200,300,400,30);
        image.add(text);
        JLabel bal=new JLabel(""+balance);
        bal.setFont(new Font("Raleway",Font.BOLD,18));
       bal.setBounds(300,330,400,30);
        image.add(bal);

        setSize(800,800);
        setLocation(300,0);
        setVisible(true);

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==back){
                    setVisible(false);
                    new Transcation(pinnumber).setVisible(true);
                }
            }
        });



    }
    public  static void main(String...args){
        new Balanceenquiry("");
    }
}
