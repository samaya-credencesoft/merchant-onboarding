package com.csoft.payone.service.seller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
public class PaymentController {

	PaymentRepository paymentRepository;

	public PaymentController(PaymentRepository paymentRepository) {
		this.paymentRepository = paymentRepository;
	}

	@GetMapping("/findAll")
	public ResponseEntity<List<Payment>> findAll() {
		// check user with the same name exists or not
		List payments = paymentRepository.findAll();
			return new ResponseEntity<List<Payment>>(HttpStatus.OK);
	}
	@PostMapping("/create")
	public ResponseEntity<Payment> create(@RequestBody Payment payment) {
		// check user with the same name exists or not
		payment = paymentRepository.save(payment);
		if (payment.getId() != null) {
			return new ResponseEntity<Payment>(HttpStatus.OK);
		} else {
			return new ResponseEntity<Payment>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@PutMapping("/update")
	public ResponseEntity<Payment> update(@RequestBody Payment payment) {
		Optional<Payment> paymentExisting = this.paymentRepository.findById(payment.getId());

		if (paymentExisting != null) {
			paymentRepository.save(paymentExisting);
			return new ResponseEntity<Payment>(HttpStatus.OK);
		} else {
			return new ResponseEntity<Payment>(HttpStatus.NOT_FOUND);
		}

	}

	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable("id") String id) {
		this.paymentRepository.deleteById(Long.parseLong(id));

	}

}
