package com.biat.mssc.ssm.biat.repository;

import com.biat.mssc.ssm.biat.domain.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PayementRepository extends JpaRepository<Payment,Long> {
}
