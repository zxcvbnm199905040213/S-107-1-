import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainFrame3     extends JFrame{
    private Container cp;
    private JTextArea jtaR = new JTextArea("",30,15);
    private JTextArea jtaL = new JTextArea("",30,15);
    private JScrollPane jspR = new JScrollPane(jtaR);
    private JScrollPane jspL = new JScrollPane(jtaL);
    private JPanel jpnC = new JPanel(new GridLayout(9,1,5,5));
    private JPanel jpnR = new JPanel(new GridLayout(1,1,5,5));
    private JPanel jpnL = new JPanel(new GridLayout(1,1,5,5));
    private JLabel jlb1 = new JLabel("Method");
    private String method [] = {"DES","AES", "XOR","Caesar"};
    private JComboBox jca = new JComboBox<String>(method);
    private JLabel jlb2 = new JLabel("Password");
    private JTextField jtf = new JTextField();
    private JRadioButton jrb1=new JRadioButton("Encrypt");
    private JRadioButton jrb2=new JRadioButton("Decrypt");
    private JButton jbtrun = new JButton("Run");
    private JButton jbtclose = new JButton("Close");
    private ButtonGroup buttonGroup = new ButtonGroup();

    boolean boo = true;

    public Frame frame;

    public MainFrame3(Frame frame){
        this.frame = frame;
        ex1();
    }

    private void ex1(){
        this.setBounds(100,100,760,600);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.addWindowListener(new WindowAdapter() {
                @Override
            public void windowClosed(WindowEvent e) {
                Frame frm=new Frame();
                frm.setVisible(true);
            }
        });
        cp = this.getContentPane();
        cp.add(jpnL, BorderLayout.WEST);
        cp.add(jpnC, BorderLayout.CENTER);
        cp.add(jpnR, BorderLayout.EAST);
        jpnL.add(jspL);
        jpnR.add(jspR);
        jpnC.add(jlb1);
        jpnC.add(jca);
        jpnC.add(jlb2);
        jpnC.add(jtf);
        jpnC.add(jrb1);
        jpnC.add(jrb2);
        jpnC.add(jbtrun);
        jpnC.add(jbtclose);
        buttonGroup.add(jrb1);
        buttonGroup.add(jrb2);

        jbtrun.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });

    }
}
