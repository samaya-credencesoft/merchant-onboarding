package com.csoft.payone.auth.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
@RestController
@RequestMapping("/users")
public class SignUpController {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	@Autowired
	private RoleRepository roleRepository ;

	@PostMapping("/sign-up")
	public ResponseEntity<ApplicationUser> signUp(@RequestBody ApplicationUser user) {
		// check user with the same name exists or not
		if (user.getUsername() == null) {
			user.setUsername(user.getEmail());
		}
		List<ApplicationUser> userObj = this.userRepository.findByEmail(user.getEmail());
		if (userObj == null || userObj.size() == 0) {
			user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

			Role role =roleRepository.findByName("ROLE_USER");

			if(role == null) {

				role=new Role();
				role.setName("ROLE_USER");
				//roleRepository.save(role);

			}
			List<Role> roles= new ArrayList<Role>();
			roles.add(role);
			user.setRoles(roles);

			user=userRepository.save(user);
			return new ResponseEntity<ApplicationUser>(user, HttpStatus.CREATED);
		} else {
			//return "failure";
			return new ResponseEntity<ApplicationUser>(user,HttpStatus.IM_USED);
		}

	}
}
