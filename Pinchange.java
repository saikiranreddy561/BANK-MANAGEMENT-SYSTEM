import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Pinchange extends JFrame {
    JLabel newpin,newpint;
    JButton back,change;
    Pinchange(String pinnumber){
        setLayout(null);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("image/ATM.jpg"));
        Image i2=i1.getImage().getScaledInstance(800,850,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,800,800);
        add(image);

        JLabel text=new JLabel("PIN CHANGE");
        text.setFont(new Font("Raleway",Font.BOLD,20));
        text.setBounds(300,280,300,22);
        image.add(text);

        JLabel newpin=new JLabel("New Pin:");
        newpin.setFont(new Font("Raleway",Font.BOLD,18));
        newpin.setBounds(200,320,150,20);
        image.add(newpin);

        JTextField newpint=new JTextField();
        newpint.setBounds(325,320,110,20);
        image.add(newpint);

        JLabel reenter=new JLabel("Re-Enter Pin:");
        reenter.setFont(new Font("Raleway",Font.BOLD,18));
        reenter.setBounds(200,360,150,20);
        image.add(reenter);

        JTextField reentert=new JTextField();
        reentert.setBounds(325,360,110,20);
        image.add(reentert);

        JButton back=new JButton("Back");
        back.setBounds(365,435,120,20);
        back.setBackground(Color.DARK_GRAY);
        back.setForeground(Color.WHITE);
        image.add(back);

        JButton change=new JButton("Change");
        change.setBounds(365,410,120,20);
        change.setBackground(Color.DARK_GRAY);
        change.setForeground(Color.WHITE);
        image.add(change);


        setSize(800,800);
        setLocation(300,0);
        setVisible(true);

        change.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(e.getSource()==change){
                    try {
                        String nep = newpint.getText();
                        String rep = reentert.getText();

                        if (nep.equals(rep) && (!nep.equals("")||!rep.equals(""))) {
                            conn c= new conn();
                            String query1="update bank set pinNo='"+rep+"' where pinNo='"+pinnumber+"'";
                            String query2="update login set pinNo='"+rep+"' where pinNo='"+pinnumber+"'";
                            String query3="update signup2 set pinNo='"+rep+"' where pinNo='"+pinnumber+"'";
                            c.s.executeUpdate(query1);
                            c.s.executeUpdate(query2);
                            c.s.executeUpdate(query3);

                            JOptionPane.showMessageDialog(null, "Pin Changed Succesfully...");
                            setVisible(false);
                            new Transcation(pinnumber).setVisible(true);

                        }
                        else if (nep.equals(""))  {


                            JOptionPane.showMessageDialog(null, "Please Enter Pin...");

                        }
                        else if (rep.equals(""))  {
                            conn c= new conn();

                            JOptionPane.showMessageDialog(null, "Please Re-Enter Pin...");

                        }
                        else {
                            JOptionPane.showMessageDialog(null, "Re-Enter Pin Correctly..");
                            return;
                        }
                    }catch (Exception e1){
                        System.out.println(e1);
                    }
                }
            }});

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==back){
                    setVisible(false);
                    new Transcation(pinnumber).setVisible(true);
                }
            }});


    }
    public static void main(String...args){
        new Pinchange("");
    }
}
