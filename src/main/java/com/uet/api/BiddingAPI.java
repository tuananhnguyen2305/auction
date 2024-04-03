package com.uet.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	public BiddingDTO create(@RequestBody BiddingDTO biddingDTO) {
		return biddingService.create(biddingDTO);
	}
	
	@GetMapping("/bidding/{id}")
	public BiddingDTO findOneById(@PathVariable int id) {
		return biddingService.findOneById(id);
	}
	
	@GetMapping("/bidding")
	public List<BiddingDTO> findAll() {
		return biddingService.findAll();
	}
}
