package com.MyPathology.SwasthLaabh.Controller;

import com.MyPathology.SwasthLaabh.Entity.Booking;
import com.MyPathology.SwasthLaabh.Service.BookingService;
import com.MyPathology.SwasthLaabh.Service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private BookingService bookingService;

    @PostMapping("/initiate")
    public ResponseEntity<String> initiatePayment(@RequestParam Long bookingId) throws Exception {
        Booking booking = bookingService.findById(bookingId);
        if (booking == null) {
            throw new RuntimeException("Booking not found");
        }
        return new ResponseEntity<>(paymentService.initiatePayment(booking), HttpStatus.CREATED);
    }

    @PostMapping("/complete")
    public ResponseEntity<Void> completePayment(@RequestParam String paymentId, @RequestParam String status) {
        paymentService.completePayment(paymentId, status);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

