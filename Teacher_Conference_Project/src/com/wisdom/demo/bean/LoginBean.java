package com.wisdom.demo.bean;

import java.io.IOException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;



@ManagedBean(name = "logincontroll")
@ViewScoped
public class LoginBean {
	
	private String username;
	private String password;
	
	  public void login() {
        
        FacesContext context = FacesContext.getCurrentInstance();

        if(this.username.equals("wisdom") && this.password.equals("123")){
            context.getExternalContext().getSessionMap().put("user", username);
            try {
        context.getExternalContext().redirect("index.xhtml");
  } catch (IOException e) {
      e.printStackTrace();
} 
        }
        else  {
        	context.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "", " login Fail"));

        } 
    }

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
