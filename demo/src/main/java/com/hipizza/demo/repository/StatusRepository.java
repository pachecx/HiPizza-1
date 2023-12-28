package com.hipizza.demo.repository;

import com.hipizza.demo.domain.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusRepository extends JpaRepository<Status, Long> {
}
