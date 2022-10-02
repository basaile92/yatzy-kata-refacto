package yatzy.model;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;
import static org.junit.jupiter.api.Assertions.assertEquals;

class HandTest {

    @Test
    void sumDiceValuesShouldReturnTheSumOfDiceValues() {
        // GIVEN
        Hand hand = new Hand(2,3,4,5,1);
        int expectedResult = 15;

        // WHEN
        int result = hand.sumDiceValues();

        // THEN
        assertEquals(expectedResult, result);
    }

    @Test
    void hasOnlyOneDistinctValueShouldCheckIfHandHasFiveDicesOfSameValues() {
        // GIVEN
        Hand firstHand = new Hand(5,5,5,5,5);
        boolean firstExpectedResult = true;
        Hand secondHand = new Hand(1,2,2,3,2);
        boolean secondExpectedResult = false;

        // WHEN
        boolean firstResult = firstHand.hasOnlyOneDistinctValue();
        boolean secondResult = secondHand.hasOnlyOneDistinctValue();

        // THEN
        assertEquals(firstExpectedResult, firstResult);
        assertEquals(secondExpectedResult, secondResult);
    }

    @Test
    void countDiceValuesEqualToShouldReturnTheNumberOfIterationInHandOfADiceValue() {
        // GIVEN
        Hand hand = new Hand(1,2,2,3,2);
        int expectedResult = 3;

        // WHEN
        int result = hand.countDiceValuesEqualTo(2);

        // THEN
        assertEquals(expectedResult, result);
    }

    @Test
    void getGreatestDiceValueWithCountGreaterThanShouldFindGreatestValueWithAtLeastNIterationsOrEmptyIfItDoesNotExist() {
        // GIVEN
        Hand hand = new Hand(5,5,3,3,3);
        Optional<Integer> firstExpectedResult = Optional.of(5);
        Optional<Integer> secondExpectedResult = Optional.of(3);
        Optional<Integer> thirdExpectedResult = Optional.empty();

        // WHEN
        Optional<Integer> firstResult = hand.getGreatestDiceValueWithCountGreaterThan(2);
        Optional<Integer> secondResult = hand.getGreatestDiceValueWithCountGreaterThan(3);
        Optional<Integer> thirdResult = hand.getGreatestDiceValueWithCountGreaterThan(4);

        // THEN
        assertEquals(firstExpectedResult, firstResult);
        assertEquals(secondExpectedResult, secondResult);
        assertEquals(thirdExpectedResult, thirdResult);
    }

    @Test
    void extractInDescendingOrderDiceValueCountGreaterThanShouldReturnAllDiceValueWithCountGreaterThanN() {
        // GIVEN
        Hand hand = new Hand(5,5,3,3,3);
        List<Integer> firstExpectedResult = asList(5,3);
        List<Integer> secondExpectedResult = singletonList(3);
        List<Integer> thirdExpectedResult = emptyList();

        // WHEN
        List<Integer> firstResult = hand.extractInDescendingOrderDiceValueCountGreaterThan(2);
        List<Integer> secondResult = hand.extractInDescendingOrderDiceValueCountGreaterThan(3);
        List<Integer> thirdResult = hand.extractInDescendingOrderDiceValueCountGreaterThan(4);

        // THEN
        assertEquals(firstExpectedResult, firstResult);
        assertEquals(secondExpectedResult, secondResult);
        assertEquals(thirdExpectedResult, thirdResult);
    }

    @Test
    void hasSameElementsThanShouldCheckIfHandHasSameElementsThatElementsToCompare() {
        // GIVEN
        Hand hand = new Hand(3,5,2,1,4);
        boolean firstExpectedResult = true;
        boolean secondExpectedResult = false;

        // WHEN
        boolean firstResult = hand.hasSameElementsThan(asList(3,2,4,1,5));
        boolean secondResult = hand.hasSameElementsThan(asList(1,1,4,1,5));

        // THEN
        assertEquals(firstExpectedResult, firstResult);
        assertEquals(secondExpectedResult, secondResult);
    }

    @Test
    void hasOneDiceValueCountEqualsToShouldCheckIfHandHasOneDiceValueCountEqualsToN() {
        // GIVEN
        Hand hand = new Hand(3,3,4,4,4);
        boolean firstExpectedResult = true;
        boolean secondExpectedResult = true;
        boolean thirdExpectedResult = false;

        // WHEN
        boolean firstResult = hand.hasOneDiceValueCountEqualsTo(2);
        boolean secondResult = hand.hasOneDiceValueCountEqualsTo(3);
        boolean thirdResult = hand.hasOneDiceValueCountEqualsTo(4);

        // THEN
        assertEquals(firstExpectedResult, firstResult);
        assertEquals(secondExpectedResult, secondResult);
        assertEquals(thirdExpectedResult, thirdResult);
    }



}
