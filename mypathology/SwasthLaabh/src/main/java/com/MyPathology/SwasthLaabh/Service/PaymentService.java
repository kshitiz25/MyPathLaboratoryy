package com.MyPathology.SwasthLaabh.Service;

import com.MyPathology.SwasthLaabh.Entity.Booking;
import com.MyPathology.SwasthLaabh.Entity.Payment;
import com.MyPathology.SwasthLaabh.Repository.PaymentRepository;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private BookingService bookingService;

    private RazorpayClient razorpayClient;

    public PaymentService() throws RazorpayException {
        razorpayClient = new RazorpayClient("YOUR_RAZORPAY_KEY", "YOUR_RAZORPAY_SECRET");
    }

    public String initiatePayment(Booking booking) throws RazorpayException {
        JSONObject orderRequest = new JSONObject();
        orderRequest.put("amount", booking.getTest().getPrice() * 100); // Amount in paise
        orderRequest.put("currency", "INR");
        orderRequest.put("receipt", booking.getId().toString());

        Order order = razorpayClient.Orders.create(orderRequest);

        // Save payment details in DB
        Payment payment = new Payment();
        payment.setBooking(booking);
        payment.setRazorpayPaymentId(order.get("id"));
        payment.setStatus("PENDING");
        paymentRepository.save(payment);

        return order.toString();
    }

    public void completePayment(String razorpayPaymentId, String status) {
        Payment payment = paymentRepository.findByRazorpayPaymentId(razorpayPaymentId);
        payment.setStatus(status);
        payment.setPaymentDate(LocalDateTime.now());
        paymentRepository.save(payment);
    }
}
