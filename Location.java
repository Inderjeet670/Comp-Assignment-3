/*Code Authored by:
***Dr. Opeyemi Olusegun Adesina
***School of Computing, University of the Fraser Valley, Abbotsford - Canada
***All rights reserved - For reuse purposes, please contact Dr. Adesina at [opeyemi.adesina@ufv.ca]
**/

package tracker.objects;

public class Location {
	
	//instance variables
	double longitude, latitude;
	
	//default constructor
	public Location() {//default constructor
		//INSERT YOUR CODE HERE...
		this.longitude = 0.0;
		this.latitude = 0.0;
	}
	
	//parameterized constructor
	public Location( double longitude, double latitude ) {//parametrized constructor
		//INSERT YOUR CODE HERE...
		this.longitude = longitude;//sets longitude
		this.latitude = latitude;//sets latitude
	}
	
	public double getLongitude() {
		//INSERT YOUR CODE HERE...
		return this.longitude;//returns longitude
	}
	
	public double getLatitude() {
		//INSERT YOUR CODE HERE...
		return this.latitude;//returns latitude
	}
	
	public void setLongitude( double longitude ) {
		//INSERT YOUR CODE HERE...
		this.longitude = longitude;//sets longitude
	}
	
	public void setLatitude( double latitude ) {
		//INSERT YOUR CODE HERE...
		this.latitude = latitude;//sets latitude

	}
	
	public boolean equals( Location other ) {
		
		//INSERT YOUR CODE HERE...
		if(other == null){
			return false;//returns false if parameter is null
		}
		else{
			//if object isn't null, the it is compared to the current object and returns true or false.
			return this.longitude == other.getLongitude() && this.latitude == other.getLatitude();// returns true or false according to the return statement after making comparisons
		}
	}
	
	public String toString() {
		return "Located at: [longitude: " + longitude +", latitude: " + latitude +"]";
	}
}