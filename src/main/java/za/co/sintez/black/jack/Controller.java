package za.co.sintez.black.jack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.co.sintez.black.jack.gamefield.GameField;
import za.co.sintez.black.jack.gamefield.card.Card;
import za.co.sintez.black.jack.gamefield.card.CardBuilder;
import za.co.sintez.black.jack.gamefield.players.Dealer;
import za.co.sintez.black.jack.gamefield.players.Player;

import java.util.ArrayList;
import java.util.List;

@Component
public class Controller {
    private static final int FIRST = 0;
    private static final int ZERO = 0;
    private ScoreChecker scoreChecker;
    private CardBuilder cardBuilder;

    @Autowired
    public void setScoreChecker(ScoreChecker scoreChecker) {
        this.scoreChecker = scoreChecker;
    }

    @Autowired
    public void setCardBuilder(CardBuilder cardBuilder) {
        this.cardBuilder = cardBuilder;
    }

    public void bet(int bet, GameField gameField) {
        Player player = gameField.getPlayer();
        Dealer dealer = gameField.getDealer();
        List<Card> cards = cardBuilder.build();

        if (gameField.getCash() == ZERO) {
            gameField.clearPlayers(player.getCards(), dealer.getCards());
            gameField.setCash(player.doBet(bet) + dealer.doBet(bet));
        }

        updateGameField(gameField, player, dealer, cards);
    }

    public void passCard(GameField gameField) {
        Player player = gameField.getPlayer();
        Dealer dealer = gameField.getDealer();
        List<Card> cards = gameField.getCards();

        List<Card> playerCards = passCards(cards);
        player.getCards().addAll(playerCards);
        dealer.getCards().addAll(passCards(cards));

        if (scoreChecker.isBlackJack(playerCards)) {
            player.win(gameField.getCash());
            dealer.getCards().get(FIRST).setVisible(true);
            gameField.clearCash();
        }

        dealer.getCards().get(FIRST).setVisible(false);
        updateGameField(gameField, player, dealer, cards);
    }

    public void hint(GameField gameField) {
        Player player = gameField.getPlayer();
        Dealer dealer = gameField.getDealer();
        List<Card> cards = gameField.getCards();

        player.getCards().addAll(hintCard(cards));

        if (scoreChecker.isBust(player.getCards())) {
            dealer.win(gameField.getCash());
            gameField.clearCash();
            dealer.getCards().get(FIRST).setVisible(true);
        } else if (scoreChecker.isTwentyOne(player.getCards())) {
            updateGameField(gameField, player, dealer, cards);
            stand(gameField);
        }

        updateGameField(gameField, player, dealer, cards);
    }

    public void stand(GameField gameField) {
        Player player = gameField.getPlayer();
        Dealer dealer = gameField.getDealer();

        int playerScore = scoreChecker.getScore(player.getCards());
        int dealerScore = scoreChecker.getScore(dealer.getCards());

        if (playerScore > dealerScore) {
            player.win(gameField.getCash());
            gameField.clearCash();
        } else {
            dealer.win(gameField.getCash());
            gameField.clearCash();
        }
        dealer.getCards().get(FIRST).setVisible(true);
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