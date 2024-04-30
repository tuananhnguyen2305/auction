package com.uet.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.uet.dto.TransactionDTO;
import com.uet.service.ITransactionService;

@RestController
public class TransactionAPI {
	@Autowired
	private ITransactionService transactionService;
	
	
	@GetMapping("/transaction/{id}")
	public ResponseEntity<?> findOneById(@PathVariable String id) {
		try {
			return new ResponseEntity<>(transactionService.fineOneById(id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("Giao dịch không tồn tại", HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/transaction")
	public ResponseEntity<?> findAll(){
		try {
			return new ResponseEntity<>(transactionService.findAll(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("Giao dịch không tồn tại", HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/transaction/{id}")
	public ResponseEntity<?> updateOneById(@PathVariable String id, @RequestBody TransactionDTO transactionDTO) {
		try {
			transactionDTO.setAuctionId(id);
			return new ResponseEntity<>(transactionService.updateOneById(id, transactionDTO), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("Cập nhật giao dịch không thành công", HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/transaction/{id}")
	public ResponseEntity<?> deleteOneById(@PathVariable String id) {
		try {
			return new ResponseEntity<>(transactionService.deleteOneById(id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("Xóa giao dịch không thành công", HttpStatus.BAD_REQUEST);
		}
	}
}
