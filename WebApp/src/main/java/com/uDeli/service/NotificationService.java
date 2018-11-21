/*package com.uDeli.service;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.notnoop.apns.APNS;
import com.notnoop.apns.ApnsService;
import com.uDeli.controller.UDeliController;
import com.uDeli.model.PushNotification;
import com.uDeli.respository.UDeliRepository;

@Service
@EnableScheduling
@Configuration
public class NotificationService {
	
	@Autowired
	UDeliRepository udeliRepo;
	List<PushNotification> notificationList = null;
	ApnsService service = null;
	@Bean
	@Scheduled(fixedDelay = 5000)

			public void notification() {
				System.out.println("Method executed at every 5 seconds. Current time is :: "+ new Date());
				notificationList = udeliRepo.notification();
				if(notificationList.size() > 0){
					//for(PushNotification pushNotification1 : notificationList) {
						
						for(int index=0; notificationList.size() > index; index++) {
						
						PushNotification pnf = (PushNotification)notificationList.get(index);
				 String title="New Order Request";
				 System.out.println("Sending an iOS push notification…");
				 InputStream cert = UDeliController.class.getClassLoader().getResourceAsStream("apns/appleBeta.p12");
				 ApnsService service = APNS.newService()
				 .withCert(cert, "arxtlabs")
				 .withSandboxDestination()
				 .build(); 
				 
				 String payload = APNS.newPayload()
				 .alertBody("Mearchant "+pnf.getName() +" "+"got a delivery order"+" "+pnf.getOrdertitle())
				 .alertTitle(title).build();
				 
				 String token = pnf.getDevicetoken();
				 
				 System.out.println("payload: "+payload);
				 
				 service.push(token, payload);
					}
					
				}
				
			}
}
*/