package com.biat.mssc.ssm.biat.services;

import com.biat.mssc.ssm.biat.domain.Payment;
import com.biat.mssc.ssm.biat.domain.PaymentEvent;
import com.biat.mssc.ssm.biat.domain.PaymentState;
import com.biat.mssc.ssm.biat.repository.PayementRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.statemachine.StateMachine;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@SpringBootTest
class PaymentServiceImplTest {
    @Autowired
    PaymentService paymentService;
    Payment payment;
    @Autowired
    PayementRepository payementRepository;


    @BeforeEach
    void setUp() {
        payment = Payment.builder()
                .amount(new BigDecimal(23)).build();
    }

    @Transactional
    @Test
    void preAuth() {
        Payment savedPayment = paymentService.newPayement(payment);
        System.out.println("Should be NEW");
        System.out.println(savedPayment.getId());
        StateMachine<PaymentState, PaymentEvent> sm=paymentService.preAuth(savedPayment.getId());
        Payment preAuthPayment = payementRepository.getOne(savedPayment.getId());
        System.out.println(sm.getState().getId());
        System.out.println(preAuthPayment);
    }
}