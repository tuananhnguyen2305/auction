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
		if(transactionDTO.getAuctionId() != null) {
			transaction.setAuctionId(transactionDTO.getAuctionId());
		}
		
		AuctionSession auction = auctionSessionRepo.findOne(transaction.getAuctionId());
		transaction.setAuctionSession(auction);
		transaction.setAmount(transactionDTO.getAmount());
		transaction.setDate(DateStringConverter.convertToDate(transactionDTO.getDate()));
		transaction.setOwnerId(transactionDTO.getOwnerId());
		transaction.setWinerId(transactionDTO.getWinerId());
		return transaction;
	}
	
	public TransactionDTO toDTO(Transaction transaction) {
		TransactionDTO transactionDTO = new TransactionDTO();
		transactionDTO.setAmount(transaction.getAmount());
		transactionDTO.setDate(DateStringConverter.convertToString(transaction.getDate()));
		transactionDTO.setAuctionId(transaction.getAuctionId());
		transactionDTO.setOwnerId(transaction.getOwnerId());
		transactionDTO.setWinerId(transaction.getWinerId());
		return transactionDTO;
	}
}
