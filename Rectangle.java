/*Code Authored by:
***Dr. Opeyemi Olusegun Adesina
***School of Computing, University of the Fraser Valley, Abbotsford - Canada
***All rights reserved - For reuse purposes, please contact Dr. Adesina at [opeyemi.adesina@ufv.ca]
**/

package tracker.shapes;

import tracker.objects.*;
import tracker.objects.Location;

import java.util.*;

public class Rectangle extends Shape {
	
	//instance variable
	private double length, width;
	
	public Rectangle() {//default constructor
		//INSERT YOUR CODE HERE...
		length =0.0;
		width = 0.0;
	} 
	
	public Rectangle( double length, double width, Location centrePoint ) {//parametrized constructor
		//INSERT YOUR CODE HERE...
		this.length = length;
		this.width = width;
		this.setCentrePoint(centrePoint);
	}
	
	public void setLength( double length ) {
		//INSERT YOUR CODE HERE...
		this.length = length;//sets length
	}
	
	public void setWidth( double width ) {
		//INSERT YOUR CODE HERE...
		this.width = width;//sets width
	}
	
	public double getLength() {
		//INSERT YOUR CODE HERE...
		return this.length;//sets length
	}
	
	public double getWidth() {
		//INSERT YOUR CODE HERE...
		return this.width;//returns width
	}
	
	public double area() {
		//INSERT YOUR CODE HERE...
		double ArrRect = this.length * this.width;//calculates area of teh rectangle
		return Math.round(ArrRect * 100)/100.0;//returns area of rectangle
	}
	
	public double perimeter() {
		//INSERT YOUR CODE HERE...
		double peri = 2 * (length + width);//calculates perimeter
		return Math.round(peri * 100)/ 100.0;//returns perimeter
	}

	/**This method converts the rectangle to its corner points using the following mathematical, let
			radius be the operational radius of coverage
			(x,y) be the centrepoint of the rectangle
				then
					x1 = radius + x
					x2 = x - radius
					y1 = radius + y
					y2 = y - radius 
			
				AND
					(x1, y1) defines top-right corner with key - TR
					(x1, y2 ) defines bottom-right corner with key - BR
					(x2, y1) defines top-left corner with key - TL
					(x2, y2) defines bottom-left corner with key - BL
		ARGUMENTS:
			radius - operational radius of coverage

		RETURN:
			corners - a map of the corner points of a rectangle shape

	**/
	public Map<String, Location> getCornerPoints( double radius ) {//finds corner of rectangle
		
		Map<String, Location> corners = new HashMap<>();
		//INSERT YOUR CODE HERE...
		double x = getCentrePoint().getLongitude();//x co-ordinate
		double y = getCentrePoint().getLatitude();//y co-ordinate
		Location centre = new Location(x,y);
		corners.put("TL",new Location(x-radius,y+radius));//top left
		corners.put("BL",new Location(x-radius,y-radius));//bottom-left
		corners.put("TR",new Location(x+radius,y+radius));//top-right
		corners.put("BR",new Location(x+radius,y-radius));//bottom right

		return corners;//returns the corners
	}
	
	public Rectangle getBoundingRectangle() {
		return this;
	}
	
	public boolean equals( Rectangle other ) {
		if( other != null ) {
			return length == other.length && width == other.width && getCentrePoint().equals( other.getCentrePoint() );
		}
		return false;
	}
	
	public String toString() {
		return "Rectangle: [length: " + length +", width: "+ width + ", "+ getCentrePoint() +"]";
	}
}