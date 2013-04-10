package edu.ycp.cs201.kaboom;

/**
 * Class whose instances represent points in the x/y plane.
 * Note that Point objects are immutable: once created,
 * their x and y values may not be changed.
 * 
 * @author David Hovemeyer
 */
public class Point {
	// TODO: add fields
	//Declare variables
	double pX, pY;
	/**
	 * Constructor.
	 * 
	 * @param x  the Point's x coordinate value
	 * @param y  the Point's y coordinate value
	 */
	public Point(double x, double y) {
		//throw new UnsupportedOperationException("TODO - implement");
		//Variables are locally redefined
		pX=x;
		pY=y;
	}
	/**
	 * Return the point's x coordinate value.
	 * 
	 * @return the point's x coordinate value
	 */
	//return X coordinate
	public double getX() {
		//throw new UnsupportedOperationException("TODO - implement");
		return pX;
	}
	
	/**
	 * Return the point's y coordinate value
	 * 
	 * @return the point's y coordinate value
	 */
	//return y coordinate
	public double getY() {
		//throw new UnsupportedOperationException("TODO - implement");
		return pY;
	}

	/**
	 * Return the geometric distance between this point and
	 * the point given as the parameter.
	 * 
	 * @param other another Point object
	 * @return the geometric distance between this point and the other point
	 */
	//return distance between points
	public double distanceTo(Point other) {
		double distX, distY, totalDist;
		distX=(other.pX - pX) * (other.pX - pX);
		distY=(other.pY - pY) * (other.pY - pY);
		totalDist=Math.sqrt(distX + distY);
		
		return totalDist;
		//throw new UnsupportedOperationException("TODO - implement");
		
	}
}
