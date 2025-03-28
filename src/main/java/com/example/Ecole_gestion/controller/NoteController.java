package com.example.Ecole_gestion.controller;

import com.example.Ecole_gestion.dto.NoteReqDTO;
import com.example.Ecole_gestion.dto.NoteRespDTO;
import com.example.Ecole_gestion.entity.Note;
import com.example.Ecole_gestion.services.NoteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NoteController {
    private final NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }
    @PostMapping(path = "note/add")
    @ResponseBody
    public ResponseEntity<NoteRespDTO> addNote(@RequestBody NoteReqDTO noteReqDTO){
       NoteRespDTO addNote = noteService.addNote(noteReqDTO);
       return new ResponseEntity<>(addNote, HttpStatus.CREATED);
    }
    @GetMapping(path = "note/get-all-note")
    public ResponseEntity<List<Note>> getAllNote(){
        return ResponseEntity
                .ok(this.noteService.getAllNote());
    }
    @GetMapping(path = "note/get-note-by-id/{noteId}")
    public ResponseEntity<NoteRespDTO> getNoteById(@PathVariable Integer noteId){
        return ResponseEntity
                .ok(this.noteService.getNoteById(noteId));
    }
    @GetMapping(path = "note/get-note-by-valeur/{valeur}")
    public ResponseEntity<Note> getNoteByValeur(@PathVariable Float valeur){
        return ResponseEntity
                .ok(this.noteService.getNoteByValeur(valeur));
    }
    @GetMapping(path = "note/get-note-by-appreciation/{appreciation}")
    public ResponseEntity<Note> getNoteByAppreciation(@PathVariable String appreciation){
        return ResponseEntity
                .ok(this.noteService.getNoteByAppreciation(appreciation));
    }
    @PutMapping(path = "note/update-note-by-id/{noteId}")
    public ResponseEntity<Note> updateNoteById(@RequestBody Note note,@PathVariable Integer noteId){
        return ResponseEntity
                .ok(this.noteService.updateNote(note, noteId));
    }
    @DeleteMapping(path = "note/delete-note-by-id/{noteId}")
    public ResponseEntity<String> deleteNoteById(@PathVariable Integer noteId){
        this.noteService.deleteNoteById(noteId);
        return ResponseEntity
                .ok("note deleted successfully!!");
    }
}
