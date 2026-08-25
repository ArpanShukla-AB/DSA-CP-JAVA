import java.util.ArrayList;
import java.util.List;

public class Snake {
    public static final int GRID_SIZE = 20;
    
    private List<int[]> body; // List of [x, y] coordinates
    private int directionX;
    private int directionY;
    private int nextDirectionX;
    private int nextDirectionY;
    
    public Snake(int startX, int startY) {
        body = new ArrayList<>();
        // Initialize snake with 3 segments
        body.add(new int[]{startX, startY});
        body.add(new int[]{startX - 1, startY});
        body.add(new int[]{startX - 2, startY});
        
        directionX = 1;
        directionY = 0;
        nextDirectionX = 1;
        nextDirectionY = 0;
    }
    
    public void setDirection(int dx, int dy) {
        // Prevent 180-degree turns
        if ((dx != -directionX || dy != -directionY) && (dx != 0 || dy != 0)) {
            nextDirectionX = dx;
            nextDirectionY = dy;
        }
    }
    
    public void move() {
        directionX = nextDirectionX;
        directionY = nextDirectionY;
        
        int headX = body.get(0)[0];
        int headY = body.get(0)[1];
        
        // Add new head
        body.add(0, new int[]{headX + directionX, headY + directionY});
        
        // Remove tail (unless growing)
        body.remove(body.size() - 1);
    }
    
    public void grow() {
        int tailX = body.get(body.size() - 1)[0];
        int tailY = body.get(body.size() - 1)[1];
        body.add(new int[]{tailX, tailY});
    }
    
    public boolean checkSelfCollision() {
        int[] head = body.get(0);
        for (int i = 1; i < body.size(); i++) {
            if (head[0] == body.get(i)[0] && head[1] == body.get(i)[1]) {
                return true;
            }
        }
        return false;
    }
    
    public int[] getHead() {
        return body.get(0);
    }
    
    public List<int[]> getBody() {
        return body;
    }
    
    public int getDirectionX() {
        return directionX;
    }
    
    public int getDirectionY() {
        return directionY;
    }
}
