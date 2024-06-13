package com.uet.auction.repository;

import com.uet.auction.entity.License;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILicenseRepository extends JpaRepository<License, Integer> {
    License findByLicenseId(String id);

}
