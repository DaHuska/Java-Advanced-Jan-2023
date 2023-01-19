package com.company.SetsAndMaps;

import java.util.*;

public class AverageStudentGrades {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int studentsCount = Integer.parseInt(scan.nextLine());

        Map<String, List<Double>> studentGrade = new TreeMap<>();
        List<Double> grades = new ArrayList<>();

        for (int i = 0; i < studentsCount; i++) {
            String[] tokens = scan.nextLine().split("\\s+");

            String studentName = tokens[0];
            double currGrade = Double.parseDouble(tokens[1]);

            studentGrade.putIfAbsent(studentName, new ArrayList<>());
            studentGrade.get(studentName).add(currGrade);
        }

        studentGrade
                .forEach((key, value) -> {
                    double avgGrade = value.stream().mapToDouble(d -> d).average().orElse(0.0);

                    System.out.printf("%s -> ", key);

                    for (double grade : value) {
                        System.out.printf("%.2f ", grade);
                    }

                    System.out.printf("(avg: %.2f)", avgGrade);
                    System.out.println();
                });
    }
}
