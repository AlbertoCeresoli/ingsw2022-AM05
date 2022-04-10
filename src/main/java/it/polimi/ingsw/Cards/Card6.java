package it.polimi.ingsw.Cards;

import it.polimi.ingsw.Constants.Colors;
import it.polimi.ingsw.Influence.Card6Effect;
import it.polimi.ingsw.IslandInteraction;
import it.polimi.ingsw.hasSetInfluence;

import java.util.Map;

public class Card6 extends CharacterCards {
	private hasSetInfluence hasSetInfluence;

	/**
	 * Card6 constructor
	 */
	public Card6(int cost, IslandInteraction islandInteraction) {
		super(cost);
		hasSetInfluence = islandInteraction;
	}

	/**
	 * The method changes reference of influence in islandInteraction, in order to change the calculateInfluence
	 * method that will be called
	 *
	 * @param index         not used
	 * @param studentColor  not used
	 * @param studentArray1 not used
	 * @param studentArray2 not used
	 */
	@Override
	public boolean useEffect(int index, Colors studentColor, Map<Colors, Integer> studentArray1, Map<Colors, Integer> studentArray2) {
		hasSetInfluence.setInfluence(new Card6Effect());

		return true;
	}
}