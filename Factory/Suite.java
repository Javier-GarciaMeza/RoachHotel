/* CECS 277 Term Project
 * Suite Class
 * @author Christopher Tobar, Donirvin Dickerson, Javier Garcia
 * @version Release Date: 05/07/2020
 */

package roachHotel.Factory;

/**
 * Patterns Used: part of the Factory
 * <p> Suite class, used to contain information about a suite.
 */
public class Suite extends MotelRoom{

    /**
     * Suite Constructor
     * Uses Factory Pattern to designate a given room as a Suite.
     */
    public Suite()
    {
    	description = "Suite : $30.00 \n";
    }//Close of Suite Constructor

    /**
     * returns the cost of a suite and other decorators
     * @return the cost of the suite
     */
    @Override
    public double cost()
    {
        return 30.00;
    }//Close of cost method

}//Close of Suite class