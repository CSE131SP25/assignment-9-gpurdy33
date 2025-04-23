// Main Game Class
package assignment9;

import java.awt.Color;
import java.awt.event.KeyEvent;
import edu.princeton.cs.introcs.StdDraw;

public class Game {

    private int score = 0;
    private Snake snake;
    private Food food;

    public Game() {
        StdDraw.enableDoubleBuffering();
        snake = new Snake();
        food = new Food();
    }

    public void play() {
        while (snake.isInbounds()) {
            int dir = getKeypress();
            if (dir != -1) {
                snake.changeDirection(dir);
            }

            snake.move();

            if (snake.eatFood(food)) {
                score++;
                food = new Food();
            }

            updateDrawing();
            StdDraw.pause(100);
        }

        StdDraw.clear();
        StdDraw.text(0.5, 0.5, "Game Over! Final Score: " + score);
        StdDraw.show();
    }

    private int getKeypress() {
        if (StdDraw.isKeyPressed(KeyEvent.VK_W)) return 1;
        if (StdDraw.isKeyPressed(KeyEvent.VK_S)) return 2;
        if (StdDraw.isKeyPressed(KeyEvent.VK_A)) return 3;
        if (StdDraw.isKeyPressed(KeyEvent.VK_D)) return 4;
        return -1;
    }

    private void updateDrawing() {
        StdDraw.clear();
        snake.draw();
        food.draw();
        StdDraw.setPenColor(Color.BLACK);
        StdDraw.textLeft(0.02, 0.98, "Score: " + score);
        StdDraw.show();
    }

    public static void main(String[] args) {
        Game g = new Game();
        g.play();
    }
}
