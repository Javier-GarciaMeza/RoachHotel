/* CECS 277 Term Project
 * RoomFactory Class
 * @author Donirvin Dickerson, Gavin Tom
 * @version Release Date: 05/07/2020
 */
package roachHotel.Factory;

/**
 * Patterns Used: part of Factory
 * <p> The enumeration of what kind of rooms exist.
 */

public enum RoomType {
  BASIC_ROOM("Basic Room"), DELUXE_ROOM("Deluxe Room"), SUITE("Suite");
  
	private String TITLE;
	
	/**
	 * Constructor for RoomType
	 * @param nameOfRoom 
	 */
	private RoomType(String nameOfRoom) {
		this.TITLE = nameOfRoom;
	} //Close constructor
	
	/**
	 * toString method for RoomType
	 * @return string of the title of the type of room in question
	 */
	@Override
	public String toString() {
		String stringToReturn = this.TITLE + "";
		return stringToReturn;
	}
} //Close RoomType