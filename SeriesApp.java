package com.mycompany.prog_part1;

import java.util.Scanner;

public class SeriesApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SeriesManager manager = new SeriesManager();

        int choice;
        do {
            System.out.println("LATEST SERIES - 2025");
            System.out.println("===========================");
             System.out.println("Enter (1) to launch menu or any other key to exit");
            System.out.println("1. Capture a new series");
            System.out.println("2. Search for a series");
            System.out.println("3. Update series age sestriction");
            System.out.println("4. Delete a series");
            System.out.println("5. Print series report - 2025");
            System.out.println("6. Exit application");
            System.out.print("Enter your choice: ");

            while (!sc.hasNextInt()) {
                System.out.println(" Please enter a number!");
                sc.next();
            }
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1 -> manager.CaptureSeries();
                case 2 -> manager.SearchSeries();
                case 3 -> manager.UpdateSeries();
                case 4 -> manager.DeleteSeries();
                case 5 -> manager.SeriesReport();
                case 6 -> System.out.println(" Exiting... Goodbye!");
                default -> System.out.println(" Invalid choice, try again.");
            }
        } while (choice != 0);

        sc.close();
    }
}
