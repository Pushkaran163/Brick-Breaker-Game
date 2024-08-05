import java.awt.Graphics;
import java.awt.Color;

public class Brick{
    private int x, y, width = 60, height = 20;
    private boolean destroyed;

    public Brick(int startX, int startY){
        x = startX;
        y = startY;
        destroyed = false;
    }

    public void draw(Graphics g){
        if(!destroyed){
            g.setColor(Color.GREEN);
            g.fillRect(x, y, width, height);
        }
    }

    public boolean isDestroyed(){
        return destroyed;
    }

    public void setDestroyed(boolean destroyed){
        this.destroyed = destroyed;
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