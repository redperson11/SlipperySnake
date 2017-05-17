import java.awt.Graphics;

//Dorian Rittenhouse
public class SnakeHead implements Snake {
	int x;
	int y;
	int direction;
	
	public SnakeHead(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void setDirection(int direction) {
		if(direction == Snake.UP)
			y--;
		else if(direction == Snake.RIGHT)
			x++;
		else if(direction == Snake.DOWN)
			y++;
		else if(direction == Snake.LEFT)
			x--;
		this.direction = direction;
	}

	public void draw(Graphics g, int width, int height) {
		g.fillOval(x * (width / 20), y * (height / 20), width / 20, height / 20);
		if(direction == Snake.UP)
			g.fillRect(x * (width / 20), (y * (height / 20)) + 20, width / 20, height / 20 / 2);
		else if(direction == Snake.RIGHT)
			g.fillRect(x * (width / 20), y * (height / 20), width / 20 / 2, height / 20);
		else if(direction == Snake.DOWN)
			g.fillRect(x * (width / 20), y * (height / 20), width / 20, height / 20 / 2);
		else if(direction == Snake.LEFT)
			g.fillRect((x * (width / 20)) + 20, y * (height / 20), width / 20 / 2, height / 20);
	}

	@Override
	public int getX() {
		return x;
	}

	@Override
	public int getY() {
		return y;
	}
}
