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
	@NamedStoredProcedureQuery(name = "getneworders",procedureName = "pgetneworders",resultClasses = NewOrderDetailsList.class)
})

public class NewOrderDetailsList {
		
		public NewOrderDetailsList() {
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
	    private Integer totalweight;
	    private Integer fragile;
	    private Timestamp preferreddeliverytime; 
	    private Integer status;
	    private Integer storetocustlocation;
	    
	    public NewOrderDetailsList(Integer orderid, String ordertitle, String customername, String Address, String phonenumber, String email, Integer numberofbags,
	    				Integer totalitems, Integer perishable, Integer totalweight, Integer fragile, Timestamp preferreddeliverytime, Integer status,
	     Integer storetocustlocation) {
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

		public Integer getTotalweight() {
			return totalweight;
		}

		public void setTotalweight(Integer totalweight) {
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

		public Integer getStoretocustlocation() {
			return storetocustlocation;
		}

		public void setStoretocustlocation(Integer storetocustlocation) {
			this.storetocustlocation = storetocustlocation;
		}

	}
