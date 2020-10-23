package com.erp.store.service;

import java.io.IOException;
import java.util.List;

import com.erp.store.entity.Unit;
import com.erp.store.util.DataDTO;

public interface StoreService {
	
	public void excelToDB(String excelFile) throws IOException;

	public List<DataDTO>getData();

}
