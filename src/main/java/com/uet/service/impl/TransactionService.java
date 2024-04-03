package com.uet.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uet.converter.TransactionConverter;
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
	public TransactionDTO create(TransactionDTO transactionDTO) {
		Transaction transaction = transactionConverter.toEntity(transactionDTO);
		transactionRepo.save(transaction);
		return transactionConverter.toDTO(transaction);
	}

	@Override
	public List<TransactionDTO> findAll() {
		List<TransactionDTO> transactionDTOs = new ArrayList<TransactionDTO>();
		for (Transaction transaction : transactionRepo.findAll()) {
			transactionDTOs.add(transactionConverter.toDTO(transaction));
		}
		return transactionDTOs;
	}
	
}
