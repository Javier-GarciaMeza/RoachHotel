/* CECS 277 Term Project
 * RoachHotelRunner Class
 * @authors Gavin Tom, Christopher Tobar, Javier Garcia, Donirvin Dickerson
 * @version Release Date: 05/07/2020
 */
package roachHotel;

// Import the various separated sections of the term project.
import roachHotel.Factory.MotelRoom;
import roachHotel.Factory.RoomType;
import roachHotel.RoomDecorator.*;
import roachHotel.PaymentStrategy.*;
import java.util.ArrayList;

/**
 * Main class for the entire project.
 *
 */
public class RoachHotelRunner {

	public static void main(String[] args) {

		//This creates one and only one instance of the roach hotel
		RoachHotel myHotel = RoachHotel.getInstance();

		//Creation of the first roach family that is possibly going to move in
		RoachColony adamFamily = new RoachColony("Addams Family", 100, 0.30);
		RoachColony tobarFamily = new RoachColony("Tobar Family",300, .40);
		RoachColony tomFamily = new RoachColony("Tom Family",200,.10);
		RoachColony kingFamily = new RoachColony("King Family",115,.50);
		RoachColony candyFamily = new RoachColony("Candy Family",200, .25);
		RoachColony smithFamily =  new RoachColony("Smith Family",150, 0.75);

		//TODO figure out how to create the ammenities string and how to implement it
		//Creation of ArrayList to have Amenities for different rooms
		ArrayList<RoomAmenities> ammenities = new ArrayList<>();
		
		//Introduction of the hotel to the main
		System.out.println(myHotel);
		System.out.println();

		
		
		//Having the Families check into their respective rooms
		System.out.println("The rooms are being set up and checked in with the with the following: ");
		int [] adder = new int[2];
		adder[0] = 0;
		adder[1] = 1;
		ammenities = hotelAddAmenities(adder);
		MotelRoom room100 = hotelCheckIn(myHotel,tobarFamily, ammenities,0);
		System.out.println(room100);
		
		adder = new int[2];
		adder[0] = 1; 
		adder[1] = 2;
		ammenities = hotelAddAmenities(adder);
		MotelRoom room101 = hotelCheckIn(myHotel,adamFamily, ammenities,1);
		System.out.println(room101);
		
		adder = new int[4];
		adder[0] = 0;
		adder[1] = 1;
		adder[2] = 2;
		adder[3] = 3;
		ammenities = hotelAddAmenities(adder);
		MotelRoom room102 = hotelCheckIn(myHotel,tomFamily,  ammenities,2);
		System.out.println(room102);
		
		adder = new int [3];
		adder[0] = 0;
		adder[1] = 2;
		adder[2] = 3;
		ammenities = hotelAddAmenities(adder);
		MotelRoom room103 = hotelCheckIn(myHotel,kingFamily,  ammenities,0);
		System.out.println(room103);
		
		MotelRoom room104 = hotelCheckIn(myHotel,candyFamily,  ammenities,1);
		System.out.println(room104);
		MotelRoom room105 = hotelCheckIn(myHotel,smithFamily,  ammenities,2);
		System.out.println(room105);
		
		//Show the Hotel when it is full.
		System.out.println("The Hotel is now full:");
		System.out.println(myHotel);
		
		//try to check in while all rooms are full
		RoachColony orangeFamily =  new RoachColony("Orange Family",150, 0.75);
		hotelCheckIn(myHotel,orangeFamily,  ammenities,0);	
		
		//Trigger Roach parties

		hotelTriggerRoachParty(tobarFamily, myHotel);
		hotelTriggerRoachParty(adamFamily, myHotel);
		hotelTriggerRoachParty(candyFamily, myHotel);
		
		// Reveal the strategy method as each Roach checks out.
		RoachPalStrategy tobarCheckOut = new RoachPalStrategy("Tobar Family","tobar@gmail.com");
		hotelTransactionLog(tobarFamily, 4, tobarCheckOut, myHotel);
		
		RoachPalStrategy AdamCheckOut = new RoachPalStrategy("Adam Family","adam@gmail.com");
		hotelTransactionLog(adamFamily, 1, AdamCheckOut, myHotel);
		
		MasterRoachStrategy tomCheckOut = new MasterRoachStrategy("Tom Family", "0010100000","123","01/21");
		hotelTransactionLog(tomFamily, 4, tomCheckOut, myHotel);
		
		MasterRoachStrategy kingCheckOut = new MasterRoachStrategy("King Family", "0234897230","212","12/25");
		hotelTransactionLog(kingFamily, 2, kingCheckOut, myHotel);
		
		RoachPalStrategy candyCheckOut = new RoachPalStrategy("Candy Family", "candy@gmail.com");
		hotelTransactionLog(candyFamily, 3, candyCheckOut, myHotel);
		
		//Now show the vacant Hotel.
		System.out.println("\n" + "The Hotel now looks like this:");
		System.out.println(myHotel);

		//Completion statement
		System.out.println("Completed Satisfactorily.");

	}//Close of main runner
	
	// Runner Method Assistances (Used for assisting in creating particular modes.)
	
	/**
	 * Helper method to check in particular roaches into a hotel
	 * @param hotel 
	 * @param family of roaches checking in
	 * @param amenities list inside the room
	 * @param roomMode The type of room that they are getting: 0 = basic, 1 = deluxe, 2 = suite
	 * @return room that has been checked in by the roaches.
	 */
	public static MotelRoom hotelCheckIn(RoachHotel hotel, RoachColony family, ArrayList<RoomAmenities> amenities, int roomMode) {
		System.out.println("The " + family.getName() + " are being checked in.");
		System.out.println("Family Info: " + family.toString());
		if(hotel.checkVacancyStatus().equalsIgnoreCase("The Hotel currently has empty rooms.")){
			if(roomMode == 0) {
				MotelRoom room = hotel.checkIn(family, RoomType.BASIC_ROOM, amenities);
				return room;
			} // Close if
			else if(roomMode == 1) {
				MotelRoom room = hotel.checkIn(family, RoomType.DELUXE_ROOM, amenities);
				return room;
			} // Close if
			else if(roomMode == 2) {
				MotelRoom room = hotel.checkIn(family, RoomType.SUITE, amenities);
				return room;
			} // Close if
			else {
				throw new IllegalArgumentException("Invalid roomMode input.");
			} // Close else
		}
		return null;
	} //Close hotelCheckIn
	
	/**
	 * Helper method that returns a proper list of amenities to add
	 * The program is given a list of ints, of which each int corresponds to a amenity to add.
	 * They are as follows:
	 * <p>0 = Food Bar
	 * <p>1 = Refill Bar
	 * <p>2 = Spray
	 * <p>3 = Spa
	 * @param int[] list of amenities
	 * @return the properly formated amenities ArrayList
	 */
	public static ArrayList<RoomAmenities> hotelAddAmenities(int[] list){
		ArrayList<RoomAmenities> arrayListToReturn = new ArrayList<>();
		for(int eachInt : list) {
			if(eachInt == 0) {
				arrayListToReturn.add(RoomAmenities.FOOD_BAR);
			} // Close if
			else if(eachInt == 1) {
				arrayListToReturn.add(RoomAmenities.REFILL_BAR);
			} // Close if
			else if(eachInt == 2) {
				arrayListToReturn.add(RoomAmenities.SPRAY_RESISTANT_SHOWER);
			} // Close if
			else if(eachInt == 3) {
				arrayListToReturn.add(RoomAmenities.SPA);
			} // Close if
		} // Close for loop
		return arrayListToReturn;
	} //Close hotelAddAmenitties
	
	/**
	 * Helper method that properly documents a roach party.
	 * @param roach team that is partying.
	 * @parma hotel of the roaches are partying in
	 */
	public static void hotelTriggerRoachParty(RoachColony roach, RoachHotel hotel) {
		System.out.println("The "+ roach.getName() + " is now partying!");
		System.out.println("The room has the following amentities:");
		System.out.println(hotel.findRoomFromColony(roach).getAmenities());
		System.out.println("Before Party:");
		System.out.println(roach.toString());
		roach.party();
		System.out.println("After Party:");
		System.out.println(roach.toString());
	} // Close hotelTriggerRoachParty
	
	/**
	 * Helper method that displays 
	 * @param roachesLeaving
	 * @param daysSpent
	 * @param payment
	 * @param hotel
	 */
	public static void hotelTransactionLog(RoachColony roachesLeaving, int daysSpent, RoachPaymentStrategy payment, RoachHotel hotel) {
		System.out.println("\nThe " + roachesLeaving.getName() + " are leaving.");
		double costOfDepature = hotelCheckOut(roachesLeaving, daysSpent, hotel);
		System.out.println(payment.pay(costOfDepature));
		System.out.println("The hotel now looks like: ");
		System.out.println(hotel);
	} // Close hotelTransactionLog
	
	// I'm painfully aware this is technically both a setter and getter. 
	/**
	 * Helper method for checking out the Roaches
	 * @param roachesLeaving
	 * @param daysSpent value of how long the roahces stayed
	 * @param hotel of the roahces leaving
	 * @return the final bill after checkout
	 */
	public static double hotelCheckOut(RoachColony roachesLeaving, int daysSpent, RoachHotel hotel) {
		double doubleToReturn = hotel.checkOut(hotel.findRoomFromColony(roachesLeaving), daysSpent);
		return doubleToReturn;
	} // Close hotelCheckOut

}//Close of RoachHotelRunner
