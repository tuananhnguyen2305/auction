package com.uet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uet.entity.Province;

@Repository
public interface ProvinceRepo extends JpaRepository<Province, Integer>{

}
