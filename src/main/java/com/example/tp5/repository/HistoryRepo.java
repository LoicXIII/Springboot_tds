package com.example.tp5.repository;

import com.example.tp5.model.History;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoryRepo extends JpaRepository<History,Integer> {
}
