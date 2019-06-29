// UserLogController [Author: Akash Chandra]
package com.rentocar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.rentocar.service.UserLogService;

@RestController
public class UserLogController {

	@Autowired
	private UserLogService userLogService;
}
