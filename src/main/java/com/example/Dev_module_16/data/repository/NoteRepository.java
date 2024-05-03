package com.example.Dev_module_16.data.repository;

import com.example.Dev_module_16.data.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteRepository extends JpaRepository <Note, Long> {
}
