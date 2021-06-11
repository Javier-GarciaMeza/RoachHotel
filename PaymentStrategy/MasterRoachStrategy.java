/* CECS 277 Term Project
 * MasterRoachStrategy class
 * @author Gavin Tom, Christopher Tobar
 * @version Release Date: 05/07/2020
 */
package roachHotel.PaymentStrategy;

/**
 * Patterns Used: part of Strategy
 * <p> MasterRoachStrategy Class to set up a Roach's MasterRoach.
 */
public class MasterRoachStrategy implements RoachPaymentStrategy {
	
	/**
	 * String Name of roach's payment.
	 */
	private String name;
	/**
	 * TODO: Determine if we need to have a function to obscure everything but the 4 last digits.
	 */
	private String cardNumber;
	/**
	 * Security code of the card in question.
	 */
	private String securityCode; // Why is this stored? You only need it while processing. RIP the roach's card. They are going to need new cards after this.
	/**
	 * Expiration date of the roach's card.
	 */
	private String expirationDate;
	
	/**
	 * Default constructor for MasterRoachStrategy
	 */
	public MasterRoachStrategy(){
		throw new IllegalArgumentException("You can't have an empty payment.");
	} //Close default constructor
	
	/**
	 * Constructor for MasterRoachStrategy
	 * @param name  of roach paying.
	 * @param cardNumber of roach paying
	 * @param securityCode of roach's card
	 * @param expirationDate of roach's card
	 */
	public MasterRoachStrategy(String name, String cardNumber, String securityCode, String expirationDate){
		this.name = name;
		this.cardNumber = cardNumber;
		this.securityCode = securityCode;
		this.expirationDate = expirationDate;
	} // Close RoachPal strategy.
	
	/**
	 * MasterRoachStrategy toString method.
	 * @return String information of the MasterRoach payment.
	 */
	@Override 
	public String toString(){
		String stringToReturn = "MasterRoach (Debit/Credit Card) - Name: " + this.name;
		stringToReturn += "\n" + "Card Number: " + this.cardNumber;
		stringToReturn += "\n" + "Security Code: " + this.securityCode;
		stringToReturn += "\n" + "Card will expire: " + this.expirationDate;
		return stringToReturn;
	} // Close toString method.

	/**
	 * Implements pay() from MasterRoachStrategy
	 * @return String of Transaction Log.
	 */
	@Override
	public String pay(double amount) {
		String stringToReturn = this.toString();
		stringToReturn += "\n" + "The customer pays: $" + String.format("%.2f", amount);
		return stringToReturn;
	} // Close pay
	
} // Close MasterRoachStrategy
