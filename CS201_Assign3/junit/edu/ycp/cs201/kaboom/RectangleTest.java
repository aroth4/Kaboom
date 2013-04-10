package edu.ycp.cs201.kaboom;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RectangleTest {
	// When comparing floating point values for equality, allow
	// a small "fudge factor" to account for the fact that floating
	// point arithmetic is not exact
	private static final double DELTA = 0.00001;
	
	// TODO: fields for test fixture objects
	private Rectangle fiveByFourAtOrigin;
	private Rectangle rectangle2;
	private Rectangle rectangle3;
	
	@Before
	public void setUp() {
		// TODO: create test fixture objects
		fiveByFourAtOrigin = new Rectangle(new Point(0.0, 0.0), 5.0, 4.0);
		rectangle2 = new Rectangle(new Point(4.0, 3.0), 2.0, 10.0);
		rectangle3 = new Rectangle(new Point(-4.0, -2.0), 7.0, 4.0);
	}
	
	//Test GetWidth
	@Test
	public void testGetWidth() {
		assertEquals(5.0, fiveByFourAtOrigin.getWidth(), DELTA);
		assertEquals(2.0, rectangle2.getWidth(), DELTA);
		assertEquals(7.0, rectangle3.getWidth(), DELTA);
	}
	
	//Test GetHeight
	@Test
	public void testGetHeight() {
		assertEquals(4.0, fiveByFourAtOrigin.getHeight(), DELTA);
		assertEquals(10.0, rectangle2.getHeight(), DELTA);
		assertEquals(4.0, rectangle3.getHeight(), DELTA);
	}
	
	//TestSetCorner
	@Test
	public void testSetTopLeft(){
		Point newTopLeft = fiveByFourAtOrigin.TopLeftCorner;
		newTopLeft.pX = 1;
		newTopLeft.pY = 1; 
		fiveByFourAtOrigin.setTopLeft(newTopLeft);
		newTopLeft.pX = 2;
		newTopLeft.pY = 2; 
		rectangle2.setTopLeft(newTopLeft);
		newTopLeft.pX = 3;
		newTopLeft.pY = 3; 
		rectangle3.setTopLeft(newTopLeft);
	}
	
	//Test Set Width
	@Test
	public void testSetWidth(){
		double newWidth = fiveByFourAtOrigin.x;
		newWidth = 5;
		fiveByFourAtOrigin.setWidth(newWidth);
		newWidth = 10;
		rectangle2.setWidth(newWidth);
		newWidth = 15;
		rectangle3.setWidth(newWidth);
	}
	
	//Test Set Height
	@Test
	public void testSetHeight(){
		double newHeight = fiveByFourAtOrigin.x;
		newHeight = 5;
		fiveByFourAtOrigin.setHeight(newHeight);
		newHeight = 10;
		rectangle2.setHeight(newHeight);
		newHeight = 15;
		rectangle3.setHeight(newHeight);
	}
	
	//Test ALL the easy overlaps
	@Test
	public void testOverlapsEasyCases() throws Exception {
		Circle doesOverlap = new Circle(new Point(3.0, -0.8), 1.0);
		Circle doesNotOverlap = new Circle(new Point(-1.2, 2.0), 1.0);
		
		assertTrue(fiveByFourAtOrigin.overlaps(doesOverlap));
		assertFalse(fiveByFourAtOrigin.overlaps(doesNotOverlap));

	}
	
	//Test ALL the hard overlaps
	@Test
	public void testOverlapsHardCase() throws Exception {
		Circle doesNotOverlap = new Circle(new Point(-0.9, -0.9), 1.0);
		
		assertFalse(fiveByFourAtOrigin.overlaps(doesNotOverlap));

	}
}
