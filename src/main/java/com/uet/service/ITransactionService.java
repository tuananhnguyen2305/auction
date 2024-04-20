package com.uet.service;

import java.util.List;

import com.uet.dto.TransactionDTO;

public interface ITransactionService {
	TransactionDTO create(TransactionDTO transactionDTO);
	List<TransactionDTO> findAll();
	TransactionDTO fineOneById(String id);
	TransactionDTO deleteOneById(String id);
	TransactionDTO updateOneById(String id, TransactionDTO transactionDTO);
}
