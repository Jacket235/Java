import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Player {

    public double balance;

    public double betAmount;

    public ArrayList<Card> mainHand = new ArrayList<>();

    public ArrayList<Card> secondHand = new ArrayList<>();

    public int mainHandCount = readHand(mainHand);

    public int secondHandCount = readHand(secondHand);

    public boolean isSplit = false;

    public int mainHandAces;

    public int secondHandAces;

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setBetAmount(double betAmount) {
        this.betAmount = betAmount;
    }

    void drawCard(Deck deck) {
        Card randomCard = deck.getRandomCard();
        boolean isAce = randomCard.rank == 'A';

        if (isSplit) {
            JLabel card = new JLabel(new ImageIcon(new ImageIcon("resources/" + randomCard.rank + "-" + randomCard.suit + ".png").getImage().getScaledInstance(120, 168, Image.SCALE_SMOOTH)));
            Frame.playersSecondHandPanel.add(card);
            secondHand.add(randomCard);
            secondHandCount += Game.instance().deck.readCardValue(randomCard);

            if (isAce) secondHandAces++;

            while (secondHandCount > 21 && secondHandAces > 0) {
                secondHandCount -= 10;
                secondHandAces--;
            }

            if (secondHandAces > 0) {
                Frame.lblSecondHandCount.setText((secondHandCount - 10) + "/" + secondHandCount);
            } else {
                Frame.lblSecondHandCount.setText(String.valueOf(secondHandCount));
            }

        } else {
            JLabel card = new JLabel(new ImageIcon(new ImageIcon("resources/" + randomCard.rank + "-" + randomCard.suit + ".png").getImage().getScaledInstance(120, 168, Image.SCALE_SMOOTH)));
            Frame.playersFirstHandPanel.add(card);
            mainHand.add(randomCard);
            mainHandCount += Game.instance().deck.readCardValue(randomCard);

            if (isAce) mainHandAces++;

            while (mainHandCount > 21 && mainHandAces > 0) {
                mainHandCount -= 10;
                mainHandAces--;
            }

            if (mainHandAces > 0) {
                Frame.lblFirstHandCount.setText((mainHandCount - 10) + "/" + mainHandCount);
            } else {
                Frame.lblFirstHandCount.setText(String.valueOf(mainHandCount));
            }
        }
    }

    int readHand(ArrayList<Card> hand) {
        int totalSum = 0;
        for(Card card : hand) {
            totalSum += Game.instance().deck.readCardValue(card);
        }

        return totalSum;
    }

    void splitCards() {
        isSplit = true;

        // Adds one of the cards to the second hand
        Card secondCard = this.mainHand.get(1);
        this.secondHand.add(secondCard);
        // Updates hand counts
        mainHandCount = Game.instance().deck.readCardValue(secondCard);
        secondHandCount = Game.instance().deck.readCardValue(secondCard);
        // Check for aces
        if (secondCard.rank == 'A') {
            mainHandAces--;
            secondHandAces++;
        }
        // Puts the card in the other hand
        JLabel card = new JLabel(new ImageIcon(new ImageIcon("resources/" + secondCard.rank + "-" + secondCard.suit + ".png").getImage().getScaledInstance(120, 168, Image.SCALE_SMOOTH)));
        Frame.playersSecondHandPanel.add(card);
        // Updates the first hand's count
        Frame.lblFirstHandCount.setText(String.valueOf(Game.instance().deck.readCardValue(secondCard)));
        // Removes the card label moved to the second hand, and the card from the player's first hand arraylist
        Frame.playersFirstHandPanel.remove(1);
        this.mainHand.remove(secondCard);

        // Makes sure the first panel shows the right cards
        Frame.playersFirstHandPanel.revalidate();
        Frame.playersFirstHandPanel.repaint();
        // Updates the second hand's count
        Frame.lblSecondHandCount.setText(String.valueOf(Game.instance().deck.readCardValue(secondCard)));
    }

    public Player(){
        this.balance = 220.0;
    }
}
