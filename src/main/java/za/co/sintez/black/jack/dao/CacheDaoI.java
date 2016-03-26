package za.co.sintez.black.jack.dao;

import za.co.sintez.black.jack.gamefield.GameField;

public interface CacheDaoI {

    void saveGameField(GameField gameField, String key);

    GameField getGameField(String key);
}