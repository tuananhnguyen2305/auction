package com.uet.service;

import java.util.List;

import com.uet.dto.TransactionDTO;

public interface ITransactionService {
	TransactionDTO create(TransactionDTO transactionDTO);
	List<TransactionDTO> findAll();
}
