package edu.ycp.cs201.kaboom;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CircleTest {
	// When comparing floating point values for equality, allow
	// a small "fudge factor" to account for the fact that floating
	// point arithmetic is not exact
	private static final double DELTA = 0.00001;
	
	// TODO: fields for text fixture objects
	private Circle atOrigin;
	private Circle circle2;
	private Circle circle3;
	
	@Before
	
	//Set fields
	public void setUp() {
		// TODO: create test fixture objects
		atOrigin = new Circle(new Point(0, 0), 10.0);
		circle2 = new Circle(new Point(5, 10), 20.0);
		circle3 = new Circle(new Point(10, 20), 30.0);
		
	}
	
	// TODO: test methods
	//Test Get Radius
	@Test
	public void testGetRadius() throws Exception {
		assertEquals(10.0, atOrigin.getRadius(), DELTA);
		assertEquals(20.0, circle2.getRadius(), DELTA);
		assertEquals(30.0, circle3.getRadius(), DELTA);
		}
	//Test GetX
	@Test
	public void testGetX() throws Exception {
		assertEquals(0.0, atOrigin.getCenter().pX, DELTA);
		assertEquals(5.0, circle2.getCenter().pX, DELTA);
		assertEquals(10.0, circle3.getCenter().pX, DELTA);
		}
	//Test GetY	
	@Test
	public void testGetY() throws Exception {
		assertEquals(0.0, atOrigin.getCenter().pY, DELTA);
		assertEquals(10.0, circle2.getCenter().pY, DELTA);
		assertEquals(20.0, circle3.getCenter().pY, DELTA);
		}
	//Test SetRadius
	@Test
	public void setRadius() throws Exception {
		atOrigin.setRadius(5.0);
		assertEquals(5.0, atOrigin.getRadius(), DELTA);
		circle2.setRadius(10.0);
		assertEquals(10.0, circle2.getRadius(), DELTA);
		circle3.setRadius(15.0);
		assertEquals(15.0, circle3.getRadius(), DELTA);
	}
	//Test SetX
	@Test
	public void setX() throws Exception {
		Point newCenter = atOrigin.Origin;
		newCenter.pX = 2.0;
		atOrigin.setCenter(newCenter);
		assertEquals(2.0, atOrigin.getCenter().pX, DELTA);
		newCenter.pX = 4.0;
		circle2.setCenter(newCenter);
		assertEquals(4.0, circle2.getCenter().pX, DELTA);
		newCenter.pX = 6.0;
		circle3.setCenter(newCenter);
		assertEquals(6.0, circle3.getCenter().pX, DELTA);
		
	}
	//Test setY
	@Test
	public void setY() throws Exception {
		Point newCenter = atOrigin.Origin;
		newCenter.pY = 1.0;
		atOrigin.setCenter(newCenter);
		assertEquals(1.0, atOrigin.getCenter().pY, DELTA);
		newCenter.pY = 3.0;
		circle2.setCenter(newCenter);
		assertEquals(3.0, circle2.getCenter().pY, DELTA);
		newCenter.pY = 5.0;
		circle3.setCenter(newCenter);
		assertEquals(5.0, circle3.getCenter().pY, DELTA);
		
	}
}
