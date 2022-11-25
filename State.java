import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.geom.Rectangle2D;
public class State extends JPanel{
    private ImageIcon bg1,imgmario,bg2;
    private Mario mario = new Mario();
    private Rock rock = new Rock();
    private Coin coin = new Coin();

    private boolean hitCoin = false;
    private boolean hitRock = false;

    private int hp=3;
    private int score=0;
    Thread actor = new Thread(new Runnable() {
        @Override
        public void run() {
            while(true){
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                }
                repaint();
            }
        }
    });
    Thread runner = new Thread(new Runnable() {
        @Override
        public void run() {
            while(true){
                try {
                    rock.x-=5;
                    if(rock.x<-50){
                        rock.x=950;
                        rock.y=430;
                    }
                    runner.sleep(10);
                } catch (InterruptedException e) {
                }
            }
        }
    });
    Thread m = new Thread(new Runnable() {
        @Override
        public void run() {
            while(true){
                try {
                    if(mario.x<20){
                        mario.x=0;
                    }
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }
            }
        }
    });
    State(){
        this.setSize(1000,600);
        bg1 = new ImageIcon(this.getClass().getResource("bg1.jpg"));
        bg2 = new ImageIcon(this.getClass().getResource("bg0.png"));
        imgmario = mario.marioSR;
        setFocusable(true);
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if(e.getKeyCode()==KeyEvent.VK_LEFT && imgmario!=mario.marioJL){
                    imgmario=mario.marioSL;
                    mario.x-=10;
                }
                else if(e.getKeyCode()==KeyEvent.VK_RIGHT && imgmario!=mario.marioJR){
                    imgmario=mario.marioSR;
                    mario.x+=10;
                }
                else if(e.getKeyCode()==KeyEvent.VK_SPACE){
                    if(mario.y==400){
                        mario.y-=200;
                        if(imgmario==mario.marioSR){
                            imgmario=mario.marioJR;
                        }
                        else if(imgmario==mario.marioSL){
                            imgmario=mario.marioJL;
                        }
                        Timer jump = new Timer(400, new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                if(mario.y==200){
                                    if(imgmario==mario.marioJR){
                                        imgmario=mario.marioSR;
                                    }
                                    else if(imgmario==mario.marioJL){
                                        imgmario=mario.marioSL;
                                    }
                                    mario.width=70;
                                    mario.y+=200;
                                }
                            }
                        });
                        jump.setRepeats(false);
                        jump.start();
                        mario.width=80;
                    }
                }
            }
        });
        actor.start();
        runner.start();
        m.start();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        if(hp>0){
            g.drawImage(bg1.getImage(),0,0, 1000,600,this);
            g.drawImage(imgmario.getImage(),mario.x, mario.y, mario.width, mario.height, this);
            g.drawImage(rock.rock.getImage(), rock.x,rock.y,rock.width,rock.height,this);
            g.drawImage(coin.getimg(),coin.x,coin.y,coin.width,coin.height,this);
            g.setFont(new Font("Impact Regular",Font.BOLD,20));
            g.drawString("Score : "+score,700,30);
            g.drawString("HP : "+hp,100,30);

            if(hitCoin){
                hitCoin = false;
            }
            if(hitRock){
                hitRock = false;
            }
            if(Intersect(rock.getbound(), mario.getbound())){
                rock.x = 950;
                hitRock = true;
                hp -= 1;
            }
            if(Intersect(coin.getbound(), mario.getbound())){
                coin.x=(int)(Math.random()*1000);
                hitCoin = true;
                score += 1;
            }
        }
        else{
            g.drawImage(bg2.getImage(), 0,0,1000,600,this);
            g.setFont(new Font("2005_iannnnnTKO",Font.CENTER_BASELINE,50));
            g.drawString("Game Over",390,200);
            g.setFont(new Font("2005_iannnnnTKO",Font.CENTER_BASELINE,30));
            g.drawString("score : "+score,450,300);
        }
    }
    public boolean Intersect(Rectangle2D a, Rectangle2D b) {
        return (a.intersects(b));
    }
}
