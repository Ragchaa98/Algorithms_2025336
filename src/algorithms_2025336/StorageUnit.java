/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package algorithms_2025336;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 *
 * @author Dorjragchaa Chuluunbaatar
 */

/**
 * Storage unit using Deque.
 * STACK mode: add front, remove front
 * QUEUE mode: add rear, remove front
 */

public class StorageUnit implements StorageInterface {
    private final Deque<FoodItem> storage;  // Deque is used to support both stack and queue operations efficiently
    private final int MAX_CAPACITY = 8;     // Maximum number of items allowed in storage
    private StorageMode mode;               // Determines whether the storage behaves as STACK or QUEUE

    public StorageUnit(StorageMode mode) {
        this.storage = new ArrayDeque<>();  // ArrayDeque provides fast add/remove operations
        this.mode = mode;
    }

    // Checks if the storage is empty
    @Override
    public boolean isEmpty() {
        return storage.isEmpty();
    }

    // Checks if storage has reached maximum capacity
    @Override
    public boolean isFull() {
        return storage.size() >= MAX_CAPACITY;
    }

    // Returns the current number of items in storage
    @Override
    public int size() {
        return storage.size();
    }

    // Adds a food item to storage based on selected mode (STACK or QUEUE)
    @Override
    public void addItem(FoodItem item) {
        
        // Prevent null values from being added
        if (item == null) {
            throw new IllegalArgumentException("Food item cannot be null.");
        }

        // Prevent adding items when storage is full
        if (isFull()) {
            throw new IllegalStateException("Storage is full. Maximum capacity is 8 items.");
        }

        // STACK → LIFO → add to front
        if (mode == StorageMode.STACK) {
            storage.addFirst(item);
        }
        
        // QUEUE → FIFO → add to end
        else {
            storage.addLast(item);
        }
    }

    // Removes and returns the next item based on FIFO/LIFO behavior
    @Override
    public FoodItem removeItem() {
        // Cannot remove from empty storage
        if (isEmpty()) {
            throw new IllegalStateException("Storage is empty. No item to remove.");
        }
        // Always removes from front:
        // STACK → top item
        // QUEUE → first inserted item
        return storage.removeFirst();
    }

    // Returns the next item without removing it
    @Override
    public FoodItem peekItem() {
        
        // Cannot peek if storage is empty
        if (isEmpty()) {
            throw new IllegalStateException("Storage is empty. No item at the top/front.");
        }
        return storage.peekFirst();
    }

    // Searches for a food item by name
    @Override
    public FoodItem searchItem(String name) {
        
        // Validate input
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Search name cannot be empty.");
        }

        // Iterate through storage to find matching item
        for (FoodItem item : storage) {
            if (item.getName().equalsIgnoreCase(name.trim())) {
                return item;
            }
        }
        
        // Return null if no match found
        return null;
    }

    // Returns a copy of all items in storage
    @Override
    public List<FoodItem> displayItems() {
        
        // Return new ArrayList to protect internal structure
        return new ArrayList<>(storage);
    }

    // Sets storage mode (STACK or QUEUE)
    @Override
    public void setMode(StorageMode mode) {
        if (mode == null) {
            throw new IllegalArgumentException("Mode cannot be null.");
        }
        this.mode = mode;
    }

    // Returns current storage mode
    @Override
    public StorageMode getMode() {
        return mode;
    }

    // Returns maximum capacity of storage
    public int getMaxCapacity() {
        return MAX_CAPACITY;
    }
}
// StorageUnit implements both Stack and Queue using Deque

// Time complexity: O(1) - add to front (STACK) or rear (QUEUE)