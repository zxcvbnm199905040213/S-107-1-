import javax.swing.*;
import java.awt.*;

public class MainFrame3 extends JFrame{

    Container cp;
    private JLabel jlb1 = new JLabel();
    private JLabel jlb2 = new JLabel();
    private JButton jbtn1 = new JButton();
    private JButton jbtn2 = new JButton();
    private JPasswordField jps = new JPasswordField();
    private JComponent jcp = new JComboBox<>();
    private JRadioButton jrbt = new JRadioButton();
    private JRadioButton jrbt2 = new JRadioButton();

    private ButtonGroup btng = new ButtonGroup();

    private JTextArea jtx1 = new JTextArea();
    private JTextArea jtx2 = new JTextArea();
    private JPanel jpn = new JPanel(new GridLayout(9,1,1,1));
    private JPanel jp2 = new JPanel(new GridLayout(1,1,1,1));
    private JPanel jp3 = new JPanel(new GridLayout(1,1,1,1));

    public MainFrame3(){
        init3();
    }
    private void init3(){
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setBounds(150,150,980,600);
        cp = this.getContentPane();

        jp2.add(jtx1);
        jp3.add(jtx2);
        jpn.add(jlb1);
        jpn.add(jlb2);

    }
}