import java.awt.*;
import java.awt.image.BufferedImage;

public class Star {
    public int x;
    public int y;
    public BufferedImage image;
    public int speedX;
    public int speedY;
public Star (){

}
    public Star(int x, int y, BufferedImage image, int speedX, int speedY) {
        this.x = x;
        this.y = y;
        this.image = image;
        this.speedX = speedX;
        this.speedY = speedY;
    }
    public void run() {
        this.x  += this.speedX;
        this.y += this.speedY;
    }
    public void render(Graphics graphics)
    {
        graphics.drawImage(this.image,x ,y , 10,10 ,null);
    }
}

