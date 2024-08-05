import java.awt.Graphics;
import java.awt.Color;

public class Ball {
    private int x, y, dx = 2, dy = -2, diameter = 20;
    
    public Ball(int startX, int startY) {
        x = startX;
        y = startY;
    }
    
    public void move() {
        x += dx;
        y += dy;
        
        if (x <= 0 || x >= 780) {
            dx = -dx;
        }
        if (y <= 0 || y >= 580) {
            dy = -dy;
        }
    }
    
    public void draw(Graphics g) {
        g.setColor(Color.RED);
        g.fillOval(x, y, diameter, diameter);
    }
    
    public void checkCollision(Paddle paddle, Brick[][] bricks) {
        if (x >= paddle.getX() && x <= paddle.getX() + paddle.getWidth() &&
            y >= paddle.getY() && y <= paddle.getY() + paddle.getHeight()) {
            dy = -dy;
        }
        
        for (int i = 0; i < bricks.length; i++) {
            for (int j = 0; j < bricks[i].length; j++) {
                if (!bricks[i][j].isDestroyed() &&
                    x >= bricks[i][j].getX() && x <= bricks[i][j].getX() + bricks[i][j].getWidth() &&
                    y >= bricks[i][j].getY() && y <= bricks[i][j].getY() + bricks[i][j].getHeight()) {
                    dy = -dy;
                    bricks[i][j].setDestroyed(true);
                }
            }
        }
    }
}