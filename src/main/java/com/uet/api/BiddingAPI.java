package com.uet.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.uet.dto.BiddingDTO;
import com.uet.service.IBiddingService;

@RestController
public class BiddingAPI {
	@Autowired
	private IBiddingService biddingService;
	
	@PostMapping("/bidding")
	public ResponseEntity<?> create(@RequestBody BiddingDTO biddingDTO) {
		try {
			return new ResponseEntity<>(biddingService.create(biddingDTO), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("Tạo lượt đấu giá không thành công", HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/bidding")
	public List<BiddingDTO> findAll() {
		return biddingService.findAll();
	}
	
	@GetMapping("/bidding/{auctionId}")
	public ResponseEntity<?> findAllBiddingsOfAnAuctionSession(@PathVariable String auctionId) {
		try {
			return new ResponseEntity<>(biddingService.findAllBiddingsOfAnAuctionSession(auctionId), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("Không tồn tại", HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("/bidding/{id}")
	public ResponseEntity<?> deleteOneById(@PathVariable int id) {
		try {
			return new ResponseEntity<>(biddingService.deleteOneById(id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("Xóa lượt đấu giá không thành công", HttpStatus.BAD_REQUEST);
		}
	}
}
