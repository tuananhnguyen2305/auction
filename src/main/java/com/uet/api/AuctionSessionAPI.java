package com.uet.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.uet.dto.AuctionSessionDTO;
import com.uet.service.IAuctionSessionService;

@RestController
public class AuctionSessionAPI {
	@Autowired
	private IAuctionSessionService auctionSessionService;
	
	@PostMapping("/auction_session")
	public AuctionSessionDTO create(@RequestBody AuctionSessionDTO auctionSessionDTO) {
		return auctionSessionService.save(auctionSessionDTO);
	}
	
	@GetMapping("/auction_session/{id}")
	public AuctionSessionDTO findOneById(@PathVariable String id) {
		return auctionSessionService.findOneById(id);
	}
	
	@GetMapping("/auction_session")
	public List<AuctionSessionDTO> findAll() {
		return auctionSessionService.findAll();
	}
	
	@PutMapping("/auction_session/{id}")
	public AuctionSessionDTO updateOneById(@RequestBody AuctionSessionDTO auctionSessionDTO, @PathVariable String id) {
		auctionSessionDTO.setAuctionId(id);
		return auctionSessionService.save(auctionSessionDTO);
	}
}
