package com.pcpartpicker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pcpartpicker.domain.Complaint;

@Repository

public interface ComplaintRepository extends JpaRepository<Complaint, Long> {

    

}
