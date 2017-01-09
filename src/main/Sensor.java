package main;

import org.apache.commons.math3.linear.*;

public class Sensor implements Runnable{

	private String name;
	private String type; 
	
	private double xParallax;
	private double yParallax;
	private double zParallax;
	private OwnShip ownShip;
	
	private Sector[] blindSectors;
	
	
	
	@Override
	public void run() {
		
		while (true) {
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("running");
			
		
			System.out.println(name + ":" +" lat:" + this.getPosition().getLatitude()+ ", lon:" + this.getPosition().getLongitude());
			
		}

	}
	
	
	public Sensor(String name, String type, double xParallax, double yParallax, double zParallax, OwnShip ownShip,
			Sector[] blindSectors) {
		super();
		this.name = name;
		this.type = type;
		this.xParallax = xParallax;
		this.yParallax = yParallax;
		this.zParallax = zParallax;
		this.ownShip = ownShip;
		this.blindSectors = blindSectors;
	}


	//TODO: finish this function
	public Position getPosition() {
		double d = Math.sqrt(Math.pow(Math.abs(xParallax), 2) + Math.pow(Math.abs(yParallax), 2));
		double sensorAngleFromShipCenter = Math.asin(yParallax/d);
		double tc =ownShip.getHeading() + sensorAngleFromShipCenter;
		
		 
			     
			 

		
		double sensorLatitude =Math.asin(Math.sin(ownShip.getPos().getLatitude())*Math.cos(d)+Math.cos(ownShip.getPos().getLatitude())*Math.sin(d)*Math.cos(tc));
		double dlon = Math.atan2(Math.sin(tc)*Math.sin(d)*Math.cos(ownShip.getPos().getLatitude()),Math.cos(d)-Math.sin(ownShip.getPos().getLatitude())*Math.sin(ownShip.getPos().getLatitude()));
		double sensorLongitude = ( ownShip.getPos().getLongitude()-dlon +Math.PI % 2*Math.PI) -Math.PI ;
		
		
		
		return new Position(sensorLatitude, sensorLongitude, ownShip.getPos().getHeight()+zParallax);
	}
	//TODO: finish this function
	public double getDistance (StaticTarget t){
		return -1;
	}
	//TODO: finish this function
	public double getBearing (StaticTarget t) {
		return -1;
	}
	//TODO: finish this function
	public Position getTargetPosition (StaticTarget t) {
		return null;
	}

}
