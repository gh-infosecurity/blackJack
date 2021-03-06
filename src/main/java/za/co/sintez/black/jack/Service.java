package za.co.sintez.black.jack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.co.sintez.black.jack.dao.CacheDaoI;
import za.co.sintez.black.jack.playfield.card.Card;
import za.co.sintez.black.jack.playfield.card.CardDeck;
import za.co.sintez.black.jack.playfield.players.Dealer;
import za.co.sintez.black.jack.playfield.players.Player;
import za.co.sintez.black.jack.playfield.PlayField;
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
    private static final String PLAYER = "Player";
    private static final String DEALER = "Dealer";
    private static final String CARDS = "cards";

    private CacheDaoI cacheDao;
    private PlayField playField;
    private CardDeck cardDeck;

    @Autowired
    public void setCacheDao(CacheDaoI cacheDao) {
        this.cacheDao = cacheDao;
    }

    @Autowired
    public void setPlayField(PlayField playField) {
        this.playField = playField;
    }

    @Autowired
    public void setCardDeck(CardDeck cardDeck) {
        this.cardDeck = cardDeck;
    }

    @PostConstruct
    public void init() {
        storePlayers(playField.getPlayer(), playField.getDealer());
    }

    @RequestMapping("/bet")
    Response bet(@RequestBody Request request) {
        int bet = request.getBet();

        Player player = cacheDao.getPlayer(PLAYER);
        Dealer dealer = cacheDao.getDealer(DEALER);

        playField.setCash(player.doBet(bet) + dealer.doBet(bet));
        playField.setPlayer(player);
        playField.setDealer(dealer);

        storePlayers(player, dealer);

        Response response = new Response();
        response.setPlayField(playField);
        return response;
    }

    @RequestMapping("/pass/card")
    Response passCard() {
        Player player = cacheDao.getPlayer(PLAYER);
        Dealer dealer = cacheDao.getDealer(DEALER);

        List<Card> cards = cardDeck.getCards();
        Collections.shuffle(cards);

        player.getCards().addAll(getCards(cards));
        dealer.getCards().addAll(getCards(cards));
        dealer.getCards().get(0).setVisible(false);

        storePlayers(player, dealer);
        cacheDao.saveCardDeck(cards, CARDS);

        playField.setPlayer(player);
        playField.setDealer(dealer);

        Response response = new Response();
        response.setPlayField(playField);
        return response;
    }

    @RequestMapping("/hint")
    Response hint() {
        Player player = cacheDao.getPlayer(PLAYER);
        Dealer dealer = cacheDao.getDealer(DEALER);

        List<Card> cards = cacheDao.getCardDeck(CARDS);
        player.getCards().addAll(getCard(cards));

        cacheDao.savePlayer(player, PLAYER);
        cacheDao.saveCardDeck(cards, CARDS);

        playField.setPlayer(player);
        playField.setDealer(dealer);

        Response response = new Response();
        response.setPlayField(playField);
        return response;
    }

    private List<Card> getCards(List<Card> cards) {
        List<Card> playerCards = new ArrayList<>(cards.subList(cards.size() - 2, cards.size()));
        cards.removeAll(playerCards);
        return playerCards;
    }

    private List<Card> getCard(List<Card> cards) {
        List<Card> playerCards = new ArrayList<>(cards.subList(cards.size() - 1, cards.size()));
        cards.removeAll(playerCards);
        return playerCards;
    }

    private void storePlayers(Player player, Dealer dealer) {
        cacheDao.savePlayer(player, PLAYER);
        cacheDao.saveDealer(dealer, DEALER);
    }
}