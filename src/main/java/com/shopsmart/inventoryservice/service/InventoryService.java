package com.shopsmart.inventoryservice.service;

import com.shopsmart.inventoryservice.dto.InventoryResponse;
import com.shopsmart.inventoryservice.model.Inventory;
import com.shopsmart.inventoryservice.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    @Transactional(readOnly = true)
    public List<InventoryResponse> stockAvailability(List<String> skuCode) {
        log.info("Received inventory check request for skuCode: {}", skuCode);
        List<Inventory> inventoryList = inventoryRepository.findBySkuCodeIn(skuCode);

        log.info("Retrieved inventory");

        return inventoryList.stream()
                .map(inventory -> InventoryResponse.builder()
                        .skuCode(inventory.getSkuCode())
                        .inStock(inventory.getQuantity())
                        .build())
                .toList();
    }
}
