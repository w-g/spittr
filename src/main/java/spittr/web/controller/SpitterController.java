package spittr.web.controller;

import javax.validation.Valid;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.util.Factory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spittr.Spitter;
import spittr.service.SpitterService;

@Controller
@RequestMapping("/spitter")
public class SpitterController {

	private static Logger logger = LoggerFactory.getLogger(SpitterController.class);
	
	private SpitterService spitterService;

	@Autowired
	public SpitterController(SpitterService spitterService) {
		this.spitterService = spitterService;
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String showRegistrationForm() {
		return "registerForm";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String proccessRegistration(@Valid Spitter spitter, Errors errors) {

		if (errors.hasErrors()) {
			return "registerForm";
		}

		spitterService.save(spitter);

		return "redirect:/spitter/" + spitter.getUsername();
	}

	@RequestMapping(value = "/{username}", method = RequestMethod.GET)
	public String showSpitterProfile(@PathVariable String username, Model model) {

		Spitter spitter = spitterService.findByUsername(username);
		model.addAttribute(spitter);

		return "profile";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String showLoginForm() {
		return "loginForm";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String processLogin(String username, String password) {
		
		//org.apache.shiro.web.filter.authc.FormAuthenticationFilter
		
		logger.info("## code from wangzb ##");
		
		Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
		SecurityManager securityManager = factory.getInstance();
		SecurityUtils.setSecurityManager(securityManager);
		
		Subject currentUser = SecurityUtils.getSubject();
		//Session session = currentUser.getSession();
		//session.setAttribute("somekey", "aValue");
		
		if(!currentUser.isAuthenticated()) {
			
			UsernamePasswordToken token = new UsernamePasswordToken("lonestarr", "vespa");
			token.setRememberMe(true);
			
			try {
				currentUser.login(token);
			} catch(UnknownAccountException uae) {
			} catch(IncorrectCredentialsException ice) {
			} catch(LockedAccountException lae) {
			} catch(AuthenticationException ae) {
			}
		}
		
		String principal = currentUser.getPrincipal().toString();
		logger.info("## " + principal + " login success ##");
		
		//Spitter spitter = spitterService.findByUsername(username);
		
		return "redirect:/spittles?max=10&count=10";
	}

	@RequestMapping(value = "/logout")
	public String processLogout() {
		
		Subject currentUser = SecurityUtils.getSubject();
		
		if(currentUser.isAuthenticated()) {
			currentUser.logout();
		}
		
		return "redirect:/spittles";
	}
	
}
