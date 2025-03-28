package com.example.Ecole_gestion.services;

import com.example.Ecole_gestion.dto.NoteReqDTO;
import com.example.Ecole_gestion.dto.NoteRespDTO;
import com.example.Ecole_gestion.entity.Note;

import java.util.List;

public interface NoteService {
    NoteRespDTO addNote(NoteReqDTO noteReqDTO);
    List<Note> getAllNote();
    Note getNoteByValeur(Float valeur);
    Note getNoteByAppreciation(String appreciation);
    NoteRespDTO getNoteById(Integer noteId);
    Note updateNote(Note note,Integer noteId);
    void deleteNoteById(Integer noteId);
}
