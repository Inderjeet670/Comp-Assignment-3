/*Code Authored by:
***Dr. Opeyemi Olusegun Adesina
***School of Computing, University of the Fraser Valley, Abbotsford - Canada
***All rights reserved - For reuse purposes, please contact Dr. Adesina at [opeyemi.adesina@ufv.ca]
**/

package tracker.shapes;

import tracker.objects.*;

public class Circle extends Shape {
	
	//instance variable
	private double radius;
	private static final double PI = 3.142; 
	
	public Circle() {
		//INSERT YOUR CODE HERE...
		this.radius = 0.0;
	} 
	
	public Circle( double radius, Location centrePoint ) {
		//INSERT YOUR CODE HERE...
		this.radius = radius;
		this.setCentrePoint(centrePoint);


	}
	
	public void setRadius( double radius ) {
		//INSERT YOUR CODE HERE...
		this.radius = radius;
	}

	public double getRadius() {
		//INSERT YOUR CODE HERE...
		return this.radius;
	}
	
	public double area() {
		//INSERT YOUR CODE HERE...
		double ar = PI * radius * radius;
		return Math.round(ar * 100)/100.0;
	}
	
	public double perimeter() {
		//INSERT YOUR CODE HERE...
		double per = (2 * PI * radius);
		return Math.round(per * 100)/100.0;
	}
	
	public Rectangle getBoundingRectangle() {
		double length = 2 * radius;
		return new Rectangle( length, length, getCentrePoint() );
	}
	
	public boolean equals( Circle other ) {
		
		//INSERT YOUR CODE HERE...
		if(other == null){
			return  false;//if object is null, false is returned
		}
		else{
			/*if its not null, then parameter object is compared with the current objec and it returns either true or false*/
			return other.radius == this.radius && other.perimeter() == this.perimeter() && other.area() == this.area();
		}
	}
	
	public String toString() {
		return "Circle: [radius: " + radius +", "+ getCentrePoint() +"]";
	}
}