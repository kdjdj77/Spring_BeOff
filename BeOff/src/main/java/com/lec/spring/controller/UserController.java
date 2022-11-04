package com.lec.spring.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.lec.spring.domain.User;
import com.lec.spring.domain.UserValidator;
import com.lec.spring.service.UserService;
import com.lec.spring.util.U;


@Controller
@RequestMapping("/user")
public class UserController {
	private UserService userService;
	
	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public UserController() {
		System.out.println(getClass().getName() + "() 생성");
	}
	@GetMapping("/login")
	public void login() {}
	
	@PostMapping("/login")
	public void loginOk() {}
	
	@GetMapping("/register")
	public void register() {}
	
	@PostMapping("/register")
	public String registerOk(@Valid User user, 
			BindingResult result, // <- validator가 유효성 검사를 한 결과
			Model model, // ★BindingResult보다 Model은 뒤에 있어야 한다
			RedirectAttributes redirectAttrs // redirect될 페이지에 넘겨줄 값
			) {
		// 이미 중복된 아이디(username)이 있다면
		if(userService.isExist(user.getUsername())) {
			result.rejectValue("username", "이미 존재하는 아이디(username)입니다");
		}
		// 에러가 있다면 redirect한다
		if (result.hasErrors()) {
			redirectAttrs.addFlashAttribute("username", user.getUsername());
			redirectAttrs.addFlashAttribute("name", user.getName());
			redirectAttrs.addFlashAttribute("email", user.getEmail());
			redirectAttrs.addFlashAttribute("phonenum", user.getPhonenum());
			List<FieldError> errList = result.getFieldErrors();
			for(FieldError err : errList) {
				redirectAttrs.addFlashAttribute("error", err.getCode());
				break; // 가장 처음에 발견된 에러만 담아 보낸다
			}
			
			return "redirect:/user/register"; // redirect JSP주소 리턴
		}
		
		// 에러가 없다면 회원등록 진행
		String page = "/user/registerOk";
		int cnt = userService.register(user);
		model.addAttribute("result", cnt);
		return page;
	}
	
	@GetMapping("/userinfo")
	public String userinfo(Model model) {
		model.addAttribute("user", U.getLoggedUser());
		return "/user/userinfo";
	}
	
	@RequestMapping("/rejectAuth")
	public String rejectAuth() {
		return "common/rejectAuth";
	}
	
	@PostMapping("/adminreq")
	public String adminReq(
			String auth, String userId, 
			String content, Model model) {
		
		userService.registerAuthReq(auth, userId, content);
		return "redirect:userinfo";
	}
	
	@GetMapping("/admin/authcheck")
	public String authcheck(Model model) {
		
		model.addAttribute("list", userService.getAllAuthreq());
		return "/user/admin/authcheck";
	}
	
	@PostMapping("/admin/authaccept")
	public String authaccept(String authreqId, String userId, String authId) {
		
		userService.acceptAuth(authreqId, userId, authId);
		return "redirect:authcheck";
	}
	
	@PostMapping("/admin/authrefuse")
	public String authaccept(String authreqId) {
		
		userService.refuseAuth(authreqId);
		return "redirect:authcheck";
	}
	
	// 이 컨트롤러 클래스의 handler 에서  폼 데이터 를 바인딩할때 검증하는 Validator 객체 지정
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.setValidator(new UserValidator());
	}
	
	@RequestMapping(value = "/phoneCheck", method = RequestMethod.GET)
	@ResponseBody
	public String sendSMS(@RequestParam("phone") String userPhoneNumber) { // 휴대폰 문자보내기
		int randomNumber = (int)((Math.random()* (9999 - 1000 + 1)) + 1000);//난수 생성

		userService.certifiedPhoneNumber(userPhoneNumber,randomNumber);
		
		return Integer.toString(randomNumber);
	}
}
