import demos.*;

public class SimpleLocation {
	public Double latitude;
	public Double longitude;
	
	
	public SimpleLocation( Double latitude,Double longitude) {
		super();
		this.latitude = latitude;
		this.longitude = longitude;
		
	}
	
	public double getDist(SimpleLocation other){
		
		int R = 6373; // radius of the earth in kilometres

		double lat1rad = Math.toRadians(this.latitude);

		double lat2rad = Math.toRadians(other.latitude);

		double deltaLat = Math.toRadians(other.latitude-this.latitude);

		double deltaLon = Math.toRadians(other.longitude-this.longitude);

		double a = Math.sin(deltaLat/2) * Math.sin(deltaLat/2) +

		Math.cos(lat1rad) * Math.cos(lat2rad) *

		Math.sin(deltaLon/2) * Math.sin(deltaLon/2);

		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));

		double d = R * c;

		return d;
				
	}
	
	public static void main(String[] args){
		
		SimpleLocation loc1=new SimpleLocation(32.9,-117.2);
		SimpleLocation loc2=new SimpleLocation(-12.0,-77.0);
		
		System.out.println(loc1.getDist(loc2));
		
		
		demos.SimpleLocation ext_loc1=new demos.SimpleLocation(32.9,-117.2);
		demos.SimpleLocation ext_loc2=new demos.SimpleLocation(-12.0,-77.0);
		
		System.out.println(ext_loc1.getDist(32.9,-117.2,-12.0,-77.0));
		
	}
	
	
	
	
	
	
}
