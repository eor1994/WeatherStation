package com.example.Weather.Controler;
import com.example.Weather.Model.WeatherModel;
import com.example.Weather.Service.WeatherService;
import com.example.Weather.Model.Inventory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

//api calls
@RestController
@RequestMapping("/api/inventory")

public class InventoryController {
    static List<Inventory> list;

    @Autowired
    private WeatherService inventoryService;

    //?
    // Get all inventories
    @GetMapping
    public List<Inventory> getAllInventories() {
        return inventoryService.getAllInventories();
    }

    //?
    @GetMapping("/{id}")
    public List<Inventory> getInventoryById(@PathVariable String id) {
        Optional<Inventory> o = inventoryService.getInventoryById(id);
        list = o.stream().collect(Collectors.toList());
        System.out.println(list);
        return list;
    }

    //add new inventory ?
    // Add a new inventory
    @PostMapping
    public Inventory addInventory(@RequestBody Inventory inventory) {
        return inventoryService.addInventory(inventory);
    }

    public static List<Inventory> returnInventoryList(){
        return list;
    }
}
