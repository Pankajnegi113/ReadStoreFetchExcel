package com.erp.store.serviceImpl;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erp.store.entity.Unit;
import com.erp.store.entity.UnitConversionMapping;
import com.erp.store.entity.UnitType;
import com.erp.store.repository.FetchDataRepository;
import com.erp.store.repository.UnitConvRepository;
import com.erp.store.repository.UnitRepository;
import com.erp.store.repository.UnitTypeRepository;
import com.erp.store.service.StoreService;
import com.erp.store.util.DataDTO;

@Service
public class StoreServiceImp implements StoreService {

	
	@Autowired
	UnitRepository unitRepository;
	
	@Autowired
	UnitTypeRepository unitTypeRepository;
	
	
	@Autowired
	UnitConvRepository unitConvRepository;
	
	@Autowired
	FetchDataRepository fetchRepository;
	
	//reads excel and store its data to the database table
	@Override
	public void excelToDB(String excel) throws IOException {
		File excelFile = new File(excel);
		FileInputStream fis = new FileInputStream(excelFile);
		Workbook workbook = new XSSFWorkbook(fis);
		Sheet sheet = workbook.getSheetAt(0);
		Iterator<Row> rowIt = sheet.iterator();
		rowIt.next();
		while (rowIt.hasNext()) {
			Row row = rowIt.next();
			Iterator<Cell> cellIterator = row.cellIterator();
			HashMap<Integer, String> map = new HashMap<>();
			int index = 0;
			while (cellIterator.hasNext()) {
				Cell cell = cellIterator.next();
				map.put(index, cell.toString());
				index++;
			}

			// storing excel data into Unit table
			Unit unit = new Unit();
			unit.setName(map.get(0));
			if (map.get(1).equals("1"))
				unit.setStatus(true);
			unit.setDescription(map.get(2));

			// storing excel data into UnitType table
			UnitType unitType = new UnitType();
			unitType.setName(map.get(3));
			UnitType storedType = unitTypeRepository.save(unitType);
			unit.setUnitType(storedType);
			Unit storedUnit = unitRepository.save(unit);

			// storing excel data into UnitCoversion Mapping table
			UnitConversionMapping unitConv = new UnitConversionMapping();
			unitConv.setConvertedFrom(storedUnit);
			if (map.get(4) != null) {
				String[] parts = map.get(4).split("\\.");
				if (parts.length > 1) {
					Unit u = new Unit();
					u.setId(Long.parseLong(parts[0]) - 1);
					unitConv.setConvertedTo(u);
				}
			}
			if (map.get(5) != "" && map.get(5) != null)
				unitConv.setValue(Double.parseDouble(map.get(5)));
			unitConvRepository.save(unitConv);
		}

		workbook.close();
		fis.close();
	}


	//fetches data from database and represent as in Excel
	@Override
	public List<DataDTO> getData() 
	{
		List<DataDTO> res = fetchRepository.fetchData();
		return res;
	}

}
