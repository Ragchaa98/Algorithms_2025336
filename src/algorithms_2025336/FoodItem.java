/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package algorithms_2025336;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 *
 * @author Dorjragchaa Chuluunbaatar
 */

public abstract class FoodItem {
    private String name;                // Name of the food item (e.g., Burger, Pizza)
    private int weight;                 // Weight of the food item in grams
    private LocalDate bestBeforeDate;   // Expiry date (must be within 2 weeks and not in the past)
    private LocalDateTime placedTime;   // Timestamp when the item was added to storage

    public FoodItem(String name, int weight, LocalDate bestBeforeDate) {
        setName(name);                          // Use setter to enforce validation
        setWeight(weight);                      // Use setter to enforce validation
        setBestBeforeDate(bestBeforeDate);      // Validate expiry rules
        this.placedTime = LocalDateTime.now();  // Automatically set current time
    }

    // Returns the name of the food item
    public String getName() {
        return name;
    }

    // Sets the food name with validation (cannot be null or empty)
    public final void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Food name cannot be empty.");
        }
        // Remove unnecessary spaces
        this.name = name.trim();
    }

    // Returns the weight of the food item
    public int getWeight() {
        return weight;
    }

    // Sets weight with validation (must be greater than 0)
    public final void setWeight(int weight) {
        if (weight <= 0) {
            throw new IllegalArgumentException("Weight must be greater than 0 grams.");
        }
        this.weight = weight;
    }

    // Returns the best-before date
    public LocalDate getBestBeforeDate() {
        return bestBeforeDate;
    }

    // Sets best-before date with validation rules
    public final void setBestBeforeDate(LocalDate bestBeforeDate) {
        
        // Prevent null values
        if (bestBeforeDate == null) {
            throw new IllegalArgumentException("Best-before date cannot be null.");
        }

        LocalDate today = LocalDate.now();

        // Prevent past dates
        if (bestBeforeDate.isBefore(today)) {
            throw new IllegalArgumentException("Best-before date cannot be in the past.");
        }

        // Restrict expiry to within 2 weeks (business rule)
        if (bestBeforeDate.isAfter(today.plusWeeks(2))) {
            throw new IllegalArgumentException("Best-before date must be within 2 weeks from today.");
        }

        this.bestBeforeDate = bestBeforeDate;
    }

    // Returns the timestamp when the item was placed in storage
    public LocalDateTime getPlacedTime() {
        return placedTime;
    }

    // Returns the specific type of food
    // Uses runtime class name instead of storing manually
    public String getFoodType() {
        return this.getClass().getSimpleName();
    }

    // Returns formatted string representation of the food item
    // Used for displaying data in GUI
    @Override
    public String toString() {
        return "Type: " + getFoodType()
                + ", Name: " + name
                + ", Weight: " + weight + "g"
                + ", Best Before: " + bestBeforeDate
                + ", Placed Time: " + placedTime;
    }
}
// Abstract base class for all food items in the restaurant storage system

// Validates date is not in the past and within 2 weeks