package com.example.fineproject.repository;

import com.example.fineproject.mongo.document.Fine;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FineRepository {
    void createFine(Fine fine);
    List<Fine> findFinesWithTheSamePNC (String username, String personalNumericCode);
}
