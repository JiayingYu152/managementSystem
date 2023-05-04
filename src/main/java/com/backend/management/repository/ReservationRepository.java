package com.backend.management.repository;

import com.backend.management.model.Reservation;
import com.backend.management.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> listByUser(User user);
    Reservation findByIdAndUsername(int reservation_id, User username); // for deletion
}

