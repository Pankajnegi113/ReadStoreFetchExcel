package com.erp.store.util;

public class DataDTO {
	private String unitName;
	private Integer status;
	private String description;
	private String type;
	private Long convsersionId;
	private Double conversionValue;
	
	public DataDTO(String unitName, boolean status, String description, String type, Long convsersionId,
			Double conversionValue) {
		this.unitName = unitName;
		if(status)
			this.status = 1;
		else
			this.status = 0;
		this.description = description;
		this.type = type;
		this.convsersionId = convsersionId;
		this.conversionValue = conversionValue;
	}
	

	
	public String getUnitName() {
		return unitName;
	}
	
	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}
	
	public Integer getStatus() {
		return status;
	}
	
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public Long getConvsersionId() {
		return convsersionId;
	}
	
	public void setConvsersionId(Long convsersionId) {
		this.convsersionId = convsersionId;
	}
	
	public Double getConversionValue() {
		return conversionValue;
	}
	
	public void setConversionValue(Double conversionValue) {
		this.conversionValue = conversionValue;
	}

}
