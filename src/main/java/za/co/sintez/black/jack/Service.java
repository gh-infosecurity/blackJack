package za.co.sintez.black.jack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.co.sintez.black.jack.dao.CacheDaoI;
import za.co.sintez.black.jack.playfield.card.Card;
import za.co.sintez.black.jack.playfield.card.CardDeck;
import za.co.sintez.black.jack.playfield.card.CardFactory;
import za.co.sintez.black.jack.playfield.players.Dealer;
import za.co.sintez.black.jack.playfield.players.Player;
import za.co.sintez.black.jack.playfield.Playfield;
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

    private CacheDaoI cacheDao;
    private Playfield playfield;
    private CardFactory cardFactory;

    @Autowired
    public void setCacheDao(CacheDaoI cacheDao) {
        this.cacheDao = cacheDao;
    }

    @Autowired
    public void setPlayfield(Playfield playfield) {
        this.playfield = playfield;
    }

    @Autowired
    public void setCardFactory(CardFactory cardFactory) {
        this.cardFactory = cardFactory;
    }

    @PostConstruct
    public void init() {
        storePlayers(playfield.getPlayer(), playfield.getDealer());
    }

    @RequestMapping("/bet")
    Response bet(@RequestBody Request request) {
        int bet = request.getBet();

        Player player = cacheDao.findPlayer(PLAYER);
        Dealer dealer = cacheDao.findDealer(DEALER);

        playfield.setCash(player.doBet(bet) + dealer.doBet(bet));
        playfield.setPlayer(player);
        playfield.setDealer(dealer);

        storePlayers(player, dealer);

        Response response = new Response();
        response.setPlayfield(playfield);
        return response;
    }

    @RequestMapping("/pass/card")
    Response passCard() {
        Player player = cacheDao.findPlayer(PLAYER);
        Dealer dealer = cacheDao.findDealer(DEALER);

        CardDeck cardDeck = cardFactory.createCardDeck();
        List<Card> cards = cardDeck.getCardDeck();
        Collections.shuffle(cards);
        List<Card> playerCards = new ArrayList<>(cards.subList(cards.size() - 2, cards.size()));
        cards.removeAll(playerCards);
        List<Card> dealerCards = new ArrayList<>(cards.subList(cards.size() - 2, cards.size()));
        cards.removeAll(dealerCards);

        player.getCards().addAll(playerCards);
        dealer.getCards().addAll(dealerCards);
        dealer.getCards().get(1).setVisible(false);

        playfield.setPlayer(player);
        playfield.setDealer(dealer);

        Response response = new Response();
        response.setPlayfield(playfield);
        return response;
    }

    private void storePlayers(Player player, Dealer dealer) {
        cacheDao.savePlayer(player, PLAYER);
        cacheDao.saveDealer(dealer, DEALER);
    }
}