package com.biat.mssc.ssm.biat.services;

import com.biat.mssc.ssm.biat.domain.Payment;
import com.biat.mssc.ssm.biat.domain.PaymentEvent;
import com.biat.mssc.ssm.biat.domain.PaymentState;
import org.springframework.statemachine.StateMachine;

public interface PaymentService {

    Payment newPayement(Payment payment);

    StateMachine<PaymentState, PaymentEvent> preAuth(Long paymentId);

    StateMachine<PaymentState, PaymentEvent> authorizePayment(Long paymentId);

    StateMachine<PaymentState, PaymentEvent> declineAuth(Long paymentId);
}
