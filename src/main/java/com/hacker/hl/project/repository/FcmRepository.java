package com.hacker.hl.project.repository;

import com.hacker.hl.project.db.entity.Fcm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FcmRepository extends JpaRepository<Fcm, Long> {

}
