package it.polimi.ingsw.Cards;

import it.polimi.ingsw.Constants.Colors;
import it.polimi.ingsw.IslandInteraction;

import java.util.Map;

public class Card3 extends CharCardsIslands {
    /**
     * Card3 constructor
     */
    public Card3(int cost, IslandInteraction islandInteraction) {
        super(cost, islandInteraction);
    }

    /**
     * The method activate calculateInfluence method in islandInteraction on the chosen island
     *
     * @param index         is the island index where the influence will be calculated
     * @param studentColor  not used
     * @param studentArray1 not used
     * @param studentArray2 not used
     */
    @Override
    public boolean useEffect(int index, Colors studentColor, Map<Colors, Integer> studentArray1, Map<Colors, Integer> studentArray2) {
        //getIslandInteraction().calculateInfluence(index);
        return true;
    }
}