import java.awt.*;
import javax.swing.*;

public class GameFrame extends JFrame {
    private JPanel currentPanel;
    private GamePanel gamePanel;
    
    public GameFrame() {
        setTitle("Snake Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        
        showMainMenu();
    }
    
    private void showMainMenu() {
        if (currentPanel != null) {
            remove(currentPanel);
        }
        
        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.Y_AXIS));
        menuPanel.setBackground(new Color(240, 240, 240)); // Light theme
        
        JLabel titleLabel = new JLabel("Snake Game");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 48));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        JButton startButton = new JButton("Start Game");
        startButton.setFont(new Font("Arial", Font.PLAIN, 20));
        startButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        startButton.addActionListener(e -> showDifficultySelector());
        
        JButton instructionsButton = new JButton("Instructions");
        instructionsButton.setFont(new Font("Arial", Font.PLAIN, 20));
        instructionsButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        instructionsButton.addActionListener(e -> showInstructions());
        
        JButton exitButton = new JButton("Exit");
        exitButton.setFont(new Font("Arial", Font.PLAIN, 20));
        exitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        exitButton.addActionListener(e -> System.exit(0));
        
        menuPanel.add(Box.createVerticalStrut(40));
        menuPanel.add(titleLabel);
        menuPanel.add(Box.createVerticalStrut(40));
        menuPanel.add(startButton);
        menuPanel.add(Box.createVerticalStrut(20));
        menuPanel.add(instructionsButton);
        menuPanel.add(Box.createVerticalStrut(20));
        menuPanel.add(exitButton);
        menuPanel.add(Box.createVerticalStrut(40));
        
        currentPanel = menuPanel;
        setContentPane(menuPanel);
        setSize(400, 500);
        setLocationRelativeTo(null);
        revalidate();
    }
    
    private void showInstructions() {
        if (currentPanel != null) {
            remove(currentPanel);
        }
        
        JPanel instructionsPanel = new JPanel();
        instructionsPanel.setLayout(new BoxLayout(instructionsPanel, BoxLayout.Y_AXIS));
        instructionsPanel.setBackground(new Color(240, 240, 240));
        
        JLabel titleLabel = new JLabel("Instructions");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 36));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        String instructions = "<html><body style='width: 350px; font-size: 14px;'>" +
                "<b>Controls:</b><br>" +
                "Arrow Keys or WASD: Move the snake<br>" +
                "P: Pause/Resume<br>" +
                "M: Mute/Unmute<br>" +
                "Space: Restart<br>" +
                "Escape: Main Menu<br><br>" +
                "<b>Gameplay:</b><br>" +
                "Eat food to grow and gain points<br>" +
                "Avoid hitting walls, obstacles, or yourself<br>" +
                "Speed increases every 5 foods<br>" +
                "Bonus food appears every 7 normal foods<br>" +
                "</body></html>";
        
        JLabel instructionsLabel = new JLabel(instructions);
        instructionsLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        JButton backButton = new JButton("Back");
        backButton.setFont(new Font("Arial", Font.PLAIN, 16));
        backButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        backButton.addActionListener(e -> showMainMenu());
        
        instructionsPanel.add(Box.createVerticalStrut(20));
        instructionsPanel.add(titleLabel);
        instructionsPanel.add(Box.createVerticalStrut(20));
        instructionsPanel.add(instructionsLabel);
        instructionsPanel.add(Box.createVerticalStrut(20));
        instructionsPanel.add(backButton);
        instructionsPanel.add(Box.createVerticalStrut(20));
        
        currentPanel = instructionsPanel;
        setContentPane(instructionsPanel);
        setSize(450, 500);
        setLocationRelativeTo(null);
        revalidate();
    }
    
    private void showDifficultySelector() {
        if (currentPanel != null) {
            remove(currentPanel);
        }
        
        JPanel difficultyPanel = new JPanel();
        difficultyPanel.setLayout(new BoxLayout(difficultyPanel, BoxLayout.Y_AXIS));
        difficultyPanel.setBackground(new Color(240, 240, 240));
        
        JLabel titleLabel = new JLabel("Select Difficulty");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 36));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        JButton easyButton = new JButton("Easy");
        easyButton.setFont(new Font("Arial", Font.PLAIN, 20));
        easyButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        easyButton.addActionListener(e -> startGame(125)); // 125ms per tick
        
        JButton mediumButton = new JButton("Medium");
        mediumButton.setFont(new Font("Arial", Font.PLAIN, 20));
        mediumButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        mediumButton.addActionListener(e -> startGame(100)); // 100ms per tick
        
        JButton hardButton = new JButton("Hard");
        hardButton.setFont(new Font("Arial", Font.PLAIN, 20));
        hardButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        hardButton.addActionListener(e -> startGame(75)); // 75ms per tick
        
        JButton backButton = new JButton("Back");
        backButton.setFont(new Font("Arial", Font.PLAIN, 16));
        backButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        backButton.addActionListener(e -> showMainMenu());
        
        difficultyPanel.add(Box.createVerticalStrut(40));
        difficultyPanel.add(titleLabel);
        difficultyPanel.add(Box.createVerticalStrut(40));
        difficultyPanel.add(easyButton);
        difficultyPanel.add(Box.createVerticalStrut(20));
        difficultyPanel.add(mediumButton);
        difficultyPanel.add(Box.createVerticalStrut(20));
        difficultyPanel.add(hardButton);
        difficultyPanel.add(Box.createVerticalStrut(40));
        difficultyPanel.add(backButton);
        difficultyPanel.add(Box.createVerticalStrut(40));
        
        currentPanel = difficultyPanel;
        setContentPane(difficultyPanel);
        setSize(400, 500);
        setLocationRelativeTo(null);
        revalidate();
    }
    
    private void startGame(int speed) {
        if (currentPanel != null) {
            remove(currentPanel);
        }
        
        gamePanel = new GamePanel(speed, this);
        
        currentPanel = gamePanel;
        setContentPane(gamePanel);
        setSize(900, 500);
        setLocationRelativeTo(null);
        revalidate();
        gamePanel.requestFocusInWindow();
    }
    
    public void returnToMainMenu() {
        if (gamePanel != null) {
            gamePanel.stopGame();
        }
        showMainMenu();
    }
}
