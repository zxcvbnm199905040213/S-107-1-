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

        jmiExit.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}
