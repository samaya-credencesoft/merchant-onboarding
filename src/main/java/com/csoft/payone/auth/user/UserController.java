package com.csoft.payone.auth.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/users")
public class UserController {
	@Autowired
	private UserRepository userRepository;
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/findAll")
	public ResponseEntity<?> findAll() {
			return new ResponseEntity<>(userRepository.findAll(),HttpStatus.OK);
	}
	@GetMapping("/findById/{id}")
	public ResponseEntity<?> findById(@PathVariable("id") String id) {
			return new ResponseEntity<>(userRepository.findById(Long.parseLong(id)),HttpStatus.OK);
	}
	@GetMapping("/findByName/{username}")
	public ResponseEntity<?> findByUsername(@PathVariable("username") String username) {
			return new ResponseEntity<>(userRepository.findByUsername(username),HttpStatus.OK);
	}
}
