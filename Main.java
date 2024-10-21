//! Calories tracker - written in procedural programming and student have to change and implement what they learn in oop

import java.util.Scanner;

public class Main {
    final static int CALORIES_PER_MIN_WALKING = 5;
    final static int CALORIES_PER_MIN_RUNNING = 10;
    final static int CALORIES_PER_MIN_CYCLING = 8;

    public static void main(String[] args) {
        double goal = readNumber("Kunlik kaloriya maqsadingizni kiritjng (500-5000):", 500, 5000);
        double walkingTime = readNumber("Kunlik yurish vaqtini (daqiqalarda) kiritng:", 0, 300);
        double runningTime = readNumber("Kunlik yugurish vaqtini (daqiqalarda) kiritng:", 0, 300);
        double cyclingTime = readNumber("Velosipedda yurish vaqtini (daqiqalarda) kiritng:", 0, 300);

        double totalCaloriesBurned = calculateTotalCalories(walkingTime, runningTime, cyclingTime);
        printActivitySummary(walkingTime, runningTime, cyclingTime, totalCaloriesBurned);
        checkGoalAchieved(goal, totalCaloriesBurned);
        provideAdvice(walkingTime, runningTime, cyclingTime, totalCaloriesBurned);

    }

    public static double readInput(String label, double min, double max) {
        var scanner = new Scanner(System.in);
        double value;
        while (true) {
            System.out.print(label);
            value = scanner.nextDouble();
            if (value >= min && value <= max)
                break;

            System.out.println("Xato kiritdingiz. Iltimos, " + min + "va " + max + " oraligini kiriting");
        }
        return value;
    }

    public static double calculateTotalCalories(double walkingTime, double runningTime, double cyclingTime) {
        double walkingCalories = walkingTime * CALORIES_PER_MIN_WALKING;
        double runningCalories = runningTime * CALORIES_PER_MIN_RUNNING;
        double cyclingCalories = cyclingTime * CALORIES_PER_MIN_CYCLING;
        return walkingCalories + runningCalories + cyclingCalories;
    }

    public static void printActivitySummary(double walkingTime, double runningTime, double cyclingTime,
            double totalCaloriesBurned) {
        System.out.println("\nFAOLIYAT XULOSASI");
        System.out.println("-------------------------------------------------");
        System.out.println("Yurish vaqti: " + walkingTime + " daqiqa");
        System.out.println("Yugurish vaqti: " + runningTime + " daqiqa");
        System.out.println("Velosipedda yurish vaqti: " + cyclingTime + " daqiqa");
        System.out.println("Umumiy ishlatilgan kaloriya: " + totalCaloriesBurned + " kaloriya");
    }

    public static void checkGoalAchieved(double goal, double totalCaloriesBurned) {
        System.out.println("\n FITNESS MAQSAD");
        System.out.println("-------------------------------------------------");
        if (totalCaloriesBurned >= goal)
            System.out.println("TABRIKLAYMIZ, SIZ KUNLIK MAQSADINGIZGA ERISHDINGIZ!");
        else
            System.out.println("Siz " + (goal - totalCaloriesBurned) + " kaloriya kam ishlatdingiz.");
    }

    public static void provideAdvice(double walkingTime, double runningTime, double cyclingTime,
            double totalCaloriesBurned) {
        System.out.println("\n MASLAHAT");
        System.out.println("-------------------------------------------------");
        if (walkingTime < 30) {
            System.out.println("Kuniga kamida 30 daqiqa yurishingizni maslahat beramiz");
        }

        if (runningTime < 20) {
            System.out.println("Kuniga kamida 20 daqiqa yugurishingizni maslahat beramiz");
        }

        if (cyclingTime < 30) {
            System.out.println("Velosipedda kamida 30 daqiqa yurishingizni maslahat beramiz");
        }

        if (totalCaloriesBurned < 300) {
            System.out.println(
                    "Kuniga kamida 300 kaloriya ishlatishingiz uchun yurish, yugurish, va velosipedda yurishingizni oshiring");
        }
    }

}