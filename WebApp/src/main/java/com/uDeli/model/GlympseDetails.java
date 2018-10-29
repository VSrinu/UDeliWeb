package com.uDeli.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@Table(name = "tmerchant")
@NamedStoredProcedureQueries({
	@NamedStoredProcedureQuery(name = "getorgdetails",procedureName = "pgetorgdetails",resultClasses = GlympseDetails.class)
})
public class GlympseDetails {
	
	public GlympseDetails() {
		
	}
	
	@NotBlank(message="Org Id cannot be blank")
	@Column(name="glympseorgid")
	private Integer glympseorgid;
	
	@NotBlank(message="Org Username cannot be blank")
	@Column(name="glympseusername")
	private String glympseusername;
	
	@NotBlank(message="Org Password cannot be blank")
	@Column(name="glympsepassword")
	private String glympsepassword;
	
	@Column(name="merchantid")
	private Integer merchantid;
	
	public GlympseDetails(Integer glympseorgid, String glympseusername, String glympsepassword, Integer merchantid) {
		super();
		
		this.glympseorgid = glympseorgid;
		this.glympseusername = glympseusername;
		this.glympsepassword = glympsepassword;
		this.merchantid = merchantid;
	}


	public Integer getGlympseorgid() {
		return glympseorgid;
	}

	public void setGlympseorgid(Integer glympseorgid) {
		this.glympseorgid = glympseorgid;
	}

	public String getGlympseusername() {
		return glympseusername;
	}

	public void setGlympseusername(String glympseusername) {
		this.glympseusername = glympseusername;
	}

	public String getGlympsepassword() {
		return glympsepassword;
	}

	public void setGlympsepassword(String glympsepassword) {
		this.glympsepassword = glympsepassword;
	}

	public Integer getMerchantid() {
		return merchantid;
	}
	
	public void setMerchantid(Integer merchantid) {
		this.merchantid = merchantid;
	}
}
