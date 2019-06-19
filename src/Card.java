/**
 * SYST 17796 Project Winter 2019 Base code.
 * Students can modify and extend to implement their game.
 * Add your name as a modifier and the date!
 */



/**
 * A class to be used as the base Card class for the project. Must be general
 * enough to be instantiated for any Card game. Students wishing to add to the
 * code should remember to add themselves as a modifier.
 * 
 * @author dancye, 2018
 */
public class Card {
	// default modifier for child classes

	/**
	 * Students should implement this method for their specific children classes
	 * 
	 * @return a String representation of a card. Could be an UNO card, a regular
	 *         playing card etc.
	 */

	final static String[] suits = {"Spades", "Hearts", "Diamonds", "Clubs"};
    final static String[] value = {"Ace", "2", "3","4","5","6","7","8", "9","10", "Jack", "Queen", "King"};
	private double cardNum;
    
    public Card(int cardNum) {
		this.cardNum = cardNum;
	}
    
    public String getValue() {
    	return value[(int)(cardNum % 13)];
    }
    
    public String getSuit() {
    	return suits[(int)(cardNum / 13)];
    }

	@Override
	public String toString() {
		return value[(int)(cardNum % 13)] + " of " + suits[(int)(cardNum / 13)];
		
	}

}
