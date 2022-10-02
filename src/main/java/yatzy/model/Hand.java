package yatzy.model;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.groupingBy;

public class Hand {

    public final List<Integer> diceValues;

    public Hand(int firstDiceValue, int secondDiceValue, int thirdDiceValue, int fourthDiceValue, int fifthDiceValue) {
        this.diceValues = asList(firstDiceValue, secondDiceValue, thirdDiceValue, fourthDiceValue, fifthDiceValue);
    }

    public int sumDiceValues() {
        return this.diceValues.stream().reduce(Integer::sum).orElse(0);
    }

    public boolean hasOnlyOneDistinctValue() {
        return this.diceValues.stream().distinct().count() == 1L;
    }

    public int countDiceValuesEqualTo(int diceValue) {
        return (int) this.diceValues.stream().filter(value -> value == diceValue).count();
    }

    public Optional<Integer> getGreatestDiceValueWithCountGreaterThan(int count) {
        return extractInDescendingOrderDiceValueCountGreaterThan(count).stream().findFirst();
    }

    public List<Integer> extractInDescendingOrderDiceValueCountGreaterThan(int count) {
        return extractNumberOfElementByDiceValue().entrySet().stream()
                .filter(entry -> entry.getValue() >= count)
                .map(Map.Entry::getKey)
                .sorted(Comparator.reverseOrder())
                .toList();
    }

    private Map<Integer, Long> extractNumberOfElementByDiceValue() {
        return this.diceValues
                .stream()
                .collect(groupingBy(diceValue -> diceValue, Collectors.counting()));
    }

    public boolean hasSameElementsThan(List<Integer> elementsToCompare) {
        return this.diceValues.stream().sorted().toList()
                .equals(elementsToCompare.stream().sorted().toList());
    }

    public boolean hasOneDiceValueCountEqualsTo(int count) {
        return extractNumberOfElementByDiceValue().containsValue((long) count);
    }
}
