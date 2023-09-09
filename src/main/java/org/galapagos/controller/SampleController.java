package org.galapagos.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

import org.galapagos.domain.SampleDTO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

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
	public void basicGet2() { // 메서드명 자체에는 규칙이 따로 없음 자기 임의대로 설정
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
	public String ex04(@ModelAttribute("sample") SampleDTO dto, @ModelAttribute("page") int page, Model model) {
		log.info("dto: " + dto);
		log.info("page: " + page);

		model.addAttribute("now", new Date());

		return "ex04";
	}

	@GetMapping("/ex06")
	public @ResponseBody SampleDTO ex06() {
		log.info("/ex06........");

		SampleDTO dto = new SampleDTO();
		dto.setAge(10);
		dto.setName("후후");

		return dto;
	}

	@GetMapping("/ex07")
	public ResponseEntity<String> ex07() {
		log.info("/ex07...............");

		String msg = "{\"name\": \"홍길동\"}";

		HttpHeaders header = new HttpHeaders();
		header.add("Content-Type", "application/json;charset=UTF-8");

		return new ResponseEntity<>(msg, header, HttpStatus.OK);
	}

	@GetMapping("/exUpload")
	public void exUpload() {
		log.info("/exUpload......................");
	}

	@PostMapping("/exUploadPost")
	public void exUploadPost(ArrayList<MultipartFile> files) {

		for (MultipartFile file : files) {
			if (file.isEmpty())
				continue;

			log.info("----------------------------------");
			log.info("name:" + file.getOriginalFilename());
			log.info("size:" + file.getSize());
			// 저장
			File dest = new File("c:/upload", file.getOriginalFilename()); // java.io의 파일객체 사용
			try {
				file.transferTo(dest);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		;
	}
	
	@GetMapping("/ex10")
	public void ex10() {
	//	throw new RuntimeException("예외 실험"); //RuntimeException : 예외처리 강요 안함
	}
}