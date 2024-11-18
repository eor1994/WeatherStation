package com.example.Weather.Repository;
import com.example.Weather.Model.Inventory;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface InventoryRepository extends MongoRepository<Inventory, String> {
    //List<Inventory> findByID(String type); // Find clothes by type (e.g., shirt, pants, etc.)
}
