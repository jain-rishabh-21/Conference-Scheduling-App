package com.pluralsight.conference.repositories;

import com.pluralsight.conference.models.Session;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepositories extends JpaRepository<Session, Long> {
}
