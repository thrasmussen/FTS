/**
 * 
 */
package main;

/**
 * @author Thomas Rasmussen
 *
 */
public class GeoCalculations {

	
	public static final double EARTH_RADIUS_IN_KM= 6371;
	
	
	public static double geoDistanceInMetersBetweenLocation(double lat1, double lat2, double lon1, double lon2){
		double dlat = Math.abs(lat1-lat2);
		double dlon = Math.abs(lon1-lon2);
		double a = Math.pow((Math.sin(dlat/2)), 2) + Math.cos(lat1) * Math.cos(lat2) * Math.pow((Math.sin(dlon/2)),2);
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
		return EARTH_RADIUS_IN_KM * c;
	}
	public static double geoDistanceInMetersBetweenLocation(Position pos1, Position pos2){
		double dlat = Math.abs(pos1.getLatitude()-pos2.getLatitude());
		double dlon = Math.abs(pos1.getLongitude()-pos2.getLongitude());
		double a = Math.pow((Math.sin(dlat/2)), 2) + Math.cos(pos1.getLatitude()) * Math.cos(pos2.getLatitude()) * Math.pow((Math.sin(dlon/2)),2);
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
		return EARTH_RADIUS_IN_KM * c;
	}
	
	
	public static double geoAngleBetweenLocations(double lat1, double lat2, double lon1, double lon2) {
		double dlat = lat2-lat1;
		double dlon = lon2-lon1;
		double angle = (Math.atan2(dlat,dlon) * 180) / Math.PI;
		return Math.toRadians(angle);
	}
	public static double geoAngleBetweenLocations(Position pos1, Position pos2) {
		double dlat = pos2.getLatitude()-pos1.getLatitude();
		double dlon = pos2.getLongitude()-pos1.getLongitude();
		double angle = (Math.atan2(dlat,dlon) * 180) / Math.PI;
		return Math.toRadians(angle);
	}
	
	
	
}
