package com.example.Weather.Service;


import com.example.Weather.Model.Inventory;
import com.example.Weather.Repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;

    // Fetch all inventories
    public List<Inventory> getAllInventories() {
        return inventoryRepository.findAll();
    }

    // Fetch an inventory by ID
    public Optional<Inventory> getInventoryById(String id) {
        return inventoryRepository.findById(id);
    }

    //create a new item ?
    // Add new inventory
    public Inventory addInventory(Inventory inventory) {
        return inventoryRepository.save(inventory);
    }
}
