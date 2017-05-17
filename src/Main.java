import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import javafx.scene.media.*;

//Dorian Rittenhouse
public class Main extends JPanel implements KeyListener, ActionListener {
	static ArrayList<Snake> snake = new ArrayList<Snake>();
	static ArrayList<Integer> directions = new ArrayList<Integer>();
	int direction = Snake.RIGHT;
	int score = 0;
	boolean gameOver = false;
	int applex = (int)(Math.random() * 20);
	int appley = (int)(Math.random() * 20);
	Apple apple = new Apple(applex, appley);
	
	//Main for setting up key listener and focus
	public Main() {
		setFocusable(true);
		addKeyListener(this);
	}
	
	public void paintComponent(Graphics g) {
		//Draws the background
		g.setColor(Color.black);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		//if loop to draw the game or the game over screen
		if(!gameOver) { //Game
			apple.draw(g, this.getWidth(), this.getHeight());
			//Does stuff if snake eats an apple.
			if(apple.touchingSnake(snake.get(0))) {
				snake.add(new SnakeBody(apple.x, apple.y));
				directions.add(directions.get(directions.size() - 1));
				applex = (int)(Math.random() * 20);
				appley = (int)(Math.random() * 20);
				apple.jump(applex, appley);
				score++;
			}
			g.setColor(Color.white);
			//draws and turns the snake
			for(int x = 0; x < snake.size(); x++) {
				snake.get(x).setDirection(directions.get(x));
				snake.get(x).draw(g, this.getWidth(), this.getHeight());
			}
			//Draws the score
			g.setFont(new Font("04b_19", Font.PLAIN, 40));
			g.drawString("Score: " + score, this.getWidth() / 2 - 80, 35);
			if(snake.get(0).getX() < 0 || snake.get(0).getX() > 19 || snake.get(0).getY() < 0 || snake.get(0).getY() > 19)
				gameOver = true;
		} else { //Game Over
			g.setColor(Color.white);
			g.setFont(new Font("04b_19", Font.PLAIN, 60));
			g.drawString("Game Over!", 130, 200);
			g.drawString("Your score was: " + score, 20, 300);
		}
		//Used this instead of timer.
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		repaint();
	}
	
	//startup for window and setting up variables
	public static void main(String[] args) throws InterruptedException, IOException {
		snake.add(new SnakeHead(0,0));
		directions.add(Snake.RIGHT);
		JFrame f = new JFrame("Slippery Snake");
		Main main = new Main();
		f.add(main);
		f.setSize(600, 620);
		f.setLocation(0, 0);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		f.setResizable(false);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		//keys to move the snake
		if(e.getKeyCode() == KeyEvent.VK_RIGHT)
			directions.set(0, Snake.RIGHT);
		if(e.getKeyCode() == KeyEvent.VK_DOWN)
			directions.set(0, Snake.DOWN);
		if(e.getKeyCode() == KeyEvent.VK_LEFT)
			directions.set(0, Snake.LEFT);
		if(e.getKeyCode() == KeyEvent.VK_UP)
			directions.set(0, Snake.UP);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		//allows player to reset game when game over screen is visible
		if(e.getKeyCode() == KeyEvent.VK_SPACE && gameOver == true) {
			gameOver = false;
			score = 0;
			snake.clear();
			directions.clear();
			direction = Snake.RIGHT;
			snake.add(new SnakeHead(1,1));
			directions.add(Snake.RIGHT);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
}
