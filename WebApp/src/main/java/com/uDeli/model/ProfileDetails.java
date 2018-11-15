package com.uDeli.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity 
@Table(name = "tmerchant") 
@NamedStoredProcedureQueries({
       
        @NamedStoredProcedureQuery(name = "getprofiledetails",procedureName = "pgetprofiledetails",resultClasses = ProfileDetails.class)
        
})
public class ProfileDetails {
		
	public ProfileDetails() {		
	}
 
	@Id
	@GeneratedValue
	@Column(name="merchantid")
	private Integer merchantid;
	
	@NotBlank(message="Username cannot be blank.")
	@Column(name="username")
	private String username;
	
	@NotBlank(message="Password cannot be blank.") 
	@Column(name="plaintextpass")
	private String plaintextpass;
	
	@NotBlank(message="GlympseorgID cannot be blank.")
	@Column(name="glympseorgid")
	private Integer glympseorgid;
	
	@NotBlank(message="Glympseusername cannot be blank.")
	@Column(name ="glympseusername")
	private String glympseusername;
	
	@NotBlank(message="Glympsepassword cannot be blank.")
	@Column(name ="glympsepassword")
	private String glympsepassword;
	
	@NotBlank(message="Offsethours cannot be blank.")
	@Column(name ="offsethours")
	private Integer offsethours;
	
	@NotBlank(message="Address cannot be blank")
	private String address;
	
	@NotBlank(message="City cannot be blank.")
    private String city;
	
	@NotBlank(message="State cannot be blank.")
    private String state;
	
	@NotBlank(message="Zip code cannot be blank.")
    private String zip;
	
	@NotBlank(message="Phone number cannot be blank.")
    private String phonenumber;
	
	@NotBlank(message="First Name cannot be blank.")
    private String firstname;
	
	@NotBlank(message="Last Name cannot be blank.")
    private String lastname;
	
	@NotBlank(message="Email cannot be blank.") 
    private String email;
	
	@NotBlank(message="Delivery hours cannot be blank.")
    private String deliveryhours;
	    
    public ProfileDetails(String username, String plaintextpass, Integer merchantid,
			Integer glympseorgid, String address, String city, String state, String zip,
			String phonenumber, String firstname, String lastname, String email, String glympseusername, String glympsepassword, Integer offsethours) {
		super(); 
		this.username = username;
		this.plaintextpass = plaintextpass;
		this.merchantid = merchantid;
		this.glympseorgid = glympseorgid;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.phonenumber = phonenumber;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;	 
		this.glympseusername = glympseusername;
		this.glympsepassword =glympsepassword;
		this.offsethours = offsethours;
	}	 

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPlaintextpass() {
		return plaintextpass;
	}

	public void setPlaintextpass(String plaintextpass) {
		this.plaintextpass = plaintextpass;
	}

	public Integer getMerchantid() {
		return merchantid;
	}

	public void setMerchantid(Integer merchantid) {
		this.merchantid = merchantid;
	}
  
	public Integer getGlympseorgid() {
		return glympseorgid;
	}

	public void setGlympseorgid(Integer glympseorgid) {
		this.glympseorgid = glympseorgid;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDeliveryhours() {
		return deliveryhours;
	}

	public void setDeliveryhours(String deliveryhours) {
		this.deliveryhours = deliveryhours;
	}

	public String getGlympseusername() {
		return glympseusername;
	}

	public void setGlympseusername(String glympseusername) {
		this.glympseusername = glympseusername;
	}

	public String getGlympsepassword() {
		return glympsepassword;
	}

	public void setGlympsepassword(String glympsepassword) {
		this.glympsepassword = glympsepassword;
	}

	public Integer getOffsethours() {
		return offsethours;
	}

	public void setOffsethours(Integer offsethours) {
		this.offsethours = offsethours;
	} 
	
}
