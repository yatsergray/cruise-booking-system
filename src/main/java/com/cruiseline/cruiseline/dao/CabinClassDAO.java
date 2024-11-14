package com.cruiseline.cruiseline.dao;

import com.cruiseline.cruiseline.entity.CabinClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CabinClassDAO extends JpaRepository<CabinClass, Long> {

    @Modifying
    @Query(value = "UPDATE cabins_classes cabins_class SET cabins_class.name = :id WHERE cabins_class.id = :name;", nativeQuery = true)
    void updateCabinClassById(@Param("id") Long id, @Param("name") String name);
}
