package com.backend.management.repository;

import com.backend.management.model.Amenity;
import com.backend.management.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AmenityRepository extends JpaRepository<Amenity, Long> {
    List<Amenity> findByAmenityID(Amenity amenity_id);
    Amenity findByIdAndUsername(Long id, User username); //for deletion
}
