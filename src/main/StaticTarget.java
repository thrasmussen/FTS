/**
 * 
 */
package main;

/**
 * @author Thomas Rasmussen
 *
 */
public class StaticTarget {
	
	private String name; 
	private String type;
	private String description;
	private Position pos;
	
	public StaticTarget(String name, String type, String description, Position pos) {
		this.name = name;
		this.type = type;
		this.description = description;
		this.pos = pos;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Position getPos() {
		return pos;
	}

	public void setPos(Position pos) {
		this.pos = pos;
	}
	
	
	

}
