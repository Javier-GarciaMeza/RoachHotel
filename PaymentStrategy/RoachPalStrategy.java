/* CECS 277 Term Project
 * RoachPalStrategy Class
 * @author Gavin Tom, Christopher Tobar
 * @version Release Date: 05/07/2020
 */
package roachHotel.PaymentStrategy;

/**
 * Patterns Used: part of Strategy
 * <p> RoachPalStrategy Class to set up a Roach's RoachPal.
 */
public class RoachPalStrategy implements RoachPaymentStrategy {
	
	/**
	 * Name of the roach paying.
	 */
	private String name;
	/**
	 * Email string of the roach paying.
	 */
	private String eMail;
	
	/**
	 * Default constructor for RoachPalStrategy
	 */
	public RoachPalStrategy(){
		throw new IllegalArgumentException("You can't have an empty payment.");
	} //Close default constructor
	
	/**
	 * Constructor for RoachPal
	 * @param name of the roach colony
	 * @param eMail of the roach colony
	 */
	public RoachPalStrategy(String name, String eMail){
		this.name = name;
		this.eMail = eMail;
	} // Close RoachPal strategy.
	
	/**
	 * RoachPalStrategy toString method.
	 * @return information of the RoachPal payment.
	 */
	@Override 
	public String toString(){
		String stringToReturn = "RoachPal (Online Billing) - Name: " + this.name;
		stringToReturn += "\n" + "Email: " + this.eMail;
		return stringToReturn;
	} // Close toString method.

	/**
	 * Implements pay() from RoachPaymentStrategy
	 * @return String of Transaction Log.
	 */
	@Override
	public String pay(double amount) {
		String stringToReturn = this.toString();
		stringToReturn += "\n" + "The customer pays: $" + String.format("%.2f", amount);
		return stringToReturn;
	} // Close pay

} // Close RoachPalStrategy
