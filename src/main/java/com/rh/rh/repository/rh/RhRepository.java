package com.rh.rh.repository.rh;

import com.rh.rh.entity.Rh;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RhRepository extends JpaRepository<Rh, Long> {
    Optional<Rh> findByUsername(String username);
    Optional<List<Rh>> findByRole(String code);
}
