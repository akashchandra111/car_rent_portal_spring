// UserLogService [Author: Akash Chandra]
package com.rentocar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rentocar.model.UserLogRepository;

@Service
public class UserLogService {
	
	@Autowired
	private UserLogRepository userLogRepo;
}
