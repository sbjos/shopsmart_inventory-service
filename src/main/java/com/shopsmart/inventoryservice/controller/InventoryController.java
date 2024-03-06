package com.shopsmart.inventoryservice.controller;

import com.shopsmart.inventoryservice.service.InventoryService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/inventory")
public class InventoryController {

    private InventoryService inventoryService;

    @GetMapping(value = "/skucode")
    @ResponseStatus(HttpStatus.OK)
    public boolean isInStock(@PathVariable String skuCode) {
        return inventoryService.isInStock(skuCode);
    }
}
