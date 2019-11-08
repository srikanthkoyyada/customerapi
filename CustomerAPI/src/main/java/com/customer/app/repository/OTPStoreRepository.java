package com.customer.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.customer.app.entity.Account;
import com.customer.app.entity.OTPStore;

@Repository
public interface OTPStoreRepository extends JpaRepository<OTPStore, Long> {

}
