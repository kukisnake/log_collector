package com.example.logcollector.repository;


import com.example.logcollector.entity.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogRepository extends JpaRepository<Log, Long>, PagingAndSortingRepository<Log, Long> {

}
