import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BrickBreakerGame extends JPanel implements ActionListener {
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private static final int PADDLE_WIDTH = 100;
    private static final int PADDLE_HEIGHT = 10;
    private static final int BALL_DIAMETER = 20;
    private static final int BRICK_WIDTH = 70;
    private static final int BRICK_HEIGHT = 20;

    private int paddleX = WIDTH / 2 - PADDLE_WIDTH / 2;
    private int ballX = WIDTH / 2 - BALL_DIAMETER / 2;
    private int ballY = HEIGHT / 2;
    private int ballXDir = -1;
    private int ballYDir = -2;

    private List<Brick> bricks;
    private Timer timer;
    private int score = 0;
    private int highScore;

    private static final String HIGH_SCORE_FILE = "BrickGame.txt";

    public BrickBreakerGame() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.BLACK);
        setFocusable(true);
        addKeyListener(new PaddleController());

        initializeBricks();
        loadHighScore();
        
        timer = new Timer(10, this);
        timer.start();
    }

    private void initializeBricks() {
        bricks = new ArrayList<>();
        int rows = 5;
        int cols = WIDTH / (BRICK_WIDTH + 10);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                Brick brick = new Brick(
                    j * (BRICK_WIDTH + 10) + 50, 
                    i * (BRICK_HEIGHT + 10) + 50
                );
                bricks.add(brick);
            }
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        // Draw Paddle
        g.setColor(Color.GREEN);
        g.fillRect(paddleX, HEIGHT - 50, PADDLE_WIDTH, PADDLE_HEIGHT);

        // Draw Ball
        g.setColor(Color.WHITE);
        g.fillOval(ballX, ballY, BALL_DIAMETER, BALL_DIAMETER);

        // Draw Bricks
        for (Brick brick : bricks) {
            if (!brick.isDestroyed()) {
                g.setColor(brick.getColor());
                g.fillRect(brick.getX(), brick.getY(), BRICK_WIDTH, BRICK_HEIGHT);
            }
        }

        // Draw Score and High Score
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.drawString("Score: " + score, 10, 30);
        g.drawString("High Score: " + highScore, WIDTH - 200, 30);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        moveBall();
        checkCollisions();
        repaint();
    }

    private void moveBall() {
        ballX += ballXDir;
        ballY += ballYDir;

        // Wall bouncing
        if (ballX <= 0 || ballX >= WIDTH - BALL_DIAMETER) {
            ballXDir = -ballXDir;
        }
        if (ballY <= 0) {
            ballYDir = -ballYDir;
        }
    }

    private void checkCollisions() {
        // Paddle collision
        Rectangle ballRect = new Rectangle(ballX, ballY, BALL_DIAMETER, BALL_DIAMETER);
        Rectangle paddleRect = new Rectangle(paddleX, HEIGHT - 50, PADDLE_WIDTH, PADDLE_HEIGHT);

        if (ballRect.intersects(paddleRect)) {
            ballYDir = -Math.abs(ballYDir);
        }

        // Brick collisions
        for (Brick brick : bricks) {
            if (!brick.isDestroyed()) {
                Rectangle brickRect = new Rectangle(brick.getX(), brick.getY(), BRICK_WIDTH, BRICK_HEIGHT);
                
                if (ballRect.intersects(brickRect)) {
                    brick.setDestroyed(true);
                    ballYDir = -ballYDir;
                    score += 10;
                }
            }
        }

        // Game over check
        if (ballY >= HEIGHT) {
            timer.stop();
            checkAndSaveHighScore();
            JOptionPane.showMessageDialog(this, "Game Over! Score: " + score);
        }

        // Win condition
        if (bricks.stream().allMatch(Brick::isDestroyed)) {
            timer.stop();
            checkAndSaveHighScore();
            JOptionPane.showMessageDialog(this, "Congratulations! You Won! Score: " + score);
        }
    }

    private void loadHighScore() {
        try (BufferedReader reader = new BufferedReader(new FileReader(HIGH_SCORE_FILE))) {
            highScore = Integer.parseInt(reader.readLine());
        } catch (IOException | NumberFormatException e) {
            highScore = 0; // Default high score
        }
    }

    private void checkAndSaveHighScore() {
        if (score > highScore) {
            highScore = score;
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(HIGH_SCORE_FILE))) {
                writer.write(String.valueOf(highScore));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private class PaddleController extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            
            if (key == KeyEvent.VK_LEFT && paddleX > 0) {
                paddleX -= 20;
            }
            
            if (key == KeyEvent.VK_RIGHT && paddleX < WIDTH - PADDLE_WIDTH) {
                paddleX += 20;
            }
        }
    }

    private class Brick {
        private int x, y;
        private boolean destroyed;
        private Color color;

        public Brick(int x, int y) {
            this.x = x;
            this.y = y;
            this.destroyed = false;
            this.color = generateRandomColor();
        }

        private Color generateRandomColor() {
            Random random = new Random();
            return new Color(
                random.nextInt(200), 
                random.nextInt(200), 
                random.nextInt(200)
            );
        }

        public int getX() { return x; }
        public int getY() { return y; }
        public boolean isDestroyed() { return destroyed; }
        public void setDestroyed(boolean destroyed) { this.destroyed = destroyed; }
        public Color getColor() { return color; }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Brick Breaker Game");
            BrickBreakerGame game = new BrickBreakerGame();
            frame.add(game);
            frame.pack();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
