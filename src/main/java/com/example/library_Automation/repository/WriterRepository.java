package com.example.library_Automation.repository;

import com.example.library_Automation.entity.WriterEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WriterRepository extends JpaRepository<WriterEntity,Long> {
    WriterEntity getByName(String name);
}
