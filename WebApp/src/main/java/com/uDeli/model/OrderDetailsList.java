package com.uDeli.model;



import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.Table;

@Entity
@Table(name = "tOrders") 
@NamedStoredProcedureQueries({
	@NamedStoredProcedureQuery(name = "getapprovedorders",procedureName = "pgetapprovedorders",resultClasses = OrderDetailsList.class),
	@NamedStoredProcedureQuery(name = "getclosedorders",procedureName = "pgetclosedorders",resultClasses = OrderDetailsList.class)
	
})


public class OrderDetailsList {
	
	public OrderDetailsList() {
	}
	@Id
	private Integer orderid;
	
	@Column(name="ordertitle")
	private String ordertitle;
	
	@Column(name="customername")
	private String customername;
	
	private String Address;
    private String phonenumber;
    private String email;
    private Integer numberofbags;
    private Integer totalitems;
    private Integer perishable;
    private Float totalweight;
    private Integer fragile;
    private String pref_date; 
	private String acce_date; 
    private String deli_date; 
    private String stutes_text;
    private Float storetocustlocation;
    private String carrier_name;
    
    public OrderDetailsList(Integer orderid, String ordertitle, String customername, String Address, String phonenumber, String email, Integer numberofbags,
    				Integer totalitems, Integer perishable, Float totalweight, Integer fragile, String pref_date, String acce_date,
    				String deli_date, String stutes_text, Float storetocustlocation, String carrier_name) {
		super();
		this.orderid = orderid;
		this.ordertitle = ordertitle;
		this.customername = customername;
		this.Address = Address;
		this.phonenumber = phonenumber;
		this.email = email;
		this.numberofbags = numberofbags;
		this.totalitems = totalitems;
		this.perishable = perishable;
		this.totalweight = totalweight;
		this.fragile = fragile;
		this.pref_date = pref_date;
		this.acce_date = acce_date;
		this.deli_date = deli_date;
		this.stutes_text = stutes_text;
		this.storetocustlocation = storetocustlocation;
		this.carrier_name = carrier_name;
			
	}

	public Integer getOrderid() {
		return orderid;
	}

	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}

	public String getOrdertitle() {
		return ordertitle;
	}

	public void setOrdertitle(String ordertitle) {
		this.ordertitle = ordertitle;
	}

	public String getCustomername() {
		return customername;
	}

	public void setCustomername(String customername) {
		this.customername = customername;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		this.Address = address;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getNumberofbags() {
		return numberofbags;
	}

	public void setNumberofbags(Integer numberofbags) {
		this.numberofbags = numberofbags;
	}

	public Integer getTotalitems() {
		return totalitems;
	}

	public void setTotalitems(Integer totalitems) {
		this.totalitems = totalitems;
	}

	public Integer getPerishable() {
		return perishable;
	}

	public void setPerishable(Integer perishable) {
		this.perishable = perishable;
	}

	public Float getTotalweight() {
		return totalweight;
	}

	public void setTotalweight(Float totalweight) {
		this.totalweight = totalweight;
	}

	public Integer getFragile() {
		return fragile;
	}

	public void setFragile(Integer fragile) {
		this.fragile = fragile;
	}

	public String getStutes_text() {
		return stutes_text;
	}

	public void setStutes_text(String stutes_text) {
		this.stutes_text = stutes_text;
	}

	public Float getStoretocustlocation() {
		return storetocustlocation;
	}

	public void setStoretocustlocation(Float storetocustlocation) {
		this.storetocustlocation = storetocustlocation;
	}

	public String getCarrier_name() {
		return carrier_name;
	}

	public void setCarrier_name(String carrier_name) {
		this.carrier_name = carrier_name;
	}

	public String getPref_date() {
		return pref_date;
	}

	public void setPref_date(String pref_date) {
		this.pref_date = pref_date;
	}

	public String getAcce_date() {
		return acce_date;
	}

	public void setAcce_date(String acce_date) {
		this.acce_date = acce_date;
	}

	public String getDeli_date() {
		return deli_date;
	}

	public void setDeli_date(String deli_date) {
		this.deli_date = deli_date;
	}
	
}
