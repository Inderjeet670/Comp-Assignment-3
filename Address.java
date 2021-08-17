/*Code Authored by:
***Dr. Opeyemi Olusegun Adesina
***School of Computing, University of the Fraser Valley, Abbotsford - Canada
***All rights reserved - For reuse purposes, please contact Dr. Adesina at [opeyemi.adesina@ufv.ca]
**/

package tracker.objects;

public class Address {
	
	private int unit, streetNumber;
	private String streetName, postalCode, city, province;
	public enum Type { BUSINESS, OFFICE, HOME }
	Type type;
	String country;
	
	//Constructors
	public Address() {
		//INSERT YOUR CODE HERE...
		unit = 0;
		streetNumber = 0;
		streetName = " ";
		city = "";
		province = "";
		type = Type.HOME;
		country = " ";
	}
	
	public Address( int streeNumber, String streetName, String postalCode, String city, String province, Type type, String country ) {
		//INSERT YOUR CODE HERE...
		unit = 0;
		this.streetNumber = streeNumber;
		this.streetName = streetName;
		this.postalCode = postalCode;
		this.city = city;
		this.province = province;
		this.type = type;
		this.country = country;
	}
	
	public Address( int unit, int streeNumber, String streetName, String postalCode, String city, String province, Type type, String country ) {
		//INSERT YOUR CODE HERE...
		this.unit = unit;
		this.streetNumber = streeNumber;
		this.streetName = streetName;
		this.postalCode = postalCode;
		this.city = city;
		this.province = province;
		this.type = type;
		this.country = country;
	}
	
	//Accessor methods
	public int getStreetNumber() {
		//INSERT YOUR CODE HERE...
		return this.streetNumber;//returns Streetnumber
	}
	
	public int getUnit() {
		//INSERT YOUR CODE HERE...
		return this.unit;//returns unit
	}
	
	public String getType() {
		//INSERT YOUR CODE HERE...
		return typeToString();//returns type
	}
	
	public String getStreetName() {
		//INSERT YOUR CODE HERE...
		return this.streetName;//returns streetname
	}
	
	public String getPostalCode() {
		//INSERT YOUR CODE HERE...
		return this.postalCode;//returns postal code
	}
	
	public String getCity() {
		//INSERT YOUR CODE HERE...
		return this.city;//returns city
	}
	
	public String getProvince() {
		//INSERT YOUR CODE HERE...
		return this.province;
	}

	public String getCountry() {
		//INSERT YOUR CODE HERE...
		return this.country;//returns country
	}
	
	public void setStreetNumber( int number ) {
		//INSERT YOUR CODE HERE...
		this.streetNumber = number;//sets streetnumber
	}
	
	public void setUnit( int number ) {
		//INSERT YOUR CODE HERE...
		this.unit = number;//sets unit
	}
	
	public void setStreetName( String name ) {
		//INSERT YOUR CODE HERE...
		this.streetName = name;//sets name
	}
	
	public void setPostalCode( String code ) {
		//INSERT YOUR CODE HERE...
		this.postalCode = code;//sets postal code
	}
	
	public void setCity( String city ) {
		//INSERT YOUR CODE HERE...
		this.city = city;//sets city
	}
	
	public void setProvince( String province ) {
		//INSERT YOUR CODE HERE...
		this.province = province;//sets province
	}

	public void setCountry( String country ) {
		//INSERT YOUR CODE HERE...
		this.country = country;//sets country
	}
	
	
	public void setType( Type type ) {
		//INSERT YOUR CODE HERE...
		this.type = type;//sets type
	}
	
	private static String formatProvince( String provinceOrFederal ) {
			
		provinceOrFederal = provinceOrFederal.toLowerCase();
		if( provinceOrFederal.equals( "ontario" ) || provinceOrFederal.equals( "on" ) ) {
			return "ON";
		} else if( provinceOrFederal.equals( "Manitoba" ) || provinceOrFederal.equals( "mb" ) ) {
			return "MB";
		} else if( provinceOrFederal.equals( "british columbia" ) || provinceOrFederal.equals( "bc" ) ) {
			return "BC";
		} else if( provinceOrFederal.equals( "new brunswick" ) || provinceOrFederal.equals( "nb" ) ) {
			return "NB";
		} else if( provinceOrFederal.equals( "alberta" ) || provinceOrFederal.equals( "ab" ) ) {
			return "AB";
		} else if( provinceOrFederal.equals( "saskatchewan" ) || provinceOrFederal.equals( "sk" ) ) {
			return "SK";
		} else if( provinceOrFederal.equals( "nova scotia" ) || provinceOrFederal.equals( "ns" ) ) {
			return "NS";
		} else if( provinceOrFederal.equals( "quebec" ) || provinceOrFederal.equals( "qc" ) ) {
			return "QC";
		} else {
			return "federal";
		}
	}
	
	private String typeToString() {
		
		switch( type ) {
			case BUSINESS : return "BUSINESS";
			case OFFICE : return "OFFICE";
			case HOME : return "HOME";
			default : return "";
		}
	}
	
	public boolean equals( Address address ) {
		//INSERT YOUR CODE HERE...
		if(address == null){//if object is null, false is returned
			return false;
		}
		else{
			/*if object is not null, then respective instance variables of current object are compared to the respective instance variable values of the input object*/
			return true ;
		}
	}
	
	public String toString() {
		//INSERT YOUR CODE HERE...
		if(this.getUnit() == 0){//in case there's no unit number this is executed
			return this.getType()+": " + this.getStreetNumber() + ", " + this.getStreetName() + ", " + this.getCity() + ", " + formatProvince(this.getProvince()) + " " + this.getPostalCode() +
					", " + this.country;
		}
		else{//else this is executed.
			return this.getType()+": " + this.getUnit() + "-" + this.getStreetNumber() + ", " + this.getStreetName() + ", " + this.getCity() + ", " + formatProvince(this.getProvince())+
					" " + this.getPostalCode()+ ", " + this.country;

		}
	}
}