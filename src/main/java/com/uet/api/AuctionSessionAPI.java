package com.uet.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.uet.dto.AuctionSessionDTO;
import com.uet.dto.BiddingDTO;
import com.uet.service.IAuctionSessionService;
import com.uet.service.IBiddingService;

@RestController
public class AuctionSessionAPI {
	@Autowired
	private IAuctionSessionService auctionSessionService;
	
	@Autowired
	private IBiddingService biddingService;
	
	@PostMapping("/auction_session")
	public ResponseEntity<?> createOne(@RequestBody AuctionSessionDTO auctionSessionDTO) {
		try {
			return new ResponseEntity<>(auctionSessionService.save(auctionSessionDTO), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>("Tạo phiên đấu giá không thành công", HttpStatus.CREATED);
		}
	}
	
	@GetMapping("/auction_session/{id}")
	public ResponseEntity<?> findOneById(@PathVariable String id) {
		try {
			return new ResponseEntity<>(auctionSessionService.findOneById(id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("Cập nhật phiên đấu giá không thành công", HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/auction_session")
	public ResponseEntity<?> findAll() {
		try {
			return new ResponseEntity<>(auctionSessionService.findAll(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("Cập nhật phiên đấu giá không thành công", HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/auction_session/{id}")
	public ResponseEntity<?> updateOneById(@RequestBody AuctionSessionDTO auctionSessionDTO, @PathVariable String id) {
		try {
			auctionSessionDTO.setAuctionId(id);
			return new ResponseEntity<>(auctionSessionService.save(auctionSessionDTO), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("Cập nhật phiên đấu giá không thành công", HttpStatus.BAD_REQUEST);
		}

	}
	
	@DeleteMapping("/auction_session/{id}")
	public ResponseEntity<?> deleteOne(@PathVariable String id) {
		try {
			List<BiddingDTO> biddingDTOs = biddingService.findAllBiddingsOfAnAuctionSession(id);
			for (BiddingDTO biddingDTO : biddingDTOs) {
				biddingService.deleteOneById(biddingDTO.getBiddingId());
			}
			return new ResponseEntity<>(auctionSessionService.deleteOneById(id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("Xóa phiên đấu giá không thành công", HttpStatus.BAD_REQUEST);
		}
	}
}
