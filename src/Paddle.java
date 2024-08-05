import java.awt.Graphics;
import java.awt.Color;

public class Paddle{
    private int x, y, width = 100, height = 10, dx = 20;

    public Paddle(int startX, int startY){
        x = startX;
        y = startY;
    }

    public void moveLeft(){
        if(x>0){
            x -= dx;
        }
    }

    public void moveRight(){
        if(x<700){
            x += dx;
        }
    }

    public void draw(Graphics g){
        g.setColor(Color.BLUE);
        g.fillRect(x, y, width, height);
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public int getWidth(){
        return width;
    }

    public int getHeight(){
        return height;
    }
}