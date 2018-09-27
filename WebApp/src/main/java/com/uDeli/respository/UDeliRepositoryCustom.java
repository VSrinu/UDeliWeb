package com.uDeli.respository;

import java.util.List;

import com.uDeli.model.CarrierDetails;
import com.uDeli.model.GetUserProfile;
import com.uDeli.model.MerchantDetails;
import com.uDeli.model.NewOrderDetailsList;
import com.uDeli.model.OrderDetails;
import com.uDeli.model.OrderDetailsList;

public interface UDeliRepositoryCustom{
   
	public List<GetUserProfile> getUserProfile(GetUserProfile getUserProfile);

	public List<MerchantDetails> getAllMerchants();

	public void insertMerchantDetails(MerchantDetails merchantdetails,String action);

	public List<MerchantDetails> editMerchantDetails(Integer merchantId);

	void deleteMerchantDetails(Integer merchantId);
	
	public List<CarrierDetails> getCarriers(int mid);

	public List<NewOrderDetailsList> getNewOrders(int mid);

	public List<OrderDetailsList> getApprovedOrders(int mid);
	
	public List<OrderDetailsList> getClosedOrders(int mid);
	
	public void insertOrderDetails(OrderDetails orderdetails, String action,  Integer merchantid);

	public List<OrderDetails> editOrderDetails(Integer orderid);
	
	public void deleteOrderDetails(Integer orderId);

	public List<CarrierDetails> getApproveCarriers(int mid);

	public List<CarrierDetails> getDenyCarriers(int mid);

	public void newCarrier(CarrierDetails carrierDetails, int carrierid, int active);
	
	public void approveCarrier(CarrierDetails carrierDetails, int carrierid, int active);
	
	public void denyCarrier(CarrierDetails carrierDetails, int carrierid, int active);


	
}
