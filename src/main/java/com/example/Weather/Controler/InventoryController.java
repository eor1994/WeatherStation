package com.example.Weather.Controler;
import com.example.Weather.Service.WeatherService;
import com.example.Weather.Model.Inventory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//api calls
@RestController
@RequestMapping("/api/inventory")

public class InventoryController {

    @Autowired
    private WeatherService inventoryService;

    //?
    // Get all inventories
    @GetMapping
    public List<Inventory> getAllInventories() {
        return inventoryService.getAllInventories();
    }

    //?
    // Get an inventory by ID
    @GetMapping("/{id}")
    public Optional<Inventory> getInventoryById(@PathVariable String id) {
        return inventoryService.getInventoryById(id);
    }

    //add new inventory ?
    // Add a new inventory
    @PostMapping
    public Inventory addInventory(@RequestBody Inventory inventory) {
        return inventoryService.addInventory(inventory);
    }
}
