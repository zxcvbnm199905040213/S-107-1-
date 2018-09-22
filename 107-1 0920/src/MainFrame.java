import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MainFrame  extends JFrame{
    private JButton jbt1[][] = new JButton[3][4] ;

    private JLabel jlb = new JLabel("");

    private JPasswordField jps = new JPasswordField();

    private Container cp ;

    private JPanel jpn1 = new JPanel(new GridLayout(1,1,5,5));
    private JPanel jpn2 = new JPanel(new GridLayout(3,4,3,3));
    private JPanel jpn3 = new JPanel(new GridLayout(1,1,5,5));

    public MainFrame(){
        init();
    }

    private void init(){

        this.setBounds(100,100,425,500);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        cp = this.getContentPane();
        cp.add(jpn1,BorderLayout.NORTH);
        cp.add(jpn2,BorderLayout.CENTER);
        cp.add(jpn3,BorderLayout.SOUTH);
        jpn1.add(jps);
        jpn3.add(jlb);


        jbt1[0][0]=new JButton("0");
        jbt1[0][1]=new JButton("1");
        jbt1[0][2]=new JButton("2");
        jbt1[0][3]=new JButton("3");
        jbt1[1][0]=new JButton("4");
        jbt1[1][1]=new JButton("5");
        jbt1[1][2]=new JButton("6");
        jbt1[1][3]=new JButton("7");
        jbt1[2][0]=new JButton("8");
        jbt1[2][1]=new JButton("9");
        jbt1[2][2]=new JButton("送出");
        jbt1[2][3]=new JButton("Exit");
        for (int i = 0 ; i < 3 ; i++){
            for (int j = 0 ; j<4 ;j++){
                jpn2.add(jbt1[i][j]);
            }
        }

        jbt1[2][3].addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        jbt1[0][0].addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jps.setText("0");
            }
        });

        jbt1[0][1].addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jps.setText("1");
            }
        });

        jbt1[0][2].addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jps.setText("2");
            }
        });

        jbt1[0][3].addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jps.setText("3");
            }
        });

        jbt1[1][0].addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jps.setText("4");
            }
        });

        jbt1[1][1].addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jps.setText("5");
            }
        });

        jbt1[1][2].addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jps.setText("6");
            }
        });

        jbt1[1][3].addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jps.setText("7");
            }
        });

        jbt1[2][0].addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jps.setText("8");
            }
        });

        jbt1[2][1].addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jps.setText("9");
            }
        });

        jbt1[2][2].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (new String(jps.getPassword()).equals("123456")){
                    jlb.setText("OK");
                }else {
                    jlb.setText("NO");
                }
            }
        });

    }
}
