package com.MyPathology.SwasthLaabh.Controller;

import com.MyPathology.SwasthLaabh.Entity.Booking;
import com.MyPathology.SwasthLaabh.Entity.Test;
import com.MyPathology.SwasthLaabh.Entity.User;
import com.MyPathology.SwasthLaabh.Service.BookingService;
import com.MyPathology.SwasthLaabh.Service.TestService;
import com.MyPathology.SwasthLaabh.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @Autowired
    private UserService userService;

    @Autowired
    private TestService testService;

    @PostMapping("/book")
    public ResponseEntity<Booking> bookTest(@RequestParam String email, @RequestParam Long testId) {
        User user = userService.findByEmail(email).orElseThrow(() -> new RuntimeException("User not found"));
        Test test = testService.findById(testId).orElseThrow(() -> new RuntimeException("Test not found"));
        return new ResponseEntity<>(bookingService.bookTest(user, test), HttpStatus.CREATED);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<Booking>> getUserBookings(@PathVariable Long userId) {
        User user = userService.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        return new ResponseEntity<>(bookingService.getBookingsForUser(user), HttpStatus.OK);
    }
}
