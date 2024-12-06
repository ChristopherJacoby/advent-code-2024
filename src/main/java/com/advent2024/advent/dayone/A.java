package com.advent2024.advent.dayone;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class A {
  private static final Logger log = LoggerFactory.getLogger(A.class);

  public static void main(String[] args) {
    try {
      List<String> input = Files.readAllLines(Paths.get("src/main/resources/dayone/a.txt"));
      input = input.stream().filter(line -> !line.trim().isEmpty()).toList();

      if (input.size() < 2) {
        throw new IllegalArgumentException(
            "Input file must contain at least two lines of numbers.");
      }

      log.debug("Input file content: {}", input);

      List<Integer> leftList = new ArrayList<>();
      List<Integer> rightList = new ArrayList<>();

      for (String line : input) {
        List<Integer> parsedList = parseList(line);
        for (int i = 0; i < parsedList.size(); i++) {
          if (i % 2 == 0) {
            leftList.add(parsedList.get(i));
          } else {
            rightList.add(parsedList.get(i));
          }
        }
      }

      if (leftList.size() != rightList.size()) {
        throw new IllegalArgumentException(
            "Mismatched list sizes: left=" + leftList.size() + ", right=" + rightList.size());
      }

      Collections.sort(leftList);
      Collections.sort(rightList);

      int totalDistance = calculateTotalDistance(leftList, rightList);

      log.info("Total distance: {}", totalDistance);
    } catch (IOException e) {
      log.error("Error reading file", e);
    }
  }

  public static List<Integer> parseList(String line) {
    String[] parts = line.trim().split("\\s+");

    if (parts.length == 0) {
      return new ArrayList<>();
    }

    List<Integer> list = new ArrayList<>();
    for (String part : parts) {
      try {
        list.add(Integer.parseInt(part));
      } catch (NumberFormatException e) {
        log.warn("Skipping invalid number: {}", part);
      }
    }
    return list;
  }

  public static int calculateTotalDistance(List<Integer> leftList, List<Integer> rightList) {
    int totalDistance = 0;
    for (int i = 0; i < leftList.size(); i++) {
      totalDistance += Math.abs(leftList.get(i) - rightList.get(i));
    }
    return totalDistance;
  }
}
