package com.shopsmart.inventoryservice;

import com.shopsmart.inventoryservice.model.Inventory;
import com.shopsmart.inventoryservice.repository.InventoryRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;

// Integration Test
@SpringBootTest
class InventoryServiceApplicationTests {

//	@Test
//	void contextLoads() {
//	}

	@Bean
	public CommandLineRunner loadData(InventoryRepository inventoryRepository) {
		return args -> {
			Inventory inventory = new Inventory();
			inventory.setSkuCode("test 1");
			inventory.setQuantity(5);

			Inventory inventory1 = new Inventory();
			inventory.setSkuCode("test 2");
			inventory.setQuantity(4);
		};
	}
}
