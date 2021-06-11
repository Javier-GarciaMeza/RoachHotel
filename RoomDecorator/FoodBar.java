/* CECS 277 Term Project
 * RoomDecorator Class
 * @author Christopher Tobar, Javier Garcia
 * @version Release Date: 05/07/2020
 */
package roachHotel.RoomDecorator;

import roachHotel.Factory.MotelRoom;

/**
 * Patterns Used: part of Decorator 
 * <p> FoodBar class, represents part of the Decorator pattern.
 */
public class FoodBar extends RoomDecorator{
	// the room that will be decorated
	MotelRoom room;
    /**
     * FoodBar decorator that will add the price of a foodbar to the motel room
     * @param myMotelRoom motel room that is adding a food Bar
     */
    public FoodBar(MotelRoom myMotelRoom)
    {
    	this.room = myMotelRoom;
    }//End of constructor

    /**
     * Returns the cost of the FoodBar when called
     * @return cose of the foodBar
     */
    @Override
    public double cost()
    {
        return 10.00 + this.room.cost();
    }

    //TODO come back and make sure that the getDescription returns the desired output
    
    /**
     * gets the description of the Food bar
     * @return the string describing the price of the food bar
     */
    @Override
    public String getDescription()
    {
        return this.room.getDescription() + " Food bar cost: $" + 10 +"\n";
    }//Close of getDescription

} //Close FoodBar
