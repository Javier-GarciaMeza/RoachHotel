/* CECS 277 Term Project
 * MotelRoom Class
 * @author Gavin Tom, Christopher Tobar, Donirvin Dickerson
 * @version Release Date: 05/07/2020
 */
package roachHotel.Factory;

import java.util.ArrayList;

import roachHotel.RoomDecorator.*;

/**
 * Patterns Used: part of the Factory and Decorator Patterns
 * <p> MotelRoom class, used to contain information about a particular motel room.
 */
public abstract class MotelRoom {

	/**
	 * String of the description of the MotelRoom
	 */
	protected String description;
	/**
	 * boolean value requesting if the room occupants should not be disturbed
	 * <p> True = don't bother / False = go and bother them
	 */
	protected boolean doNotDisturb;
	/**
	 * int value of the roomNumber
	 */
	private int roomNumber;
	/**
	 * ArrayList containing Strings of the various amenities stored
	 */
	private ArrayList<RoomAmenities> amenities ;
	/**
	 * int value of the length that the Room has been used.
	 */
	public int daysStayed;

	public MotelRoom()
	{
		this.doNotDisturb = false;
	}// end of the MotelRoom
	
	/**
	 * Gets the description of the hotel room
	 * @return string that describes the hotel room
	 */
	public String getDescription()
	{
		return this.description;
	}//Close of getDescription method

	/**
	 * Returns all the decorators added to the room
	 * @return decorators added to the room
	 */
	public ArrayList<RoomAmenities> getAmenities()
	{
		return this.amenities;
	}//Close of getAmenities() method

	/**
	 * Inverts the boolean whenever this function is called on
	 */
	public void setDoNotDisturb()
	{
		this.doNotDisturb = !this.doNotDisturb;
	}//End of setDoNotDisturb method

	/**
	 * returns the status of the DoNotDisturb status of the room
	 * @return the status of the doNotDisturb sign
	 */
	public boolean isDoNotDisturb()
	{
		return this.doNotDisturb;
	}//Close of isDoNotDisturb method

	/**
	 * Sets the room number for the motel romo
	 * @param roomNumber room number of the motel room
	 */
	public void setRoomNumber(int roomNumber)
	{
		this.roomNumber = roomNumber;
	}//close of setRoomNumber method

	/**
	 * Gets the room number
	 * @return the roomNumber
	 */
	public int getRoomNumber()
	{
		int roomNumberToReturn = this.roomNumber + 0; //Force deepcopy
		return roomNumberToReturn;
	}//Close of getRoomNumber method

	/**
	 * abstract cost method that will be used in the concrete implementations
	 * @return cost of total decorators and rooms
	 */
	public abstract double cost();
	
	//TODO: Finish this method
	@Override
	public String toString() {
		// Room: Room Number: 101 BasicRoom, Spa, RefillBar, Shower Cost: 100.0
		// Iterate through arraylist of amenities.
		return "Room: Room Number: " + roomNumber + " " + getDescription() + " Cost: " + cost();
	} // Close toString

	/**
	 * Set the amenities.
	 * @param amenities ArrayList of amenities
	 * <p> Take note that the ArrayList of amenities is case sensitive for the particular amenities. 
	 * It is the RoachHotelRunner's responsibility to make sure that the names of the amenities fit the known amenities.
	 * <br> As of this documentation, the known strings (w/o quotes) are: "Spa", "Shower", "Refill Bar", and "Food Bar".
	 */
	public void setAmenities(ArrayList<RoomAmenities> amenities) {
		this.amenities = amenities;
	} // Close setAmenities
	
} //Close MotelRoom
