package com.example.Dev_module_18.service.impl;

import com.example.Dev_module_18.data.entity.Note;
import com.example.Dev_module_18.data.repository.NoteRepository;
import com.example.Dev_module_18.service.NoteService;
import com.example.Dev_module_18.service.exception.NoteNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteServiceImpl implements NoteService {
    Note note = new Note();

    @Autowired
    private NoteRepository noteRepository;

    @Override
    public List<Note> listAll() {
        return noteRepository.findAll();
    }

    @Override
    public Note add(Note note) {
        return noteRepository.save(note);
    }

    @Override
    public void deleteById(long id) throws NoteNotFoundException {
        try {
            noteRepository.deleteById(id);
        }catch (Exception e) {
            throw new NoteNotFoundException(id);
        }

    }

    @Override
    public void update(Note note) throws NoteNotFoundException {
        try {
            noteRepository.save(note);
        }catch (Exception e){
            throw new NoteNotFoundException(note.getId());
        }

    }

    @Override
    public Note getById(long id) throws NoteNotFoundException {
        return noteRepository.findById(id)
                .orElseThrow(() -> new NoteNotFoundException(id));
    }
}
