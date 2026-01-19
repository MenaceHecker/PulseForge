package com.pulseforge.repository;

import com.pulseforge.domain.EventEntity;
import com.pulseforge.domain.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface EventRepository extends JpaRepository<EventEntity, UUID> {

    Optional<EventEntity> findByUserAndIdempotencyKey(
            UserEntity user,
            String idempotencyKey
    );
}
