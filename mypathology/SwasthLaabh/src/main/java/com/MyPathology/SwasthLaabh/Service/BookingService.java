package com.MyPathology.SwasthLaabh.Service;

import com.MyPathology.SwasthLaabh.Entity.Booking;
import com.MyPathology.SwasthLaabh.Entity.Test;
import com.MyPathology.SwasthLaabh.Entity.User;
import com.MyPathology.SwasthLaabh.Repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    public Booking bookTest(User user, Test test) {
        Booking booking = new Booking();
        booking.setUser(user);
        booking.setTest(test);
        booking.setBookingDate(LocalDateTime.now());
        booking.setPaid(false);
        return bookingRepository.save(booking);
    }

    public List<Booking> getBookingsForUser(User user) {
        return bookingRepository.findByUser(user);
    }

    public Booking findById(Long id) {
        return bookingRepository.findById(id).orElse(null);
    }
}
