/* CECS 277 Term Project
 * RoachPaymentStrategy Interface
 * @author Gavin Tom
 * @version Release Date: 05/07/2020
 */
package roachHotel.PaymentStrategy;

/**
 * Patterns Used: part of Strategy
 * <p> RoachPaymentStrategy Interface to set up specifics for each Roach's payment method.
 */
public interface RoachPaymentStrategy {
	
	/**
	 * Method that all Payment Methods that roaches use need to adhere to.
	 * @param amount that roaches need to pay
	 * @return String detailing the transaction that occurred.
	 */
	public String pay(double amount);

} // Close RoachPaymentStrategy
