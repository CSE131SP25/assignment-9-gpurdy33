package assignment9;

import java.util.LinkedList;
import java.awt.Color;

public class Snake {

    private static final double SEGMENT_SIZE = 0.02;
    private static final double MOVEMENT_SIZE = SEGMENT_SIZE * 1.5;
    private static final Color SNAKE_COLOR = Color.GREEN;

    private LinkedList<BodySegment> segments;
    private double deltaX;
    private double deltaY;

    public Snake() {
        segments = new LinkedList<>();
        segments.add(new BodySegment(0.5, 0.5, SEGMENT_SIZE, SNAKE_COLOR));
        deltaX = 0;
        deltaY = 0;
    }

    public void changeDirection(int direction) {
        if(direction == 1) { deltaY = MOVEMENT_SIZE; deltaX = 0; } // up
        else if(direction == 2) { deltaY = -MOVEMENT_SIZE; deltaX = 0; } // down
        else if(direction == 3) { deltaX = -MOVEMENT_SIZE; deltaY = 0; } // left
        else if(direction == 4) { deltaX = MOVEMENT_SIZE; deltaY = 0; } // right
    }

    public void move() {
        double newX = segments.getFirst().getX() + deltaX;
        double newY = segments.getFirst().getY() + deltaY;
        segments.addFirst(new BodySegment(newX, newY, SEGMENT_SIZE, SNAKE_COLOR));
        segments.removeLast();
    }

    public void draw() {
        for (BodySegment segment : segments) {
            segment.draw();
        }
    }

    public boolean eatFood(Food f) {
        BodySegment head = segments.getFirst();
        double dx = head.getX() - f.getX();
        double dy = head.getY() - f.getY();
        double dist = Math.sqrt(dx * dx + dy * dy);
        if (dist < SEGMENT_SIZE + Food.FOOD_SIZE) {
            double newX = segments.getLast().getX();
            double newY = segments.getLast().getY();
            segments.addLast(new BodySegment(newX, newY, SEGMENT_SIZE, SNAKE_COLOR));
            return true;
        }
        return false;
    }

    public boolean isInbounds() {
        BodySegment head = segments.getFirst();
        double x = head.getX();
        double y = head.getY();
        return x >= 0 && x <= 1 && y >= 0 && y <= 1;
    }
} 
