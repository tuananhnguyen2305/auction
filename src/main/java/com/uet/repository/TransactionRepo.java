package com.uet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uet.entity.Transaction;

@Repository
public interface TransactionRepo extends JpaRepository<Transaction, String>{

}
