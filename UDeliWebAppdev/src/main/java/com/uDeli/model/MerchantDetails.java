package com.uDeli.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity 
@Table(name = "tmerchant") 
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(name = "getallmerchants",procedureName = "pgetallmerchants",resultClasses = MerchantDetails.class),
        @NamedStoredProcedureQuery(name = "pinsertmerchant",procedureName = "pInsertMerchant",resultClasses = MerchantDetails.class),
        @NamedStoredProcedureQuery(name = "getmerchantdetailsbyid",procedureName = "pgetmerchantdetailsbyid",resultClasses = MerchantDetails.class),
        @NamedStoredProcedureQuery(name = "updatemerchant",procedureName = "pupdatemerchant",resultClasses = MerchantDetails.class),
        @NamedStoredProcedureQuery(name = "deletemerchant",procedureName = "pdeletemerchant",resultClasses = MerchantDetails.class)
        
})

public class MerchantDetails {
	
	public MerchantDetails() {		
	}
 
	@Id
	@GeneratedValue
	@Column(name="merchantid")
	private Integer merchantid;
	
	@Column(name="usertype")
	private Character usertype;
	
	@NotBlank(message="Username cannot be blank.")
	@Column(name="username")
	private String username;
	
	@NotBlank(message="Password cannot be blank.") 
	@Column(name="plaintextpass")
	private String plaintextpass;
	
	@NotBlank(message="Merchant Name cannot be blank")
	@Column(name="name")
	private String name;
	
	
	@Column(name="glympseorgid")
	private Integer glympseorgid;
	@Column(name="glympsekey")
	private String glympsekey;
	
	@NotBlank(message="Address cannot be blank")
	private String address;
	
	@NotBlank(message="City cannot be blank.")
    private String city;
	
	@NotBlank(message="State cannot be blank.")
    private String state;
	
	@NotBlank(message="Zip code cannot be blank.")
    private String zip;
	
	@NotBlank(message="Country cannot be blank.")
    private String country;
	
	@NotBlank(message="Phone number cannot be blank.")
    private String phonenumber;
	
	@NotBlank(message="First Name cannot be blank.")
    private String firstname;
	
	@NotBlank(message="Last Name cannot be blank.")
    private String lastname;
	
	@NotBlank(message="Email cannot be blank.") 
    private String email;
	
	@NotBlank(message="Description cannot be blank.")
    private String description;
	
	@NotBlank(message="Delivery hours cannot be blank.")
    private String deliveryhours;
	    
    public MerchantDetails(Character usertype, String username, String plaintextpass, Integer merchantid,
			String name, Integer glympseorgid, String glympsekey, String address, String city, String state, String zip,
			String country, String phonenumber, String firstname, String lastname, String email) {
		super(); 
		this.usertype = usertype;
		this.username = username;
		this.plaintextpass = plaintextpass;
		this.merchantid = merchantid;
		this.name = name;
		this.glympseorgid = glympseorgid;
		this.glympsekey = glympsekey;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.country = country;
		this.phonenumber = phonenumber;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;	 
	}	 
     
	public Character getUsertype() {
		return usertype;
	}

	public void setUsertype(Character usertype) {
		this.usertype = usertype;
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
  
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getGlympseorgid() {
		return glympseorgid;
	}

	public void setGlympseorgid(Integer glympseorgid) {
		this.glympseorgid = glympseorgid;
	}

	public String getGlympsekey() {
		return glympsekey;
	}

	public void setGlympsekey(String glympsekey) {
		this.glympsekey = glympsekey;
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

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
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


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getDeliveryhours() {
		return deliveryhours;
	}

	public void setDeliveryhours(String deliveryhours) {
		this.deliveryhours = deliveryhours;
	} 
}
