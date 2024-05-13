package com.example.Dev_module_18.controller;

import com.example.Dev_module_18.data.entity.Note;
import com.example.Dev_module_18.service.NoteService;
import com.example.Dev_module_18.service.exception.NoteNotFoundException;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@Controller
@RequestMapping("/note")
public class NoteController {

    @Autowired
    private NoteService noteService;

    @GetMapping("/list")
    public ResponseEntity<List<Note>> getList() {
        List<Note> notes = noteService.listAll();
        return ResponseEntity.ok(notes);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteNoteById(@PathVariable Long id) {
        try {
            noteService.deleteById(id);
            return ResponseEntity.ok("Note deleted successfully");
        } catch (NoteNotFoundException ex) {
            return ResponseEntity.notFound().build();
        }
    }


    @GetMapping("/edit/{id}")
    public ResponseEntity<Note> getNoteForEdit(@PathVariable Long id) {
        try {
            Note note = noteService.getById(id);
            return ResponseEntity.ok(note);
        } catch (NoteNotFoundException ex) {
            return ResponseEntity.notFound().build();
        }
    }


    @PutMapping("/edit/{id}")
    public ResponseEntity<String> editNote(
            @PathVariable Long  id,
            @RequestBody @NotNull Note note) {
        Note newNote = new Note();
        newNote.setId(id);
        newNote.setTitle(note.getTitle());
        newNote.setContent(note.getContent());
        try {
            noteService.update(newNote);
            return ResponseEntity.ok("Note updated successfully");
        }catch (NoteNotFoundException ex){
            return ResponseEntity.notFound().build();
        }

    }

    @PostMapping("/create")
    public ResponseEntity<String> createNote(@RequestBody Note newNote) {
        noteService.add(newNote);
        return ResponseEntity.ok("Note created successfully");
    }
}