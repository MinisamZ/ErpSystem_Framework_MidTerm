package com.example.ERP.System.repository;

import com.example.ERP.System.model.Textile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface TextileRepository extends JpaRepository<Textile, Long> {
    //    @Query("UPDATE textile SET quantity = :textile.getQuantity")
//    Textile updateByID(@Param("id") Textile textile);
//    @SQLUpdate("UPDATE textile Set quatitu ")
    @Modifying
    @Query("update Textile t set t.quantity = :quantity where t.id = :id")
    void updateMaterial(Long id, int quantity);

//    void updateMaterial(@Param("id") Long id, @Param("quantity") int quantity);

}
