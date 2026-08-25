import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GamePanel extends JPanel {
    private static final int BOARD_WIDTH = 30;
    private static final int BOARD_HEIGHT = 22;
    private static final int CELL_SIZE = 20;
    
    private Snake snake;
    private Food currentFood;
    private ScoreManager scoreManager;
    private GameFrame gameFrame;
    
    private boolean gameRunning;
    private boolean gamePaused;
    private boolean gameOver;
    private Timer gameTimer;
    private int tickSpeed;
    
    private boolean wrapWalls;
    private boolean obstaclesEnabled;
    private boolean soundEnabled;
    private int foodsUntilBonus;
    
    private int gameOverFlashCounter;
    private static final int FLASH_DURATION = 10;
    
    public GamePanel(int speed, GameFrame gameFrame) {
        this.gameFrame = gameFrame;
        this.tickSpeed = speed;
        this.wrapWalls = false;
        this.obstaclesEnabled = false;
        this.soundEnabled = true;
        this.foodsUntilBonus = 7;
        
        setBackground(new Color(240, 240, 240)); // Light theme
        setFocusable(true);
        
        initializeGame();
        setupKeyBindings();
        startGameLoop();
    }
    
    private void initializeGame() {
        snake = new Snake(BOARD_WIDTH / 2, BOARD_HEIGHT / 2);
        scoreManager = new ScoreManager();
        currentFood = new Food(snake, BOARD_WIDTH, BOARD_HEIGHT);
        
        gameRunning = true;
        gamePaused = false;
        gameOver = false;
        gameOverFlashCounter = 0;
    }
    
    private void setupKeyBindings() {
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                
                if (gameOver) {
                    if (keyCode == KeyEvent.VK_SPACE) {
                        initializeGame();
                        requestFocusInWindow();
                    } else if (keyCode == KeyEvent.VK_ESCAPE) {
                        gameFrame.returnToMainMenu();
                    }
                    return;
                }
                
                switch (keyCode) {
                    case KeyEvent.VK_UP:
                    case KeyEvent.VK_W:
                        snake.setDirection(0, -1);
                        break;
                    case KeyEvent.VK_DOWN:
                    case KeyEvent.VK_S:
                        snake.setDirection(0, 1);
                        break;
                    case KeyEvent.VK_LEFT:
                    case KeyEvent.VK_A:
                        snake.setDirection(-1, 0);
                        break;
                    case KeyEvent.VK_RIGHT:
                    case KeyEvent.VK_D:
                        snake.setDirection(1, 0);
                        break;
                    case KeyEvent.VK_P:
                        gamePaused = !gamePaused;
                        break;
                    case KeyEvent.VK_M:
                        soundEnabled = !soundEnabled;
                        break;
                    case KeyEvent.VK_ESCAPE:
                        gameFrame.returnToMainMenu();
                        break;
                }
            }
        });
    }
    
    private void startGameLoop() {
        gameTimer = new Timer(tickSpeed, e -> {
            if (!gamePaused && gameRunning && !gameOver) {
                update();
            } else if (gameOver) {
                gameOverFlashCounter++;
            }
            repaint();
        });
        gameTimer.start();
    }
    
    private void update() {
        // Move snake
        snake.move();
        
        // Handle wall wrapping
        int[] head = snake.getHead();
        if (wrapWalls) {
            head[0] = (head[0] + BOARD_WIDTH) % BOARD_WIDTH;
            head[1] = (head[1] + BOARD_HEIGHT) % BOARD_HEIGHT;
        }
        
        // Check collisions
        if (checkWallCollision() || snake.checkSelfCollision() || checkObstacleCollision()) {
            gameOver = true;
            gameRunning = false;
            playSound("game-over");
            return;
        }
        
        // Check food collision
        if (head[0] == currentFood.getX() && head[1] == currentFood.getY()) {
            snake.grow();
            scoreManager.addScore(10);
            scoreManager.addFood();
            foodsUntilBonus--;
            playSound("eat");
            
            if (foodsUntilBonus == 0) {
                currentFood.setBonus(true);
                scoreManager.addScore(50);
                foodsUntilBonus = 7;
            } else {
                currentFood.setBonus(false);
            }
            
            currentFood = new Food(snake, BOARD_WIDTH, BOARD_HEIGHT);
        }
    }
    
    private boolean checkWallCollision() {
        if (!wrapWalls) {
            int[] head = snake.getHead();
            return head[0] < 0 || head[0] >= BOARD_WIDTH ||
                   head[1] < 0 || head[1] >= BOARD_HEIGHT;
        }
        return false;
    }
    
    private boolean checkObstacleCollision() {
        // Placeholder for obstacle collision - can be expanded
        return false;
    }
    
    private void playSound(String soundName) {
        if (!soundEnabled) return;
        // Sound playback would be implemented here
        // For now, just a placeholder
    }
    
    public void stopGame() {
        if (gameTimer != null) {
            gameTimer.stop();
        }
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        // Draw game board
        drawBoard(g2d);
        
        // Draw snake
        drawSnake(g2d);
        
        // Draw food
        drawFood(g2d);
        
        // Draw UI
        drawUI(g2d);
        
        // Draw game over overlay
        if (gameOver) {
            drawGameOverScreen(g2d);
        }
        
        // Draw pause indicator
        if (gamePaused && !gameOver) {
            drawPauseIndicator(g2d);
        }
    }
    
    private void drawBoard(Graphics2D g) {
        int boardPixelWidth = BOARD_WIDTH * CELL_SIZE;
        int boardPixelHeight = BOARD_HEIGHT * CELL_SIZE;
        
        // Draw background
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, boardPixelWidth, boardPixelHeight);
        
        // Draw grid
        g.setColor(new Color(200, 200, 200));
        g.setStroke(new BasicStroke(0.5f));
        for (int i = 0; i <= BOARD_WIDTH; i++) {
            g.drawLine(i * CELL_SIZE, 0, i * CELL_SIZE, boardPixelHeight);
        }
        for (int i = 0; i <= BOARD_HEIGHT; i++) {
            g.drawLine(0, i * CELL_SIZE, boardPixelWidth, i * CELL_SIZE);
        }
        
        // Draw border
        g.setColor(Color.BLACK);
        g.setStroke(new BasicStroke(2));
        g.drawRect(0, 0, boardPixelWidth, boardPixelHeight);
    }
    
    private void drawSnake(Graphics2D g) {
        int boardPixelHeight = BOARD_HEIGHT * CELL_SIZE;
        
        java.util.List<int[]> body = snake.getBody();
        for (int i = 0; i < body.size(); i++) {
            int[] segment = body.get(i);
            int x = segment[0] * CELL_SIZE;
            int y = segment[1] * CELL_SIZE;
            
            if (i == 0) {
                // Head
                g.setColor(new Color(0, 150, 0));
                g.fillRect(x + 1, y + 1, CELL_SIZE - 2, CELL_SIZE - 2);
                g.setColor(Color.BLACK);
                g.setStroke(new BasicStroke(2));
                g.drawRect(x + 1, y + 1, CELL_SIZE - 2, CELL_SIZE - 2);
            } else {
                // Body
                g.setColor(new Color(100, 200, 100));
                g.fillRect(x + 2, y + 2, CELL_SIZE - 4, CELL_SIZE - 4);
            }
        }
    }
    
    private void drawFood(Graphics2D g) {
        int x = currentFood.getX() * CELL_SIZE;
        int y = currentFood.getY() * CELL_SIZE;
        
        if (currentFood.isBonus()) {
            g.setColor(new Color(255, 215, 0)); // Gold
            g.fillOval(x + 2, y + 2, CELL_SIZE - 4, CELL_SIZE - 4);
            g.setColor(Color.BLACK);
            g.setStroke(new BasicStroke(2));
            g.drawOval(x + 2, y + 2, CELL_SIZE - 4, CELL_SIZE - 4);
        } else {
            g.setColor(new Color(255, 0, 0));
            g.fillOval(x + 3, y + 3, CELL_SIZE - 6, CELL_SIZE - 6);
        }
    }
    
    private void drawUI(Graphics2D g) {
        int boardPixelWidth = BOARD_WIDTH * CELL_SIZE;
        int boardPixelHeight = BOARD_HEIGHT * CELL_SIZE;
        
        // Draw UI background
        g.setColor(new Color(240, 240, 240));
        g.fillRect(boardPixelWidth, 0, getWidth() - boardPixelWidth, getHeight());
        
        // Draw UI text
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.BOLD, 14));
        
        int uiX = boardPixelWidth + 15;
        int uiY = 30;
        
        g.drawString("Score: " + scoreManager.getScore(), uiX, uiY);
        g.drawString("High Score: " + scoreManager.getHighScore(), uiX, uiY + 25);
        g.drawString("Level: " + scoreManager.getLevel(), uiX, uiY + 50);
        g.drawString("Foods: " + scoreManager.getFoodsEaten(), uiX, uiY + 75);
        
        g.setFont(new Font("Arial", Font.PLAIN, 11));
        g.drawString("P: Pause", uiX, uiY + 110);
        g.drawString("M: Mute", uiX, uiY + 125);
        g.drawString("ESC: Menu", uiX, uiY + 140);
    }
    
    private void drawGameOverScreen(Graphics2D g) {
        // Flash effect
        if ((gameOverFlashCounter / 5) % 2 == 0) {
            g.setColor(new Color(0, 0, 0, 200));
            g.fillRect(0, 0, getWidth(), getHeight());
        }
        
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 48));
        String gameOverText = "GAME OVER";
        FontMetrics fm = g.getFontMetrics();
        int textX = (getWidth() - fm.stringWidth(gameOverText)) / 2;
        int textY = (getHeight() - fm.getHeight()) / 2;
        g.drawString(gameOverText, textX, textY);
        
        g.setFont(new Font("Arial", Font.PLAIN, 18));
        String scoreText = "Final Score: " + scoreManager.getScore();
        fm = g.getFontMetrics();
        textX = (getWidth() - fm.stringWidth(scoreText)) / 2;
        g.drawString(scoreText, textX, textY + 50);
        
        g.setFont(new Font("Arial", Font.PLAIN, 14));
        String restartText = "Press SPACE to restart or ESC for menu";
        fm = g.getFontMetrics();
        textX = (getWidth() - fm.stringWidth(restartText)) / 2;
        g.drawString(restartText, textX, textY + 100);
    }
    
    private void drawPauseIndicator(Graphics2D g) {
        g.setColor(new Color(0, 0, 0, 150));
        g.fillRect(0, 0, getWidth(), getHeight());
        
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 48));
        String pauseText = "PAUSED";
        FontMetrics fm = g.getFontMetrics();
        int textX = (getWidth() - fm.stringWidth(pauseText)) / 2;
        int textY = (getHeight() - fm.getHeight()) / 2;
        g.drawString(pauseText, textX, textY);
        
        g.setFont(new Font("Arial", Font.PLAIN, 16));
        String resumeText = "Press P to resume";
        fm = g.getFontMetrics();
        textX = (getWidth() - fm.stringWidth(resumeText)) / 2;
        g.drawString(resumeText, textX, textY + 50);
    }
}
