package spittr.web.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;

import spittr.service.SpittleService;

@Controller
@RequestMapping("/spittles")
public class SpittleController {

	private SpittleService spittleService;
	
	@Autowired
	public SpittleController(SpittleService spittleService) {
		this.spittleService = spittleService;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String spittles(@RequestParam("max") long max, 
			@RequestParam("count") int count, 
			Model model) {

		Subject currentUser = SecurityUtils.getSubject();
		if(currentUser.isAuthenticated()) {
			// do something
		}
		
		model.addAttribute("spittleList", spittleService.findSpittles(max, count));
		
		return "spittles";
	}
	
	@RequestMapping(value="/{spittleId}", method = RequestMethod.GET)
	public String spittle(@PathVariable("spittleId") long spittleId, 
			Model model) {
		
		model.addAttribute(spittleService.findOne(spittleId));
		
		return "spittle";
	}
}
