/* CECS 277 Term Project
 * RoomDecorator Class
 * @author Chris Tobar
 * @version Release Date: 05/07/2020
 */
package roachHotel.RoomDecorator;
import roachHotel.Factory.MotelRoom;

/**
 * Patterns Used: part of Decorator 
 * <p> Abstract class that templates all decorators.
 */
public abstract class RoomDecorator extends MotelRoom{

	//Hotel room that is going to be decorated
	private MotelRoom myMotelRoom;
	
	/*
	 * Constructor for room decorator
	 */
	public RoomDecorator()
	{
		
	}
	
	/**
	 * Abstract method that will get the descriptions of the decorators
	 * @return the string describing the current decorator
	 */
	public abstract String getDescription();
	
} //Close RoomDecorator
