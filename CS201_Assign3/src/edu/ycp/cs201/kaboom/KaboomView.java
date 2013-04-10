//EXTRA CREDIT: GAME MUSIC AND SOUND EFFECTS ADDED, "LEVELS", DIFFICULTY INCREASED AFTER CERTAIN POINT VALUES ARE REACHED.  
//Sound Effects: http://soungle.com/index.php?page=search&total=33&q=explosion&actual=3
//Sound Effects: http://www.dota-blog.com/2008/03/dota-allstars-sound-effects-free.html
//Music: From http://www.jamendo.com/en/track/459399/sunday-night   -Song covered by Creative Commons Free Usage
//Sound and music were uploaded to student public website for quick retrieval

package edu.ycp.cs201.kaboom;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * KaboomView is the GUI panel class.
 * It draws a picture of each frame of animation based on the
 * game state (Game object), handles user input (mouse moves),
 * and updates the game state based on the user input.
 */
public class KaboomView extends JPanel {
	private static final long serialVersionUID = 1L;

	private static final Color BACKGROUND_COLOR = new Color(0, 127, 0);
	private static final Color BUCKET_COLOR = new Color(139, 69, 19);
	private static final Color BOMBER_COLOR = Color.WHITE;
	private static final Color BOMB_COLOR = Color.BLACK;
	

	public static double MouseX;
	
	// The game object contains all of the game state data.
	private Game game;


	
	// TODO: add any other fields you need
	
	/**
	 * Constructor.
	 * 
	 * @param game the Game object representing the game state
	 */
	public KaboomView(Game game) {
		this.game = game;
		setBackground(BACKGROUND_COLOR);
		setPreferredSize(new Dimension((int) Game.WIDTH, (int) Game.HEIGHT));
	}
	
	/**
	 * Start the game.
	 */
	public void startGame() {
		// Create the animation timer.
		// It will fire an event about 60 times per second.
		// Every time a timer event fires the handleTimerEvent method
		// will be called.

		Timer timer = new Timer(1000 / 60, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				handleTimerEvent();
			}
		});
		timer.start();
		
		// Add a listener for mouse motion.
		// Each time the mouse is moved, the handleMouseMove method
		// will be called.
		addMouseMotionListener(new MouseAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				handleMouseMove(e);
			}
		});
	}

	protected void handleTimerEvent() {
		// You should not need to change this method.
		game.timerTick();
		repaint();
	}
	
	protected void handleMouseMove(MouseEvent e) {
		// TODO: handle mouse movement
		MouseX=e.getX();
		// Hint: update the game state to inform it that the
		// bucket should be moved.
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g); // paint the background
		
		// TODO: paint the game objects (bucket, bomber, and bombs)
		g.setColor(BUCKET_COLOR);
		g.fillRect(((int) Game.BUCKET.TopLeftCorner.pX), (int)Game.BUCKET.TopLeftCorner.pY, 
				(int) Game.BUCKET.x, (int) Game.BUCKET.y);
		g.setColor(BOMBER_COLOR);
		g.fillRect(((int) Game.BOMBER.TopLeftCorner.pX), (int)Game.BOMBER.TopLeftCorner.pY, 
				(int) Game.BOMBER.x, (int) Game.BOMBER.y);
		

		g.setColor(BOMB_COLOR);
		for (int i = 0; i < Game.BOMBS.size(); i++) {
	    	 g.fillOval((int)Game.BOMBS.get(i).Origin.pX, (int)Game.BOMBS.get(i).Origin.pY, 15, 15);
	    	}


		
		//Display Score
		Font Score = new Font("Serif", Font.BOLD, 50);
	    g.setColor(Color.BLACK);
	    g.setFont(Score);
	    g.drawString(Integer.toString(Game.score), 540, 60);
	    //Display difficulty
	    if(game.difficulty==1){
	    	Font Difficulty = new Font("Serif", Font.BOLD, 15);
		    g.setColor(Color.BLACK);
		    g.setFont(Difficulty);
		    g.drawString("VERY EASY", 530, 75);
	    }
	    if(game.difficulty==2){
	    	Font Difficulty = new Font("Serif", Font.BOLD, 15);
		    g.setColor(Color.BLACK);
		    g.setFont(Difficulty);
		    g.drawString("EASY", 580, 75);
	    }

	    if(game.difficulty==3){
	    	Font Difficulty = new Font("Serif", Font.BOLD, 15);
		    g.setColor(Color.WHITE);
		    g.setFont(Difficulty);
		    g.drawString("MEDIUM", 550, 75);
	    }

	    if(game.difficulty==4){
	    	Font Difficulty = new Font("Serif", Font.BOLD, 15);
		    g.setColor(Color.RED);
		    g.setFont(Difficulty);
		    g.drawString("HARD", 560, 75);
	    }

	    if(game.difficulty==5){
	    	Font Difficulty = new Font("Serif", Font.BOLD, 15);
		    g.setColor(Color.RED);
		    g.setFont(Difficulty);
		    g.drawString("GODLIKE", 560, 75);
	    }


		//If Game Over boolean is true, display game over message
		if(game.gameOver==true){
			Font Message = new Font("Serif", Font.BOLD, 50);
				FontMetrics fm = getFontMetrics(Message);
			    g.setColor(Color.RED);
				g.setFont(Message);
			
			    String s = "Game Over, HAHA!";
			    int xstart = ((int) Game.WIDTH - fm.stringWidth(s)) / 2;
			    int ystart = (int) (Game.HEIGHT / 2);
			
			    g.drawString(s, xstart, ystart);
		}
	}
}
