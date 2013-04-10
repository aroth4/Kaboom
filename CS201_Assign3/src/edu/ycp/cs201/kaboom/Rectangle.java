package edu.ycp.cs201.kaboom;

/**
 * Instances of this class represent rectangle with a given
 * top left point and given width and height.
 * They can be moved by setting a new top left point,
 * and resized by setting new width/height values.
 * 
 * Important: note that y coordinates increase in the down
 * direction and decrease in the up direction.
 * 
 * @author David Hovemeyer
 */
public class Rectangle {
	// TODO: add fields
	//Declare variables
	double x;
	double y;
	Point TopLeftCorner;
	/**
	 * Constructor.
	 * 
	 * @param topLeft the top left corner of the rectangle
	 * @param width   the width of the rectangle
	 * @param height  the height of the rectangle
	 */
	public Rectangle(Point topLeft, double width, double height) {
		//throw new UnsupportedOperationException("TODO - implement");
		//Redeclare variables
		TopLeftCorner=topLeft;
		x=width;
		y=height;
	}
	
	/**
	 * Get the top left point of the rectangle.
	 * 
	 * @return the top left point of the rectangle
	 */
	//return Corner
	public Point getTopLeft() {
		return TopLeftCorner;
		//throw new UnsupportedOperationException("TODO - implement");
	}
	
	/**
	 * Set the top left point of the rectangle.
	 * 
	 * @param topLeft the (new) top left point of the rectangle
	 */
	//Set topleft corner as local
	public void setTopLeft(Point topLeft) {
		//throw new UnsupportedOperationException("TODO - implement");
		TopLeftCorner=topLeft;
	}
	
	/**
	 * Get the current width of the rectangle.
	 * 
	 * @return the current width of the rectangle
	 */
	//
	//return width
	public double getWidth() {
		//throw new UnsupportedOperationException("TODO - implement");
		return x;
	}
	
	/**
	 * Set the width of the rectangle.
	 * 
	 * @param width the (new) width of the rectangle
	 */
	//Set width locally
	public void setWidth(double width) {
		//throw new UnsupportedOperationException("TODO - implement");
		x=width;
	}
	
	/**
	 * Get the current height of the rectangle.
	 * 
	 * @return the current height of the rectangle
	 */
	
	//return height
	public double getHeight() {
		//throw new UnsupportedOperationException("TODO - implement");
		return y;
	}
	
	/**
	 * Set the height of the rectangle.
	 * 
	 * @param height the (new) height of the rectangle
	 */
	
	//Set height locally
	public void setHeight(double height) {
		//throw new UnsupportedOperationException("TODO - implement");
		y=height;
	}

	/**
	 * Determine whether the given circle either completely or partially
	 * overlaps this retangle.
	 * 
	 * @param circle  a circle
	 * @return true if the circle completely or partially overlaps the rectangle,
	 *         false if there is no overlap
	 */
	
	//Find out if circle and rectangle overlap-old code kept as backup.
	public boolean overlaps(Circle circle) {  
		
		//***Nick Lay helped with this segment's logic***
		
		//New points
		Point RectCenter = TopLeftCorner;
		Point CircleDist = circle.Origin;
		
		//Set values for center of rectangle
		RectCenter.pX = TopLeftCorner.pX + (x/2.0);
		RectCenter.pY = TopLeftCorner.pY + (y/2.0);
		
		//Set values for distance between center of circle
		//and center of rectangle
		CircleDist.pX = Math.abs(circle.Origin.pX - RectCenter.pX);
		CircleDist.pY = Math.abs(circle.Origin.pY - RectCenter.pY);
		
		//If dist between shapes X, is > sum of radius of circle and half
		//of rectangle width-return false
		if(CircleDist.pX > (x/2.0 + circle.cRadius)){
			return false;
		}
		//If dist between shapes Y, is > sum of radius of circle and half
		//of rectangle height-return false
		if(CircleDist.pY > (y/2.0 + circle.cRadius)){
			return false;
		}
		//If dist between shapes X, is <= sum of radius of circle half and half
		//of rectangle width-return true
		if(CircleDist.pX <= (x/2.0)){
			return true;
		}
		//If dist between shapes Y, is <= sum of radius of circle half and half
		//of rectangle height-return true
		if(CircleDist.pY <= (y/2.0)){
			return true;
		}
		return false;
		
		//throw new UnsupportedOperationException("TODO - implement");
//		double TopCircle = circle.Origin.pY - circle.cRadius;
//		double BottomCircle = circle.Origin.pY + circle.cRadius;
//		double LeftSideCircle = circle.Origin.pX - circle.cRadius;
//		double RightSideCircle = circle.Origin.pY + circle.cRadius;
//		
//		double TopRect = TopLeftCorner.pY;
//		double BottomRect = TopLeftCorner.pY+y;
//		double LeftSideRect = TopLeftCorner.pX;
//		double RightSideRect = TopLeftCorner.pX+x;
//		
//		if(BottomCircle<TopRect && BottomCircle>BottomRect){
//			return true;
//		} else if(TopCircle<BottomRect && TopCircle>TopRect){
//			return true;
//		} else if(RightSideCircle>RightSideRect && RightSideCircle<LeftSideRect){
//			return true;
//		} else if(LeftSideCircle<LeftSideRect && LeftSideCircle>RightSideRect){
//			return true;
//		}
		
		
	}
}
