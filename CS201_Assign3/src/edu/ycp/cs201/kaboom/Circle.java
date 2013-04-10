package edu.ycp.cs201.kaboom;



/**
 * Class whose instances represent circles in the x/y plane.
 * Circles can be moved by setting a new center point,
 * and resized by setting a new radius.
 * 
 * @author David Hovemeyer
 */
public class Circle {
	// TODO: add fields
	double cRadius;
	Point Origin;
	/**
	 * Constructor.
	 * 
	 * @param center  the center Point of the circle
	 * @param radius  the radius of the circle
	 */
	//Declare fields
	public Circle(Point center, double radius) {
		cRadius=radius;
		Origin=center;
	}
	
	/**
	 * Get the current center point of the circle.
	 * 
	 * @return the center point of the circle
	 */
	//return center
	public Point getCenter() {
		return Origin;
		//throw new UnsupportedOperationException("TODO - implement");

	}
	
	/**
	 * Set the center point of the circle.
	 * 
	 * @param center the (new) center point of the circle
	 */
	//set center locally
	public void setCenter(Point center) {
		//throw new UnsupportedOperationException("TODO - implement");
		Origin = center;
	}

	/**
	 * Get the current radius.
	 * 
	 * @return the current radius
	 */
	//return radius
	public double getRadius() {
		return cRadius;
		//throw new UnsupportedOperationException("TODO - implement");
	}

	/**
	 * Set the radius.
	 * 
	 * @param radius the (new) radius of the circle
	 */
	//Set radius locally
	public void setRadius(double radius) {
		//throw new UnsupportedOperationException("TODO - implement");
		cRadius = radius;
	}

}
