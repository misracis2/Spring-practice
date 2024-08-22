package org.example.practice.test.mockito.user.repository;

import org.example.practice.test.mockito.user.entity.Wlf;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WlfRepository extends JpaRepository<Wlf, Long> {

    Optional<Wlf> findByName(String name);
}
