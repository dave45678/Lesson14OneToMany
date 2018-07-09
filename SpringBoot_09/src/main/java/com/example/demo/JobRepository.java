package com.example.demo;

import org.springframework.data.repository.CrudRepository;

// CrudRepository<Job, Long> CrudRepository<what type to store, the type of the primary key>
public interface JobRepository extends CrudRepository<Job, Long> {
}
