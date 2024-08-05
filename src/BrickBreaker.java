import javax.swing.JFrame;

public class BrickBreaker{
    public static void main(String[] args){
        JFrame frame = new JFrame();
        GamePanel gamePanel = new GamePanel();

        frame.setTitle("Brick Breaker Game");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(gamePanel);
        frame.setVisible(true);
    }
}