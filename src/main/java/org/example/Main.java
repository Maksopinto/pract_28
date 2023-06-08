package org.example;

import java.util.Scanner;

public class Main {
    private static final String ADMIN_PASSWORD = "1111";
    private static final String[] QUESTIONS = {
            "1. What is the subject pronoun for the third-person singular in English?",
            "a) He\nb) She\nc) They\nd) It",
            "2. Which pronoun is used to refer to a group of people?",
            "a) He\nb) We\nc) I\nd) You",
            "3. What is the object pronoun for the first-person singular in English?",
            "a) Me\nb) I\nc) Myself\nd) Mine",
            "4. Which pronoun is used as a possessive pronoun for the third-person plural?",
            "a) His\nb) Theirs\nc) Yours\nd) Ours",
            "5. What is the reflexive pronoun for the second-person singular in English?",
            "a) Himself\nb) Herself\nc) Myself\nd) Yourself"
    };
    private static final String[] ANSWERS = {"d", "b", "a", "b", "d"};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isAdmin = false;

        System.out.println("English Pronouns Quiz");
        System.out.println("---------------------");

        while (true) {
            System.out.println("Hripko maxim");
            System.out.println("Enter 'q' to quit or 'p' to view correct answers.");

            System.out.print("Enter your choice (a, b, c, d): ");
            String choice = scanner.nextLine().toLowerCase();

            if (choice.equals("q")) {
                break;
            } else if (choice.equals("p")) {
                System.out.print("Enter the admin password: ");
                String password = scanner.nextLine();

                if (password.equals(ADMIN_PASSWORD)) {
                    isAdmin = true;
                    printCorrectAnswers();
                } else {
                    System.out.println("Incorrect password. Access denied.");
                }
            } else if (isValidChoice(choice)) {
                System.out.println("Invalid option. Please enter a valid choice (a, b, c, d).");
            } else {
                int score = calculateScore(choice);
                double percentage = (double) score / (QUESTIONS.length / 2) * 100;

                System.out.println("Quiz Results");
                System.out.println("------------");
                System.out.println("Score: " + score + "/" + (QUESTIONS.length / 2));
                System.out.printf("Percentage: %.2f%%\n", percentage);
                break;
            }
        }

        scanner.close();
    }

    private static boolean isValidChoice(String choice) {
        return !choice.equals("a") && !choice.equals("b") && !choice.equals("c") && !choice.equals("d");
    }

    private static int calculateScore(String choice) {
        int score = 0;

        for (int i = 0; i < ANSWERS.length; i++) {
            if (choice.equals(ANSWERS[i])) {
                score++;
            }
        }

        return score;
    }

    private static void printCorrectAnswers() {
        System.out.println("Correct Answers");
        System.out.println("---------------");

        for (int i = 0; i < QUESTIONS.length; i += 2) {
            System.out.println(QUESTIONS[i]);
            System.out.println("Correct answer: " + ANSWERS[i / 2]);
            System.out.println();
        }
    }
}