package za.co.sintez.black.jack.response;

import za.co.sintez.black.jack.gamefield.GameField;
import za.co.sintez.black.jack.gamefield.card.Card;
import za.co.sintez.black.jack.gamefield.players.Dealer;
import za.co.sintez.black.jack.gamefield.players.Player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Controller {

    public void bet(int bet, GameField gameField) {
        Player player = gameField.getPlayer();
        Dealer dealer = gameField.getDealer();
        List<Card> cards = gameField.getCards();

        gameField.setCash(player.doBet(bet) + dealer.doBet(bet));

        updateGameField(gameField, player, dealer, cards);
    }

    public void passCard(GameField gameField) {
        Player player = gameField.getPlayer();
        Dealer dealer = gameField.getDealer();
        List<Card> cards = gameField.getCards();

        Collections.shuffle(cards);

        player.getCards().addAll(passCards(cards));
        dealer.getCards().addAll(passCards(cards));
        dealer.getCards().get(0).setVisible(false);

        updateGameField(gameField, player, dealer, cards);
    }

    public void hint(GameField gameField) {
        Player player = gameField.getPlayer();
        Dealer dealer = gameField.getDealer();
        List<Card> cards = gameField.getCards();

        player.getCards().addAll(hintCard(cards));

        updateGameField(gameField, player, dealer, cards);
    }

    private void updateGameField(GameField gameField, Player player, Dealer dealer, List<Card> cards) {
        gameField.setPlayer(player);
        gameField.setDealer(dealer);
        gameField.setCards(cards);
    }

    private List<Card> passCards(List<Card> cards) {
        return getCards(cards, 2);
    }

    private List<Card> hintCard(List<Card> cards) {
        return getCards(cards, 1);
    }

    private List<Card> getCards(List<Card> cards, int count) {
        List<Card> playerCards = new ArrayList<>(cards.subList(cards.size() - count, cards.size()));
        cards.removeAll(playerCards);
        setVisible(playerCards);
        return playerCards;
    }

    private void setVisible(List<Card> playerCards) {
        for (Card card : playerCards) {
            card.setVisible(true);
        }
    }
}