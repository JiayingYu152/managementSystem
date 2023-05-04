package com.backend.management.service;

import com.backend.management.exception.ReservationNotFoundException;
import com.backend.management.model.Reservation;
import com.backend.management.model.User;
import com.backend.management.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
public class ReservationService {
    private final ReservationRepository reservationRepository;

    @Autowired
    public ReservationService(ReservationRepository reservationRepository){
        this.reservationRepository = reservationRepository;
    }

    public List<Reservation> listByUser(User user){
        return reservationRepository.listByUser(user);
    }

    public Reservation findByIdAndUsername(int reservation_id, User username) throws ReservationNotFoundException {
        Reservation reservation = reservationRepository.findByIdAndUsername(reservation_id, username);
        if(reservation == null){
            throw new ReservationNotFoundException("Reservation not found");
        }
        return reservation;
    }

    public void add(Reservation reservation){
        reservationRepository.save(reservation);
    }

    @Transactional
    public void delete(int reservation_id, String username) throws ReservationNotFoundException{
        User user = new User.Builder().setUsername(username).build();
        Reservation reservation = reservationRepository.findByIdAndUsername(reservation_id, user);
        if(reservation == null){
            throw new ReservationNotFoundException("Reservation not found");
        }
        reservationRepository.delete(reservation);
    }
}
