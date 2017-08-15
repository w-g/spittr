package spittr.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/")
public class HomeController {

	@RequestMapping(method = RequestMethod.GET)
	public String home() {
		return "home";
	}

	@RequestMapping(value = "/foo", method = RequestMethod.GET)
	public String foo() {
		return "foo";
	}
}
