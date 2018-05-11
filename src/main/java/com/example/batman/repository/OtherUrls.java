package com.example.batman.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("otherUrls")
public interface OtherUrls extends JpaRepository<OtherUrls, Long> {
}
