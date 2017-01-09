package main;

import java.util.Scanner;

public class MovementTest {

	public static void main(String[] args) {
		
		Scanner reader = new Scanner(System.in);
		
		
		Position startpos = new Position(59.164148, 5.599353, 0);
		StaticTarget tgt1 = new StaticTarget("Target 1", "Radar", "N/A", startpos );
		OwnShip ownShip = new OwnShip("HMS Neversail", 100, 25, startpos, 3.444, 0.00001);
		Sensor sensor1 = new Sensor("Sensor1", "radar", 0.1, 0.1, 0.1 , ownShip, null);
		ownShip.run();
	//	sensor1.run();
		
		while (true) {
			System.out.println("Enter new heading");
			
			double d = reader.nextDouble();
			
		}
		
		
		
		
		

		
	
		
	}
}
