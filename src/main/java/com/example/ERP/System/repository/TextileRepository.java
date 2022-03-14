package com.example.ERP.System.repository;

import com.example.ERP.System.model.Textile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TextileRepository extends JpaRepository<Textile, Long> {
    //    @Query("UPDATE textile SET quantity = :textile.getQuantity")
//    Textile updateByID(@Param("id") Textile textile);
//    @SQLUpdate("UPDATE textile Set quatitu ")
    @Modifying
    @Query("update Textile t set t.quantity = :quantity WHERE t.id = :id")
    void updateMaterial(@Param("id") Long id, @Param("quantity") int quantity);

}
