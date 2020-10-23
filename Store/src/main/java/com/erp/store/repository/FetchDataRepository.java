package com.erp.store.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.erp.store.entity.UnitConversionMapping;
import com.erp.store.util.DataDTO;

@Repository
public interface FetchDataRepository extends JpaRepository<UnitConversionMapping, Long> {
	
	@Query(value = "select new com.erp.store.util.DataDTO(unit.name,unit.status,unit.description,uType.name,unconv.convertedTo.id,unconv.value) FROM UnitConversionMapping unconv join unconv.convertedFrom unit left join unit.unitType uType")
	List<DataDTO>fetchData();

}
