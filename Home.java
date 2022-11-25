import javax.swing.*;
import java.awt.*;

public class Home extends JPanel{
    private ImageIcon bg0 = new ImageIcon(this.getClass().getResource("bg0.png"));
    private ImageIcon start = new ImageIcon(this.getClass().getResource("start.jpg"));
    public JButton Bstart = new JButton(start);
    Home(){
        setLayout(null);
        Bstart.setBounds(385,250,180,50);
        add(Bstart);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(bg0.getImage(),0,0,getWidth(),getHeight(),this);
        g.setFont(new Font("2005_iannnnnTKO",Font.CENTER_BASELINE,50));
        g.drawString("Game",405,200);
    }
}
