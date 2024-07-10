package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Memo;
import com.example.demo.repository.MemoRepository;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MemoController {
	
	private final MemoRepository repository;

	//Read
	@GetMapping("/")
	public String showAllMemo(@ModelAttribute Memo memo, Model model) {
		model.addAttribute("memos", repository.findAll());
		return "index";
	}
	
	//Create
	@PostMapping("/add") //entityのmemoテーブルから情報取得
	public String addMemo(@ModelAttribute Memo memo) {
		repository.save(memo);
		return "redirect:/";
	}
	
	//Update
	@PostMapping("/edit")
	public String editMemo(@ModelAttribute Memo memo) {
		repository.save(memo);
		return "redirect:/";
	}
	
	//Delete
	@GetMapping("/delete/{id}")
	public String deleteMemo(@PathVariable Integer id) {
		repository.deleteById(id);
		return "redirect:/";
	}
	
}
