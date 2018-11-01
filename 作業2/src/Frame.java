import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Frame extends JFrame{
    private JMenuBar jmb = new JMenuBar();
    private JMenu jmnuFile = new JMenu("File");
    private JMenu jmnuTool = new JMenu("Tool");
    private JMenu jmnuGame = new JMenu("Game");
    private JMenu jmnuHelp = new JMenu("Help");
    private JMenuItem jmiOpen = new JMenuItem("Open");
    private JMenuItem jmiClose = new JMenuItem("Close");
    private JMenuItem jmiExit = new JMenuItem("Exit");
    private JMenuItem jmiOX = new JMenuItem("OX");
    private JMenuItem jmiK = new JMenuItem("加密");
    private JMenuItem jmiKK = new JMenuItem("加密２");
    private JMenuItem jmiDT = new JMenuItem("DT");
    Container cp;
    public Frame(){
        exe();
    }
    private void exe(){
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setBounds(150,150,980,600);
        this.setJMenuBar(jmb);
        cp = this.getContentPane();
        jmb.add(jmnuFile);
        jmb.add(jmnuTool);
        jmb.add(jmnuGame);
        jmb.add(jmnuHelp);
        jmnuFile.add(jmiOpen);
        jmnuFile.add(jmiClose);
        jmnuFile.add(jmiExit);
        jmnuTool.add(jmiK);
        jmnuTool.add(jmiKK);
        jmnuGame.add(jmiOX);
        jmnuGame.add(jmiDT);

        jmiExit.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        jmiOX.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame2 OX = new MainFrame2(Frame.this);
                OX.setVisible(true);
                Frame.this.setVisible(false);
            }
        });
        jmiK.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame3 K = new MainFrame3(Frame.this);
                K.setVisible(true);
                Frame.this.setVisible(false);
            }
        });
        jmiKK.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                encryptfile KK = new encryptfile(Frame.this);
                KK.setVisible(true);
                Frame.this.setVisible(false);
            }
        });
        jmiDT.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DigiralTimer DT = new DigiralTimer(Frame.this);
                DT.setVisible(true);
                Frame.this.setVisible(false);
            }
        });
    }
}
