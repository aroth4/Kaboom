package edu.ycp.cs201.kaboom;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 * This class contains the main method used to start the
 * game.  You should not need to change anything here.
 */
public class Kaboom {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				// Create the Game object that represents the game state
				Game game = new Game();
				
				// Create the KabomView that will visualize the game state
				KaboomView view = new KaboomView(game);

				// Create a frame (top-level window) to enclose the KaboomView
				JFrame frame = new JFrame();
				frame.setTitle("Kaboom!");
				frame.setContentPane(view);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.pack();
				//Start the game!
				view.startGame();
				// Make the frame visible
				frame.setVisible(true);
				
			}
			
		});
		
	}
}
