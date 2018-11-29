package com.uDeli.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.Table;

@Entity
@Table(name = "tOrderToCarriers") 
		@NamedStoredProcedureQueries({
		@NamedStoredProcedureQuery(name = "getDeviceDetails",procedureName = "pgetDeviceDetails",resultClasses = PushNotification.class),
		@NamedStoredProcedureQuery(name = "updateOrderNotification",procedureName = "pupdateOrderNotification",resultClasses = PushNotification.class)
})

public class PushNotification {
	
	public PushNotification() {
	}
	
	@Id
	//private Integer carrierid;
	private Integer orderid;
	private String name;
	private String ordertitle;
	private String orderdetails;
	private String devicetoken;
	/*private String message;
	private String type;*/
	/*private Integer status_notification;*/
	
	public PushNotification( Integer orderid, String name, String ordertitle, String orderdetails, String devicetoken) {
		super();
		
		//this.carrierid = carrierid;
		this.orderid = orderid;
		this.name = name;
		this.ordertitle = ordertitle;
		this.orderdetails = orderdetails;
		this.devicetoken = devicetoken;
		/*this.message = message;
		this.type = type;*/
		/*this.status_notification = status_notification;*/
	}

	/*public Integer getCarrierid() {
		return carrierid;
	}

	public void setCarrierid(Integer carrierid) {
		this.carrierid = carrierid;
	}*/

	public Integer getOrderid() {
		return orderid;
	}

	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getDevicetoken() {
		return devicetoken;
	}

	public void setDevicetoken(String devicetoken) {
		this.devicetoken = devicetoken;
	}

	/*public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}*/

	/*public Integer getStatus_notification() {
		return status_notification;
	}

	public void setStatus_notification(Integer status_notification) {
		this.status_notification = status_notification;
	}*/
	
}
