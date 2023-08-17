import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;

public class SignUp extends JFrame {
    long random;
    JTextField namet,fnamet,dobt,phonet,addresst,statet,cityt,pincodet;
    JButton next;
    JRadioButton male,female,married,unmarried,other;
    SignUp(){

        //frame
        getContentPane().setBackground(Color.WHITE);
        setSize(800,800);
        setLocation(350,10);
        setVisible(true);

        //
        setLayout(null);
        Random ran=new Random();
        long random =Math.abs((ran.nextLong())%9000L+1000L);
        JLabel formno=new JLabel("Application No:"+random);
        formno.setFont(new Font("Raleway",Font.BOLD,38));
        formno.setBounds(190,20,600,40);
        add(formno);

        JLabel personaldetails=new JLabel("Form 1: Personal Details..");
        personaldetails.setFont(new Font("Raleway",Font.BOLD,30));
        personaldetails.setBounds(200,80,600,35);
        add(personaldetails);

        JLabel name=new JLabel("Name:");
        name.setFont(new Font("Raleway",Font.BOLD,20));
        name.setBounds(100,180,100,20);
        add(name);
        JTextField namet=new JTextField();
        namet.setBounds(250,180,300,20);
        add(namet);


        JLabel fname=new JLabel("Father's Name:");
        fname.setFont(new Font("Raleway",Font.BOLD,20));
        fname.setBounds(100,230,200,20);
        add(fname);
        JTextField fnamet=new JTextField();
        fnamet.setBounds(250,230,300,20);
        add(fnamet);

        JLabel dob=new JLabel("Date.Of.Birth:");
        dob.setFont(new Font("Raleway",Font.BOLD,20));
        dob.setBounds(100,280,200,20);
        add(dob);
        JTextField dobt=new JTextField();
        dobt.setBounds(250,280,300,20);
        add(dobt);

        JLabel gender=new JLabel("Gender:");
        gender.setFont(new Font("Raleway",Font.BOLD,20));
        gender.setBounds(100,330,200,20);
        add(gender);
        JRadioButton male=new JRadioButton("Male");
        male.setBounds(250,330,60,20);
        male.setBackground(Color.WHITE);
        add(male);
        JRadioButton female=new JRadioButton("Female");
        female.setBounds(350,330,100,20);
        female.setBackground(Color.WHITE);
        add(female);
        ButtonGroup genderg=new ButtonGroup();
        genderg.add(male);
        genderg.add(female);


        JLabel phone=new JLabel("Phone.No:");
        phone.setFont(new Font("Raleway",Font.BOLD,20));
        phone.setBounds(100,380,200,20);
        add(phone);
        JTextField phonet=new JTextField();
        phonet.setBounds(250,380,300,20);
        add(phonet);

        JLabel maritials=new JLabel("Maritial Status:");
        maritials.setFont(new Font("Raleway",Font.BOLD,20));
        maritials.setBounds(100,430,200,20);
        add(maritials);
        JRadioButton married=new JRadioButton("Married");
        married.setBounds(250,430,100,20);
        married.setBackground(Color.WHITE);
        add(married);
        JRadioButton unmarried=new JRadioButton("Unmarried");
        unmarried.setBounds(350,430,100,20);
        unmarried.setBackground(Color.WHITE);
        add(unmarried);
        JRadioButton other=new JRadioButton("Other");
        other.setBounds(460,430,100,20);
        other.setBackground(Color.WHITE);
        add(other);
        ButtonGroup maritialsg=new ButtonGroup();
        maritialsg.add(married);
        maritialsg.add(unmarried);
        maritialsg.add(other);

        JLabel address=new JLabel("Address:");
        address.setFont(new Font("Raleway",Font.BOLD,20));
        address.setBounds(100,480,200,20);
        add(address);
        JTextField addresst=new JTextField();
        addresst.setBounds(250,480,300,20);
        add(addresst);

        JLabel city=new JLabel("City:");
        city.setFont(new Font("Raleway",Font.BOLD,20));
        city.setBounds(100,530,200,20);
        add(city);
        JTextField cityt=new JTextField();
        cityt.setBounds(250,530,300,20);
        add(cityt);

        JLabel state=new JLabel("State");
        state.setFont(new Font("Raleway",Font.BOLD,20));
        state.setBounds(100,580,200,20);
        add(state);
        JTextField statet=new JTextField();
        statet.setBounds(250,580,300,20);
        add(statet);

        JLabel pincode=new JLabel("Pin Code:");
        pincode.setFont(new Font("Raleway",Font.BOLD,20));
        pincode.setBounds(100,630,200,20);
        add(pincode);
        JTextField pincodet=new JTextField();
        pincodet.setBounds(250,630,300,20);
        add(pincodet);

        JButton next=new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBounds(580,660,80,30);
        next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String formno=""+random;
                String name=namet.getText();
                String fname=fnamet.getText();
                String dob=dobt.getText();
                String gender=null;
                if(male.isSelected()){
                    gender="male";

                }
                else if(female.isSelected()){
                    gender="Female";
                }
                String phoneno=phonet.getText();
                String maritials=null;
                if(married.isSelected()){
                    maritials="Married";
                }else if(unmarried.isSelected()){
                    maritials="Unmarried";
                }else if(other.isSelected()){
                    maritials="Other";
                }
                String address=addresst.getText();
                String city=cityt.getText();
                String state=statet.getText();
                String pincode=pincodet.getText();
                try{
                    if(name.equals("")|| fname.equals("")  || dob.equals("")  ||phoneno.equals("") || address.equals("") || city.equals("") || state.equals("")|| pincode.equals("") ){
                        JOptionPane.showMessageDialog(null,"Enter All Required Fields To proceed..");
                    }
                    else{
                        conn c=new conn();
                        String query="insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+" ','"+phoneno+"' ,'"+maritials+"','"+address+"','"+city+"','"+pincode+"','"+state+"')";
                        c.s.executeUpdate(query);
                        setVisible(false);
                        new SignUp1(formno).setVisible(true);
                    }

                }catch(Exception e1){
                    System.out.println(e1);
                }

            }
        });
        add(next);


    }


    public static void main(String...args){
        new SignUp();

    }
}
