package com.brainmatics.controller;

import com.brainmatics.entity.LoginForm;
import com.brainmatics.entity.Result;
import com.brainmatics.entity.User;
import com.brainmatics.service.UserService;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(method = RequestMethod.POST, value = "/register")
	public ResponseEntity<?> register(@Valid @RequestBody User user, 
			Errors errors) 
			throws Exception {
		Result result = new Result();
		if(errors.hasErrors()){
			for(ObjectError err: errors.getAllErrors()){
				result.getMessages().add(err.getDefaultMessage());
			}
			return ResponseEntity.badRequest().body(result);
		}
		User output = userService.register(user);
		result.setPayload(output);
		return ResponseEntity.ok(result);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/login")
	public User login(@RequestBody LoginForm form) throws Exception {
		return userService.login(form.getEmail(), form.getPassword());
	}

}
