package com.hackerrank.day0;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class WeightedMean {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> vals = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> weights = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        weightedMean(vals, weights);

        bufferedReader.close();
    }

    private static void weightedMean(List<Integer> vals, List<Integer> weights) {
        double multiply = 0;
        double sum = 0;
        for (int i = 0; i < vals.size(); i++) {
            multiply += vals.get(i) * weights.get(i);
            sum += weights.get(i);
        }
        double result = multiply/sum;
        System.out.printf("%.1f", result);
    }
}
