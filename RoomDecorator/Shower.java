/* CECS 277 Term Project
 * RoomDecorator Class
 * @author Christopher Tobar, Javier Garcia
 * @version Release Date: 05/07/2020
 */
package roachHotel.RoomDecorator;

import roachHotel.Factory.MotelRoom;

/**
 * Patterns Used: part of Decorator 
 * <p> Shower Class, represents part of the Decorator pattern.
 */
public class Shower extends RoomDecorator{
	// the room that is being decorated with a service.
	MotelRoom room;
    /**
     * Shower decorator that will add the price of a shower to the motel room
     * @param myMotelRoom motel room that is adding a shower
     */
    public Shower(MotelRoom myMotelRoom)
    {	//set this room as the param
    	this.room = myMotelRoom;
    }//Close of Shower Constructor

    //TODO come back and make method gives the desired outcome
    
    /**
     * Adds the description of the shower to the existing description of the room.
     * @return String describing room upgrades
     */
    @Override
    public String getDescription()
    {
        return this.room.getDescription()+ " Shower cost: $" + 25 + "\n";
    }//close of getDescription method

    /**
     * Gets the cost of the shower + cost of the existing charges
     * @return price of the shower
     */
    @Override
    public double cost()
    {
        return 25.00 + this.room.cost() ;
    }//Close of cost method


} // Close Shower
