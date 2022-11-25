import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.net.URL;

public class Coin {
    public Image imgCoin;
    public int x;
    public int y=250,width=60,height=60;
    Coin(){
        String imageLocation = "coin.png";
        URL imageURL = this.getClass().getResource(imageLocation);
        imgCoin = Toolkit.getDefaultToolkit().getImage(imageURL);
    }
    public Image getimg(){
        return imgCoin;
    }
    public Rectangle2D getbound(){
        return (new Rectangle2D.Double(x,y,45,45));
    }
}
