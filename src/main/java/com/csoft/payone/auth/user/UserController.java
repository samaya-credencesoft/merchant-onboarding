package com.csoft.payone.auth.user;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.api.client.json.Json;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {
	@Autowired
	private UserRepository userRepository;
	ObjectMapper mapper;
	//@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/findAll")
	public ResponseEntity<List<ApplicationUser>> findAll() {
		return new ResponseEntity<List<ApplicationUser>>(userRepository.findAll(),HttpStatus.OK);
	}
	@GetMapping("/findById/{id}")
	public ResponseEntity<?> findById(@PathVariable("id") String id) {
			return new ResponseEntity<>(userRepository.findById(Long.parseLong(id)),HttpStatus.OK);
	}
	//@PreAuthorize("hasRole('USER')")
	@GetMapping("/findByName/{username}")
	public ResponseEntity<?> findByUsername(@PathVariable("username") String username)  {
			return new ResponseEntity<>(userRepository.findByUsername(username),HttpStatus.OK);
	}
}
