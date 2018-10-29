package com.uDeli.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "tOrders") 
@NamedStoredProcedureQueries({
	@NamedStoredProcedureQuery(name = "getneworders",procedureName = "pgetneworders",resultClasses = NewOrderDetailsList.class),
	@NamedStoredProcedureQuery(name = "distanceMatrix",procedureName = "pDistanceMatrix",resultClasses = NewOrderDetailsList.class)
})

public class NewOrderDetailsList {
		
		public NewOrderDetailsList() {
		}
		@Id
		private Integer orderid;
		
		@NotBlank(message="Ordertitle cannot be blank")
		@Column(name="ordertitle")
		private String ordertitle;
		
		@NotBlank(message="Customername cannot be blank")
		@Column(name="customername")
		private String customername;
		
		@NotBlank(message="Address cannot be blank")
		private String Address;
		
		@NotBlank(message="Phone Number cannot be blank")
	    private String phonenumber;
		
		@NotBlank(message="email cannot be blank")
	    private String email;
		
		@NotBlank(message="Numberofbags cannot be blank")
	    private Integer numberofbags;
		
		@NotBlank(message="Totalitems cannot be blank")
	    private Integer totalitems;
		
		@NotBlank(message="Address cannot be blank")
	    private Integer perishable;
		
		@NotBlank(message="Totalweight cannot be blank")
	    private Float totalweight;
		
		@NotBlank(message="Address cannot be blank")
	    private Integer fragile;
		
		@NotBlank(message="Preferreddeliverytime cannot be blank")
	    private Timestamp preferreddeliverytime; 
		
	    private Integer status;
		
		@NotBlank(message="Storetocustlocation cannot be blank")
	    private Float storetocustlocation;
	    
	    public NewOrderDetailsList(Integer orderid, String ordertitle, String customername, String Address, String phonenumber, String email, Integer numberofbags,
	    				Integer totalitems, Integer perishable, Float totalweight, Integer fragile, Timestamp preferreddeliverytime, Integer status,
	    				Float storetocustlocation) {
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
			this.preferreddeliverytime = preferreddeliverytime;
			this.status = status;
			this.storetocustlocation = storetocustlocation;
				
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
