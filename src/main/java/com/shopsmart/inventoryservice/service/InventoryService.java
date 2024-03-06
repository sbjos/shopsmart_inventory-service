package com.shopsmart.inventoryservice.service;

import com.shopsmart.inventoryservice.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InventoryService {

    private InventoryRepository inventoryRepository;

    public boolean isInStock(String skuCode) {
        return inventoryRepository.finBySkuCode(skuCode).isPresent();
    }
}
