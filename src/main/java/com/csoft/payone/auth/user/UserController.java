package com.csoft.payone.auth.user;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;



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
    	if(user.getUsername()==null) {
			user.setUsername(user.getEmail());
		}
    	//user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		
		List<ApplicationUser> userObj =  this.applicationUserRepository.findByEmail(user.getEmail());
		if (userObj==null || userObj.size()==0) {
			user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
			applicationUserRepository.save(user);
			return new ResponseEntity<ApplicationUser>(user, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<ApplicationUser>(HttpStatus.IM_USED);
		}
		
    }

}
