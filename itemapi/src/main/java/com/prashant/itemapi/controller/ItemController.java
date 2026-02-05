package com.prashant.itemapi.controller;

import com.prashant.itemapi.model.Item;
import com.prashant.itemapi.service.ItemService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    // Add Item
    @PostMapping
    public ResponseEntity<Item> addItem(@Valid @RequestBody Item item) {

        Item savedItem = itemService.addItem(item);

        return new ResponseEntity<>(savedItem, HttpStatus.CREATED);
    }

    // Get Item by ID
    @GetMapping("/{id}")
    public ResponseEntity<Item> getItem(@PathVariable Long id) {

        Item item = itemService.getItemById(id);

        if (item == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok(item);
    }

    // Get All (Optional)
    @GetMapping
    public List<Item> getAll() {
        return itemService.getAllItems();
    }
}
