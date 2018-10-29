package com.uDeli.model;




import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "tOrders") 
		@NamedStoredProcedureQueries({
		@NamedStoredProcedureQuery(name = "insertorder",procedureName = "pInsertOrder",resultClasses = OrderDetails.class),
        @NamedStoredProcedureQuery(name = "getorderdetailsbyid",procedureName = "pgetorderdetailsbyid",resultClasses = OrderDetails.class),
		@NamedStoredProcedureQuery(name = "updateorder",procedureName = "pupdateOrder",resultClasses = OrderDetails.class),
		@NamedStoredProcedureQuery(name = "deleteorder",procedureName = "pdeleteorder",resultClasses = OrderDetails.class)
})

public class OrderDetails {
	
	public OrderDetails() {
	}
	
	@Id
	@GeneratedValue
	@Column(name="orderid")
	private Integer orderid;
	
	@Column(name="merchantid")
	private Integer merchantid;
	
	@NotBlank(message="Ordertitle cannot be blank.")
	@Column(name="ordertitle")
	private String ordertitle;
	
	@NotBlank(message="Orderdetails cannot be blank.")
	@Column(name="orderdetails")
	private String orderdetails;
	
	@NotBlank(message="Customername cannot be blank.")
	@Column(name="customername")
	private String customername;
	
	@NotBlank(message="Address cannot be blank.")
	private String address;
	
	@NotBlank(message="City cannot be blank.")
    private String city;
	
	@NotBlank(message="State cannot be blank.")
    private String state;
	
	@NotBlank(message="Zip cannot be blank.")
    private String zip;
	
	@NotBlank(message="Phonenumber cannot be blank.")
    private String phonenumber;
	
	@NotBlank(message="Email cannot be blank.")
    private String email;
    
    @NotBlank(message="Numberofbags cannot be blank.")
    private Integer numberofbags;
    
    @NotBlank(message="Totalitems cannot be blank.")
    private Integer totalitems;
    
    @NotBlank(message="Totalitems cannot be blank.")
    private Integer perishable;
    
    @NotBlank(message="Totalweight cannot be blank.")
    private Float totalweight;
    
    @NotBlank(message="Fragile cannot be blank.")
    private Integer fragile;
    
    @NotBlank(message="Preferreddeliverytime cannot be blank.")
    private Timestamp preferreddeliverytime; 
    
    private Integer status;
    
    @NotBlank(message="Storetocustlocation cannot be blank.")
    private Float storetocustlocation;
	
   	public OrderDetails(Integer orderid, Integer merchantid, String ordertitle, String orderdetails, String customername, String address, String city, String state,
    String zip, String phonenumber, String email, Integer numberofbags, Integer totalitems, Float totalweight,  Integer perishable, Integer fragile, 
    Timestamp preferreddeliverytime, Integer status, Float storetocustlocation) {
    	super();
    	
    	this.orderid = orderid;
    	this.merchantid = merchantid;
    	this.ordertitle = ordertitle;
    	this.orderdetails = orderdetails;
    	this.customername = customername;
    	this.address = address;
    	this.city = city;
    	this.state = state;
    	this.zip = zip;
    	this.phonenumber = phonenumber;
    	this.email = email;
    	this.numberofbags = numberofbags;
    	this.totalitems = totalitems;
    	this.totalweight = totalweight;
    	this.perishable = perishable;
    	this.fragile = fragile;
    	this.preferreddeliverytime = preferreddeliverytime;
    	this.status = status;
    	this.storetocustlocation = storetocustlocation;
    	/*this.distance = distance;*/
    	
    }

	public Integer getOrderid() {
		return orderid;
	}

	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}

	public Integer getMerchantid() {
		return merchantid;
	}

	public void setMerchantid(Integer merchantid) {
		this.merchantid = merchantid;
	}

	public String getOrdertitle() {
		return ordertitle;
	}

	public void setOrdertitle(String ordertitle) {
		this.ordertitle = ordertitle;
	}

	public String getOrderdetails() {
		return orderdetails;
	}

	public void setOrderdetails(String orderdetails) {
		this.orderdetails = orderdetails;
	}

	public String getCustomername() {
		return customername;
	}

	public void setCustomername(String customername) {
		this.customername = customername;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	} 

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
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

	public Float getTotalweight() {
		return totalweight;
	}

	public void setTotalweight(Float totalweight) {
		this.totalweight = totalweight;
	}

	public Integer getPerishable() {
		return perishable;
	}

	public void setPerishable(Integer perishable) {
		this.perishable = perishable;
	}

	public Integer getFragile() {
		return fragile;
	}

	public void setFragile(Integer fragile) {
		this.fragile = fragile;
	}

	public Timestamp getPreferreddeliverytime() {
		return preferreddeliverytime;
	}

	public void setPreferreddeliverytime(Timestamp preferreddeliverytime) {
		this.preferreddeliverytime = preferreddeliverytime;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Float getStoretocustlocation() {
		return storetocustlocation;
	}

	public void setStoretocustlocation(Float storetocustlocation) {
		this.storetocustlocation = storetocustlocation;
	}
    
    
}
