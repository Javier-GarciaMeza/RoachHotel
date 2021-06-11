/* CECS 277 Term Project
 * BasicRoom Class
 * @author Chris Tobar, Donirvin Dickerson, Javier Garcia
 * @version Release Date: 05/07/2020
 */

package roachHotel.Factory;

/**
 * Patterns Used: part of the Factory
 * <p> BasicRoom class, used to contain information about a basic room.
 */
public class BasicRoom extends MotelRoom{
    

    /**
     * Basic Room Constructor
     * Uses Factory Pattern to define the room as basic rating room; 
     */
    public BasicRoom()
    {
    	description = "Basic Room : $5.00 \n" ;
    }//close of BasicRoom Constructor

    /**
     * Overrides the MotelRoom cost function to give a base price.
     * @return the cost for the basic room by itself.
     */
    @Override
    public double cost()
    {
        return 5.00 ;
    }//Close of cost method

}//Close of BasicRoom class
