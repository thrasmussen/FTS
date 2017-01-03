package main;

public class MovementTest {

	public static void main(String[] args) {
		
		
		Position pos = new Position("SUT position", 59.164148, 5.599353);
		Position tgtpos = new Position("TGT1 position", 59.164148, 5.599353);
		OwnShip SUT = new OwnShip("HMS Neversail", 100, 25, pos, (3/4)* Math.PI, 0.001);
		
		StaticTarget tgt1 = new StaticTarget("Target 1", "Radar", "N/A", tgtpos );
	
		
		System.out.println("HEADING: " + SUT.getHeadingDegrees());
		
		for (int i = 0; i < 1000; i++) {
			System.out.println("SUT pos: " + SUT.getPos().getLatitude() + "," + SUT.getPos().getLongitude());
			
			System.out.println("angle: " + Math.toDegrees(GeoCalculations.geoAngleBetweenLocations(SUT.getPos(), tgt1.getPos())));
			System.out.println("distance: " + GeoCalculations.geoDistanceInMetersBetweenLocation(SUT.getPos(), tgt1.getPos()));
			
			
			
			
			
			//SUT.setHeading(SUT.getHeading()+ 0.01);
			SUT.updatePosition();
		}
		
		
	}
}
