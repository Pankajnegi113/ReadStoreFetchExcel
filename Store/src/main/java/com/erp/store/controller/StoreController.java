package com.erp.store.controller;

import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.erp.store.service.StoreService;
import com.erp.store.util.DataDTO;

@RestController
public class StoreController {
	
	@Autowired
	StoreService storeService;
	
	//fetch data from the database and return as response data same as in excel sheet
	@RequestMapping(value="/fetch",method = RequestMethod.GET)
	public ResponseEntity<List<DataDTO>> fetch() throws IOException
	{
		List<DataDTO> response = storeService.getData();
		System.out.println(response);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	
	//stores excel data to the database
	@RequestMapping(value="/excelToDB",method = RequestMethod.POST)
	public ResponseEntity<String> excelToDBSave() throws IOException
	{
		String excelFile = "E:\\MAIN_Assignment\\unit1.xlsx";
		storeService.excelToDB(excelFile);
		return new ResponseEntity<>("Data Added to DB successfully", HttpStatus.CREATED);
	}
	
	
	

}
