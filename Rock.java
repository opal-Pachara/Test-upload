import javax.swing.*;
import java.awt.geom.Rectangle2D;

public class Rock {
    ImageIcon rock;
    int x=900,y=430,width=75,height=75;
    Rock(){
        rock = new ImageIcon(this.getClass().getResource("rock.png"));
    }
    public Rectangle2D getbound(){
        return (new Rectangle2D.Double(x,y,5,5));
    }
}
