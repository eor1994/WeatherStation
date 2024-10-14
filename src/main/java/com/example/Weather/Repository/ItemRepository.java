package com.example.Weather.Repository;

import com.example.Weather.Model.Item;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ItemRepository extends MongoRepository<Item, String> {

}
