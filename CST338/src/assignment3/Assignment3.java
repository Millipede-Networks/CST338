package assignment3;

import java.util.Random;

import assignment3.Card.Suit;

public class Assignment3
{

   // Andrew made this comment! WOOT!
   
   
   // COMMENTS! WORK DAMN YOU!
   
   public static void main(String[] args) {
		// create 5 instances of Card class

      Card newCard = new Card(); Card newCard2 = new Card(); Card newCard3 = new
			Card(); Card newCard4 = new Card(); Card newCard5 = new Card();

			// Adds values to cards, tests set method newCard.set('K', Suit.DIAMONDS);
			newCard2.set('9', Suit.HEARTS); newCard3.set('Q', Suit.CLUBS);
			newCard4.set('3', Suit.SPADES); newCard5.set('A', Suit.SPADES);

			// Tests equals method newCard2.equals(newCard);

			System.out.println("Card 1: " + newCard.toString());

			System.out.println("Card 2: " + newCard2.toString());

			// Break between Card and Hand testing System.out.println();

			// Creates new hand w/ no cards yet Hand myHand = new Hand(0);

			// Test for takeCard method myHand.takeCard(newCard);
			myHand.takeCard(newCard2); myHand.takeCard(newCard3);
			myHand.takeCard(newCard4); myHand.takeCard(newCard5);

			// Displays current hand System.out.println("My hand: " + myHand.toString());

			// Tests valid Hand's inspectCard method System.out.println("3rd card is: " +
			myHand.inspectCard(2));

			// Tests Hand's resetHand method myHand.resetHand();
			System.out.println("Hand is now empty: " + myHand.toString());

			// Tests error flag setting of Hand's inspectCard method Card noCard =
			myHand.inspectCard(3);

			if (noCard.getErrorFlag()) { System.out.println("No card available."); } else
			{ System.out.println(noCard.toString()); }

			// Resets hand to original status
			System.out.println("Reseting hand to original status...");

			myHand.takeCard(newCard); myHand.takeCard(newCard2);
			myHand.takeCard(newCard3); myHand.takeCard(newCard4);
			myHand.takeCard(newCard5);

			// Displays hand again System.out.println("Hand is once again: " +
			myHand.toString());

			// Break between Hand and Deck testing
			System.out.println();
			// Break is over, back to work
			//
			// Start Deck testing
			//
			int onePack = 1, twoPacks = 2; // Assign numberOfPacks integer variable to 2
			Deck twoPackDeck = new Deck(twoPacks); // Instantiate masterDeck
			// Deal all the cards in a loop until the deck is empty
			// dealt directly to the display/screen. Display each card as it
			// comes off the deck.
			twoPackDeck.init(twoPacks);
			System.out.println("**A deck has been created with two packs of cards.");
			System.out.println("**Dealing unshuffled deck... ");
			for (int i = twoPackDeck.getTopCard(); i >= 0; i--) {
				System.out.println(twoPackDeck.dealCard());
			}

			// Next, reset the deck by initializing it again (to the same two packs).

			twoPackDeck.init(twoPacks);

			// Shuffle the deck this time,

			twoPackDeck.shuffle();

			// and re-deal to the screen in a
			// loop again. Notice that the cards are now coming off in a random order.

			System.out.println("**Dealing shuffled deck... ");
			for (int i = twoPackDeck.getTopCard(); i >= 0; i--) {
				System.out.println(twoPackDeck.dealCard());
			}

			// Repeat this double deal, unshuffled, then shuffled,
			// but this time using a single pack deck
			Deck onePackDeck = new Deck(onePack);
			onePackDeck.init(onePack);
			System.out.println("**A deck has been created with one pack of cards.");
			System.out.println("**Dealing unshuffled deck...");
			for (int i = onePackDeck.getTopCard(); i >= 0; i--) {
				System.out.println(onePackDeck.dealCard());
			}

			onePackDeck.shuffle();
			System.out.println("**The deck has been shuffled.");

			System.out.println("**Dealing shuffled deck... ");
			for (int i = onePackDeck.getTopCard(); i >= 0; i--) {
				System.out.println(onePackDeck.dealCard());
			}

	}

}// end Assignment3 class

class Card
{

   private char value;
   private Suit suit;
   private boolean errorFlag = false;

   enum Suit
   {
      CLUBS, DIAMONDS, HEARTS, SPADES;
   }

   // default constructor initializes values to 'A' and 'SPADES' per instruc.
   public Card()
   {
      value = 'A';
      suit = Suit.SPADES;
   }

   // constructor with all parameters
   public Card(char value, Suit constructSuit)
   {
      set(value, constructSuit);

   }

   Suit testSuit = Suit.CLUBS;

   public void setSuit(Suit newSuit)
   {
      suit = newSuit;
   }

   // createString() takes a char value representing the card value
   // (2, 3, T etc.) and converts it to a string. It does the same with a
   // suit value, and then concatenates them
   // It then returns the concatenated string as cardString
   // *Note, this is equivalent to this method in the assignment page:
   // "string toString() - a stringizer that the client can use prior to
   // displaying the card." Name change to avoid mixing w/ standard toString()
   // feel free to rename back to toString() if needed for your code
   @Override
   public String toString()
   {
      if (errorFlag == true)
      {
         // System.out.println("Invalid Input");
         return "Invalid Input";
      }

      String charToString = new Character(value).toString();
      String enumToString = suit.toString();
      // concatenate
      String cardString = charToString + " of " + enumToString;

      return cardString;
   }// end createString()

   // Accessors and mutators (note, set() is the mutator for value and suit)
   // Accessor for char variable value ('A', '2', etc.)
   public char getvalue()
   {
      return value;
   }

   // Accessor for enum variable suit
   Suit getSuit()
   {
      return suit;
   }

   // Accessor for errorFlag
   boolean getErrorFlag()
   {
      return errorFlag;
   }

   // Mutator for errorFlag
   public void setErrorFlag(boolean trueOrFalse)
   {
      errorFlag = trueOrFalse;
   }

   // isValid() tests for validity for a char value ('A', '2', '3', etc.)
   // if the input is valid, it returns true; if invalid, it returns false
   public boolean isValid(char value, Suit newSuit)
   {
      Character compareChar = new Character(value);

      if (compareChar.equals('A') || compareChar.equals('2')
         || compareChar.equals('3') || compareChar.equals('4')
         || compareChar.equals('5') || compareChar.equals('6')
         || compareChar.equals('7') || compareChar.equals('8')
         || compareChar.equals('9') || compareChar.equals('T')
         || compareChar.equals('J') || compareChar.equals('Q')
         || compareChar.equals('K'))
      {
         return true;
      }
      return false;
   }// end isValid()

   // set() is a mutator for Card class variables value (e.g., '2', 'A')
   // and suit (e.g., 'CLUBS,' 'DIAMONDS')
   // it tests for validity using the method isValid, and sets the values if
   // values are valid, and returns true, while setting errorFlag() to false.
   // If they are not valid, it sets the boolean method errorFlag() to true,
   // and returns false.
   boolean set(char setValue, Suit setSuit)
   {
      if (isValid(setValue, setSuit))
      {
         value = setValue;
         suit = setSuit;
         errorFlag = false;

         return true;
      }

      errorFlag = true;
      return false;
   }

   // boolean equals() compares
   boolean equals(Card card)
   {
      // convert char values to strings to allow use of equals() method
      String charToStringThis = new Character(value).toString();
      String charToStringInput = new Character(card.value).toString();

      if (charToStringThis.equals(charToStringInput) && suit.equals(card.suit)
         && errorFlag == card.errorFlag)
      {
         // included for testing purposes
         System.out.println("The values compared with equals() are equal.");
         System.out.println("The calling object values are: " + suit.toString()
            + " " + charToStringThis);

         System.out.println("The object passed to method values are: "
            + card.suit.toString() + " " + charToStringInput);
         //

         return true;
      }

      // included for testing purposes
      System.out.println("The values compared with equals() are NOT equal.");
      System.out.println("The calling object values are:" + suit.toString()
         + " " + charToStringThis);

      System.out.println("The object passed to method values are:"
         + card.suit.toString() + " " + charToStringInput);

      return false;
   }

}// end Card class

class Hand
{
   private Card[] myCards;
   private int numCards;

   public static final int MAX_CARDS = 50;

   // Default constructor; calls Constructor #1.
   public Hand()
   {
      this(MAX_CARDS);
   }

   // Constructor #1
   public Hand(int numCards)
   {
      this.numCards = numCards;
      myCards = new Card[MAX_CARDS];
   }

   /**
    * Removes all cards from the hand by resetting the number of cards to 0.
    */
   public void resetHand()
   {
      numCards = 0;
   }

   /**
    * If Card parameter is valid, adds the card to the top of the array, then
    * increments the number of cards in the array.
    * 
    * Displays number of cards for testing.
    * 
    * @param card The card to be added to array
    * @return Whether parameter card was added or not
    */
   public boolean takeCard(Card card)
   {
      if (card.getErrorFlag())
      {
         return false;
      } else
      {
         myCards[numCards] = card;
         numCards++;
         return true;
      }
   }

   /**
    * Returns the top card in the array, then decrements the number of cards in
    * the array to "remove" that top card.
    * 
    * Displays value of top card for testing.
    * 
    * @return The top card
    */
   public Card playCard()
   {
      Card playedCard = myCards[numCards - 1];
      numCards--;
      return playedCard;
   }

   /**
    * Converts the contents of the entire hand into a string to be returned.
    * 
    * @return String containing the contents of the entire hand
    */
   @Override
   public String toString()
   {
      String wholeHand = "";

      for (int i = 0; i < numCards; i++)
      {
         wholeHand += myCards[i] + " ";
      }

      return wholeHand;
   }

   /**
    * Accessor for an individual card. Checks if index is valid, then returns
    * either a card with an error flag or the requested card.
    * 
    * @param k Index of card to access
    * @return Card user requested or card w/ error flag
    */
   public Card inspectCard(int k)
   {
      // Sets error flag if index is invalid. Returns card w/ error flag.
      if (k < 0 || k >= numCards)
      {
         Card badCard = new Card();
         badCard.setErrorFlag(true);
         return badCard;
      }
      // Returns copy of card at index k.
      else
      {
         return myCards[k];
      }

   }

   /**
    * Accessor method for numCards.
    * 
    * @return Number of cards in the hand
    */
   public int getNumCards()
   {
      return numCards;
   }

}

class Deck
{ // The Deck class will create two decks of cards.
  // It creates a Master copy deck and a working copy deck.
  // We shuffle the working copy deck after we create it.
  // No cards are lost in the shuffle.

   // allow a maximum of six packs (6�52 cards)
   public static final int MAX_CARDS = 312; // I have been testing 52 cards
   private static Card[] masterPack; // the unchanging pack of card objects
   private Card[] cards; // the pack that we copy from the master
   private int topCard; // Like the name says. It's the last index position.
   public static int numPacks;

   public Deck(int numPacks)
   {

      Deck.numPacks = numPacks;
      allocateMasterPack(); // Generate the MasterPack

   }

   public void init(int numPacks)
   {

      cards = masterPack; // Initialize new cards array of objects
      getTopCard(); // Find out the index of the top card of this new deck

   }

   public void shuffle()
   {
      // This method will use a random number generator to
      // determine an integer in the range of zero to the top card.
      // The topCard variable will be used as a means to track
      // the new position of our card swap location.

      Random randPick = new Random(); // Random number generator
      topCard = cards.length - 1; // Set the top card index position.
      while (topCard != 0)
      { // while the top card is not the last card in deck,
         int randCard = randPick.nextInt(topCard + 1); // Pick a random number
         Card tempCard = cards[topCard]; // Use a temporary card object to
                                         // assist with the swap
         cards[topCard] = cards[randCard]; // After holding the topCard object
                                           // in a temporary card object,
         // We can now copy over the old index position of the top card
         // The the top card object has been copied over with the card object
         // that we got from the randomly generated index position.

         cards[randCard] = tempCard; // The object that used to be in the random
                                     // index location is gone, so this
         // assign the card object we saved in tempCard to the location of the
         // random
         // index.
         // By using the temporary object, we did not destructively copy over
         // any objects
         // that were already in the array of objects.

         topCard = topCard - 1; // The top card is now the one below it.
      }
      // Out of the while loop means that the topCard position had reached 0
      // Thus, we were out of cards to shuffle at that point.
      topCard = cards.length - 1; // Reset the top card index position.

   }

   public Card dealCard()
   { // returns and removes the card in the top
     // occupied position of cards[]. Make sure
     // there are still cards available.
      Card dealtCard = cards[this.topCard];
      this.topCard = topCard - 1; // The top card is now the one below it.
      return dealtCard;
   }

   public int getTopCard()
   { // An accessor for the int, topCard (no mutator)
      this.topCard = cards.length - 1;
      return topCard;
   }

   public Card inspectCard(int k)
   {
      // Sets error flag if index is invalid. Returns card w/ error flag.
      if (k < 0 || k >= numPacks * 52)
      {
         Card badCard = new Card();
         badCard.setErrorFlag(true);
         return badCard;
      }
      // Returns copy of card at index k.
      else
      {
         return cards[k];
      }

   }

   private static void allocateMasterPack()
   { // This creates new master deck
      if (masterPack != null)
      { // "Have I been here before?"
         return; // return if masterPack already exists
      }
      int numCards = 52 * numPacks;
      if (numCards > MAX_CARDS)
      { // return if masterPack has too many cards
         System.exit(1); // Too many cards requested for Deck
      }
      masterPack = new Card[numCards]; // Instantiate a new Card object array
      // loop through the array of objects, assign Suits and Values to each
      // card object. deckSize is used as an index counter and for later
      // when we use it to quickly find four Suit choices and thirteen Value
      // choices.
      for (int deckSize = 0; deckSize < masterPack.length; deckSize++)
      {
         masterPack[deckSize] = new Card();

         // We know that the deck has (52 * numPacks) cards.
         // Fifty two card decks can be divided by 4 and by 13 (Suits and
         // Values).
         // Use the result of the modulus division between deckSize and 4.
         // The result determines the Suit assigned to the indexed object
         // on masterPack.
         Suit suit;
         if (deckSize % 4 == 0)
         {
            suit = Suit.SPADES;
         } else if (deckSize % 4 == 1)
         {
            suit = Suit.DIAMONDS;
         } else if (deckSize % 4 == 2)
         {
            suit = Suit.HEARTS;
         } else
         {
            suit = Suit.CLUBS;
         }

         // Use the result of the modulus division between deckSize and 13.
         // The result is the switchValue which determines the character
         // assigned to card Value, like 'A' for Ace.

         int switchValue = deckSize % 13;
         switch (switchValue)
         {
         case 0:
            masterPack[deckSize].set('A', suit);
            break;
         case 1:
            masterPack[deckSize].set('2', suit);
            break;
         case 2:
            masterPack[deckSize].set('3', suit);
            break;
         case 3:
            masterPack[deckSize].set('4', suit);
            break;
         case 4:
            masterPack[deckSize].set('5', suit);
            break;
         case 5:
            masterPack[deckSize].set('6', suit);
            break;
         case 6:
            masterPack[deckSize].set('7', suit);
            break;
         case 7:
            masterPack[deckSize].set('8', suit);
            break;
         case 8:
            masterPack[deckSize].set('9', suit);
            break;
         case 9:
            masterPack[deckSize].set('T', suit);
            break;
         case 10:
            masterPack[deckSize].set('J', suit);
            break;
         case 11:
            masterPack[deckSize].set('Q', suit);
            break;
         case 12:
            masterPack[deckSize].set('K', suit);
            break;
         }
      }
   }
}
