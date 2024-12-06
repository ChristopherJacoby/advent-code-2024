package com.advent2024.advent.dayone;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;

class ATest {

  @Test
  void testCalculateTotalDistance() {
    List<Integer> leftList = Arrays.asList(2, 1, 3, 3, 3, 4);
    List<Integer> rightList = Arrays.asList(3, 3, 3, 4, 5, 9);

    int totalDistance = A.calculateTotalDistance(leftList, rightList);

    List<Integer> sortedLeftList = new ArrayList<>(leftList);
    Collections.sort(sortedLeftList);

    assertThat(sortedLeftList).isEqualTo(Arrays.asList(1, 2, 3, 3, 3, 4));
    assertEquals(11, totalDistance);
  }

  @Test
  void testParseList() {
    String input = "3 4 2 1 3 3";

    List<Integer> parsedList = A.parseList(input);

    assertEquals(Arrays.asList(3, 4, 2, 1, 3, 3), parsedList);
  }
}
