package com.advent2024.advent.dayone;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class ATest {

  @Test
  void testCalculateTotalDistance() {
    List<Integer> leftList = Arrays.asList(1, 2, 3, 3, 3, 4);
    List<Integer> rightList = Arrays.asList(3, 3, 3, 4, 5, 9);

    int totalDistance = A.calculateTotalDistance(leftList, rightList);

    assertEquals(11, totalDistance);
  }

  @Test
  void testParseList() {
    String input = "3 4 2 1 3 3";

    List<Integer> parsedList = A.parseList(input);

    assertEquals(Arrays.asList(3, 4, 2, 1, 3, 3), parsedList);
  }
}
