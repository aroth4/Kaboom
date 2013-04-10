package edu.ycp.cs201.kaboom;


import java.util.ArrayList;
import java.util.Random;
import java.applet.*;
import java.net.*;



/**
 * The Game class represents the game state:
 * the position of the bucket, the position/direction of the bomber,
 * the position(s) of the bombs, etc.  Note that this class
 * is NOT responsible for drawing game play objects:
 * that is handled by the KaboomView class.
 */
public class Game {
	/**
	 * Width of the gameplay field.
	 */
	public static final double WIDTH = 640;

	/**
	 * Height of the gameplay field.
	 */
	
	// Fields
	public static final double HEIGHT = 480;
	private static double width;
	private static double height;
	private static double pX;
	private static double pY;
	private static double radius;
	private static int direction = 1;
	static int score;
	static int difficulty;
	private static int count = 0;
	
	
	public static ArrayList<Circle> BOMBS = new ArrayList<Circle>(); 
	public static Rectangle BUCKET = new Rectangle(new Point(pX, pY), width, height);
	public static Rectangle BOMBER = new Rectangle(new Point(pX, pY), width, height);
	public static Circle BOMB = new Circle(new Point(pX, pY), radius);
	
	private Random rand; // use this to generate random numbers

	boolean gameOver=false;
	boolean playSound=false;
	// TODO: add fields to represent the game state
	// Hint: use your Point, Circle, and Rectangle classes

	/**
	 * Constructor: initialize the game state.
	 */
	public Game() {
		//Init game variables and starting positions
		rand = new Random();
		BUCKET.TopLeftCorner.pX=300; 
		BUCKET.TopLeftCorner.pY=432;
		BUCKET.x=60.0;
		BUCKET.y=30.0;
		BOMBER.TopLeftCorner.pX=10;
		BOMBER.TopLeftCorner.pY=10;
		BOMBER.x=30.0;
		BOMBER.y=30.0;
		BOMB.Origin.pX=(BOMBER.TopLeftCorner.pX+7);
		BOMB.Origin.pY=40;
		BOMB.cRadius=15;
		score=0;
		generateBombs();
		
		
		//PLAY MUSIC
		try {
			AudioClip clip = Applet.newAudioClip(
			new URL("http://students.ycp.edu/~aroth4/Music.wav"));
			clip.loop();
			} catch (MalformedURLException murle) {
			System.out.println(murle);
			}
		

	}

	/**
	 * This method is called approximately 60 times per second.
	 * It should update the game state by moving the bomber and bombs,
	 * and moving the bucket if the player has moved the mouse.
	 */
	private void generateBombs() {
		
		// Create bombs in bomb Array
			
		BOMBS.add(new Circle((new Point(pX, 40)), radius));
		BombpX(
				BOMBER.TopLeftCorner.pX+7, BOMBS.size());
			}
	
	public void timerTick() {
		// Updates bomb, bomber, score and bucket
		count++;
		 // If the game has ended, don't make an further updates to the game state
		  if (gameOver==true) {
		  }
		  if (gameOver==false){
		dropBomb();
		moveBucket();
		moveBomber();
		gameScore();
		
		if(count % 30 == 0) {
			generateBombs();
			//System.out.println(BOMBS.size());
			
			//PLAY THE BOMBS
			try {
				AudioClip clip = Applet.newAudioClip(
				new URL("http://students.ycp.edu/~aroth4/Explosion.wav"));
				clip.play();
				} catch (MalformedURLException murle) {
				System.out.println(murle);
				}
			}
	
		if(count % 2300 == 0){
				try {
					AudioClip clip = Applet.newAudioClip(
					new URL("http://students.ycp.edu/~aroth4/GodLike.wav"));
					clip.play();
					} catch (MalformedURLException murle) {
					System.out.println(murle);
					}
		}
		
		//Debug count
		//System.out.println(count);
		//debug coordinates for collision
//		System.out.printf("Origin X: %s\n", BOMB.Origin.pX);
//		System.out.printf("Bucket X: %s\n", BUCKET.TopLeftCorner.pX);
//		System.out.printf("Origin Y: %s\n", BOMB.Origin.pY);
//		System.out.printf("Bucket Y: %s\n", BUCKET.TopLeftCorner.pY);
		  }
	}
	
	private void BombpX(double x, int numBomb) {
		
		// Set bomb location
				
		BOMBS.get(numBomb-1).Origin.pX = x;
			}
	
	private void gameScore() { 
		// Check for collision.  If circle's y coordinates, and x coordinates intersect
		// bucket, then collision is detected-add 10 points to score
		for (int i = 0; i < BOMBS.size(); i++) {
		if (BOMBS.get(i).Origin.pY + 15 >= BUCKET.TopLeftCorner.pY && 
				BOMBS.get(i).Origin.pY + 15 <= BUCKET.TopLeftCorner.pY + 30 && 
				BOMBS.get(i).Origin.pX - 15 >= BUCKET.TopLeftCorner.pX - 30 && 
				BOMBS.get(i).Origin.pX + 15 <= BUCKET.TopLeftCorner.pX + 60){
				score+=10;
				BOMBS.remove(i);
			//Reset the bombs location
//				BOMBS.get(i).Origin.pY=40;
//				BOMBS.get(i).Origin.pX=BOMBER.TopLeftCorner.pX+7;
			}
		}

	}

	public void moveBomber() {
		//Generate random number, if bomber hits JPanel bounds, or rand number is 35 or 70
		//then switch directions
		int newRandom = rand.nextInt(100);
		if(BOMBER.TopLeftCorner.pX <=0 || BOMBER.TopLeftCorner.pX + 30 > 639){
			direction *=-1;
		}
		else if(newRandom==35 || newRandom==70){
			direction*=-1;
		}
		//Move bomber left/right at 4 pixels per second
			BOMBER.TopLeftCorner.pX += (4 * direction);
	}
	
	public void dropBomb() {
		//*Nick Lay helped with ArrayList usage.
		
		//Drop bombs based on where the bombers location is
		
		for (int i = 0; i < BOMBS.size(); i++) {
			//INCREASE DIFFICULTY BASED ON SCORE
			playSound=true;
			if(score<=100){
				BOMBS.get(i).Origin.pY += 3;
				difficulty=1;
			}
			if(score<=250 && score>101){
				BOMBS.get(i).Origin.pY += 5;
				difficulty=2;
			}
			if(score<=500 && score>251){
				BOMBS.get(i).Origin.pY += 7;
				difficulty=3;
			}
			if(score<=750 && score>501){
				BOMBS.get(i).Origin.pY += 10;
				difficulty=4;
			}
			if(score>=751){
				BOMBS.get(i).Origin.pY += 20;
				difficulty=5;

			}
			if (BOMBS.get(i).Origin.pY > 480) {					
			// If bomb reaches bottom of screen without being diffused			
				gameOver = true;
			}
		}

	}
	
	public void moveBucket() {
		//Set buckets mid-point equal to Mouse location
		BUCKET.TopLeftCorner.pX = KaboomView.MouseX - 30;
	}
	
}
