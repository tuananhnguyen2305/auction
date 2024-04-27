package com.uet.service;

import java.util.List;

import com.uet.dto.AuctionSessionDTO;
import com.uet.dto.BiddingDTO;
import com.uet.dto.TransactionDTO;

public interface ITransactionService {
	TransactionDTO create(AuctionSessionDTO transactionDTO, BiddingDTO biddingDTO);
	List<TransactionDTO> findAll();
	TransactionDTO fineOneById(String id);
	TransactionDTO deleteOneById(String id);
	TransactionDTO updateOneById(String id, TransactionDTO transactionDTO);
}
