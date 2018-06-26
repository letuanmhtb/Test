import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GameWindow extends JFrame {
    GameCanvas gameCanvas;
    long lastTime = 0;
    public GameWindow()  {
        this.setSize(1024,600);
        this.gameCanvas = new GameCanvas();
        this.add(this.gameCanvas);
        this.keyboardEvent();
        this.windowEvent();

    }
public void gameLoop () {
        while (true){
            long currentTime = System.nanoTime();
            if (currentTime - this.lastTime >= 17_000_000) {
            this.gameCanvas.runAll();
            this.gameCanvas.renderAll();
            this.lastTime = currentTime;
            }
        }
    }
    private void keyboardEvent () {
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                ;
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if ( e.getKeyCode() == KeyEvent.VK_LEFT) {
                    gameCanvas.positionPlayerX -= 4;
                }
                if ( e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    gameCanvas.positionPlayerX += 4;
                }
            }
            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
    }
    private void windowEvent () {
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(1);
            }
        });
        this.setVisible(true);

    }

}





