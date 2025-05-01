import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Dealer {

    public Card hiddenCard;

    public ArrayList<Card> hand = new ArrayList<>();

    void dealersTurn() {
        int currentDealerCount = Integer.parseInt(Frame.lblDealersCardCount.getText());
        Frame.lblDealersCardCount.setText(String.valueOf(currentDealerCount + Game.instance().deck.readCardValue(hiddenCard)));

        JLabel secondCard = (JLabel) Frame.dealersCardPanel.getComponent(1);
        secondCard.setIcon(new ImageIcon(new ImageIcon("resources/" + hiddenCard.rank + "-" + hiddenCard.suit + ".png").getImage().getScaledInstance(120, 168, Image.SCALE_SMOOTH)));

        while(Integer.parseInt(Frame.lblDealersCardCount.getText()) < 17) {
            drawCard(Game.instance().deck, false);
        }

        Game.instance().endGame();
    }

    void drawCard(Deck deck, boolean isHiddenCard) {
        Card randomCard = deck.getRandomCard();
        int currentDealerCount = Integer.parseInt(Frame.lblDealersCardCount.getText());
        int cardValue = Game.instance().deck.readCardValue(randomCard);

        if (isHiddenCard) {
            JLabel card = new JLabel(new ImageIcon(new ImageIcon("resources/back.png").getImage().getScaledInstance(120, 168, Image.SCALE_SMOOTH)));
            hiddenCard = randomCard;
            Frame.dealersCardPanel.add(card);
        } else {
            JLabel card = new JLabel(new ImageIcon(new ImageIcon("resources/" + randomCard.rank + "-" + randomCard.suit + ".png").getImage().getScaledInstance(120, 168, Image.SCALE_SMOOTH)));
            Frame.dealersCardPanel.add(card);
            Frame.lblDealersCardCount.setText(String.valueOf(cardValue + currentDealerCount));
        }

        hand.add(randomCard);
    }
}
