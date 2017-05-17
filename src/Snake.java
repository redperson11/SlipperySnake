import java.awt.Graphics;

//Dorian Rittenhouse
public interface Snake {
	//Directions for moveDirection method
	public static final int UP = 0, RIGHT = 1, DOWN = 2, LEFT = 3;
	
	void setDirection(int direction);
	void draw(Graphics g, int width, int height);
	int getX();
	int getY();
}