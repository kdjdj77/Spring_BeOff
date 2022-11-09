package com.lec.spring.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.lec.spring.domain.qna.Qna;
import com.lec.spring.service.BoardService;
import com.lec.spring.util.U;

@Controller
@RequestMapping("/board")
public class QnaController {
	
	private BoardService boardService;
	
	@Autowired
	public void setBoardService(BoardService boardService) {
		this.boardService = boardService;
	}

	public QnaController() {
		System.out.println(getClass().getName() + "() 생성");
	}
	
	// /board/list
	@GetMapping("/list")
//	public void list(Model model) {
	public void glist(Integer page, String search, Model model) {
		String s = "";
		if (!search.equals(null)) s = search;
		model.addAttribute("search", s);
		boardService.list(page, s, model);
	}
	
	@PostMapping("/list")
	public String plist(Integer page, String search, Model model) {
		boardService.list(page, search, model);
		model.addAttribute("search", search);
		return "board/list";
	}
	
	// /board/write
	@GetMapping("/write")
	public void write() {}
	
	@PostMapping("/write")
	public String writeOk(
			@RequestParam Map<String, MultipartFile> files   // 첨부파일들
			, @ModelAttribute("dto") Qna write
			, Model model) {
		System.out.println("POST: /board/write " + write);		
		model.addAttribute("result", boardService.write(write, files));
//		model.addAttribute("result", boardService.write(write));
//		model.addAttribute("dto", write);
		System.out.println("저장후: " + write);
		return "board/writeOk";
	}
		
	// /board/detail
	@GetMapping("/detail")
	public void detail(Long id, Model model){
		model.addAttribute("list", boardService.detail(id));		
	}
	
	// /board/update
	@GetMapping("/update")
	public void update(Long id, Model model) {
		model.addAttribute("list", boardService.selectById(id));
	}
	
	@PostMapping("/update")
	public String updateOk(
			@RequestParam Map<String, MultipartFile> files  // 새로 추가될 첨부파일들
			, @ModelAttribute("dto") Qna write
			, Model model
			, Long[] delfile    // 삭제될 파일들
			) {
		
		model.addAttribute("result", boardService.update(write, files, delfile));
		
		return "board/updateOk";
	}
	
	// /board/delete
	@PostMapping("/delete")
	public String deleteOk(Long id, Model model) {
		model.addAttribute("result", boardService.deleteById(id));
		
		return "board/deleteOk";
	}
	
	// 페이징
	// pageRows 변경시 동작
	@PostMapping("/pageRows")
	public String pageRows(Integer page, String search, Integer pageRows) {
		U.getSession().setAttribute("pageRows", pageRows);
		return "redirect:/board/list?page=" + page + "&search=" + search;
	}
	
	
} // end controller