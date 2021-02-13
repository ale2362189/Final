package com.promineotech.storeApp.repostitory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.promineotech.storeApp.entity.Order;
import com.promineotech.storeApp.entity.Percentage;

public interface PercentageRepository extends JpaRepository<Percentage, Long>{

}
