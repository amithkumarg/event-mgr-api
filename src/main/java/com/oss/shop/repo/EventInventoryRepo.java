package com.oss.shop.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.oss.shop.model.EventInventory;

@Repository
public interface EventInventoryRepo extends JpaRepository<EventInventory, Integer> {
	
	List<EventInventory> findByEventCode(String eventCode);
	
	@Query(value = "SELECT COUNT(inventory_id) FROM lnevent.event_inventory"
			+ " WHERE event_code = COALESCE(?1, event_code)"
			+ " AND available = COALESCE(?2, available)"
			+ " AND seat_type = COALESCE(?3, seat_type)"
			+ " AND aisle = COALESCE(?4, aisle)", nativeQuery = true)
	int count(String eventCode, Boolean available, String seatType, Boolean aisle);

}
