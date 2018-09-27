package com.uDeli.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uDeli.model.MerchantDetails;

public interface UDeliRepository extends JpaRepository<MerchantDetails,String>,UDeliRepositoryCustom,CarrierDetailsRepositoryCustom{

 
}
