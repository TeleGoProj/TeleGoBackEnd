package com.telego.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.telego.model.request.UserSearchRequest;
import com.telego.model.response.UserSearchResponse;
import com.telego.service.UserSearchService;

@RestController
@RequestMapping("/api/search")
public class UserSearchController {
	
	@Autowired
	private UserSearchService userSearchService;
	
	@PostMapping("/search-users")
	public UserSearchResponse searchForUsers(@RequestBody UserSearchRequest request) {
		return userSearchService.searchForUsers(request);	
	}
}
