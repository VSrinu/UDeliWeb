package com.uDeli.respository;

import java.util.List;

import com.uDeli.model.CarrierDetails;
import com.uDeli.model.GetUserProfile;
import com.uDeli.model.MerchantDetails;
import com.uDeli.model.OrderDetails;
import com.uDeli.model.OrderDetailsList;

public interface CarrierDetailsRepositoryCustom{
     
	public List<CarrierDetails> getCarriers(int mid);

	/*public List<OrderDetailsList> getAllOrders(int mid);

	public void insertOrderDetails(OrderDetails orderdetails, String action);

	public List<OrderDetails> editOrderDetails(Integer orderid);
	
	public void deleteOrderDetails(Integer orderId);*/

	public List<CarrierDetails> getApproveCarriers(int mid);

	public List<CarrierDetails> getDenyCarriers(int mid);

	public void newCarrier(CarrierDetails carrierDetails, int carrierid, int active);
	
	public void approveCarrier(CarrierDetails carrierDetails, int carrierid, int active);
	
	public void denyCarrier(CarrierDetails carrierDetails, int carrierid, int active);
	
}
