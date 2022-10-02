package yatzy.service;

import org.junit.jupiter.api.Test;
import yatzy.model.Hand;

import static org.junit.jupiter.api.Assertions.assertEquals;


class ScoreServiceTest {

    @Test
    void chanceShouldScoreSumOfAllDices() {
        // GIVEN
        Hand hand = new Hand(2,3,4,5,1);
        int expectedResult = 15;

        // WHEN
        int chanceScore = ScoreService.chance(hand);

        // THEN
        assertEquals(expectedResult, chanceScore);
    }

    @Test
    void yatzyOnHandContainingYatzyShouldScoreFifty() {
        // GIVEN
        Hand firstHand = new Hand(4,4,4,4,4);
        Hand secondHand = new Hand(6,6,6,6,6);
        int expectedResult = 50;

        // WHEN
        int firstYatzyScore = ScoreService.yatzy(firstHand);
        int secondYatzyScore = ScoreService.yatzy(secondHand);

        // THEN
        assertEquals(expectedResult, firstYatzyScore);
        assertEquals(expectedResult, secondYatzyScore);
    }

    @Test
    void yatzyOnHandNotContainingYatzyShouldScoreZero() {
        // GIVEN
        Hand hand = new Hand(6,6,6,6,3);
        int expectedResult = 0;

        // WHEN
        int yatzyScore = ScoreService.yatzy(hand);

        // THEN
        assertEquals(expectedResult, yatzyScore);
    }

    @Test
    void oneOnHandShouldScoreNumberOfOnes() {
        // GIVEN
        Hand firstHand = new Hand(1,2,3,4,5);
        int firstExpectedResult = 1;
        Hand secondHand = new Hand(1,2,1,4,5);
        int secondExpectedResult = 2;
        Hand thirdHand = new Hand(6,2,2,4,5);
        int thirdExpectedResult = 0;
        Hand fourthHand = new Hand(1,2,1,1,1);
        int fourthExpectedResult = 4;


        // WHEN
        int firstScore = ScoreService.ones(firstHand);
        int secondScore = ScoreService.ones(secondHand);
        int thirdScore = ScoreService.ones(thirdHand);
        int fourthScore = ScoreService.ones(fourthHand);

        // THEN
        assertEquals(firstExpectedResult, firstScore);
        assertEquals(secondExpectedResult, secondScore);
        assertEquals(thirdExpectedResult, thirdScore);
        assertEquals(fourthExpectedResult, fourthScore);
    }

    @Test
    void twoOnHandShouldScoreNumberOfTwosMultipliedByTwo() {
        // GIVEN
        Hand firstHand = new Hand(1,2,3,2,6);
        int firstExpectedResult = 4;
        Hand secondHand = new Hand(2,2,2,2,2);
        int secondExpectedResult = 10;


        // WHEN
        int firstScore = ScoreService.twos(firstHand);
        int secondScore = ScoreService.twos(secondHand);

        // THEN
        assertEquals(firstExpectedResult, firstScore);
        assertEquals(secondExpectedResult, secondScore);
    }

    @Test
    void threeOnHandShouldScoreNumberOfThreesMultipliedByThree() {
        // GIVEN
        Hand firstHand = new Hand(1,2,3,2,3);
        int firstExpectedResult = 6;
        Hand secondHand = new Hand(2,3,3,3,3);
        int secondExpectedResult = 12;


        // WHEN
        int firstScore = ScoreService.threes(firstHand);
        int secondScore = ScoreService.threes(secondHand);

        // THEN
        assertEquals(firstExpectedResult, firstScore);
        assertEquals(secondExpectedResult, secondScore);
    }

    @Test
    void fourOnHandShouldScoreNumberOfFoursMultipliedByFour() {
        // GIVEN
        Hand firstHand = new Hand(4,4,4,5,5);
        int firstExpectedResult = 12;
        Hand secondHand = new Hand(4,4,5,5,5);
        int secondExpectedResult = 8;
        Hand thirdHand = new Hand(4,5,5,5,5);
        int thirdExpectedResult = 4;


        // WHEN
        int firstScore = ScoreService.fours(firstHand);
        int secondScore = ScoreService.fours(secondHand);
        int thirdScore = ScoreService.fours(thirdHand);

        // THEN
        assertEquals(firstExpectedResult, firstScore);
        assertEquals(secondExpectedResult, secondScore);
        assertEquals(thirdExpectedResult, thirdScore);
    }

    @Test
    void fivesOnHandShouldScoreNumberOfFivesMultipliedByFive() {
        // GIVEN
        Hand firstHand = new Hand(4,4,4,5,5);
        int firstExpectedResult = 10;
        Hand secondHand = new Hand(4,4,5,5,5);
        int secondExpectedResult = 15;
        Hand thirdHand = new Hand(4,5,5,5,5);
        int thirdExpectedResult = 20;


        // WHEN
        int firstScore = ScoreService.fives(firstHand);
        int secondScore = ScoreService.fives(secondHand);
        int thirdScore = ScoreService.fives(thirdHand);

        // THEN
        assertEquals(firstExpectedResult, firstScore);
        assertEquals(secondExpectedResult, secondScore);
        assertEquals(thirdExpectedResult, thirdScore);
    }

    @Test
    void sixesOnHandShouldScoreNumberOfSixesMultipliedBySix() {
        // GIVEN
        Hand firstHand = new Hand(4,4,4,5,5);
        int firstExpectedResult = 0;
        Hand secondHand = new Hand(4,4,6,5,5);
        int secondExpectedResult = 6;
        Hand thirdHand = new Hand(6,5,6,6,5);
        int thirdExpectedResult = 18;


        // WHEN
        int firstScore = ScoreService.sixes(firstHand);
        int secondScore = ScoreService.sixes(secondHand);
        int thirdScore = ScoreService.sixes(thirdHand);

        // THEN
        assertEquals(firstExpectedResult, firstScore);
        assertEquals(secondExpectedResult, secondScore);
        assertEquals(thirdExpectedResult, thirdScore);
    }

    @Test
    void onePairOnHandShouldScoreSumOfGreatestPair() {
        // GIVEN
        Hand firstHand = new Hand(3,4,3,5,6);
        int firstExpectedResult = 6;
        Hand secondHand = new Hand(5,3,3,3,5);
        int secondExpectedResult = 10;
        Hand thirdHand = new Hand(5,3,6,6,5);
        int thirdExpectedResult = 12;
        Hand fourthHand = new Hand(5,3,1,2,4);
        int fourthExpectedResult = 0;


        // WHEN
        int firstScore = ScoreService.scorePair(firstHand);
        int secondScore = ScoreService.scorePair(secondHand);
        int thirdScore = ScoreService.scorePair(thirdHand);
        int fourthScore = ScoreService.scorePair(fourthHand);


        // THEN
        assertEquals(firstExpectedResult, firstScore);
        assertEquals(secondExpectedResult, secondScore);
        assertEquals(thirdExpectedResult, thirdScore);
        assertEquals(fourthExpectedResult, fourthScore);
    }

    @Test
    void twoPairShouldScoreSumOfTwoGreatestPairIfPresentOrZero() {
        Hand firstHand = new Hand(3,3,5,4,5);
        int firstExpectedResult = 16;
        Hand secondHand = new Hand(3,3,5,5,5);
        int secondExpectedResult = 16;
        Hand thirdHand = new Hand(3,3,0,1,5);
        int thirdExpectedResult = 0;

        // WHEN
        int firstScore = ScoreService.twoPair(firstHand);
        int secondScore = ScoreService.twoPair(secondHand);
        int thirdScore = ScoreService.twoPair(thirdHand);


        // THEN
        assertEquals(firstExpectedResult, firstScore);
        assertEquals(secondExpectedResult, secondScore);
        assertEquals(thirdExpectedResult, thirdScore);
    }

    @Test
    void threeOfAKindShouldScoreSumOfTheThreeOfThatKindOrZeroIfThereIsNot() {
        Hand firstHand = new Hand(3,3,3,4,5);
        int firstExpectedResult = 9;
        Hand secondHand = new Hand(5,3,5,4,5);
        int secondExpectedResult = 15;
        Hand thirdHand = new Hand(3,3,3,3,5);
        int thirdExpectedResult = 9;
        Hand fourthHand = new Hand(1,2,3,4,5);
        int fourthExpectedResult = 0;

        // WHEN
        int firstScore = ScoreService.threeOfAKind(firstHand);
        int secondScore = ScoreService.threeOfAKind(secondHand);
        int thirdScore = ScoreService.threeOfAKind(thirdHand);
        int fourthScore = ScoreService.threeOfAKind(fourthHand);


        // THEN
        assertEquals(firstExpectedResult, firstScore);
        assertEquals(secondExpectedResult, secondScore);
        assertEquals(thirdExpectedResult, thirdScore);
        assertEquals(fourthExpectedResult, fourthScore);
    }

    @Test
    void fourOfAKindShouldScoreSumOfTheFourOfThatKindOrZeroIfThereIsNot() {
        Hand firstHand = new Hand(3,3,3,3,5);
        int firstExpectedResult = 12;
        Hand secondHand = new Hand(5,5,5,4,5);
        int secondExpectedResult = 20;
        Hand thirdHand = new Hand(1,2,3,4,5);
        int thirdExpectedResult = 0;

        // WHEN
        int firstScore = ScoreService.fourOfAKind(firstHand);
        int secondScore = ScoreService.fourOfAKind(secondHand);
        int thirdScore = ScoreService.fourOfAKind(thirdHand);


        // THEN
        assertEquals(firstExpectedResult, firstScore);
        assertEquals(secondExpectedResult, secondScore);
        assertEquals(thirdExpectedResult, thirdScore);
    }

    @Test
    void smallStraightShouldScoreFifteenIfThereIsAllElementsBetweenOneAndFiveInHand() {
        Hand firstHand = new Hand(1,2,3,4,5);
        int firstExpectedResult = 15;
        Hand secondHand = new Hand(2,3,4,5,1);
        int secondExpectedResult = 15;
        Hand thirdHand = new Hand(1,2,2,4,5);
        int thirdExpectedResult = 0;

        // WHEN
        int firstScore = ScoreService.smallStraight(firstHand);
        int secondScore = ScoreService.smallStraight(secondHand);
        int thirdScore = ScoreService.smallStraight(thirdHand);


        // THEN
        assertEquals(firstExpectedResult, firstScore);
        assertEquals(secondExpectedResult, secondScore);
        assertEquals(thirdExpectedResult, thirdScore);
    }

    @Test
    void largeStraightShouldScoreTwentyIfThereIsAllElementsBetweenTwoAndSixInHand() {
        Hand firstHand = new Hand(6,2,3,4,5);
        int firstExpectedResult = 20;
        Hand secondHand = new Hand(2,3,4,5,6);
        int secondExpectedResult = 20;
        Hand thirdHand = new Hand(1,2,2,4,5);
        int thirdExpectedResult = 0;

        // WHEN
        int firstScore = ScoreService.largeStraight(firstHand);
        int secondScore = ScoreService.largeStraight(secondHand);
        int thirdScore = ScoreService.largeStraight(thirdHand);


        // THEN
        assertEquals(firstExpectedResult, firstScore);
        assertEquals(secondExpectedResult, secondScore);
        assertEquals(thirdExpectedResult, thirdScore);
    }

    @Test
    void fullHouseShouldScoreSumOfAllDiceValueIfThereIsThreeDicesOfAKindAndTwoOtherDicesOfAKind() {
        Hand firstHand = new Hand(6,2,2,2,6);
        int firstExpectedResult = 18;
        Hand secondHand = new Hand(2,3,4,5,6);
        int secondExpectedResult = 0;
        Hand thirdHand = new Hand(2,2,2,2,2);
        int thirdExpectedResult = 10;

        // WHEN
        int firstScore = ScoreService.fullHouse(firstHand);
        int secondScore = ScoreService.fullHouse(secondHand);
        int thirdScore = ScoreService.fullHouse(thirdHand);


        // THEN
        assertEquals(firstExpectedResult, firstScore);
        assertEquals(secondExpectedResult, secondScore);
        assertEquals(thirdExpectedResult, thirdScore);
    }
}
