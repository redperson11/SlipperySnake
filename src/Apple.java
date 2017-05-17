import java.awt.*;

public class Apple {
	int x;
	int y;
	
	public Apple(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void draw(Graphics g, int width, int height) {
		g.setColor(Color.WHITE);
		g.fillOval(x * (width / 20), y * (height / 20), width / 20, height / 20);
	}
	
	public boolean touchingSnake(Snake snake) {
		if(snake.getX() == x && snake.getY() == y)
			return true;
		return false;
	}
	
	public void jump(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
