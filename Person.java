/*Code Authored by:
***Dr. Opeyemi Olusegun Adesina
***School of Computing, University of the Fraser Valley, Abbotsford - Canada
***All rights reserved - For reuse purposes, please contact Dr. Adesina at [opeyemi.adesina@ufv.ca]
**/

package tracker.objects;

import java.util.*;
import tracker.shapes.*;
import tracker.shapes.Circle;
import tracker.shapes.Rectangle;

public class Person {
	
	private int identity;
	private String name;
	private double age;
	private Sex sex;
	private List<Address> addresses = new ArrayList<Address>();
	private Status status;
	private Location location = new Location();
	
	//constructors
	public Person() {
		name = " ";
		age = 0.0;
		sex = Sex.UNKNOWN;
		status = Status.UNKNOWN;
		identity = 0;
	}
	
	public Person( int identity, String name, double age, Sex sex, Status status, List<Address> addresses, Location location ) {
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.addresses = addresses;
		this.status = status;
		this.identity = identity;
		this.location = location;
	}
	
	
	//Implementations of accessor methods
	public String getName() {
		return name;
	}
	
	public double getAge() {
		return age;
	}
	
	public Sex getSex() {
		return sex;
	}
	
	public Status getStatus() {
		return status;
	}
	
	public List<Address> getAddresses() {
		return addresses;
	}
	
	public int getIdentity() {
		return identity;
	}
	
	public Location getLocation() {
		//INSERT YOUR CODE HERE...
		return this.location;
	}
	
	public void setName( String name ) {
		//INSERT YOUR CODE HERE...
		this.name = name;//sets the value of name
	}
	
	public void setAge( double age ) {
		//INSERT YOUR CODE HERE...
		this.age = age;//sets the value of age

	}
	
	public void setSex( Sex sex ) {
		//INSERT YOUR CODE HERE...
		this.sex = sex;//sets sex
	}
	
	public void setStatus( Status status ) {
		//INSERT YOUR CODE HERE...
		this.status = status;//sets status

	}
	
	public void setAddresses( List<Address> addresses ) {
		//INSERT YOUR CODE HERE...
		this.addresses = addresses;//setst address or addresses

	}
	
	public void setIdentity( int identity ) {
		//INSERT YOUR CODE HERE...
		this.identity = identity;//sets identity

	}
	
	public void setLocation( Location location ) {
		//INSERT YOUR CODE HERE...
		this.location = location;
	}
	
	public enum Status { 
		POSITIVE, NEGATIVE, SYMPTOMATIC, ASYMPTOMATIC, UNKNOWN 
	}
	
	public enum Sex { 
		MALE, FEMALE, UNKNOWN 
	}
	
	public boolean equals( Person person ) {
		
		//INSERT YOUR CODE HERE...
		if(person == null){//if object is null false is returned
			return false;
		}
		else{//if object is not null, then the values of the current object are compared to the values of the input object and the result which could be true or false is returned.
			return this.getName().equals(person.getName()) && this.getAge() == person.getAge() && this.getSex() == person.getSex() &&this.addresses.equals(person.getAddresses()) && this.getStatus() == person.getStatus()&&this.identity == person.getIdentity();

		}
	}

	/**Takes an operational radius and all the people in the community as arguments
	***Checks if this person (say p) is COVID-19 positive or asymptomatic and computes the list of everyone 
	in the neighbourhood that should be notified (or given an order).

	Person at location (x,y) is in the neighbourhood (i.e., in an operational radius - rad) 
	of person at location (xn, yn) if the following holds, if:
		- 'rec' be the bounding rectangle of circle with centrepoint (x,y)
		- 'rad' is the operational radius
		- 'topLeft' and 'bottomRight' be the top-left and 'bottomRight' corner points of rec 
		- x1, x2 are the longitudes of bottomLeft and topRight corners respectively
		- y1, y2 are the latitudes of bottomLeft and topRight corners respectively

		Subject to:
			y1 <= y <= y2 and x1 <= x <= x2										(1)
			p is POSITIVE or p is ASYMPTOMATIC									(2)


	ARGUMENTS:
		operational radius
		map of people in the community
	RETURN: 
		A map of neighbors within an operating radius - mapping person 
		identity with the person (i.e., Map<Integer, Person>).
	**/
	public Map<Integer, Person> getNeighbours( double radius, Map<Integer, Person> allPersons ) {

		Map<Integer, Person> neighbours = new HashMap<>();
		//INSERT YOUR CODE HERE...
		Circle ofRadius = new Circle(radius,location);//first we create circle for this person
		Rectangle main = ofRadius.getBoundingRectangle();//then we find the rectangular dimensions
		Map<String, tracker.objects.Location> corners = new HashMap<>();
		corners = main.getCornerPoints(radius);//using getcornerpoints method in rectangle class, corners are located
		Location BL = corners.get("BL");//variables for ease of use later in the code
		Location TL = corners.get("TL");//variables for ease of use later in the code
		Location TR = corners.get("TR");//variables for ease of use later in the code
		Location BR = corners.get("BR");//variables for ease of use later in the code
		double y1,y2,x1,x2;
		x1 = TL.getLongitude();//x of BL and TL
		x2 = TR.getLongitude();//x of TR and BR
		y1 = BL.getLatitude();//y of BL and BR
		y2 = TR.getLatitude();//y of TL and TR
         if(this.getStatus() == Status.ASYMPTOMATIC || this.getStatus() == Status.POSITIVE){//checks if this person is covid positive
			 for(Map.Entry<Integer, Person> entry: allPersons.entrySet()){//if statement above is true, then it loops over the input hashmap
			 	double x = entry.getValue().getLocation().getLongitude();//x co-ordinate for ease of use later
			 	double y = entry.getValue().getLocation().getLatitude();// y co-ordinate for ease of use later
			 	if(y1 <= y && y<=y2 && x1 <= x && x <= x2){//if these conditions are met, code goes to the next line, this statement checks if the location of the user in the map is inside the radius.
			 		if(entry.getValue().equals(this)){
						continue;//to prevent including the current person, we use continue;, in case it finds the exact same person in the list.
					}
			 		else{
						neighbours.put(entry.getKey(),entry.getValue());//if the person in the map is in the operational radius, the information is put into the hashmap 'neighbours'
					}
				}
			 }
		 }


		return neighbours;//returns the hashmap of users inside the operational radius that need to be informed
	}
	
	public String toString() {
		
		//INSERT YOUR CODE HERE...
		return "ID: " + this.identity +"\nFull Name: " +this.getName() +"\nAge: " + this.getAge()
				+ "\nSex: " +this.getSex() + "\nCovid-19 Status: " + this.getStatus()
				+ "\nContact Address(es): " + "\n" + this.addresses.get(0) ;
	}
}