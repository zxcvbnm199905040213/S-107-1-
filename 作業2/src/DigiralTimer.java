import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DigiralTimer extends JFrame {
    public static void main(String[] args) {
        // new clock().setVisible(true);
    }
    Container cp;
    private JLabel jlbs[] = new JLabel[8];
    private JPanel jpnC = new JPanel(new GridLayout(1,8,2,2));
    private String jlbImageName[] = {"0.PNG", "1.PNG", "2.PNG", "3.PNG", "4.PNG", "5.PNG", "6.PNG", "7.PNG", "8.PNG", "9.PNG",};
    private ImageIcon icons[] = new ImageIcon[10];
    private JPanel jpnS = new JPanel(new GridLayout(1,3,3,3));
    private JButton jbtnstart = new JButton("Start");
    private JButton jbtnreset = new JButton("Reset");
    private JButton jbtnclose = new JButton("Close");
    private Timer t1;
    private int h,m,s;

    private Frame holy;

    public DigiralTimer(Frame holy) {
        xd();
    }
    public void xd(){
        cp = this.getContentPane();
        setBounds(100,100,300,150);
        cp.setLayout(new BorderLayout(3,3));
        for (int i = 0;i<10;i++){
            icons[i] = new ImageIcon(jlbImageName[i]);
            Image img = icons[i].getImage();
            Image newimg = img.getScaledInstance(30,60, Image.SCALE_SMOOTH);
            icons[i] = new ImageIcon(newimg);
        }
        jlbs[6] = new JLabel(":");
        jlbs[6] .setFont(new Font(null, Font.BOLD,24));
        jlbs[6].setHorizontalAlignment(JLabel.CENTER);
        jlbs[7] = new JLabel(":");
        jlbs[7] .setFont(new Font(null, Font.BOLD,24));
        jlbs[7].setHorizontalAlignment(JLabel.CENTER);

        for (int i =0;i<6;i++){
            jlbs[i] = new JLabel(icons[0]);
            if (i == 2){
                jpnC.add(jlbs[6]);
                jpnC.add(jlbs[i]);
            }else if (i == 4){
                jpnC.add(jlbs[7]);
                jpnC.add(jlbs[i]);
            }else {
                jpnC.add(jlbs[i]);
            }
        }
        t1 = new Timer(60, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                s++;
                if (s == 60) {
                    s = 0;
                    m++;
                    if (m == 60) {
                        m = 0;
                        h++;
                    }
                }
                if (s % 2 == 0) {
                    jlbs[6].setForeground(Color.GREEN);
                    jlbs[7].setForeground(Color.GREEN);
                } else {
                    jlbs[6].setForeground(Color.BLACK);
                    jlbs[7].setForeground(Color.BLACK);
                }
                jlbs[5].setIcon(icons[s % 10]);
                jlbs[4].setIcon(icons[s / 10]);
                jlbs[3].setIcon(icons[m % 10]);
                jlbs[2].setIcon(icons[m / 10]);
                jlbs[1].setIcon(icons[h % 10]);
                jlbs[0].setIcon(icons[h / 10]);
            }
        });
        cp.add(jpnC, BorderLayout.CENTER);
        cp.add(jpnS, BorderLayout.SOUTH);
        jpnS.add(jbtnstart); jpnS.add(jbtnreset); jpnS.add(jbtnclose);

        jbtnstart.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton tmpbtn = (JButton) e.getSource();
                if (tmpbtn.getText().equals("Start")) {
                    t1.start();
                    tmpbtn.setText("Pause");
                } else {
                    t1.stop();
                    tmpbtn.setText("Start");
                }
            }
        });

        jbtnclose.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Frame qw = new Frame();
                qw.setVisible(true);
                DigiralTimer.this.setVisible(false);
            }
        });

        jbtnreset.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

    }
}