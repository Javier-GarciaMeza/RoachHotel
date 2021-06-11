/* CECS 277 Term Project
 * RoachHotel Class
 * @author Gavin Tom, Javier Garacia, Christopher Tobar
 * @version Release Date: 05/07/2020
 */
package roachHotel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import roachHotel.Factory.*;
import roachHotel.RoomDecorator.RoomAmenities;

/**
 * Patterns Used: Singleton, part of Factory and Decorator.
 * <p> RoachHotel class containing the Hotel of the roaches.
 */
public class RoachHotel {
	
	/**
	 * Instance of RoachHotel
	 */
	private volatile static RoachHotel theRoachHotel;

	// TODO: Check where this is used.
	private int capacity;
	/**
	 * Boolean Value to keep track of the vacancy status of the Hotel.
	 * This remains true as 
	 */
	private boolean vacancyStatus;
	
	/**
	 * ArrayList of all available rooms in the Roach Hotel
	 */
	// TODO: Consider this perhaps a Map instead.
	private ArrayList<Integer> availableRooms;
	
	/**
	 * Map that will store all the MotelRooms and their particular rooms.
	 */
	private Map<RoachColony, MotelRoom> roomRoster ;
	
	/**
	 * String name of hotel, set to final.
	 */
	private final String NAME = "Hotel Refuge";
	
	
	/**
	 * Default constructor of the Roach Hotel.
	 */
	private RoachHotel() {
		roomRoster = new HashMap<RoachColony,MotelRoom>();
		this.availableRooms = new ArrayList<Integer>();
		// Creates room numbers 100 to 106 below. I'm aware that maybe this should be something else.
		for(int i = 100; i < 106; i++){
			this.availableRooms.add(i);
		} //Close for loop
		this.capacity = this.availableRooms.size();
		this.checkVacancyStatus();
	} //Close Default Constructor
	
	/**
	 * If there are no Available rooms it will update inner boolean to true, else it leaves it false
	 */
	public void updateVacancyStatus() {
		if(this.availableRooms.isEmpty()) {
			this.vacancyStatus = false;
		} //Close if statement that checks to see if available rooms are empty.
		else {
			// TODO: Note that if there was an observer class, this would be where we notify all subscribers.
			this.vacancyStatus = true;
		} // Close else statement
	} // Close updateVacancyStatus
	
	/**
	 * Creates an instance of RoachHotel if it does not exist. Otherwise, return RoachHotel itself.
	 * @return RoachHotel itself.
	 */
	public static RoachHotel getInstance() {
		if (RoachHotel.theRoachHotel == null) {
			synchronized(RoachHotel.class) { // For dealing with multiple threads as noted in Lab.
				if(RoachHotel.theRoachHotel == null) { //Last verification check.
					RoachHotel.theRoachHotel = new RoachHotel();
				} //if statement containing the creation of the roach hotel class.
			} //Close synchronized
		} // Close if statement checking for empty self.
		
		return RoachHotel.theRoachHotel;
	} //Close getInstance()
	
	// TODO: Will be updated as other classes are placed together.
	/**
	 * toString method for Roach Hotel, prints the current status of the motel.
	 * @return String of the current status of the Hotel itself.
	 */
	@Override
	public String toString() {
		String stringToReturn = this.NAME;
		stringToReturn += " Hotel";
		stringToReturn += "\n" + checkVacancyStatus() + " (Total Rooms: " + this.getCapacity() + ")";
		stringToReturn += "\n" + checkAvailableRooms();
		return stringToReturn;
	} // Close toString method
	
	/**
	 * Return the toString of the ArrayList of available rooms.
	 * <p> Yes, anyone else who is reading this, you'll find that you will be writing this a lot in other functions.
	 * @return string of available rooms
	 */
	public String checkAvailableRooms() {
		return "Available Rooms: " + this.getAvailableRooms().toString();
	} // Close listAvailableRooms
	
	/**
	 * Return the capacity of the 
	 * @return int capacity of the hotel
	 */
	public int getCapacity() {
		int capacityToReturn = this.capacity + 0; // Force deep copy
		return capacityToReturn;
	} // Close getCapacity
	
	/**
	 * Return the available rooms, should create a deep copy of the available room to protect the list
	 * @return (new) ArrayList<Integer> of the available rooms
	 */
	public ArrayList<Integer> getAvailableRooms(){
		ArrayList<Integer> arrayListToReturn = new ArrayList<>();
		for(int eachInt : this.availableRooms) {
			arrayListToReturn.add(eachInt);
		} //Close enhanced loop
		return arrayListToReturn;
	} //Close getAvailableRooms
	
	/**
	 * Return the String of a Vacancy "Sign".
	 * @return String of the Vacancy "Sign".
	 */
	public String checkVacancyStatus() {
		updateVacancyStatus();
		if(this.vacancyStatus) {
			return  "The Hotel currently has empty rooms.";
		} // close if statement
		else {
			return "The Hotel is currently full.";
		} // close else statement
	} // Close checkVacancyStatus
	
	/**
	 * Method to "spray" a colony.
	 * <p>This method by coding assignment has been requested to be in the RoachHotel, even though it likely could be handled by RoachColony.
	 * @param colony
	 */
	public static void spray(RoachColony colony) {
		// Okay so what happens below is that we have to cast the population as a double to multiply it out, and then
		// it is recasted into a double to be stored back in the RoachColony
		MotelRoom roomToCheck = RoachHotel.getInstance().findRoomFromColony(colony);
		int populationAfterReductions = (int)((double)(colony.getPopulation()) * .50); // Initial calculation is to reduce the population by 50%
		if(!roomToCheck.getAmenities().isEmpty()){
			if(roomToCheck.getAmenities().contains(RoomAmenities.SPRAY_RESISTANT_SHOWER)) {
				populationAfterReductions = (int)((double)(colony.getPopulation()) * .75); // If there's a spray resistant shower, it'll get reduced by 25% instead.
			} //Close for loop
		}
		colony.setPopulation(populationAfterReductions);
	} // Close spray
	
	/**
	 * Check in class allows a roach colony to check into a desired room
	 * @param client RoachColony of roaches entering the room
	 * @param RoomType enumeration of the possible rooms that are possibly used
	 * @param ammenities ArrayList string of possible ammenities that the RoachRoom requests.
	 * @return the instance of the room they checked into
	 */
	public MotelRoom checkIn(RoachColony client, RoomType type ,ArrayList<RoomAmenities> ammenities){
		MotelRoom checkedIn = null; //Instance of motel room
		int room = this.availableRooms.remove(0); // remove available room
		//get room with Colony's request
		checkedIn = RoomFactory.getRoom(type,ammenities);
		checkedIn.setRoomNumber(room);
		roomRoster.put(client, checkedIn); // map the room number to the room for colony
		client.setRoomNumber(room);
		return checkedIn;
	} // Close checkIn
	
	/**
	 * Checks out the guest from the room
	 * @param room being checked out
	 * @param int days spent
	 * @return the total cost
	 */
	public double checkOut(MotelRoom room, int days){
		double bill = 0;
		bill = room.cost() * days;
		this.availableRooms.add(room.getRoomNumber());
		findColonyFromRoom(room).setRoomNumber(0);
		room.equals(null);
		return bill;
	} //Close checkOut
	
	/**
	 * Will search for the room the colony is staying in.
	 * @param client the colony 
	 * @return the room the colony is in, returns null if not found
	 */
	public MotelRoom findRoomFromColony(RoachColony client){
		MotelRoom found = null;
		if(this.roomRoster.containsKey(client)){
			found = this.roomRoster.get(client);
		} //Close if statement
		return found;
	} // Close findRoomFromColony
	
	/**
	 * Will find the colony staying in a specific room.
	 * @param room searched for
	 * @return the colony in the room, returns null if not found
	 */
	public RoachColony findColonyFromRoom(MotelRoom room){
		//iterator to help search rooms
		Iterator<RoachColony> listings = roomRoster.keySet().iterator();
		RoachColony key = null; // the colony staying in a room
		MotelRoom checkedIn; // room that is being occupied
		// loop through the keyset of the roomRoster
		while(listings.hasNext()){
			// set current colony equal to key
			key = listings.next();
			// get the room associated with the colony
			checkedIn = roomRoster.get(key);
			// if the associated room matches room looking for return colony
			if(checkedIn.equals(room)){
				return key;
			} // Close if statement
		} // Close While
		//else return null
		return null;
	} // Close findColonyFromRoom
	
} //Close RoachHotel
