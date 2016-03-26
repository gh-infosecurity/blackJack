package za.co.sintez.black.jack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.co.sintez.black.jack.dao.CacheDaoI;
import za.co.sintez.black.jack.gamefield.GameField;
import za.co.sintez.black.jack.gamefield.card.Card;
import za.co.sintez.black.jack.gamefield.card.CardBuilder;
import za.co.sintez.black.jack.gamefield.players.Dealer;
import za.co.sintez.black.jack.gamefield.players.Player;
import za.co.sintez.black.jack.request.Request;
import za.co.sintez.black.jack.response.Response;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping(method = POST,
        consumes = APPLICATION_JSON_VALUE,
        produces = APPLICATION_JSON_VALUE)
public class Service {
    public static final String PLAY_FIELD = "play_field";

    private CacheDaoI cacheDao;
    private GameField gameField;

    @Autowired
    public void setCacheDao(CacheDaoI cacheDao) {
        this.cacheDao = cacheDao;
    }

    @Autowired
    public void setGameField(GameField gameField) {
        this.gameField = gameField;
    }

    @PostConstruct
    public void init() {
        cacheDao.saveGameField(gameField, PLAY_FIELD);
    }

    @RequestMapping("/bet")
    Response bet(@RequestBody Request request) {
        int bet = request.getBet();

        GameField gameField = cacheDao.getGameField(PLAY_FIELD);


        Player player = gameField.getPlayer();
        Dealer dealer = gameField.getDealer();

        gameField.setCash(player.doBet(bet) + dealer.doBet(bet));

        gameField.setPlayer(player);
        gameField.setDealer(dealer);


        cacheDao.saveGameField(gameField, PLAY_FIELD);


        Response response = new Response();
        response.setGameField(gameField);
        return response;
    }

    @RequestMapping("/pass/card")
    Response passCard() {
        GameField gameField = cacheDao.getGameField(PLAY_FIELD);

        Player player = gameField.getPlayer();
        Dealer dealer = gameField.getDealer();
        List<Card> cards = gameField.getCards();

        Collections.shuffle(cards);

        player.getCards().addAll(passCards(cards));
        dealer.getCards().addAll(passCards(cards));
        dealer.getCards().get(0).setVisible(false);

        gameField.setPlayer(player);
        gameField.setDealer(dealer);
        gameField.setCards(cards);

        cacheDao.saveGameField(gameField, PLAY_FIELD);

        Response response = new Response();
        response.setGameField(gameField);
        return response;
    }

    @RequestMapping("/hint")
    Response hint() {
        GameField gameField = cacheDao.getGameField(PLAY_FIELD);

        Player player = gameField.getPlayer();
        Dealer dealer = gameField.getDealer();
        List<Card> cards = gameField.getCards();

        player.getCards().addAll(hintCard(cards));

        gameField.setPlayer(player);
        gameField.setDealer(dealer);
        gameField.setCards(cards);

        cacheDao.saveGameField(gameField, PLAY_FIELD);

        Response response = new Response();
        response.setGameField(gameField);
        return response;
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
        return playerCards;
    }
}