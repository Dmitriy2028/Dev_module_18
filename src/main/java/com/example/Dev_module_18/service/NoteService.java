package com.example.Dev_module_18.service;

import com.example.Dev_module_18.data.entity.Note;
import com.example.Dev_module_18.service.exception.NoteNotFoundException;

import java.util.List;

public interface NoteService {

    List<Note> listAll();

    Note add(Note note);

    void deleteById(long id) throws NoteNotFoundException;

    void update(Note note) throws NoteNotFoundException;

    Note getById(long id) throws NoteNotFoundException;
}
