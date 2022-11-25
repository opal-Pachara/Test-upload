import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayGame extends JFrame implements ActionListener {
    Home homegame = new Home();
    PlayGame(){
        this.setSize(1000,600);
        this.add(homegame);
        homegame.Bstart.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == homegame.Bstart){
            this.setLocationRelativeTo(null);
            remove(homegame);
            this.setSize(1000,600);
            State state = new State();
            this.add(state);
            state.requestFocusInWindow();
            repaint();
        }
    }
    public static void main(String[] args){
        JFrame frame = new PlayGame();
        frame.setSize(1000,600);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setTitle("OOP Project Game");
        frame.setLocationRelativeTo(null);
    }
}
