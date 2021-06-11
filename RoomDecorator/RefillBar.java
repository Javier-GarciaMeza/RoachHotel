/* CECS 277 Term Project
 * RoomDecorator Class
 * @author Christopher Tobar, Javier Garcia
 * @version Release Date: 05/07/2020
 */
package roachHotel.RoomDecorator;

import roachHotel.Factory.MotelRoom;

/**
 * Patterns Used: part of Decorator 
 * <p> RefillBar class, represents part of the Decorator pattern.
 */
public class RefillBar extends RoomDecorator{
	// the room that will be decorated 
	MotelRoom room;
    /**
     * RefillBar decorator that will add the price of a RefillBar to the motel room
     * @param myMotelRoom motel room that is adding a RefillBar
     */
    public RefillBar(MotelRoom myMotelRoom)
    {
        this.room = myMotelRoom;
    }//close of Constructor

   

    /**
     * Gets the description of the RefillBar and adds it to existing decription
     * @return the description of the Refill Bar
     */
    @Override
    public String getDescription()
    {
        return this.room.getDescription() + " Refill Bar cost: $" + 5 + "\n";
    }//Close of getDescription method

    
    /**
     * Gets the cost of the Refill Bar and adds it to existing charges.
     * @return the cost of the refill bar
     */
    @Override
    public double cost()
    {
        return 5.00 + this.room.cost();
    }//Close of cost method

} //Close RefillBar
