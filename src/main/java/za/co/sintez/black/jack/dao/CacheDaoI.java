package za.co.sintez.black.jack.dao;

import za.co.sintez.black.jack.playfield.card.Card;
import za.co.sintez.black.jack.playfield.players.Dealer;
import za.co.sintez.black.jack.playfield.players.Player;

import java.util.List;

public interface CacheDaoI {

    void savePlayer(Player player, String key);

    void saveDealer(Dealer dealer, String key);

    Player getPlayer(String key);

    Dealer getDealer(String key);

    void saveCardDeck(List<Card> cards, String key);

    List<Card> getCardDeck(String key);
}
