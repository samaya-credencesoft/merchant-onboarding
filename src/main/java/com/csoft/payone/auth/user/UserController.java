package com.csoft.payone.auth.user;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;

@RestController
@RequestMapping("/users")
public class UserController {

    private ApplicationUserRepository applicationUserRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    private UserDetailsServiceImpl userDeatilService;

    public UserController(ApplicationUserRepository applicationUserRepository,
                          BCryptPasswordEncoder bCryptPasswordEncoder,UserDetailsServiceImpl userDeatilService) {
        this.applicationUserRepository = applicationUserRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.userDeatilService=userDeatilService;
    }

    @PostMapping("/sign-up")
    public ResponseEntity<ApplicationUser> signUp(@RequestBody ApplicationUser user) {
    	//check user with the same name exists or not 
    	if(user.getUsername()!=null)
    	user.setUsername(user.getEmail());
    	user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		
		List<ApplicationUser> userObj =  this.applicationUserRepository.findByEmail(user.getEmail());
		if (userObj==null || userObj.size()==0) {
			user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
			applicationUserRepository.save(user);
			return new ResponseEntity<ApplicationUser>(HttpStatus.OK);
		} else {
			return new ResponseEntity<ApplicationUser>(HttpStatus.IM_USED);
		}
		
    }
}