import java.awt.Graphics;

public class SnakeBody implements Snake {
	int x;
	int y;

	public SnakeBody(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	@Override
	public void setDirection(int direction) {
		if(direction == Snake.UP)
			y--;
		else if(direction == Snake.RIGHT)
			x++;
		else if(direction == Snake.DOWN)
			y++;
		else if(direction == Snake.LEFT)
			x--;
	}

	@Override
	public void draw(Graphics g, int width, int height) {
		g.fillRect(x * (width / 20), y * (height / 20), width / 20, height / 20);
	}

	@Override
	public int getX() {
		// TODO Auto-generated method stub
		return x;
	}

	@Override
	public int getY() {
		// TODO Auto-generated method stub
		return y;
	}

}
