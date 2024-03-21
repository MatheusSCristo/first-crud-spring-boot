package com.matheus.crud.Repository;

import com.matheus.crud.Domain.Clothes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClothesRepository extends JpaRepository<Clothes,String> {
}
