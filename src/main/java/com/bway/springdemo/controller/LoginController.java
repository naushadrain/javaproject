package com.bway.springdemo.controller;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bway.springdemo.model.User;
import com.bway.springdemo.repository.UserRepository;
import com.bway.springdemo.utilities.VerifyRecaptcha;

@Controller
public class LoginController {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	private UserRepository userRepo;
	
	@GetMapping("/login")
	public String showLoginForm() {
		
		return "LoginForm";
	}

	  @PostMapping("/login")
	  public String doLogin(@ModelAttribute User user,  Model model,HttpSession session, @RequestParam("g-recaptcha-response") String gCode) throws IOException {
		 
		  //validation
		 // passwordValidataion(user.getPassword());
		  
		  if(VerifyRecaptcha.verify(gCode)) {
			  
			     user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
				 User usr =  userRepo.findUser(user.getUserName(), user.getPassword());
				  
				  if(usr != null) {  
					  logger.info("====== user logged in successfully =====");
					  
					  session.setAttribute("user", usr);
					  session.setMaxInactiveInterval(120);
					  
					  //model.addAttribute("uname", user.getUserName());
					  
					  return "Home";
				  }else {
					  logger.info("=========== login failed ==============");
					  model.addAttribute("message","user not found!!");
					  return  "LoginForm";
				  }
		  }
		  
		  logger.info("=========== login failed ==============");
		  model.addAttribute("message","you are robot !!");
		  return  "LoginForm";
	  }
	  
	 @GetMapping("/logout")
	  public String logout(HttpSession session) {
		 
		  logger.info("=============logout success ===========");
		   session.invalidate();//session kill
		  
		  return "LoginForm";
	  }
}
