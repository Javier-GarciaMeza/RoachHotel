/* CECS 277 Term Project
 * DeluxeRoom Class
 * @author Chris Tobar, Donirvin Dickerson, Javier Garcia
 * @version Release Date: 05/07/2020
 */

package roachHotel.Factory;

/**
 * Patterns Used: part of the Factory
 * <p> DeluxeRoom class, used to contain information about a deluxe room.
 */
public class DeluxeRoom extends MotelRoom{
    

    /**
     * Deluxe Room Constructor
     * Uses Factory pattern to designate a given room as Deluxe.
     */
    public DeluxeRoom()
    {
    	description = "Deluxe Room : $15.00 \n";
    }//Close of DeluxeRoom

    /**
     * Overrides the MotelRoom cost function to give a base price.
     * Function returns the base price for a deluxe room.
     * @return price
     */
    @Override
    public double cost()
    {
        return 15.00 ;
    }
}//Close of DeluxeRoom class