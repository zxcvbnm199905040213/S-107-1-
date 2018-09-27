import javax.swing.*;

public class Frame extends JFrame{
    public Frame(){
        exe();
    }
    private void exe(){
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setBounds(150,150,980,600);
    }
}
