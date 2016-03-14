package za.co.sintez.black.jack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.co.sintez.black.jack.playfield.card.CardFactory;
import za.co.sintez.black.jack.dao.CacheDaoI;
import za.co.sintez.black.jack.playfield.players.Dealer;
import za.co.sintez.black.jack.playfield.players.Player;
import za.co.sintez.black.jack.playfield.Playfield;
import za.co.sintez.black.jack.request.Request;
import za.co.sintez.black.jack.response.Response;

import javax.annotation.PostConstruct;

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

    @Autowired
    public void setCacheDao(CacheDaoI cacheDao) {
        this.cacheDao = cacheDao;
    }

    @Autowired
    public Playfield getPlayfield() {
        return playfield;
    }

    @PostConstruct
    public void init(){
        cashPlayers();
    }

    @RequestMapping("/bet")
    Response bet(@RequestBody Request request) {
        int bet = request.getBet();

        Player player = cacheDao.findPlayer(PLAYER);
        Dealer dealer = cacheDao.findDealer(DEALER);
        playfield.setCash(player.doBet(bet) + dealer.doBet(bet));

        cashPlayers();

        Response response = new Response();
        response.setPlayfield(playfield);
        return response;
    }

    private void cashPlayers() {
        cacheDao.savePlayer(playfield.getPlayer(), PLAYER);
        cacheDao.saveDealer(playfield.getDealer(), DEALER);
    }
}