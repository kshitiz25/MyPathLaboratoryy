package com.MyPathology.SwasthLaabh.Repository;

import com.MyPathology.SwasthLaabh.Entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
    Payment findByRazorpayPaymentId(String razorpayPaymentId);
}
