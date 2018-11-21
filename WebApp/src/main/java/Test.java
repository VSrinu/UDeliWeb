/*import java.io.InputStream;

import com.notnoop.apns.APNS;
import com.notnoop.apns.ApnsService;

public class Test {
	
	 public static void main(String[] args) {
	        InputStream cert = Test.class.getClassLoader().getResourceAsStream("apns/appleBeta.p12");
	        System.out.println("certifecate"+cert);
	        ApnsService service =
	                APNS.newService()
	                        .withCert(cert, "arxtlabs")
	                        .withProductionDestination()
	                        .build();
	        String payload = APNS.newPayload().alertBody("Not like this!").build();
	        String token = "7333C44D7DF7107DACF934DB338C52969B4B4E8A6786185CF2C6C63814796A09";
	        service.push(token, payload);
	        System.out.println("success message");

	    }

}*/
/*

import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;
import java.io.InputStream;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RestController;
import com.notnoop.apns.APNS; 
import com.notnoop.apns.ApnsService;

@Configuration
@EnableScheduling
public class Test {
 ApnsService service = null;
 //@Scheduled(fixedDelay = 5000)
 public static void main(String[] args) {
	 System.out.println("Method executed at every 5 seconds. Current time is :: "+ new Date());
 String title="arxtlabs";
 System.out.println("Sending an iOS push notification…");
 InputStream cert = Test.class.getClassLoader().getResourceAsStream("apns/appleBeta.p12");
 ApnsService service = APNS.newService()
 .withCert(cert, "arxtlabs")
 .withSandboxDestination()
 .build(); 
 
 String payload = APNS.newPayload()
 .alertBody("Can’t be simpler than this!")
 .alertTitle("test alert "+title).build();
 
 String token = "7333C44D7DF7107DACF934DB338C52969B4B4E8A6786185CF2C6C63814796A09";
 
 System.out.println("payload: "+payload);
 
 service.push(token, payload);
 
 System.out.println("The message has been hopefully sent…");
 
 }
}*/