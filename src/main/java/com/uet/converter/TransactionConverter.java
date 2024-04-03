package com.uet.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.uet.dto.TransactionDTO;
import com.uet.entity.AuctionSession;
import com.uet.entity.Transaction;
import com.uet.repository.AuctionSessionRepo;

@Component
public class TransactionConverter {
	@Autowired
	private AuctionSessionRepo auctionSessionRepo;
	
	public Transaction toEntity(TransactionDTO transactionDTO) {
		Transaction transaction = new Transaction();
		transaction.setAmount(transactionDTO.getAmount());
		transaction.setDate(transactionDTO.getDate());
		transaction.setOwnerId(transactionDTO.getOwnerId());
		transaction.setWinerId(transactionDTO.getWinerId());
		AuctionSession auctionSession = auctionSessionRepo.findOne(transactionDTO.getAuctionId());
		transaction.setAuctionSession(auctionSession);
		return transaction;
	}
	
	public TransactionDTO toDTO(Transaction transaction) {
		TransactionDTO transactionDTO = new TransactionDTO();
		transactionDTO.setAmount(transaction.getAmount());
		transactionDTO.setAuctionId(transaction.getAuctionSession().getAuctionId());
		transactionDTO.setDate(transaction.getDate());
		transactionDTO.setId(transaction.getId());
		transactionDTO.setOwnerId(transaction.getOwnerId());
		transactionDTO.setWinerId(transaction.getWinerId());
		return transactionDTO;
	}
}
