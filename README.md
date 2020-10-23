# ReadStoreFetchExcel- Two Api's are there

## 1) An API to import an excel sheet

 <li> a) Unit Name, status, description will store in the unit table.
 <li> b) The type is already present in the unit_type table or not. If not present create a entry in unit_type table and store the id of row in the unit table as unit_type.
 <li> c) ConversionUid column contains the row number for eg:- 3 that means 3rd row in the excel sheet. 
	So you need to map the id from the database of the current row and ConversionUid column row (i.e 3rd-row id from database) 
	in the unit_conversion_mapping table as conversion_from is the id of the current row and conversion_to is the id of ConversionUid row and
 	value as conversion value from the excel sheet.</li>

## 2) An API to get a list of units in the same structure as given in the excel file.
