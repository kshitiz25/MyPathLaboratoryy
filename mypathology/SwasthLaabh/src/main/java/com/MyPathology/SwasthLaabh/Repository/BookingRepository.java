package com.MyPathology.SwasthLaabh.Repository;

import com.MyPathology.SwasthLaabh.Entity.Booking;
import com.MyPathology.SwasthLaabh.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking>findByUser(User user);
}
