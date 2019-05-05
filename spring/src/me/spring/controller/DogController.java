package me.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import me.spring.entity.Dog;
import me.spring.service.DogService;


@Controller
@RequestMapping("/dog")
public class DogController {
	
	@Autowired
	private DogService dogService;
	
	@RequestMapping(value = "/searchDogById")
	@ResponseBody
	public String findDog(Integer dogId,Model model) {
		String result="id:%s,dogId:%s,dogName:%s,dogKind:%s";
		Dog dog=dogService.getDog(dogId);
		return result.format(
				result,
				dog.getId(),
				dog.getDogId(),
				dog.getDogName(),
				dog.getDogKind()
				);
		}
		
		
}
