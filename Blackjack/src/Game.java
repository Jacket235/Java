
public class Game {

    private static Game instance = new Game();

    Player player;

    Dealer dealer;

    Deck deck;

    public static Game instance() {
        return instance;
    }

    private Game() {
        player = new Player();

        dealer = new Dealer();

        deck = new Deck();
    }

    void startGame() {
        player.drawCard(deck);
        dealer.drawCard(deck, false);
        player.drawCard(deck);
        dealer.drawCard(deck, true);
    }

    void endGame() {
        int playerCount = Game.instance().player.mainHandCount;
        int dealerCount = Integer.parseInt(Frame.lblDealersCardCount.getText());

        // First hand check
        if (playerCount > 21) {
            System.out.println("Dealer wins first hand.");
        }
        else if (dealerCount > 21) {
            System.out.println("Player wins first hand.");
            Game.instance().player.setBalance(Game.instance().player.balance + (Game.instance().player.betAmount * 2));
        }
        else if (playerCount == dealerCount) {
            System.out.println("Player draws.");
            Game.instance().player.setBalance(Game.instance().player.balance + Game.instance().player.betAmount);
        }
        else if (playerCount > dealerCount) {
            System.out.println("Player wins first hand.");
            Game.instance().player.setBalance(Game.instance().player.balance + (Game.instance().player.betAmount * 2));
        }
        else {
            System.out.println("Dealer wins first hand.");
        }

        // Second hand check
        if (!Frame.lblSecondHandCount.getText().isEmpty()) {
            int playerSecondCount = Game.instance().player.secondHandCount;

            if (playerSecondCount > 21) {
                System.out.println("Dealer wins second hand.");
            }
            else if (dealerCount > 21) {
                System.out.println("Player wins second hand.");
                Game.instance().player.setBalance(Game.instance().player.balance + (Game.instance().player.betAmount * 2));
            }
            else if (playerSecondCount == dealerCount) {
                System.out.println("Player draws second hand.");
                Game.instance().player.setBalance(Game.instance().player.balance + Game.instance().player.betAmount);
            }
            else if (playerSecondCount > dealerCount) {
                System.out.println("Player wins second hand.");
                Game.instance().player.setBalance(Game.instance().player.balance + (Game.instance().player.betAmount * 2));
            }
            else {
                System.out.println("Dealer wins second hand.");
            }
        }

        Game.instance().player.mainHandAces = 0;
        Game.instance().player.secondHandAces = 0;
        Game.instance().player.mainHandCount = 0;
        Game.instance().player.secondHandCount = 0;
        Frame.lblBalance.setText("Balance: " + Game.instance().player.balance + " PLN");
    }
}