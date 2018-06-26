import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Hello {
    public static void main(String[] args) {
       Random random = new Random();
        String[][] map =
                {
                        {"*", "*", "P", "*"},
                        {"*", "*", "*", "*"},
                        {"*", "*", "*", "*"},
                        {"*", "*", "*", "*"}
                };
        int playerX = 2;
        int playerY = 0;
        int enemyX1 = 0;
        int enemyY1 = 0;
        int enemyX2 = 0;
        int enemyY2 = 0;




       do {
            enemyX1 = random.nextInt(4);
            enemyY1 = random.nextInt(4);
        }
        while ( playerX == enemyX1  && enemyY1 == playerY);
        map[enemyY1][enemyX1] = "E";
        do {
            enemyX2 = random.nextInt(4);
            enemyY2 = random.nextInt(4);
        }
        while ( (playerX == enemyX2  && enemyY2 == playerY) || (enemyX1 == enemyX2 && enemyY1 == enemyY2));
        map[enemyY2][enemyX2] = "E";
        System.out.println(map[enemyY1][enemyX1]);
        while (true) {
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    System.out.print(map[i][j] + " ");
                }
                System.out.println();
            }
            map[playerY][playerX] = "*";
                Scanner scanner = new Scanner(System.in);
                String key = scanner.next();
                switch (key) {
                    case ("a"):
                        if (playerX == 0) {playerX = 3;} else
                        {playerX -= 1; };
                        break;
                    case ("d"):
                        if (playerX == 3) {playerX = 0;} else
                        {playerX += 1; };
                        break;
                    case ("s"):
                        if (playerY == 3) {playerY = 0;} else
                        {playerY += 1; };
                        break;
                    case ("w"):
                        if (playerY == 0) {playerY = 3;} else
                        {playerY -= 1; }
                        break;}
if ((playerX == enemyX1 && playerY == enemyY1) || (playerX == enemyX2 && playerY == enemyY2)) {
    System.out.println("Lost!!!!!!!!!!!!!!!!!!");
break;}

                map[playerY][playerX] = "P";
            map[enemyY1][enemyX1] = "*";
            map[enemyY2][enemyX2] = "*";
            enemyY1 = (enemyY1 + 1) % 4 ;
            if (enemyX1 == playerX && enemyY1 == playerY) {
                System.out.println("Lost 1");
                break;
            }
            map[enemyY1][enemyX1] = "E";
enemyX2 = (enemyX2 + 1) % 4;
            if (enemyX2 == playerX && enemyY2 == playerY) {
                System.out.println("Lost 2");
                break;
            }
map[enemyY2][enemyX2] = "E";
        }



    }

}
