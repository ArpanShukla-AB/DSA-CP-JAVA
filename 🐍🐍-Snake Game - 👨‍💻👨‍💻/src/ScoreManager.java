public class ScoreManager {
    private int score;
    private int foodsEaten;
    private int level;
    private int highScore;
    
    public ScoreManager() {
        this.score = 0;
        this.foodsEaten = 0;
        this.level = 1;
        this.highScore = 0;
    }
    
    public void addScore(int points) {
        score += points;
        if (score > highScore) {
            highScore = score;
        }
    }
    
    public void addFood() {
        foodsEaten++;
        // Increase level every 5 foods
        level = (foodsEaten / 5) + 1;
    }
    
    public void reset() {
        score = 0;
        foodsEaten = 0;
        level = 1;
    }
    
    public int getScore() {
        return score;
    }
    
    public int getFoodsEaten() {
        return foodsEaten;
    }
    
    public int getLevel() {
        return level;
    }
    
    public int getHighScore() {
        return highScore;
    }
}
