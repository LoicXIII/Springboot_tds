package com.example.tp5.repository;

import com.example.tp5.model.History;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoryRepository extends JpaRepository<History,Integer> {
    public History History();
}
