package com.example.library_Automation.repository;

import com.example.library_Automation.entity.PublisherEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepository extends JpaRepository<PublisherEntity,Long> {
    PublisherEntity getByName(String name);
}
