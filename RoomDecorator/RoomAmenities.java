/* CECS 277 Term Project
 * RoomFactory Class
 * @author Javier Garcia
 * @version Release Date: 05/07/2020
 */
package roachHotel.RoomDecorator;

/**
 * Patterns Used: part of Factory
 * <p> The enumeration of what kind of rooms exist.
 */

public enum RoomAmenities{
  FOOD_BAR("Food Bar"), REFILL_BAR("Refill Bar"), SPRAY_RESISTANT_SHOWER("Spray"), SPA("Spa");
  
	/**
	 * Amentity title.
	 */
	private String TITLE;
	
	/**
	 * Constructor for RoomAmenties
	 * @param amenities description of amenities in question.
	 */
	private RoomAmenities(String amenities) {
		this.TITLE = amenities;
	} //Close constructor
	
	/**
	 * toString Override for Room Amenities
	 */
	@Override
	public String toString() {
		String stringToReturn = this.TITLE + ""; //Return forced deep copy
		return stringToReturn;
	} //Close toString method
	
} //Close RoomType