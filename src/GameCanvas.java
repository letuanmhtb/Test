import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameCanvas extends JPanel {

    BufferedImage enemyImage;
    BufferedImage playerImage;
    BufferedImage backBuffered;
    Graphics graphic;
    List<Star> stars ;
    public int positionEnemyX = 0;
    int positionEnemyY = 0;
    public int positionPlayerX = 512;
    int positionPlayerY = 300;
    int speedEnemyX = 5;
    int speedEnemyY = 5;
    private Random random = new Random();

    public GameCanvas() {
        this.setSize(1024, 600);
        this.setupCharacter();
        this.setupBackBuffered();
        this.setVisible(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(this.backBuffered, 0, 0, null);
    }
    private void setupCharacter() {
        this.stars = new ArrayList<>() ;
        this.enemyImage = this.loadImage("resources-rocket-master/resources/images/circle.png");
        this.playerImage = this.loadImage("resources-rocket-master/resources/images/circle.png");
    }
    public void renderAll() {
        graphic.setColor(Color.BLACK);
        graphic.fillRect(0, 0, 1024, 600);
        this.stars.forEach(star -> star.render(graphic));
        graphic.drawImage(this.enemyImage, positionEnemyX, positionEnemyY, null);
        graphic.drawImage(this.playerImage, positionPlayerX, positionPlayerY, 10, 10, null);
        this.repaint();


    }
    public void runAll() {
     this.stars.forEach(star -> star.run());
        positionEnemyX += speedEnemyX;
        positionEnemyY += speedEnemyY;
        if (positionEnemyY < 0 || positionEnemyY >= 600 - 30) {
            speedEnemyY = -speedEnemyY;
        }
        if (positionEnemyX < 0 || positionEnemyX >= 1024 - 30) {
            speedEnemyX = -speedEnemyX;
        this.createStar();
        }

    }
    public  void createStar() {
        Star star = new Star(
                this.random.nextInt(1024),
                0,
                this.loadImage("resources-rocket-master/resources/images/star.png"),
                this.random.nextInt(10)+1,
                this.random.nextInt(10)+1

        );
        this.stars.add(star);
    }
private void setupBackBuffered() {
        this.backBuffered = new BufferedImage(1024, 600, BufferedImage.TYPE_4BYTE_ABGR);
        this.graphic = this.backBuffered.getGraphics();

    }


    private BufferedImage loadImage(String path) {
        try {
            return ImageIO.read(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }


        return null;
    }
}










