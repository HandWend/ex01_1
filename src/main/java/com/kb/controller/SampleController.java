package com.kb.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kb.domain.SampleDTO;
import com.kb.domain.ToDoDTO;

import lombok.extern.log4j.Log4j;

@Log4j
// 메소드에다 하는 게 아니라 클래스에다 하는 것이다.
@RequestMapping("/sample/*")
// Controller 클래스를 만들고 annotation 설정해주기
@Controller
public class SampleController {

	// void: 리턴 값 없음
	@RequestMapping("")
	public void basic() {
		log.info("------------------");
	}
	
	//get방식만 처리하겠다.
	// mvc2 모델의 doGet 메소드와 유사
	@GetMapping("/")
	public void basicGet() {
		log.info("++++++++++++++++++++Get");
	}
	
	@PostMapping("/")
	public void basicPost() {
		log.info("++++++++++++++++++++Post");
	}
	
	@GetMapping("/ex01")
	public String ex01(SampleDTO dto) {
		log.info(dto);
		return "ex01";
	}
	
	@GetMapping("/ex02")
	public String ex02(@RequestParam("name") String name, @RequestParam("age") int age) {
		log.info(name);
		log.info(age);
		return "ex02";
	}
	
	@GetMapping("/ex03")
	public String ex03(@RequestParam("name") ArrayList<String> names) {
		log.info(names);
		return "ex03";
	}
	
	// 단순히 String->Date의 변환을 자동으로 해 주는 것 아님.
	// validator의 역할로 개발자가 정의한 내용에 따라 데이터 타입을 맞추게 됨. 
	// validator의 역할: 유효성 검사
	// 설명) SimpleDateFormat("yyyy-MM-dd")가 개발자가 정의한 내용 및 데이터 타입
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(java.util.Date.class, new CustomDateEditor(dateFormat, false));
		// true와 false: 빈 값을 허용할거냐 안 할거냐
		// null값일 때 _ true: 404, false: 400
		
	}
	
	@GetMapping("/ex04")
	public String ex04(ToDoDTO todo) {
		log.info(todo);
		return "ex04";
	}
	
	@GetMapping("/ex05")
	//여기선 model 이용
	public String ex05(SampleDTO dto, @ModelAttribute("page") int page) {
		log.info(dto);
		log.info(page);
		//web-inf 안에 ex05.jsp가 있냐, 있으면 들고 올게
		return "sample/ex05";
	}
	
	/*
	 * @GetMapping("/ex06") //여기선 model 이용 public String ex06(String name, int age,
	 * RedirectAttributes rttr) { rttr.addFlashAttribute("name", name);
	 * rttr.addFlashAttribute("age", age); //web-inf 안에 ex05.jsp가 있냐, 있으면 들고 올게
	 * return "redirect:/"; }
	 */
	/*
	 * http://localhost/sample/ex06?name=양&age=1
	 */	@GetMapping("/ex06")
	public String ex06(String name, int age, RedirectAttributes rttr) {
		rttr.addFlashAttribute("name", name);
		rttr.addFlashAttribute("age", age);
		return "redirect:/";
	}
	
	/*
	 * http://localhost/sample/ex07
	 */	@GetMapping("/ex07")
	//여기선 model 이용
	public String ex07(RedirectAttributes rttr) {
		rttr.addFlashAttribute("name", "양");
		rttr.addFlashAttribute("age", 25);
		//web-inf 안에 ex05.jsp가 있냐, 있으면 들고 올게
		return "redirect:/";
	}
	
	 @GetMapping("/ex08")
	 public @ResponseBody SampleDTO ex08() {
		 log.info("/ex08....");
		 SampleDTO dto = new SampleDTO();
		 	dto.setName("양");
		 	dto.setAge(25);
		 	return dto;
	 }
	 
	 @GetMapping("/ex09")
	 public ResponseEntity<String> ex09() {
		String msg = "{\"name\":\"양\",\"age\":25}";
		
		HttpHeaders header = new HttpHeaders();
		header.add("content-type", "application/json;charset=UTF-8");
		
		return new ResponseEntity<String>(msg, header, HttpStatus.OK);
		
	 }
	
	
}
