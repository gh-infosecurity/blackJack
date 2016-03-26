package za.co.sintez.black.jack;

import org.testng.annotations.Test;
import za.co.sintez.black.jack.gamefield.card.Card;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;
import static za.co.sintez.black.jack.gamefield.card.Cards.ACE_DIAMONDS;
import static za.co.sintez.black.jack.gamefield.card.Cards._10_CLUBS;
import static za.co.sintez.black.jack.gamefield.card.Cards._5_CLUBS;

public class ScoreCheckerTest {
    private ScoreChecker checker = new ScoreChecker();

    @Test
    public void testIsBlackJack() throws Exception {
        List<Card> cards = Arrays.asList(new Card(_10_CLUBS), new Card(ACE_DIAMONDS));
        assertTrue(checker.isBlackJack(cards));
    }

    @Test
    public void testIsNotBlackJack() throws Exception {
        List<Card> cards = Arrays.asList(new Card(_10_CLUBS), new Card(_5_CLUBS));
        assertFalse(checker.isBlackJack(cards));
    }
}