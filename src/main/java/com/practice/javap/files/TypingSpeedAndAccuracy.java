package com.practice.javap.files;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TypingSpeedAndAccuracy {
    public static void main(String[] args) {
        File file = new File("src/main/resources/lorem.txt");
        String[] list = "The quick brown fox jumps over the lazy dog".split(" ");
        Integer[] integers = new Integer[list.length];
        StringBuilder stringBuilder = new StringBuilder();
        int count = 0;
        long start;
        long end;
        long duration;
        Scanner scanner = new Scanner(System.in);
        System.out.print("0 for file and 1 for manual - ");
        int option = Integer.parseInt(scanner.nextLine());
        if (option == 1) {
            System.out.println("Enter the following five times: The quick brown fox jumps over the lazy dog");
        }
        if (option == 0) {
            try {
                scanner = new Scanner(file);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                System.out.println("file is not there.");
            }
        }
        start = System.nanoTime();
        while (count < 5 && scanner.hasNextLine()) {
            count++;
            stringBuilder.append(scanner.nextLine());
            stringBuilder.append(" ");
        }
        String finalContent = stringBuilder.toString();
        end = System.nanoTime();
        duration = option == 1 ? end - start : 0;

        int total = count * list.length;
        int correct = 0;
        for (String s : list) {
            int index = 0;
            while ((index = finalContent.indexOf(s + " ", index)) != -1) {
                correct++;
                index += s.length() + 1; // Move index past the found word and space
            }
        }

        System.out.println("Correct occurrences: " + correct);
        System.out.println("Total expected occurrences: " + total);
        System.out.println("Correctness: " + (correct * 100 / total) + "%");

        if (option == 1) {
            double speed = (total + 0.0) / ((duration + 0.0) / (60.0 * 1000000000.0));
            System.out.println("Speed: " + Math.round(speed));
        }
    }
}
