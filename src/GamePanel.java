import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.Graphics;
// import java.awt.Color;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class GamePanel extends JPanel implements KeyListener {
    private Ball ball;
    private Paddle paddle;
    private Brick[][] bricks;
    
    public GamePanel() {
        ball = new Ball(400, 300);
        paddle = new Paddle(350, 550);
        bricks = new Brick[5][10]; // Example grid size
        
        // Initialize bricks
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 10; j++) {
                bricks[i][j] = new Brick(j * 70 + 30, i * 20 + 50);
            }
        }
        
        setFocusable(true);
        addKeyListener(this);
        Timer timer = new Timer(10, e -> updateGame());
        timer.start();
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        // Draw ball, paddle, and bricks
        ball.draw(g);
        paddle.draw(g);
        
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 10; j++) {
                if (!bricks[i][j].isDestroyed()) {
                    bricks[i][j].draw(g);
                }
            }
        }
    }
    
    private void updateGame() {
        ball.move();
        ball.checkCollision(paddle, bricks);
        repaint();
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            paddle.moveLeft();
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            paddle.moveRight();
        }
    }
    
    @Override
    public void keyReleased(KeyEvent e) {}
    
    @Override
    public void keyTyped(KeyEvent e) {}
}