package com.uDeli.respository;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import com.uDeli.model.CarrierDetails;
import com.uDeli.model.GetUserProfile;
import com.uDeli.model.MerchantDetails;
import com.uDeli.model.NewOrderDetailsList;
import com.uDeli.model.OrderDetails;
import com.uDeli.model.OrderDetailsList;
import com.uDeli.model.ProfileDetails;
import com.uDeli.model.PushNotification;
import com.uDeli.utils.UDeliConstants;

public class UDeliRepositoryImpl implements UDeliRepositoryCustom{

	@PersistenceContext
    private EntityManager em;
	
	StoredProcedureQuery spQuery;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<GetUserProfile> getUserProfile(GetUserProfile getuserprofile) {
		
		   StoredProcedureQuery spQuery =
		              em.createNamedStoredProcedureQuery("getuserprofile");
		   spQuery.registerStoredProcedureParameter(0, String.class, ParameterMode.IN);
		   spQuery.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		   System.out.println("get username" + getuserprofile.getUsername());
		   System.out.println("get username" + getuserprofile.getPlaintextpass());
		   spQuery.setParameter(0,getuserprofile.getUsername());
		   spQuery.setParameter(1,getuserprofile.getPlaintextpass());
		   List<GetUserProfile> userDetailsList = spQuery.getResultList(); 
		   return userDetailsList;
	} 
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<MerchantDetails> getAllMerchants() {
		
		   StoredProcedureQuery spQuery =
		              em.createNamedStoredProcedureQuery("getallmerchants");
		   List<MerchantDetails> userDetailsList = spQuery.getResultList();
		   return userDetailsList;
	} 
	 
	@Override
	public void insertMerchantDetails(MerchantDetails merchantdetails,String action) {
		System.out.println(" Inside UDeliRepositoryImpl..insertMerchantDetails --------- Enter------"); 
		System.out.println("Action------"+action);
			if(action.equals("insert"))
			{
				spQuery =  em.createNamedStoredProcedureQuery("pinsertmerchant");
			}
			else if(action.equals("update"))
			{
				spQuery =  em.createNamedStoredProcedureQuery("updatemerchant");
			}
				            
		   spQuery.registerStoredProcedureParameter(0, String.class, ParameterMode.IN);
		   spQuery.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		   spQuery.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		   spQuery.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
		   spQuery.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);
		   spQuery.registerStoredProcedureParameter(5, String.class, ParameterMode.IN);
		   spQuery.registerStoredProcedureParameter(6, String.class, ParameterMode.IN);
		   spQuery.registerStoredProcedureParameter(7, String.class, ParameterMode.IN);
		   spQuery.registerStoredProcedureParameter(8, String.class, ParameterMode.IN);
		   spQuery.registerStoredProcedureParameter(9, String.class, ParameterMode.IN);
		   spQuery.registerStoredProcedureParameter(10, String.class, ParameterMode.IN);
		   spQuery.registerStoredProcedureParameter(11, String.class, ParameterMode.IN);
		   spQuery.registerStoredProcedureParameter(12, String.class, ParameterMode.IN);
		   spQuery.registerStoredProcedureParameter(13, String.class, ParameterMode.IN);  
		 
		   spQuery.setParameter(0,merchantdetails.getName());
		   spQuery.setParameter(1,merchantdetails.getAddress());
		   spQuery.setParameter(2,merchantdetails.getCity());
		   spQuery.setParameter(3,merchantdetails.getState());
		   spQuery.setParameter(4,merchantdetails.getZip());
		   spQuery.setParameter(5,merchantdetails.getCountry());
		   spQuery.setParameter(6,merchantdetails.getPhonenumber());
		   spQuery.setParameter(7,merchantdetails.getFirstname());
		   spQuery.setParameter(8,merchantdetails.getLastname());
		   spQuery.setParameter(9,merchantdetails.getEmail());
		   spQuery.setParameter(10,merchantdetails.getDescription());
		   spQuery.setParameter(11,merchantdetails.getDeliveryhours());
		   spQuery.setParameter(12,merchantdetails.getUsername());
		   spQuery.setParameter(13,merchantdetails.getPlaintextpass());  
		   
		   if(action.equals("update"))
		   {
			   System.out.println("---merchantdetails.getMerchantid()----"+merchantdetails.getMerchantid());
			   spQuery.registerStoredProcedureParameter(14, Integer.class, ParameterMode.IN);
			   spQuery.setParameter(14,merchantdetails.getMerchantid());  
			}
		   
		   boolean s = spQuery.execute();
		   
		  System.out.println(" Inside UDeliRepositoryImpl..insertMerchantDetails --------- Exit------"); 
	}	
	
	
	@Override
	public List<MerchantDetails> editMerchantDetails(Integer merchantId) {
		System.out.println(" Inside UDeliRepositoryImpl..editMerchantDetails --------- Enter------"); 
		  StoredProcedureQuery spQuery =
	              em.createNamedStoredProcedureQuery("getmerchantdetailsbyid");
		   spQuery.registerStoredProcedureParameter(0, Integer.class, ParameterMode.IN);
		   spQuery.setParameter(0,merchantId);
		   @SuppressWarnings("unchecked")
		List<MerchantDetails> merchantDetailsList = spQuery.getResultList();
	 
		System.out.println("----editMerchantDetails------"+merchantDetailsList.size());
		System.out.println(" Inside UDeliRepositoryImpl..editMerchantDetails --------- Exit------"); 
		return merchantDetailsList;
	}
	
	
	@Override
	public void deleteMerchantDetails(Integer merchantId) {
		
		System.out.println(" Inside UDeliRepositoryImpl..deleteMerchantDetails --------- Enter------"); 
		
		spQuery =  em.createNamedStoredProcedureQuery("deletemerchant");
		spQuery.registerStoredProcedureParameter(0, Integer.class, ParameterMode.IN);
		spQuery.setParameter(0,merchantId);  
			
		boolean s = spQuery.execute();
		   
		System.out.println(" Inside UDeliRepositoryImpl..deleteMerchantDetails --------- Exit------"); 
	}	

	
	@SuppressWarnings("unchecked")
	@Override
	public List<CarrierDetails> getCarriers(int mid){
		
		   StoredProcedureQuery spQuery = em.createNamedStoredProcedureQuery("getcarriers");
		   spQuery.registerStoredProcedureParameter(0, Integer.class, ParameterMode.IN);
		   spQuery.setParameter(0, mid);
		   List<CarrierDetails> carriersList = spQuery.getResultList();
		   return carriersList;
	} 
	
	@SuppressWarnings("unchecked")
	@Override
	public void newCarrier(CarrierDetails carrierDetails, int carrierid, int active) {
		StoredProcedureQuery spQuery =  em.createNamedStoredProcedureQuery("updatecarriers");
		spQuery.registerStoredProcedureParameter(0, Integer.class, ParameterMode.IN);
		spQuery.registerStoredProcedureParameter(1, Character.class, ParameterMode.IN);
		spQuery.setParameter(0,carrierDetails.getCarrierid());
		spQuery.setParameter(1,carrierDetails.getActive());
			
		List<CarrierDetails> carriersList = spQuery.getResultList();
		   
	}	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<CarrierDetails> getApproveCarriers(int mid){
		
		   StoredProcedureQuery spQuery = em.createNamedStoredProcedureQuery("approvecarriers");
		   spQuery.registerStoredProcedureParameter(0, Integer.class, ParameterMode.IN);
		   spQuery.setParameter(0, mid);
		   List<CarrierDetails> carriersList = spQuery.getResultList();
		   return carriersList;
	} 
	
	@SuppressWarnings("unchecked")
	@Override
	public void approveCarrier(CarrierDetails carrierDetails, int carrierid, int active) {
		StoredProcedureQuery spQuery =  em.createNamedStoredProcedureQuery("updatecarriers");
		spQuery.registerStoredProcedureParameter(0, Integer.class, ParameterMode.IN);
		spQuery.registerStoredProcedureParameter(1, Character.class, ParameterMode.IN);
		spQuery.setParameter(0,carrierDetails.getCarrierid());
		spQuery.setParameter(1,carrierDetails.getActive());
			
		List<CarrierDetails> carriersList = spQuery.getResultList();
		   
	}	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<CarrierDetails> getDenyCarriers(int mid){
		
		   StoredProcedureQuery spQuery = em.createNamedStoredProcedureQuery("denycarriers");
		   spQuery.registerStoredProcedureParameter(0, Integer.class, ParameterMode.IN);
		   spQuery.setParameter(0, mid);
		   List<CarrierDetails> carriersList = spQuery.getResultList();
		   return carriersList;
	} 
	
	@SuppressWarnings("unchecked")
	@Override
	public void denyCarrier(CarrierDetails carrierDetails, int carrierid, int active) {
		StoredProcedureQuery spQuery =  em.createNamedStoredProcedureQuery("updatecarriers");
		spQuery.registerStoredProcedureParameter(0, Integer.class, ParameterMode.IN);
		spQuery.registerStoredProcedureParameter(1, Character.class, ParameterMode.IN);
		spQuery.setParameter(0,carrierDetails.getCarrierid());
		spQuery.setParameter(1,carrierDetails.getActive());
			
		List<CarrierDetails> carriersList = spQuery.getResultList();
		   
	}	
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<NewOrderDetailsList> getNewOrders(int mid){
			spQuery = em.createNamedStoredProcedureQuery("getneworders");
			spQuery.registerStoredProcedureParameter(0, Integer.class, ParameterMode.IN);
			spQuery.setParameter(0, mid);
		List<NewOrderDetailsList> newOrderDetailsList = spQuery.getResultList();
		return newOrderDetailsList;
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<OrderDetailsList> getApprovedOrders(int mid){
			spQuery = em.createNamedStoredProcedureQuery("getapprovedorders");
			spQuery.registerStoredProcedureParameter(0, Integer.class, ParameterMode.IN);
			spQuery.setParameter(0, mid);
		List<OrderDetailsList> orderDetailsList = spQuery.getResultList();
		return orderDetailsList;
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<OrderDetailsList> getClosedOrders(int mid){
			spQuery = em.createNamedStoredProcedureQuery("getclosedorders");
			spQuery.registerStoredProcedureParameter(0, Integer.class, ParameterMode.IN);
			spQuery.setParameter(0, mid);
		List<OrderDetailsList> orderDetailsList = spQuery.getResultList();
		return orderDetailsList;
		
	}
	
	@Override
	public void insertOrderDetails(OrderDetails orderdetails, String action, Integer merchantid) {
		
		try {
		if(action.equals("insert"))
		{
			spQuery =  em.createNamedStoredProcedureQuery("insertorder");
		}
		else if(action.equals("update"))
		{
			spQuery =  em.createNamedStoredProcedureQuery("updateorder");
		}
		
		   spQuery.registerStoredProcedureParameter(0, String.class, ParameterMode.IN);
		   spQuery.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		   spQuery.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		   spQuery.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
		   spQuery.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);
		   spQuery.registerStoredProcedureParameter(5, String.class, ParameterMode.IN);
		   spQuery.registerStoredProcedureParameter(6, String.class, ParameterMode.IN);
		   spQuery.registerStoredProcedureParameter(7, String.class, ParameterMode.IN);
		   spQuery.registerStoredProcedureParameter(8, String.class, ParameterMode.IN);
		   spQuery.registerStoredProcedureParameter(9, Integer.class, ParameterMode.IN);
		   spQuery.registerStoredProcedureParameter(10, Integer.class, ParameterMode.IN);
		   spQuery.registerStoredProcedureParameter(11, Float.class, ParameterMode.IN);
		   spQuery.registerStoredProcedureParameter(12, Integer.class, ParameterMode.IN); 
		   spQuery.registerStoredProcedureParameter(13, Integer.class, ParameterMode.IN);
		   spQuery.registerStoredProcedureParameter(14, Timestamp.class, ParameterMode.IN);
		   spQuery.registerStoredProcedureParameter(15, Integer.class, ParameterMode.IN);
		   /*spQuery.registerStoredProcedureParameter(16, Float.class, ParameterMode.IN);*/
		
		   
		   spQuery.setParameter(0,orderdetails.getOrdertitle());
		   spQuery.setParameter(1,orderdetails.getOrderdetails());
		   spQuery.setParameter(2,orderdetails.getCustomername());
		   spQuery.setParameter(3,orderdetails.getAddress());
		   spQuery.setParameter(4,orderdetails.getCity());
		   spQuery.setParameter(5,orderdetails.getState());
		   spQuery.setParameter(6,orderdetails.getZip());
		   spQuery.setParameter(7,orderdetails.getPhonenumber());
		   spQuery.setParameter(8,orderdetails.getEmail());
		   spQuery.setParameter(9,orderdetails.getNumberofbags());
		   spQuery.setParameter(10,orderdetails.getTotalitems());
		   spQuery.setParameter(11,orderdetails.getTotalweight());
		   spQuery.setParameter(12,orderdetails.getPerishable()); 
		   spQuery.setParameter(13,orderdetails.getFragile());
		   spQuery.setParameter(14,orderdetails.getPreferreddeliverytime());
		   spQuery.setParameter(15,UDeliConstants.STATUS_NEW);
		   /*spQuery.setParameter(16,orderdetails.getStoretocustlocation());*/
		   
		   if(action.equals("insert"))
		   {
			   spQuery.registerStoredProcedureParameter(17, Integer.class, ParameterMode.IN);
			   spQuery.setParameter(17,merchantid);  
		   }
		   else if(action.equals("update")){
			   spQuery.registerStoredProcedureParameter(17, Integer.class, ParameterMode.IN);
			   spQuery.setParameter(17,orderdetails.getOrderid());  
		   }
		   boolean s = spQuery.execute();
		}
		catch(Exception exception) {
			exception.printStackTrace();
			System.out.println(exception);
			
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<OrderDetails> editOrderDetails(Integer orderid) {
		
		   spQuery = em.createNamedStoredProcedureQuery("getorderdetailsbyid");
		   
		   System.out.println(orderid+"==========after the procedure in Orders details======================");
		   spQuery.registerStoredProcedureParameter(0, Integer.class, ParameterMode.IN);
		   spQuery.setParameter(0,orderid);
		List<OrderDetails> orderDetailsList = spQuery.getResultList();
	 
		return orderDetailsList;
	}
	
	@Override
	public void deleteOrderDetails(Integer orderId) {
		
		spQuery =  em.createNamedStoredProcedureQuery("deleteorder");
		spQuery.registerStoredProcedureParameter(0, Integer.class, ParameterMode.IN);
		spQuery.setParameter(0,orderId);  
			
		boolean s = spQuery.execute();
	}	
	
	@Override
	public void distanceCalculation(Integer orderid) {
		
		   spQuery = em.createNamedStoredProcedureQuery("distanceMatrix");
		   
		   System.out.println(orderid+"==========after the procedure in distanceCalculation======================");
		   spQuery.registerStoredProcedureParameter(0, Integer.class, ParameterMode.IN);
		   spQuery.setParameter(0,orderid);
		   boolean d = spQuery.execute();
		   
		   
	 
	}
	
	@Override
	public void orgData(MerchantDetails merchantdetails, Integer merchantid) {
	try {
		spQuery =  em.createNamedStoredProcedureQuery("getorgdetails");
		spQuery.registerStoredProcedureParameter(0, String.class, ParameterMode.IN);
		spQuery.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		spQuery.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		spQuery.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
		spQuery.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);
		spQuery.registerStoredProcedureParameter(5, String.class, ParameterMode.IN);
		spQuery.registerStoredProcedureParameter(6, String.class, ParameterMode.IN);
		spQuery.registerStoredProcedureParameter(7, String.class, ParameterMode.IN);
		spQuery.registerStoredProcedureParameter(8, String.class, ParameterMode.IN);
		spQuery.registerStoredProcedureParameter(9, String.class, ParameterMode.IN);
		spQuery.registerStoredProcedureParameter(10, String.class, ParameterMode.IN);
		spQuery.registerStoredProcedureParameter(11, Integer.class, ParameterMode.IN);
		spQuery.registerStoredProcedureParameter(12, String.class, ParameterMode.IN);
		spQuery.registerStoredProcedureParameter(13, String.class, ParameterMode.IN);
		spQuery.registerStoredProcedureParameter(14, Integer.class, ParameterMode.IN);
		spQuery.registerStoredProcedureParameter(15, Integer.class, ParameterMode.IN);
		
		spQuery.setParameter(0,merchantdetails.getAddress());
		spQuery.setParameter(1,merchantdetails.getCity());
		spQuery.setParameter(2,merchantdetails.getState());
		spQuery.setParameter(3,merchantdetails.getZip()); 
		spQuery.setParameter(4,merchantdetails.getPhonenumber());
		spQuery.setParameter(5,merchantdetails.getFirstname());
		spQuery.setParameter(6,merchantdetails.getLastname());
		spQuery.setParameter(7,merchantdetails.getEmail());
		spQuery.setParameter(8,merchantdetails.getDeliveryhours());
		spQuery.setParameter(9,merchantdetails.getUsername()); 
		spQuery.setParameter(10,merchantdetails.getPlaintextpass()); 
		spQuery.setParameter(11,merchantdetails.getGlympseorgid());
		/*spQuery.setParameter(12,merchantdetails.getGlympseusername());
		spQuery.setParameter(13,merchantdetails.getGlympsepassword());
		spQuery.setParameter(14,merchantdetails.getOffsethours());*/
		spQuery.setParameter(15,merchantid);  
		boolean s = spQuery.execute();
		}
	catch(Exception exception) {
		exception.printStackTrace();
		System.out.println(exception);
		
	}  
		   
	}	
	
	@SuppressWarnings("unchecked")
	public List<ProfileDetails> editOrgDetails(Integer merchantid){
		StoredProcedureQuery spQuery = em.createNamedStoredProcedureQuery("getprofiledetails");
			spQuery.registerStoredProcedureParameter(0, Integer.class, ParameterMode.IN);
			spQuery.setParameter(0, merchantid);
		List<ProfileDetails> profileDetails = spQuery.getResultList();
		return profileDetails;
		
	}
	
	@SuppressWarnings("unchecked")
	public List<PushNotification> notification(){
		StoredProcedureQuery spQuery = em.createNamedStoredProcedureQuery("getDeviceDetails");
		List<PushNotification> pushNotification = spQuery.getResultList();
		return pushNotification;
	}
	
	@Override
	public void updateNotificatioStatus(String devicetoken) {
		spQuery =  em.createNamedStoredProcedureQuery("updateOrderNotification");
		spQuery.registerStoredProcedureParameter(0, String.class, ParameterMode.IN);
		spQuery.setParameter(0,devicetoken); 
		boolean s = spQuery.execute();
	}
	
	@SuppressWarnings("unchecked")
	public List<CarrierDetails> newCarriers(){
		   StoredProcedureQuery spQuery = em.createNamedStoredProcedureQuery("newCarriers");
		   List<CarrierDetails> newcarriers = spQuery.getResultList();
		   return newcarriers;
	} 
	
	@Override
	public void updateNewCarriers(String devicetoken) {
		spQuery =  em.createNamedStoredProcedureQuery("updateNewCarriers");
		spQuery.registerStoredProcedureParameter(0, String.class, ParameterMode.IN);
		spQuery.setParameter(0,devicetoken); 
		boolean s = spQuery.execute();
	}
	}
