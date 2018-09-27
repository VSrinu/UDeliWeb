package com.uDeli.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.Table;

@Entity
@Table(name = "tCarrier")
@NamedStoredProcedureQueries({
    @NamedStoredProcedureQuery(name = "getcarriers",procedureName = "pgetcarriers",resultClasses = CarrierDetails.class),
    @NamedStoredProcedureQuery(name = "updatecarriers",procedureName = "pupdatecarrier",resultClasses = CarrierDetails.class),
    @NamedStoredProcedureQuery(name = "approvecarriers",procedureName = "pgetApproveCarriers",resultClasses = CarrierDetails.class),
    @NamedStoredProcedureQuery(name = "denycarriers",procedureName = "pgetDenyCarriers",resultClasses = CarrierDetails.class)
})


public class CarrierDetails {
	
	public CarrierDetails() {
	}
	@Column(name="merchantid")
	private Integer merchantid;
	@Id
	private String id;
	private Integer carrierid;
	private String name;
	private String address;
	private String emailid;
	private String phonenumber;
	private Character active;
	
	public CarrierDetails(String id, Integer carrierid, String name, String address, String emailid, String phonenumber, Integer merchantid, Character active) {
		super();
		this.id = id;
		this.carrierid = carrierid;
		this.name = name;
		this.address = address;
		this.emailid = emailid;
		this.phonenumber = phonenumber;
		this.merchantid = merchantid;
		this.active = active;
		
	}
	
	
	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public Integer getCarrierid() {
		return carrierid;
	}


	public void setCarrierid(Integer carrierid) {
		this.carrierid = carrierid;
	}

	
	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getEmailid() {
		return emailid;
	}


	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}


	public String getPhonenumber() {
		return phonenumber;
	}


	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}


	public Integer getMerchantid() {
		return merchantid;
	}


	public void setMerchantid(Integer merchantid) {
		this.merchantid = merchantid;
	}


	public Character getActive() {
		return active;
	}


	public void setActive(Character active) {
		this.active = active;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


}