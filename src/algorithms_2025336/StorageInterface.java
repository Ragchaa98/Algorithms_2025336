/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package algorithms_2025336;

import java.util.List;

/**
 *
 * @author Dorjragchaa Chuluunbaatar
 */

public interface StorageInterface {
    boolean isEmpty();  // Returns true if the storage has no items
    boolean isFull();   // Returns true if the storage has reached its maximum capacity
    int size();         // Returns the current number of items stored

    void addItem(FoodItem item);    // Adds a new food item into storage based on current mode (STACK or QUEUE)
    
    // Removes and returns the next item:
    // STACK → last added item (LIFO)
    // QUEUE → first added item (FIFO)
    FoodItem removeItem();
    
    // Returns the next item without removing it
    // (top for STACK, front for QUEUE)
    FoodItem peekItem();
    
    // Searches for a food item by its name (case-insensitive)
    // Returns the item if found, otherwise returns null
    FoodItem searchItem(String name);
    
    // Returns a list of all food items currently in storage
    // Used for displaying contents in GUI
    List<FoodItem> displayItems();

    // Sets the storage mode (STACK or QUEUE)
    void setMode(StorageMode mode);
    
    // Returns the current storage mode
    StorageMode getMode();
}
// Interface defining core storage operations for Stack and Queue

// Time complexity: O(n) - linear search through all items