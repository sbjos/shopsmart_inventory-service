package com.shopsmart.inventoryservice.controller;

import com.shopsmart.inventoryservice.dto.InventoryResponse;
import com.shopsmart.inventoryservice.service.InventoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.naming.InsufficientResourcesException;
import java.util.List;

@RestController
@RequestMapping(value = "/api/inventory")
@RequiredArgsConstructor
@Slf4j
public class InventoryController {

    private final InventoryService inventoryService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<InventoryResponse> stockAvailability(@RequestParam List<String> skuCode) throws InsufficientResourcesException {
        log.info("Received inventory check request for skuCode: {}", skuCode);
        return inventoryService.stockAvailability(skuCode);
    }
}
