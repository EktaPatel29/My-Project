package com.pcpartpicker.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User implements Serializable 
{

	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)  
	 @Column(name="userid")
    private Long userId;
	 
//	@ManyToOne(optional = false)
//    @JoinColumn(name = "type_id")
//    private AmcContractList contractType;
	  
	@Column(name = "username")
    private String userName;   

	@Column(name = "password")
    private String password;   

	@Column(name = "email")
    private String email;
    
	@Column(name ="enabled")
	private int enabled;
	
	public User(){
		
	}
	
	public User(User user) 
	{
	        this.userId = user.userId;
	        this.userName = user.userName;
	        this.email = user.email;       
	        this.password = user.password;
	        this.enabled=user.enabled;        
	}
	
	public User(String email,String userName)
	{
		this.email=email;
		this.userName=userName;
	}
	
	public int getEnabled() 
	{
		return enabled;
	}

	public void setEnabled(int enabled) 
	{
		this.enabled = enabled;
	}	

	public Long getUserid() {
		return userId;
	}

	public void setUserid(Long userid) {
		this.userId = userid;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
  
}