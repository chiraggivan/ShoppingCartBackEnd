package com.niit.shoppingcartbackend.model;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import com.niit.shoppingcartbackend.model.*;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

@Entity
@Table  
@Component

public class User {

	@Id
	private String id;
	//@NotEmpty
	private String name;
	//@Min(5)
	//@Max(25)
	private String password;
	
	private String adminrole;
	//@NotEmpty(message="Please enter valid email id")
	private String email;
	private String contactno;
	
	private Date dob;
	
	//private String billing_id;
	//private String oneShipping_id;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="billing_id")
	private BillingAddress billingAddress;
	
	public BillingAddress getBillingAddress() {
		return billingAddress;
	}
	public void setBillingAddress(BillingAddress billingAddress) {
		this.billingAddress = billingAddress;
	}
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="oneShipping_id")
	private OneShippingAddress oneShippingAddress;
	
	public OneShippingAddress getOneShippingAddress() {
		return oneShippingAddress;
	}
	public void setOneShippingAddress(OneShippingAddress oneShippingAddress) {
		this.oneShippingAddress = oneShippingAddress;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getAdminrole() {
		return adminrole;
	}
	public void setAdminrole(String adminrole) {
		this.adminrole = adminrole;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContactno() {
		return contactno;
	}
	public void setContactno(String contactno) {
		this.contactno = contactno;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	/*public String getBilling_id() {
		return billing_id;
	}
	public void setBilling_id(String billing_id) {
		this.billing_id = billing_id;
	}
	public String getOneShipping_id() {
		return oneShipping_id;
	}
	public void setOneShipping_id(String oneShipping_id) {
		this.oneShipping_id = oneShipping_id;
	}*/
	
}
