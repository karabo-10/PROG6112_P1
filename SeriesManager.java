package com.mycompany.prog_part1;

import java.util.ArrayList;
import java.util.Scanner;

public class SeriesManager {
    private ArrayList<SeriesModel> seriesList = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

// 1. Capture
public void CaptureSeries() {
    int id;
    while (true) {
        System.out.print("Enter series ID (numbers only): ");
        if (sc.hasNextInt()) {
            id = sc.nextInt();
            sc.nextLine(); // clear buffer
            break;
        } else {
            System.out.println("❌ Invalid input. Please enter numbers only.");
            sc.next(); // clear invalid input
        }
    }

    System.out.print("Enter series name: ");
    String name = sc.nextLine();

    // 🔎 Check duplicates (ID + Name)
    for (SeriesModel s : seriesList) {
        if (s.getSeriesId().equals(String.valueOf(id)) &&
            s.getSeriesName().equalsIgnoreCase(name)) {
            System.out.println("⚠ Series with same ID and Name already exists. Not added.");
            return;
        }
    }

    int age;
    while (true) {
        System.out.print("Enter age restriction (2–18): ");
        if (sc.hasNextInt()) {
            age = sc.nextInt();
            if (age >= 2 && age <= 18) {
                break;
            } else {
                System.out.println("Invalid range. Try again.");
            }
        } else {
            System.out.println("❌ Enter numbers only!");
            sc.next(); // clear invalid input
        }
    }

    int episodes;
    while (true) {
        System.out.print("Enter number of episodes: ");
        if (sc.hasNextInt()) {
            episodes = sc.nextInt();
            sc.nextLine(); // clear buffer
            if (episodes > 0) {
                break;
            } else {
                System.out.println("❌ Episodes must be greater than 0.");
            }
        } else {
            System.out.println("❌ Invalid input. Please enter numbers only.");
            sc.next(); // clear invalid input
        }
    }

    seriesList.add(new SeriesModel(String.valueOf(id), name, age, episodes));
    System.out.println("✅ Series processed successfully!");
}
    // 2. Search
    public void SearchSeries() {
        System.out.print("Enter series ID to search: ");
        String id = sc.nextLine();

        for (SeriesModel s : seriesList) {
            if (s.getSeriesId().equals(id)) {
                System.out.println("\n Found series:\n" + s);
                return;
            }
        }
        System.out.println("No series data found.");
    }

    // 3. Update age restriction
    public void UpdateSeries() {
        System.out.print("Enter series ID to update: ");
        String id = sc.nextLine();

        for (SeriesModel s : seriesList) {
            if (s.getSeriesId().equals(id)) {
                System.out.print("Enter new age restriction (2–18): ");
                int newAge = sc.nextInt();
                sc.nextLine();
                if (newAge >= 2 && newAge <= 18) {
                    s.setAgeRestriction(newAge);
                    System.out.println("️ Age restriction updated!");
                } else {
                    System.out.println(" Invalid age entered.");
                }
                return;
            }
        }
        System.out.println(" Series not found.");
    }

    // 4. Delete
    public void DeleteSeries() {
        System.out.print("Enter series ID to delete: ");
        String id = sc.nextLine();

        for (SeriesModel s : seriesList) {
            if (s.getSeriesId().equals(id)) {
                seriesList.remove(s);
                System.out.println("🗑️ Deleted series ID: " + id);
                return;
            }
        }
        System.out.println(" Series not found.");
    }

    // 5. Report
    public void SeriesReport() {
        System.out.println("\n===== SERIES REPORT =====");
        if (seriesList.isEmpty()) {
            System.out.println("No series available.");
        } else {
            for (int i = 0; i < seriesList.size(); i++) {
                System.out.println("Series " + (i + 1));
                System.out.println(seriesList.get(i));
                System.out.println("-------------------------------");
                
    
            }
        }
    }
}