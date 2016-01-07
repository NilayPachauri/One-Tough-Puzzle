/**
 * Write a description of class Piece here.
 *
 * @Ryan Chandra
 * @version (a version number or a date)
 */
public class Piece {
	
	// H = 1; D = 2; C = 3; S = 4;
	// H in = -1; D in = -2; C in = -3; S in = -4;
	// ORIENTATION: 0 is starting, 1 is 90 degrees, 2 is 180 degrees, 3 is 270
	// degrees (flipped clockwise)
	private int[]	sides;			// array with the sides (as ints)
	private int		orientation;	// orientation as an int
	private String	name;			// ID
					
	public Piece(int[] newSides, String newName)
	// constructor
	{
		sides = newSides;
		orientation = 0;
		name = newName;
	}
	
	
	/**
	 * @return the sides
	 */
	public int[] getSides() {
		return sides;
	}

	
	/**
	 * @param sides the sides to set
	 */
	public void setSides(int[] sides) {
		this.sides = sides;
	}

	
	/**
	 * @return the orientation
	 */
	public int getOrientation() {
		return orientation;
	}

	
	/**
	 * @param orientation the orientation to set
	 */
	public void setOrientation(int orientation) {
		this.orientation = orientation % 4;
	}

	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	public void turnRight()	{
		orientation = ++orientation % 4;
		int[] newSides = new int[4];
		
		for (int i = 0; i < sides.length; i++)	{
			newSides[++i % 4] = sides[i];
		}
		
		sides = newSides;
	}
	
	public void turnLeft()	{
		orientation = ++orientation % 4;
		int[] newSides = new int[4];
		
		for (int i = 0; i < sides.length; i++)	{
			newSides[i] = sides[++i % 4];
		}
		
		sides = newSides;
	}
	
	public void turnBack()	{
		orientation = (orientation + 2) % 4;
		int[] newSides = new int[4];
		
		for (int i = 0; i < sides.length; i++)	{
			newSides[i] = sides[(i + 2) % 4];
		}
		
		sides = newSides;
	}
	
}