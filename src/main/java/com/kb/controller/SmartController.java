package com.kb.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
//이 파일은 컨트롤러다.라는 아노테이션.
@Controller
public class SmartController {
	
	private static final Logger logger = LoggerFactory.getLogger(SmartController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	//매핑, url경로가 /로 왔을 때, 아래에 메소드를 호출한다.
	//value값은 중복되면 안됨.
	//get방식으로 보여줄끄야
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Locale locale, Model model) {
		
		
		//이미 servelet-context.xml에 .jsp를 받으니 뒤에 .jsp를 따로 찍어주지 않아도 된다.
		//return login이 알아서 login.jsp를 찾는다.
		return "login";
	}
	
	@RequestMapping(value = "/mypage", method = RequestMethod.GET)
	public String mypage(Locale locale, Model model) {
		
		
		//이미 servelet-context.xml에 .jsp를 받으니 뒤에 .jsp를 따로 찍어주지 않아도 된다.
		//return login이 알아서 login.jsp를 찾는다.
		return "mypage";
	}
	
}
