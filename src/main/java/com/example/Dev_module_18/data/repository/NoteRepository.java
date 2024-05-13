package com.example.Dev_module_18.data.repository;

import com.example.Dev_module_18.data.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteRepository extends JpaRepository <Note, Long> {
}
