/*import java.io.InputStream;

import com.notnoop.apns.APNS;
import com.notnoop.apns.ApnsService;

public class Test {
	
	 public static void main(String[] args) {
		 String title="Carrier Request";
	        InputStream cert = Test.class.getClassLoader().getResourceAsStream("apns/applePro.p12");
	        System.out.println("certifecate"+cert);
	        ApnsService service =
	                APNS.newService()
	                        .withCert(cert, "arxtlabs")
	                        .withProductionDestination()
	                        .build();
	        String payload = APNS.newPayload().alertBody("Sorry, Merchant has Denied your Request you can't get the orders for delivery").alertTitle(title).build();
	        String token = "E1286243B8A6131E1F28AF65AFFFD5AD1A9A3653DB189DE46899378423AA9985";
	        service.push(token, payload);
	        System.out.println("success message");

	    }

}*/
