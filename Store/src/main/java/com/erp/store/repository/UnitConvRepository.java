package com.erp.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.erp.store.entity.UnitConversionMapping;

public interface UnitConvRepository extends JpaRepository<UnitConversionMapping, Long> {

}
