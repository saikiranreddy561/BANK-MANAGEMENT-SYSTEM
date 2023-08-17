import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class SignUp1 extends JFrame {
    JTextField pant,adhart;
    JButton next;
    JRadioButton yes,no,eyes,eno;
    JComboBox religioncb,categorycb,educationcb,qualificationcb,incomecb;
    String formno;
    SignUp1(String formno){

        this.formno=formno;
        //frame
        getContentPane().setBackground(Color.WHITE);
        setSize(700,750);
        setLocation(350,100);
        setVisible(true);

        //
        setLayout(null);

        JLabel additionaldetails=new JLabel("Form 2: Additional Details..");
        additionaldetails.setFont(new Font("Raleway",Font.BOLD,30));
        additionaldetails.setBounds(200,50,600,35);
        add(additionaldetails);

        JLabel religion=new JLabel("Religion:");
        religion.setFont(new Font("Raleway",Font.BOLD,20));
        religion.setBounds(100,150,200,25);
        add(religion);
        String r[]={"Hindu", "Muslim","Sikh","Christian","Other"};
        JComboBox religioncb =new JComboBox(r);
        religioncb.setBounds(200,150,250,25);
        add(religioncb);


        JLabel category=new JLabel("Category:");
        category.setFont(new Font("Raleway",Font.BOLD,20));
        category.setBounds(100,210,200,25);
        add(category);
        String c[]={"General","BC","SC","ST","Other"};
        JComboBox categorycb=new JComboBox(c);
        categorycb.setBounds(200,210,250,25);
        add(categorycb);

        JLabel income=new JLabel("Income:");
        income.setFont(new Font("Raleway",Font.BOLD,20));
        income.setBounds(100,260,200,25 );
        add(income);
        String i[]={"<100000","100000-300000","300000-500000","500000-900000",">1000000"};
        JComboBox incomecb=new JComboBox(i);
        incomecb.setBounds(200,260,250,25);
        add(incomecb);

        JLabel education=new JLabel("EducationQualification:");
        education.setFont(new Font("Raleway",Font.BOLD,20));
        education.setBounds(100,310,300,25);
        add(education);
        String e[]={"SSC","Inter","Graduation","Other"};
        JComboBox educationcb=new JComboBox(e);
        educationcb.setBounds(330,310,250,25);
        add(educationcb);


        JLabel occupation=new JLabel("Occupation:");
        occupation.setFont(new Font("Raleway",Font.BOLD,20));
        occupation.setBounds(100,360,200,25);
        add(occupation);
        String o[]={"Salaried","Self Employed","Business Man","Student","Other"};
        JComboBox occupationcb=new JComboBox(o);
        occupationcb.setBounds(250,360,250,25);
        add(occupationcb);

        JLabel pan=new JLabel("Pan.No:");
        pan.setFont(new Font("Raleway",Font.BOLD,20));
        pan.setBounds(100,410,200,25);
        add(pan);
        JTextField pant=new JTextField();
        pant.setBounds(200,410,250,25);
        add(pant);

        JLabel adhar=new JLabel("Aadhar.No:");
        adhar.setFont(new Font("Raleway",Font.BOLD,20));
        adhar.setBounds(100,460,200,25);
        add(adhar);
        JTextField adhart=new JTextField();
        adhart.setBounds(250,460,250,25);
        add(adhart);


        JLabel senior=new JLabel("SeniorCitizen:");
        senior.setFont(new Font("Raleway",Font.BOLD,20));
        senior.setBounds(100,510,180,25);
        add(senior);
        JRadioButton yes=new JRadioButton("Yes");
        yes.setBounds(250,510,80,25);
        add(yes);
        JRadioButton no=new JRadioButton("No");
        no.setBounds(350,510,80,25);
        add(no);
        ButtonGroup seniorg=new ButtonGroup();
        seniorg.add(yes);
        seniorg.add(no);


        JLabel eacc=new JLabel("exisistingAcc:");
        eacc.setFont(new Font("Raleway",Font.BOLD,20));
        eacc.setBounds(100,560,200,25);
        add(eacc);
        JRadioButton eyes=new JRadioButton("Yes");
        eyes.setBounds(250,560,80,25);
        add(eyes);
        JRadioButton eno=new JRadioButton("No");
        eno.setBounds(350,560,80,25);
        add(eno);
        ButtonGroup eaccg=new ButtonGroup();
        eaccg.add(eyes);
        eaccg.add(eno);


        JButton next=new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBounds(540,610,80,30);
        next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String sreligion = (String) religioncb.getSelectedItem();
                String scategory = (String) categorycb.getSelectedItem();
                String soccupation = (String) occupationcb.getSelectedItem();
                String sincome = (String) incomecb.getSelectedItem();
                String seducation = (String) educationcb.getSelectedItem();
                String seniorc = null;

                if (yes.isSelected()) {
                    seniorc = "Yes";

                } else if (no.isSelected()) {
                    seniorc = "No";
                }
                String sexisting = null;

                if (eyes.isSelected()) {
                    sexisting = "Yes";
                } else if (eno.isSelected()) {
                    sexisting = "No";
                }

                String span = pant.getText();
                String sadhar = adhart.getText();
                try{
                    if(span.equals("")  || sadhar.equals("")){
                        JOptionPane.showMessageDialog(null,"Enter All Required Fields To proceed..");
                    }
                    else{
                        conn c=new conn();
                        String query="insert into signup1 values('"+formno+"','"+sreligion+"','"+scategory+"','"+sincome+"','"+seducation+" ','"+soccupation+"' ,'"+span+"','"+sadhar+"','"+seniorc+"','"+sexisting+"')";
                        c.s.executeUpdate(query);
                        setVisible(false);
                        new SignUp2(formno).setVisible(true);


                    }

                }catch(Exception e1){
                    System.out.println(e1);
                }


            }

        });
        add(next);


    }


    public static void main(String...args){
        new SignUp1("");

    }
}
