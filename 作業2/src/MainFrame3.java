import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;


public class MainFrame3     extends JFrame{
    private Container cp;
    private JTextArea jta1 = new JTextArea("", 50, 25);
    private JTextArea jta2 = new JTextArea("", 50, 25);
    private JScrollPane jsp1 = new JScrollPane(jta1);
    private JScrollPane jsp2 = new JScrollPane(jta2);
    private JLabel jlb1 = new JLabel("Method");
    private String methodStr[] = {"DES", "AES", "Caesar", "XOR"};
    private JComboBox jcomb = new JComboBox<String>(methodStr);
    private JLabel jlbPW = new JLabel("Password");
    private JTextField jtfPW = new JTextField();
    private JRadioButton jrb1 = new JRadioButton("Encrypt");
    private JRadioButton jrb2 = new JRadioButton("Decrypt");
    private JButton jbtnrun = new JButton("Run");
    private JButton jbtnclose = new JButton("close");
    private ButtonGroup btnGroup = new ButtonGroup();

    private JMenuBar jmb = new JMenuBar();
    private JMenu jmf = new JMenu("File");
    private JMenu jma = new JMenu("About");
    private JMenuItem jmiopen = new JMenuItem("Open");
    private JMenuItem jmiclose = new JMenuItem("Close");
    private JMenuItem jmisave = new JMenuItem("Save");
    private JFileChooser jfc = new JFileChooser();

    private JPanel jpl1 = new JPanel(new GridLayout(9, 1, 1, 1));
    private JPanel jpl2 = new JPanel(new GridLayout(1, 1, 1, 1));
    private JPanel jpl3 = new JPanel(new GridLayout(1, 1, 1, 1));

    boolean boo = true;

    public Frame frame;

    public MainFrame3(Frame frame){
        this.frame = frame;
        ex();
    }

    private void ex() {
        this.setBounds(100, 100, 760, 600);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                Frame frm = new Frame();
                frm.setVisible(true);
            }
        });
        cp = this.getContentPane();
        cp.add(jpl1, BorderLayout.CENTER);
        cp.add(jpl2, BorderLayout.WEST);
        cp.add(jpl3, BorderLayout.EAST);
        jpl1.add(jlb1);
        jpl1.add(jcomb);
        jpl1.add(jlbPW);
        jpl1.add(jtfPW);
        jpl1.add(jrb1);
        jpl1.add(jrb2);
        jpl1.add(jbtnrun);
        jpl1.add(jbtnclose);

        jpl2.add(jsp1);
        jpl3.add(jsp2);

        btnGroup.add(jrb1);
        btnGroup.add(jrb2);

        this.setJMenuBar(jmb);
        jmb.add(jmf);
        jmb.add(jma);
        jmf.add(jmiopen);
        jmf.add(jmisave);
        jmf.add(jmiclose);

        jbtnrun.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (jrb1.isSelected()) {
                    int dataLength = jta1.getText().length();
                    if (dataLength > 0) {
                        switch (jcomb.getSelectedIndex()) {
                            case 0:
                                JOptionPane.showMessageDialog(MainFrame3.this, "sorry, "
                                        + jcomb.getSelectedItem() + "not implement yet!");
                                break;
                            case 1:
                                JOptionPane.showMessageDialog(MainFrame3.this, "sorry, "
                                        + jcomb.getSelectedItem() + "not implement yet!");
                                break;
                            case 2:
                                try {
                                    int key = Integer.parseInt(jtfPW.getText());
                                    char data[] = jta1.getText().toCharArray();
                                    for (int i = 0; i < dataLength; i++) {
                                        data[i] = (char) (data[i] + key);
                                    }
                                    jta2.setText(new String(data));
                                } catch (NumberFormatException exp) {
                                    JOptionPane.showMessageDialog(MainFrame3.this,
                                            "key is not a number");
                                } catch (Exception exp1) {
                                    JOptionPane.showMessageDialog(MainFrame3.this, "Error:" +
                                            exp1.toString());
                                }
                                break;
                            case 3:
                                JOptionPane.showMessageDialog(MainFrame3.this, "sorry, "
                                        + jcomb.getSelectedItem() + "not implement yet!");
                        }
                    }
                } else if (jrb2.isSelected()) {
                    int dataLength = jta2.getText().length();
                    if (dataLength > 0) {
                        switch (jcomb.getSelectedIndex()) {
                            case 0:
                                JOptionPane.showMessageDialog(MainFrame3.this, "sorry, "
                                        + jcomb.getSelectedItem() + "not implement yet!");
                                break;
                            case 1:
                                JOptionPane.showMessageDialog(MainFrame3.this, "sorry, "
                                        + jcomb.getSelectedItem() + "not implement yet!");
                                break;
                            case 2:
                                try {
                                    int key = Integer.parseInt(jtfPW.getText());
                                    char data[] = jta2.getText().toCharArray();
                                    for (int i = 0; i < dataLength; i++) {
                                        data[i] = (char) (data[i] - key);
                                    }
                                    jta1.setText(new String(data));
                                } catch (NumberFormatException exp) {
                                    JOptionPane.showMessageDialog(MainFrame3.this,
                                            "key is not a number");
                                } catch (Exception exp1) {
                                    JOptionPane.showMessageDialog(MainFrame3.this, "Error:" +
                                            exp1.toString());
                                }
                                break;
                            case 3:
                                JOptionPane.showMessageDialog(MainFrame3.this, "sorry, "
                                        + jcomb.getSelectedItem() + "not implement yet!");
                        }
                    }
                }
            }
        });
        jmiopen.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (jfc.showOpenDialog(MainFrame3.this) == JFileChooser.APPROVE_OPTION){
                        jta1.setText("");
                        String str = "";
                        File selectFile = jfc.getSelectedFile();
                        FileReader fr = new FileReader(selectFile);
                        BufferedReader bfr = new BufferedReader(fr);
                        while ((str = bfr.readLine()) != null){
                            jta1.append(str);
                        }
                        fr.close();
                    }
                }catch (IOException ioe){
                    JOptionPane.showMessageDialog(MainFrame3.this, "Open file error: "
                            +ioe.toString());
                }
            }
        });
        jmisave.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (jta2.getText().length() > 0) {
                        jfc.setFileFilter(new FileNameExtensionFilter(".txt ", "txt"));
                        if (jfc.showSaveDialog(MainFrame3.this) == JFileChooser.APPROVE_OPTION) {
                            File selectedFile = new File(jfc.getSelectedFile().getPath() + jfc.getSelectedFile().getName() + ".txt");
                            FileWriter fw = new FileWriter(selectedFile);
                            BufferedWriter bfw = new BufferedWriter(fw);
                            bfw.write(jta2.getText());
                            bfw.close();
                        }
                    }else {
                        JOptionPane.showMessageDialog(MainFrame3.this, "No Data Can Write Out!!");
                    }
                }catch(IOException ioe2){
                    JOptionPane.showMessageDialog(MainFrame3.this, "open file error: " + ioe2.toString());
                } catch (Exception ioe3) {
                    JOptionPane.showMessageDialog(MainFrame3.this, "Error: " + ioe3.toString());
                }
            }
        });
        jbtnclose.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}
