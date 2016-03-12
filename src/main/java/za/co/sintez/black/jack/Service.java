package za.co.sintez.black.jack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.co.sintez.black.jack.card.CardFactory;
import za.co.sintez.black.jack.dao.CacheDaoI;
import za.co.sintez.black.jack.players.Dealer;
import za.co.sintez.black.jack.players.Player;
import za.co.sintez.black.jack.playfield.Playfield;
import za.co.sintez.black.jack.request.Request;
import za.co.sintez.black.jack.response.Response;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping(method = POST,
        consumes = APPLICATION_JSON_VALUE,
        produces = APPLICATION_JSON_VALUE)
public class Service {
    public static final String PLAYER = "Player";

    private CacheDaoI cacheDao;
    private CardFactory cardFactory;

    @Autowired
    public void setCacheDao(CacheDaoI cacheDao) {
        this.cacheDao = cacheDao;
    }

    @Autowired
    public void setCardFactory(CardFactory cardFactory) {
        this.cardFactory = cardFactory;
    }

    @RequestMapping("/bet")
    Response bet(@RequestBody Request request) {
        Playfield playfield = new Playfield();
        playfield.setPlayer(new Player());
        playfield.setDealer(new Dealer());
        playfield.setCardDeck(cardFactory.createCardDeck());
        playfield.setCash(0);

        int bet = request.getBet();
        int playerBet = playfield.getPlayer().getCash() - bet;
        int dealerBet = playfield.getDealer().getCash() - bet;
        playfield.setCash(playerBet + dealerBet);

        cacheDao.savePlayer(playfield.getPlayer(), PLAYER);
        Player player = cacheDao.findPlayer(PLAYER);
        Response response = new Response();
        response.setBet(player.getCash());
        return response;
    }
}