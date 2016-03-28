package za.co.sintez.black.jack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.co.sintez.black.jack.dao.CacheDaoI;
import za.co.sintez.black.jack.gamefield.GameField;
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
    private CacheDaoI cacheDao;
    private GameField gameField;
    private Controller controller;

    @Autowired
    public void setCacheDao(CacheDaoI cacheDao) {
        this.cacheDao = cacheDao;
    }

    @Autowired
    public void setGameField(GameField gameField) {
        this.gameField = gameField;
    }

    @Autowired
    public void setController(Controller controller) {
        this.controller = controller;
    }

    @PostConstruct
    public void init() {
        cacheDao.saveGameField(gameField);
    }

    @RequestMapping("/bet")
    Response bet(@RequestBody Request request) {
        GameField gameField = cacheDao.getGameField();
        controller.bet(request.getBet(), gameField);
        cacheDao.saveGameField(gameField);
        return getResponse(gameField);
    }

    @RequestMapping("/pass/card")
    Response passCard() {
        GameField gameField = cacheDao.getGameField();
        controller.passCard(gameField);
        cacheDao.saveGameField(gameField);
        return getResponse(gameField);
    }

    @RequestMapping("/hint")
    Response hint() {
        GameField gameField = cacheDao.getGameField();
        controller.hint(gameField);
        cacheDao.saveGameField(gameField);
        return getResponse(gameField);
    }

    @RequestMapping("/stand")
    Response stand() {
        GameField gameField = cacheDao.getGameField();
        controller.stand(gameField);
        cacheDao.saveGameField(gameField);
        return getResponse(gameField);
    }

    private Response getResponse(GameField gameField) {
        Response response = new Response();
        response.setGameField(gameField);
        return response;
    }
}