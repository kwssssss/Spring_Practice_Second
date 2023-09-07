package org.galapagos.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import org.galapagos.domain.UserDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/user/")
@Log4j
public class UserController {

	@GetMapping("/join")
	public String joinGet() { //get요청 담당
		return "user/join";
	}
	
	@PostMapping("/join") // 함수의 overload 기능처럼 url이 같아도 메소드가 다르면 다른걸로 간주
	public String joinPost(UserDTO user) { //post요청 담당
			// DB에 INSERT 작업을 함
			log.info(user);
			
			// "redirect: 이동할 url"
			return "redirect:/user/join_result";
	}
	
	@GetMapping("/join_result")
	public String jinResult(UserDTO user) {
		return "user/join_result";
	}
	
}
