package com.uet.auction.repository;

import com.uet.auction.entity.Transport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITransportRepository extends JpaRepository<Transport, Integer> {
}
