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
        @NamedStoredProcedureQuery(name = "getuserprofile",procedureName = "pgetuserprofile",resultClasses = GetUserProfile.class)
})

public class GetUserProfile {
	
	public GetUserProfile() {		
	}
		
	public GetUserProfile(Character usertype,String username,String plaintextpass,Integer merchantid,String name)
	{
		super();
		
		this.usertype = usertype;
		this.username = username;
		this.plaintextpass = plaintextpass;	 
		this.merchantid = merchantid;
		this.name=name;
	 
	}
	
	@Id
	@GeneratedValue
	@Column(name="merchantid")
	private Integer merchantid;
	@Column(name="usertype")
	private Character usertype;
	@Column(name="username")
	@NotBlank(message = "Username cannot be blank")
	private String username;
	@Column(name="plaintextpass")
	@NotBlank(message = "Password cannot be blank")
	private String plaintextpass;	
	private String name;
		
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
  
}
