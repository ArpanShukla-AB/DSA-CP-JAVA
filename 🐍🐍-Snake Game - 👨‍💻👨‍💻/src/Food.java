import java.util.Random;

public class Food {
    private int x;
    private int y;
    private boolean isBonus;
    private static final Random random = new Random();
    
    public Food(Snake snake, int boardWidth, int boardHeight) {
        generateRandomPosition(snake, boardWidth, boardHeight);
        isBonus = false;
    }
    
    public void generateRandomPosition(Snake snake, int boardWidth, int boardHeight) {
        boolean valid = false;
        while (!valid) {
            x = random.nextInt(boardWidth);
            y = random.nextInt(boardHeight);
            
            // Check if position is not on snake
            valid = true;
            for (int[] segment : snake.getBody()) {
                if (segment[0] == x && segment[1] == y) {
                    valid = false;
                    break;
                }
            }
        }
    }
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
    
    public boolean isBonus() {
        return isBonus;
    }
    
    public void setBonus(boolean bonus) {
        isBonus = bonus;
    }
}
