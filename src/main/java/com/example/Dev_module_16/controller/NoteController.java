package com.example.Dev_module_16.controller;

import com.example.Dev_module_16.data.entity.Note;
import com.example.Dev_module_16.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Validated
@Controller
@RequestMapping("/note")
public class NoteController {

    @Autowired
    private NoteService noteService;

    @GetMapping("/list")
    public ModelAndView getList() {
        ModelAndView result = new ModelAndView("notes/note");
        result.addObject("notes", noteService.listAll());
        return result;
    }

    @PostMapping("/delete")
    public String deleteNoteById(@RequestParam("id") long id) {
        noteService.deleteById(id);
        return "redirect:/note/list";
    }

    @GetMapping("/edit")
    public ModelAndView getNoteForEdit(@RequestParam(value = "id") long id) {
        ModelAndView result = new ModelAndView("notes/edit");
        result.addObject("note", noteService.getById(id));
        return result;
    }

    @PostMapping("/edit")
    public ModelAndView editNote(
            @RequestParam(value = "id") long id,
            @RequestParam(value = "title") String title,
            @RequestParam(value = "content") String content) {
        Note note = new Note();
        note.setId(id);
        note.setTitle(title);
        note.setContent(content);
        noteService.update(note);
        return new ModelAndView("redirect:/note/list");
    }

    @PostMapping("/create")
    public ModelAndView createNote(
            @RequestParam(value="title") String title,
            @RequestParam(value="content") String content) {
        Note note = new  Note();
        note.setTitle(title);
        note.setContent(content);
        noteService.add(note);
        return new ModelAndView("redirect:/note/list");
    }
}