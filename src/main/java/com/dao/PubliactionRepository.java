package com.dao;


import com.Entity.Publication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PubliactionRepository extends JpaRepository<Publication,Long> {
    List<Publication> findByPoint(String point);
}
