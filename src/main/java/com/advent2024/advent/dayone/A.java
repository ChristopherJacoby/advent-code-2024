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
      List<Integer> leftList = parseList(input.get(0));
      List<Integer> rightList = parseList(input.get(1));

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
