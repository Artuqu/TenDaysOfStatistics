package com.hackerrank.day0;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MeanMedianMode {


    public static void main(String[] args) throws IOException {
        List<Integer> arr = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        String[] numbers = reader.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr.add(Integer.parseInt(numbers[i]));
        }
        solution(arr);

    }

    private static void solution(List<Integer> arr) {
        Collections.sort(arr);
        int currCounter = 0;
        double sum = 0, median;
        int currNumber = 0, mode = 0;
        int counter = 0;
        if (!arr.isEmpty()) {
            currNumber = arr.get(0);
            for (int i = 0; i < arr.size(); i++) {
                sum += arr.get(i);
            }
            for (int i = 0; i < arr.size(); i++) {
                if (currNumber == arr.get(i)) {
                    currCounter++;
                } else {
                    counter = Math.max(currCounter, counter);
                    currCounter = 0;
                    currNumber = arr.get(i);
                    i--;
                }
                if (currCounter > counter) mode = arr.get(i);
            }
            double mean = sum / arr.size();
            if (arr.size() % 2 == 0) {
                median = (double) (arr.get(arr.size() / 2) + arr.get(arr.size() / 2 - 1)) / 2;
            } else {
                median = arr.get(arr.size() / 2);
            }
            System.out.println(mean);
            System.out.println(median);
            System.out.println(mode);
        }
    }
}
//6
// 1, 2, 3, 4, 5, 6, 7
