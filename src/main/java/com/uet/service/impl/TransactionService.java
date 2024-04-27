package com.uet.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uet.converter.TransactionConverter;
import com.uet.dto.AuctionSessionDTO;
import com.uet.dto.BiddingDTO;
import com.uet.dto.TransactionDTO;
import com.uet.entity.Transaction;
import com.uet.repository.TransactionRepo;
import com.uet.service.ITransactionService;

@Service
public class TransactionService implements ITransactionService {
	@Autowired
	private TransactionRepo transactionRepo;
	
	@Autowired
	private TransactionConverter transactionConverter;
	
	
	@Override
	public TransactionDTO create(AuctionSessionDTO auctionSessionDTO, BiddingDTO biddingDTO) {
		TransactionDTO transaction = new TransactionDTO();
		transaction.setAuctionId(auctionSessionDTO.getAuctionId());
		transaction.setDate(auctionSessionDTO.getEndingTime());
		transaction.setWinerId(biddingDTO.getUserId());
		transaction.setOwnerId(auctionSessionDTO.getUserId());
		transaction.setAmount(biddingDTO.getAmount());
		transactionRepo.save(transactionConverter.toEntity(transaction));
		return transaction;
	}

	@Override
	public List<TransactionDTO> findAll() {
		List<TransactionDTO> transactionDTOs = new ArrayList<TransactionDTO>();
		for (Transaction transaction : transactionRepo.findAll()) {
			transactionDTOs.add(transactionConverter.toDTO(transaction));
		}
		return transactionDTOs;
	}

	@Override
	public TransactionDTO fineOneById(String id) {
		Transaction transaction = transactionRepo.findOne(id);
		return transactionConverter.toDTO(transaction);
	}

	@Override
	public TransactionDTO deleteOneById(String id) {
		Transaction transaction = transactionRepo.findOne(id);
		transactionRepo.delete(transaction);
		return transactionConverter.toDTO(transaction);
	}

	@Override
	public TransactionDTO updateOneById(String id, TransactionDTO transactionDTO) {
		Transaction transaction = transactionRepo.findOne(id);
		if (transaction != null) {
			transaction = transactionConverter.toEntity(transactionDTO);
			transaction.setAuctionId(id);
			transactionRepo.save(transaction);
			return transactionConverter.toDTO(transaction);
		}
		return null;
	}
	
}
