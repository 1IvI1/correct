package com.example.correct.database.repositories;

import com.example.correct.database.Dictionary;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DictionaryRepository extends CrudRepository<Dictionary, Integer> {
    List<Dictionary> findAll();
}
