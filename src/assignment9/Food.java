// Food.java
package assignment9;

import java.awt.Color;
import edu.princeton.cs.introcs.StdDraw;

public class Food {

    public static final double FOOD_SIZE = 0.02;
    private double x, y;

    public Food() {
        x = Math.random();
        y = Math.random();
    }

    public void draw() {
        StdDraw.setPenColor(Color.RED);
        StdDraw.filledCircle(x, y, FOOD_SIZE);
    }

    public double getX() { return x; }
    public double getY() { return y; }
} 
