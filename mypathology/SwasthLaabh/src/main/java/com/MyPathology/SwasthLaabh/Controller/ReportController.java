package com.MyPathology.SwasthLaabh.Controller;


import com.MyPathology.SwasthLaabh.Entity.Booking;
import com.MyPathology.SwasthLaabh.Service.BookingService;
import com.MyPathology.SwasthLaabh.Service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/reports")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @Autowired
    private BookingService bookingService;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadReport(@RequestParam("file") MultipartFile file, @RequestParam Long bookingId) throws Exception {
        Booking booking = bookingService.findById(bookingId);
        if (booking == null) {
            throw new RuntimeException("Booking not found");
        }
        String reportUrl = reportService.uploadReport(file, booking);
        return new ResponseEntity<>(reportUrl, HttpStatus.CREATED);
    }
}
