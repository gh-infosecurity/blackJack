package za.co.sintez.black.jack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.co.sintez.black.jack.dao.CacheDaoI;
import za.co.sintez.black.jack.players.Player;
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

    @Autowired
    public void setCacheDao(CacheDaoI cacheDao) {
        this.cacheDao = cacheDao;
    }

    @RequestMapping("/bet")
    Response bet(@RequestBody Request request) {
        cacheDao.savePlayer(new Player(), PLAYER);
        Player player = cacheDao.findPlayer(PLAYER);

        Response response = new Response();
        return response;
    }
}