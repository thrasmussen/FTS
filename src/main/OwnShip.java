/**
 * 
 */
package main;

/**
 * @author Thomas Rasmussen
 *
 */
public class OwnShip {
	
	private String name;
	private double length;
	private double width;
	
	private Position pos;
	private double heading; //radians
	private double speed_in_mps; //meters per sec
	
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public Position getPos() {
		return pos;
	}

	public void setPos(Position pos) {
		this.pos = pos;
	}

	public double getHeading() {
		return heading;
	}
	
	public double getHeadingDegrees() {
		return Math.toDegrees(heading);
	}

	public void setHeading(double heading) {
		this.heading = heading;
	}

	public double getSpeed_in_mps() {
		return speed_in_mps;
	}

	public void setSpeed_in_mps(double speed_in_mps) {
		this.speed_in_mps = speed_in_mps;
	}
	

	public OwnShip (String name, double length, double width, Position pos, double heading, double speed_in_mps){
		this.name = name;
		this.length = length;
		this.width = width;
		this.pos = pos;
		this.heading = heading;
		this.speed_in_mps = speed_in_mps;		
	}
	
	public double distanceByTime(double deltaTime) {
		return this.speed_in_mps * deltaTime;		
	}
	
	public void updatePosition () {
		
		
		double newLat = pos.getLatitude() + Math.cos(heading) * speed_in_mps;
		double newLon = pos.getLongitude() + Math.sin(heading) * speed_in_mps;
		pos = new Position("SUT position", newLat, newLon);	
	}
	
	
	

}
