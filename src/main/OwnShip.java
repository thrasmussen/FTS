/**
 * 
 */
package main;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @author Thomas Rasmussen
 *
 */
public class OwnShip implements Runnable{
	
	private String name;
	private double length;
	private double width;
	
	private double pitch;
	private double roll;
	
	private Position pos;
	private double heading; //radians
	private double speed_in_mps; //meters per sec
	private Lock lock;
	
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		lock.lock();
		this.name = name;
		lock.unlock();
	}

	public double getPitch() {
		return pitch;
	}

	public void setPitch(double pitch) {
		this.pitch = pitch;
	}

	public double getRoll() {
		return roll;
	}

	public void setRoll(double roll) {
		this.roll = roll;
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
		this.roll = 0;
		this.pitch = 0;
		this.speed_in_mps = speed_in_mps;	
		this.lock = new Lock() {
			
			@Override
			public void unlock() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public boolean tryLock() {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public Condition newCondition() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public void lockInterruptibly() throws InterruptedException {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void lock() {
				// TODO Auto-generated method stub
				
			}
		};
	}
	
	public double distanceByTime(double deltaTime) {
		return this.speed_in_mps * deltaTime;		
	}
	
	public void updatePosition () {
		
		
		double newLat = pos.getLatitude() + Math.cos(heading) * speed_in_mps;
		double newLon = pos.getLongitude() + Math.sin(heading) * speed_in_mps;
		pos = new Position(newLat, newLon, pos.getHeight());	
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		while (true) {
			//lock.lock();
			System.out.println(name + " heading: " + this.getHeadingDegrees());
			System.out.println(name + " pos: " + this.getPos().getLatitude() + "," + this.getPos().getLongitude());
			
			
			
			
			
			
			
			this.setHeading(this.getHeading());
			this.updatePosition();
			//System.out.println("------------------------------------");
			//lock.unlock();
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
	}
}
