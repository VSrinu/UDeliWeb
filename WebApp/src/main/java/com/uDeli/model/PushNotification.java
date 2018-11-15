package com.uDeli.model;

import javax.persistence.Entity;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.Table;

@Entity
@Table(name = "tOrders") 
		@NamedStoredProcedureQueries({
		@NamedStoredProcedureQuery(name = "getDeviceDetails",procedureName = "pgetDeviceDetails",resultClasses = OrderDetails.class)
})

public class PushNotification {
	
	public PushNotification() {
	}
	
	private Integer orderid;
	private Integer merchantid;
	private String ordertitle;
	private String orderdetails;
	private String devicetoken;
	private String message;
	private String type;
	private Integer status_notification;
	
	public PushNotification(Integer orderid, Integer merchantid, String ordertitle, String orderdetails, String devicetoken, 
			String message, String type, Integer status_notification) {
		super();
		
		this.orderid = orderid;
		this.merchantid = merchantid;
		this.ordertitle = ordertitle;
		this.orderdetails = orderdetails;
		this.message = message;
		this.type = type;
		this.status_notification = status_notification;
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

	public String getDevicetoken() {
		return devicetoken;
	}

	public void setDevicetoken(String devicetoken) {
		this.devicetoken = devicetoken;
	}

	public String getMessage() {
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
	}

	public Integer getStatus_notification() {
		return status_notification;
	}

	public void setStatus_notification(Integer status_notification) {
		this.status_notification = status_notification;
	}
	
}
