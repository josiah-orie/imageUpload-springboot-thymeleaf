package com.jovine360.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jovine360.entity.FileData;

public interface FileDataRepository extends JpaRepository<FileData, Long> {

	Optional<FileData> findByName(String filename);
}
