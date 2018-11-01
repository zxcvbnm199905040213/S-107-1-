import javax.swing.*;
        import java.awt.*;
        import java.awt.event.ActionEvent;
        import java.awt.event.WindowAdapter;
        import java.awt.event.WindowEvent;
        import java.io.*;

public class encryptfile extends JFrame {
    public static void main(String[] args) {
    }

    private Container cp;
    private JPanel jplW = new JPanel(new GridLayout(2, 1, 3, 3));
    private JPanel jplE = new JPanel(new GridLayout(2, 1, 3, 3));
    private JPanel jplC = new JPanel(new GridLayout(2, 1, 3, 3));
    private JPanel jplN = new JPanel(new GridLayout(1, 6, 3, 3));
    private JPanel jplS = new JPanel(new GridLayout(1, 1, 0, 0));
    private JLabel jlb1 = new JLabel("原始檔");
    private JLabel jlb2 = new JLabel("加密檔");
    private JLabel jlb3 = new JLabel("加密法");
    private JLabel jlbkey = new JLabel("key");
    private String algoLabels[] = {"Caesar", "XOR", "DES", "AES"};
    private JComboBox jcomb = new JComboBox(algoLabels);
    private JTextField jtf1 = new JTextField();
    private JTextField jtf2 = new JTextField();
    private JTextField jtfkey = new JTextField("1723");
    private JButton jbtnchoose = new JButton("選擇");
    private JButton jbtnupload = new JButton("上傳");
    private JButton jbtnrun = new JButton("Run");
    private JButton jbtnclose = new JButton("Close");
    private JProgressBar jpb = new JProgressBar();
    private int frmw = 500, frmh = 250;
    private Timer t1;
    private int val = 10;
    private Frame gd;
    private JFileChooser jfc = new JFileChooser();
    private String loadfilename = "";

    public encryptfile(Frame good) {
        this.gd = gd;
        iii();
    }

    public void iii() {
        this.setBounds(120, 120, frmw, frmh);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                gd.setVisible(true);
            }
        });
        cp = this.getContentPane();
        cp.add(jplN, BorderLayout.NORTH);
        cp.add(jplW, BorderLayout.WEST);
        cp.add(jplC, BorderLayout.CENTER);
        cp.add(jplE, BorderLayout.EAST);
        cp.add(jplS, BorderLayout.SOUTH);

        jplN.add(jlb3);
        jplN.add(jcomb);
        jplN.add(jlbkey);
        jplN.add(jtfkey);
        jplN.add(jbtnrun);
        jplN.add(jbtnclose);

        jplW.add(jlb1);
        jplW.add(jlb2);

        jplC.add(jtf1);
        jplC.add(jtf2);

        jplE.add(jbtnchoose);
        jplE.add(jbtnupload);

        jplS.add(jpb);

        jbtnchoose.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (jfc.showOpenDialog(encryptfile.this) == JFileChooser.APPROVE_OPTION) {
                    loadfilename = jfc.getSelectedFile().getPath();
                    jtf1.setText(jfc.getSelectedFile().getPath());
                    jtf2.setText(jtf1.getText()+".sec");
                }
            }
        });

        jbtnrun.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (loadfilename.equals("")) {
                    JOptionPane.showMessageDialog(encryptfile.this, "No File Selected");
                } else {
                    try {
                        File selectFile = new File(jtf1.getText());
                        long fileLength = selectFile.length();
                        jpb.setMaximum(100);
                        char key[] = jtfkey.getText().toCharArray();
                        FileReader fr = new FileReader(selectFile);
                        BufferedReader bfr = new BufferedReader(fr);

                        File writeFile = new File(jtf2.getText());
                        FileWriter fw = new FileWriter(writeFile);
                        BufferedWriter bfw = new BufferedWriter(fw);

                        int data;
                        int i = 0;
                        while ((data = bfr.read()) != -1) {
                            data = data ^ key[i % key.length];
                            bfw.write(data);
                            i++;
                            jpb.setValue(Math.round((float) i / fileLength * 100));
                        }
                        bfw.close();
                        fr.close();
                        JOptionPane.showMessageDialog(encryptfile.this, "Finish!!");
                    } catch (IOException ioe3) {
                        JOptionPane.showMessageDialog(encryptfile.this, "Open File Error: " + ioe3.toString());
                    }
                }
            }
        });

        jbtnclose.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Frame qw = new Frame();
                qw.setVisible(true);
                encryptfile.this.setVisible(false);
            }
        });
    }
}