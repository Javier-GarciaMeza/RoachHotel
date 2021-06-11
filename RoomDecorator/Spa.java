/* CECS 277 Term Project
 * RoomDecorator Class
 * @author Christopher Tobar, Javier Garcia
 * @version Release Date: 05/07/2020
 */
package roachHotel.RoomDecorator;

import roachHotel.Factory.MotelRoom;

/**
 * Patterns Used: part of Decorator 
 * <p> Spa class, represents part of the Decorator pattern.
 */
public class Spa extends RoomDecorator{
	MotelRoom room;
    /**
     * Spa decorator that will add the price of the Spa to the motel room
     * @param myMotelRoom motel room that is adding a Spa
     */
    public Spa(MotelRoom myMotelRoom)
    {

    	this.room = myMotelRoom;
    }//Close of Spa Constructor

    //TODO come back and make sure description is the desired output
    
    /**
     * Gets the Description of the Spa and adds it to existing description
     * @return description of the Spa
     */
    @Override
    public String getDescription()
    {
        return this.room.getDescription()+" Price of Spa: $" + 20 + "\n";
    }//Close of getDescription method

    /**
     * Gets the cost of the Spa and adds it to existing charges.
     * @return cost of the Spa
     */
    @Override
    public double cost()
    {
        return 20.00 + this.room.cost();
    }//Close of cost method


} // Close Spa
