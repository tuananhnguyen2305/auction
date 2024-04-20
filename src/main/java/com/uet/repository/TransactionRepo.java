package com.uet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uet.entity.Transaction;

public interface TransactionRepo extends JpaRepository<Transaction, String>{

}
