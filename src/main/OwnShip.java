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
	

	
	public OwnShip (String name, double length, double width, Position pos, double heading, double speed_in_mps){
		this.name = name;
		this.length = length;
		this.width = width;
		this.pos = pos;
		this.heading = heading;
		this.speed_in_mps = speed_in_mps;		
	}
	

}
