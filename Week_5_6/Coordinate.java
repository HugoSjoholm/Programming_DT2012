public class Coordinate{

	private double latitude;
	private double longitude;


	public Coordinate(double lat, double lon){
		if(lat > 90 || lat < -90){
			throw new IllegalArgumentException("Latitude range is [-90, 90], but found " + lat);
		}
		if(lon > 180 || lon < -180){
			throw new IllegalArgumentException("Latitude range is [-180, 180], but found " + lon);	
		}

		latitude = lat;
		longitude = lon;
	}

	public double getLatitude(){return latitude;}
	public double getLongitude(){return longitude;}


	public String toString(){
		//Denna är färdig. This is done. 
		
		// Implement a toString method
		return "" + latitude + "° N, " + longitude + "° E";
	}

	private int sign(double deg){
		// Your code here
		// Determine if the coordinate is positive or negative
		// Send a 1 or a -1 for positive or negative, respectively


		//is this function ever used??
		return 0;
	}
	private String sexagecimalDegrees(double deg){
		// Follow the process for conversion from the Wikipedia page
		// https://en.wikipedia.org/wiki/Geographic_coordinate_conversion
		// and determine the values for the variables degrees, minutes, and seconds
		
		int flooredDeg = (int)deg;

		double min = (deg - flooredDeg) * 60;
		int seconds = (int)((min - ((int)min)) * 60);

		return "" + flooredDeg + "° " + (int)min + "' " + seconds + "'' "; //the min should be rounded, but to get the same result as the assigment I have to floor it. this may cause inacurascies in the future

	}

	public String toSexagecimal(){
		String sexagecimalLat = sexagecimalDegrees(latitude);
		String sexagecimalLon = sexagecimalDegrees(longitude);
		String ns = "N";
		String ew = "E";
		// Your code here
		// Use the methods above to create the appropriate string to return

		return sexagecimalLat + ns + ", " + sexagecimalLon + ew;
	}
	

	private double haversine(double angle){
		// Modify this method to calculate the haversine
		// for the angle between latitudes or longitudes
		double tmp = Math.sin(angle / 2);
		return (tmp * tmp);
	}

	public double distanceTo(Coordinate that){
		// You can use the following reference to find pointers on how to implement the Haversine formula 
		// https://community.esri.com/t5/coordinate-reference-systems-blog/distance-on-a-sphere-the-haversine-formula/ba-p/902128
		// You can even use this reference: https://www.baeldung.com/java-find-distance-between-points
		// But bear in mind that YOU MUST NOT CHANGE THE SIGNATURE FOR THIS METHOD
		// And that you need to use the haversine() method above as well
		// You are only allowed to use the Math library and nothing else
		double c = 0; // Modify this according to the formulas you read
		double earthRadius = 6371.01; // in Km

		double dsiatanceLatitued = Math.toRadians((this.latitude - that.latitude));
		double distanceLongitued = Math.toRadians((this.longitude - that.longitude));

		double startLatitued = Math.toRadians(this.latitude);
		double endLatitued = Math.toRadians(that.latitude);

		double tmp = haversine(dsiatanceLatitued) + Math.cos(startLatitued) * Math.cos(endLatitued) * haversine(distanceLongitued);
		c = 2 * Math.atan2(Math.sqrt(tmp), Math.sqrt(1 - tmp));

		return c * earthRadius;
	}

	// Create a simple test program
	public static void main(String[] args){
		Coordinate c1 = new Coordinate(56.6744, 12.8578);
		Coordinate c2 = new Coordinate(56.0465, 12.6945);

		System.out.println("Halmstad is at " + c1.toString() + " or " + c1.toSexagecimal());
		System.out.println("Helsingborg is at " + c2.toString() + " or " + c2.toSexagecimal());
		System.out.println("The distance between them is " + c1.distanceTo(c2) + " km");
		


	}
}