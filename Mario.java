import javax.swing.*;
import java.awt.geom.Rectangle2D;

public class Mario {
    public int x=50,y=400,width=70,height=100;
    ImageIcon marioSR = new ImageIcon(this.getClass().getResource("standright.png"));
    ImageIcon marioSL = new ImageIcon(this.getClass().getResource("standleft.png"));
    ImageIcon marioJR = new ImageIcon(this.getClass().getResource("jumpright.png"));
    ImageIcon marioJL = new ImageIcon(this.getClass().getResource("jumpleft.png"));
    Mario(){

    }
    public Rectangle2D getbound(){
        return (new Rectangle2D.Double(x,y,50,height));
    }
}
