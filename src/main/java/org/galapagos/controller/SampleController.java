package org.galapagos.controller;

import java.util.ArrayList;
import java.util.Date;

import org.galapagos.domain.SampleDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/sample/")
@Log4j
public class SampleController {

	@RequestMapping("")
	public void basic() {
		log.info("basic............");
	}

	@RequestMapping(value = "/basic", method = { RequestMethod.GET, RequestMethod.POST })
	public void basicGet() {
		log.info("basic get ............ . . . . . . . . .");
		// return "sample/basic"
	}

	@GetMapping("/basicOnlyGet")
	public void basicGet2() { //메서드명 자체에는 규칙이 따로 없음 자기 임의대로 설정
		log.info("basic get only get!!!!!!!!!!!!@@@@@@");
		// return "sample/basicOnlyGet"
	}

	@GetMapping("/ex01") // 여러가지 정보를 객체로 캡슐화해서 받겠다.
	public String ex01(SampleDTO dto) {
		log.info(dto);
		return "ex01";
	}

//	@GetMapping("/ex02") //여러가지 정보를 개별적으로 받겠다. // 캡슐화와 혼용해서 사용 가능
//	public String ex02( @RequestParam("name") String name, @RequestParam("age") int age) {
//		log.info("name: " + name);
//		log.info("age: " + age);
//
//		return "ex02";
//	}

	@GetMapping("/ex02")
	public String ex02(@RequestParam("name") String name, @RequestParam("age") int age) {
		log.info("name: " + name);
		log.info("age: " + age);
		return "ex02";
	}
	
	@GetMapping("/ex02List")
	public String ex02List(@RequestParam("ids") ArrayList<String> ids) {
		log.info("ids: " + ids);
	
		return "ex02List";
	}
	
	@GetMapping("/ex04")
	public String ex04(
			@ModelAttribute("sample") SampleDTO dto,
			@ModelAttribute("page") int page,
			Model model) {
		log.info("dto: " + dto);
		log.info("page: " + page);
		
		model.addAttribute("now", new Date());
		
		return "ex04";
	}
	
}
