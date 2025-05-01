import java.util.ArrayList;
import java.util.HashMap;

public class Deck {
    public ArrayList<Card> cards = new ArrayList<>();
    void fillDeck(int amountOfDecks){
        char[] suits = {'C', 'D', 'H', 'S'};
        char[] ranks = {'A', 'K', 'Q', 'J', 'X', '9', '8', '7', '6', '5', '4', '3', '2'};

        for(int i = 0; i < amountOfDecks; i++){
            for(int j = 0; j < suits.length; j++){
                for(int k = 0; k < ranks.length; k++){
                    cards.add(new Card(suits[j], ranks[k]));
                }
            }
        }
    }
    Card getRandomCard(){
        if(cards.size() <= 0) {
            System.out.println("Your deck ran out");
            return null;
        }
        Card randomCard = cards.get((int) (Math.random() * cards.size()));
        this.cards.remove(randomCard);

        return randomCard;
    }
    int readCardValue(Card card){
        HashMap<Character, Integer> values = new HashMap<>();
        values.put('A', 11);
        values.put('K', 10);
        values.put('Q', 10);
        values.put('J', 10);
        values.put('X', 10);
        values.put('9', 9);
        values.put('8', 8);
        values.put('7', 7);
        values.put('6', 6);
        values.put('5', 5);
        values.put('4', 4);
        values.put('3', 3);
        values.put('2', 2);

        return values.get(card.rank);
    }
    public Deck(){
        this.fillDeck(8);
    }
}
