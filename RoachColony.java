/* CECS 277 Term Project
 * RoachColony Class
 * @author Gavin Tom, Javier Garcia
 * @version Release Date: 05/07/2020
 */
package roachHotel;

/**
 * Patterns Used: Should be part of Observer, but not in scope.
 * <p> RoachColony class used for storing information of the roach colony.
 */
public class RoachColony {
	
	/**
	 * String name of the Roach Colony
	 */
	private String name;
	/**
	 * int population count of the current amount of roaches
	 */
	private int population;
	/**
	 * double value of the growth rate of the Roaches
	 */
	private double growthRate;
	
	/**
	 * int value of the room the Roaches are staying in.
	 */
	private int roomStay;
	
	// TODO: Determine if we need to throw an exception for this.
	/**
	 * Creates an empty Roach Colony. 
	 */
	public RoachColony() {
		
	} // Close Default Constructor
	
	/**
	 * Roach Colony Constructor
	 * <p> Note that the room number is not set in, RoachHotel.checkIn is supposed to handle that!
	 * @param name String name of Roach Colony
	 * @param population int of the Roach Colony
	 * @param growthRate double of the Roach Colony
	 */
	public RoachColony(String name, int population, double growthRate) {
		setName(name);
		setPopulation(population);
		setGrowthRate(growthRate);
		setRoomNumber(-1); // Alright, I'm aware you aren't supposed to use magic numbers. In this case, we are using this to indicate they aren't in a room.
	} // Close RoachColony Constructor
	
	/**
	 * Setter for Roach Colony name.
	 * @param name String
	 */
	public void setName(String name) {
		this.name = name;
	} // Close setName
	
	/**
	 * Getter for Roach Colony name.
	 * @return String of Roach Colony
	 */
	public String getName() {
		String stringToReturn = this.name + ""; // Hack method to force clone.
		return stringToReturn;
	} // Close getName
	
	/**
	 * Setter for Roach Colony population
	 * @param population int of the Roach Colony
	 */
	public void setPopulation(int population) {
		this.population = population;
	} // Close setPopulation
	
	/**
	 * Getter for Roach Colony population
	 * @return population int of the Roach Colony
	 */
	public int getPopulation() {
		int populationToReturn = this.population + 0; // Hack method to force clone
		return populationToReturn;
	} // Close getPopulation
	
	/**
	 * Setter for growthRate 
	 * @param growthRate double of the Roach Colony
	 */
	public void setGrowthRate(double growthRate) {
		this.growthRate = growthRate;
	} // Close setGrowthRate
	
	/**
	 * Getter for growthRate
	 * @return growthRate double of Roach Colony
	 */
	public double getGrowthRate() {
		double growthRateToReturn = this.growthRate + 0; // Hack method to force clone
		return growthRateToReturn;
	} // Close getGrowthRate
	
	/**
	 * Setter for room number
	 * @param roomNumber int for number Roaches are staying in.
	 */
	public void setRoomNumber(int roomNumber) {
		this.roomStay = roomNumber;
	} // Close setRoomNumber
	
	/**
	 * Getter for Room Number
	 * @return int of room number, returns -1 if unassigned
	 */
	public int getRoomNumber() {
		return this.roomStay;
	} // Close getRoomNumber
	
	/**
	 * Function to simulate a Roach Party.
	 */
	public void party(){
		double popIncrease = this.getPopulation() * this.growthRate;
		this.population =(int) (this.getPopulation() + popIncrease); 
		RoachHotel.spray(this);
	} // Close party()
	
	/**
	 * toString method for RoachColony
	 * @return String of Roach Colony Information
	 */
	@Override
	public String toString() {
		String stringToReturn = getName();
		stringToReturn += " Population: " + getPopulation();
		stringToReturn += " Growth Rate: " + getGrowthRate();
		return stringToReturn;
	} // Close toString
	
	
} // Close RoachColony
