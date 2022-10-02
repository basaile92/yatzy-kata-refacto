package yatzy.service;

import yatzy.model.Hand;

import java.util.List;

import static java.util.Arrays.asList;

public class ScoreService {

    private ScoreService(){}

    public static int chance(Hand hand)
    {
        return hand.sumDiceValues();
    }

    public static int yatzy(Hand hand)
    {
        int yatzyScore = 50;
        return  hand.hasOnlyOneDistinctValue() ?
                yatzyScore :
                0;
    }

    public static int ones(Hand hand) {
        return hand.countDiceValuesEqualTo(1);
    }

    public static int twos(Hand hand) {
        int multiplier = 2;
        return multiplier * hand.countDiceValuesEqualTo(2);
    }

    public static int threes(Hand hand) {
        int multiplier = 3;
        return multiplier * hand.countDiceValuesEqualTo(3);
    }

    public static int fours(Hand hand) {
        int multiplier = 4;
        return multiplier * hand.countDiceValuesEqualTo(4);

    }

    public static int fives(Hand hand) {
        int multiplier = 5;
        return multiplier * hand.countDiceValuesEqualTo(5);
    }

    public static int sixes(Hand hand) {
        int multiplier = 6;
        return multiplier * hand.countDiceValuesEqualTo(6);
    }

    public static int scorePair(Hand hand) {
        int multiplier = 2;
        return multiplier * hand.getGreatestDiceValueWithCountGreaterThan(2).orElse(0);
    }

    public static int twoPair(Hand hand) {
        int multiplier = 2;
        List<Integer> pairList = hand.extractInDescendingOrderDiceValueCountGreaterThan(2);
        if(pairList.size() < 2) {
            return 0;
        }
        return multiplier * pairList.stream().reduce(Integer::sum).orElse(0);
    }

    public static int threeOfAKind(Hand hand) {
        int multiplier = 3;
        return multiplier * hand.getGreatestDiceValueWithCountGreaterThan(3).orElse(0);
    }

    public static int fourOfAKind(Hand hand) {
        int multiplier = 4;
        return multiplier * hand.getGreatestDiceValueWithCountGreaterThan(4).orElse(0);
    }

    public static int smallStraight(Hand hand) {
        int smallStraightScore = 15;
        return hand.hasSameElementsThan(asList(1,2,3,4,5)) ? smallStraightScore : 0;
    }

    public static int largeStraight(Hand hand) {
        int largeStraightScore = 20;
        return hand.hasSameElementsThan(asList(2,3,4,5,6)) ? largeStraightScore : 0;
    }


    public static int fullHouse(Hand hand) {
        if(isFullHouse(hand))
            return hand.sumDiceValues();
        return 0;
    }

    private static boolean isFullHouse(Hand hand) {
        return hand.hasOneDiceValueCountEqualsTo(2) && hand.hasOneDiceValueCountEqualsTo(3)
                || hand.hasOneDiceValueCountEqualsTo(5);
    }
}
