package com.pluralsight.conference.repositories;

import com.pluralsight.conference.models.Speaker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpeakerRepositories extends JpaRepository<Speaker, Long> {
}
