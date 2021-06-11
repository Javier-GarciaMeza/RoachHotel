/* CECS 277 Term Project
 * RoomFactory Class
 * @author Donirvin Dickerson, Javier Garcia
 * @version Release Date: 05/07/2020
 */
package roachHotel.Factory;

import java.util.ArrayList;
import roachHotel.RoomDecorator.*;

/**
 * Patterns Used: part of Factory
 * <p> Creation of the basis of the MotelFactory that will be used for production.
 */
public class RoomFactory {
	
	/**
	 * Factory pattern that constructs the overall MotelRoom.
	 * @param Roomtype room being constructed
	 * @param amenities the amenities constructed
	 * @return Constructed MotelRoom
	 */
	public static MotelRoom getRoom(RoomType type, ArrayList <RoomAmenities> amenities) {
		MotelRoom result;

		// Factory constructs the initial room
		switch (type) {
			case DELUXE_ROOM:
				result = new DeluxeRoom();
				break;
			case BASIC_ROOM:
				result = new BasicRoom();
				break;
			case SUITE:
				result = new Suite();
				break;
			default:
				result = null;
		} //Close switch cases
		
		// Add the desired decorations to the room
		result = decorateRoom(result, amenities);
		result.setAmenities(amenities);
		return result;
	} // close Motel GetRoom
	
	/**
	 * Dedicated Decorator for Room
	 * @param room being decorated
	 * @param amenities ArrayList of amenities to add
	 * @return the decorated room
	 */
	public static MotelRoom decorateRoom(MotelRoom room, ArrayList<RoomAmenities> amenities) {
		if(room != null ){
			if(amenities.contains(RoomAmenities.FOOD_BAR)){
				room = new FoodBar(room);
			} // Close FoodBar case
			if(amenities.contains(RoomAmenities.REFILL_BAR)){
				room = new RefillBar(room);
			} // Close RefillBar case
			if(amenities.contains(RoomAmenities.SPRAY_RESISTANT_SHOWER)){
				room = new Shower(room);
			} // Close Spray Case
			if(amenities.contains(RoomAmenities.SPA)){
				room = new Spa(room);
			} //Close Spa case
		} // Close Decorator checker.
		return room;
	} // Close MotelRoom

} // Close RoomFactory
