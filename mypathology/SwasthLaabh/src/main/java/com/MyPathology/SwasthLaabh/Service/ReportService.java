package com.MyPathology.SwasthLaabh.Service;

import com.MyPathology.SwasthLaabh.Entity.Booking;
import com.MyPathology.SwasthLaabh.Entity.Report;
import com.MyPathology.SwasthLaabh.Repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;

@Service
public class ReportService {

    @Autowired
    private ReportRepository reportRepository;

    private final String REPORT_DIR = "/path/to/reports/";

    public String uploadReport(MultipartFile file, Booking booking) throws IOException {
        // Save the file locally
        String fileName = "report_" + booking.getId() + "_" + file.getOriginalFilename();
        Files.write(Paths.get(REPORT_DIR + fileName), file.getBytes());

        // Save the report URL in DB
        Report report = new Report();
        report.setBooking(booking);
        report.setReportUrl(REPORT_DIR + fileName);
        report.setUploadDate(LocalDateTime.now());
        reportRepository.save(report);

        return report.getReportUrl();
    }
}
