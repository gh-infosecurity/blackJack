package za.co.sintez.black.jack.dao;

import za.co.sintez.black.jack.playfield.players.Dealer;
import za.co.sintez.black.jack.playfield.players.Player;

public interface CacheDaoI {

    void savePlayer(Player player, String key);

    void saveDealer(Dealer dealer, String key);

    Player findPlayer(String key);

    Dealer findDealer(String key);
}
