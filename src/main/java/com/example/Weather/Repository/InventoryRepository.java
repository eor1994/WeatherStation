package com.example.Weather.Repository;
import com.example.Weather.Model.Inventory;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface InventoryRepository
        extends MongoRepository<Inventory, String> {
}
