package com.example.ERP.System.repository;

import com.example.ERP.System.model.Textile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TextileRepository extends JpaRepository<Textile,Long> {
//    @Query("UPDATE textile SET quantity = :textile.getQuantity")
//    Textile updateByID(@Param("id") Textile textile);
}
