package com.uDeli.respository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import com.uDeli.model.CarrierDetails;
import com.uDeli.model.OrderDetails;
import com.uDeli.model.OrderDetailsList;

public class CarrierDetailsRepositoryImpl implements CarrierDetailsRepositoryCustom{

	@PersistenceContext
    private EntityManager em;
	
	StoredProcedureQuery spQuery; 
	
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
	
	
	/*@SuppressWarnings("unchecked")
	@Override
	public List<OrderDetailsList> getAllOrders(int mid){
			spQuery = em.createNamedStoredProcedureQuery("getallorders");
			spQuery.registerStoredProcedureParameter(0, Integer.class, ParameterMode.IN);
			spQuery.setParameter(0, mid);
		List<OrderDetailsList> orderDetailsList = spQuery.getResultList();
		return orderDetailsList;
		
	}
	
	@Override
	public void insertOrderDetails(OrderDetails orderdetails, String action) {
		
		
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
		   spQuery.registerStoredProcedureParameter(9, String.class, ParameterMode.IN);
		   spQuery.registerStoredProcedureParameter(10, String.class, ParameterMode.IN);
		   spQuery.registerStoredProcedureParameter(11, String.class, ParameterMode.IN);
		   spQuery.registerStoredProcedureParameter(12, String.class, ParameterMode.IN);
		   spQuery.registerStoredProcedureParameter(13, String.class, ParameterMode.IN); 
		   spQuery.registerStoredProcedureParameter(14, String.class, ParameterMode.IN);
		   spQuery.registerStoredProcedureParameter(15, String.class, ParameterMode.IN);
		   spQuery.registerStoredProcedureParameter(16, String.class, ParameterMode.IN);
		   spQuery.registerStoredProcedureParameter(17, String.class, ParameterMode.IN);
		
		   
		   spQuery.setParameter(0,orderdetails.getMerchantid());
		   spQuery.setParameter(1,orderdetails.getOrdertitle());
		   spQuery.setParameter(2,orderdetails.getOrderdetails());
		   spQuery.setParameter(3,orderdetails.getCustomername());
		   spQuery.setParameter(4,orderdetails.getAddress());
		   spQuery.setParameter(5,orderdetails.getCity());
		   spQuery.setParameter(6,orderdetails.getState());
		   spQuery.setParameter(7,orderdetails.getZip());
		   spQuery.setParameter(8,orderdetails.getPhonenumber());
		   spQuery.setParameter(9,orderdetails.getEmail());
		   spQuery.setParameter(10,orderdetails.getNumberofbags());
		   spQuery.setParameter(11,orderdetails.getTotalitems());
		   spQuery.setParameter(12,orderdetails.getTotalweight());
		   spQuery.setParameter(13,orderdetails.getPerishable()); 
		   spQuery.setParameter(14,orderdetails.getFragile());
		   spQuery.setParameter(15,orderdetails.getPreferreddeliverytime());
		   spQuery.setParameter(16,orderdetails.getStatus());
		   spQuery.setParameter(17,orderdetails.getStoretocustlocation());
		   
		   if(action.equals("update"))
		   {
			   spQuery.registerStoredProcedureParameter(18, Integer.class, ParameterMode.IN);
			   spQuery.setParameter(18,orderdetails.getOrderid());  
		   }
		   
		   boolean s = spQuery.execute();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<OrderDetails> editOrderDetails(Integer orderid) {
		
		   spQuery = em.createNamedStoredProcedureQuery("getorderdetailsbyid");
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
	} */
	
	}
