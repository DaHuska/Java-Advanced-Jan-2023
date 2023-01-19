package com.company.SetsAndMaps;

import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

public class AcademyGraduation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int numberStudents = Integer.parseInt(scan.nextLine());

        Map<String, List<Double>> studentGrades = new TreeMap<>();

        for (int i = 0; i < numberStudents; i++) {
            String student = scan.nextLine();
            List<Double> grades = Arrays.stream(scan.nextLine().split("\\s+"))
            .map(Double::parseDouble).collect(Collectors.toList());

            studentGrades.putIfAbsent(student, new ArrayList<>());
            studentGrades.get(student).addAll(grades);
        }

        studentGrades
                .forEach((student, grades) -> {
                    double averageGrade = grades.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
                       
                    // too precise calculation of average grade 
                    DecimalFormat formatedGrade = new DecimalFormat("0.######");
                    System.out.printf("%s is graduated with %s%n", student, formatedGrade.format(averageGrade));
                });
    }
}
