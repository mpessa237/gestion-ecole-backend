package com.example.Ecole_gestion.services;

import com.example.Ecole_gestion.dto.NoteReqDTO;
import com.example.Ecole_gestion.dto.NoteRespDTO;
import com.example.Ecole_gestion.entity.Note;
import com.example.Ecole_gestion.exception.RessourceNotFoundException;
import com.example.Ecole_gestion.mapper.NoteMapper;
import com.example.Ecole_gestion.repository.NoteRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NoteServiceImpl implements NoteService{
    private final NoteRepo noteRepo;
    private final NoteMapper noteMapper;

    public NoteServiceImpl(NoteRepo noteRepo, NoteMapper noteMapper) {
        this.noteRepo = noteRepo;
        this.noteMapper = noteMapper;
    }

    @Override
    public NoteRespDTO addNote(NoteReqDTO noteReqDTO) {

        Note note = noteMapper.toEntity(noteReqDTO);
        Note addNote = this.noteRepo.save(note);

        return noteMapper.toDto(addNote);
    }

    @Override
    public List<Note> getAllNote() {
        return this.noteRepo.findAll();
    }

    @Override
    public Note getNoteByValeur(Float valeur) {
        Optional<Note> note = this.noteRepo.findNoteByValeur(valeur);
        if (note.isEmpty())
            throw new RessourceNotFoundException("note not found!!");
        return note.get();
    }

    @Override
    public Note getNoteByAppreciation(String appreciation) {
        Optional<Note> note = this.noteRepo.findNoteByAppreciation(appreciation);
        if (note.isEmpty())
            throw new RessourceNotFoundException("note not found!!");
        return note.get();
    }

    @Override
    public NoteRespDTO getNoteById(Integer noteId) {
       Note note = this.noteRepo.findById(noteId)
               .orElseThrow(()-> new RessourceNotFoundException("note not found!!"));
       return noteMapper.toDto(note);
    }

    @Override
    public Note updateNote(Note note, Integer noteId) {
        Optional<Note> noteOptional = this.noteRepo.findById(noteId);
        if (noteOptional.isEmpty())
            throw new RessourceNotFoundException("note not found!!");

        if (note.getAppreciation()!=null)
            noteOptional.get().setAppreciation(note.getAppreciation());
        if (note.getValeur()!=null)
            noteOptional.get().setValeur(note.getValeur());

        return this.noteRepo.saveAndFlush(noteOptional.get());
    }

    @Override
    public void deleteNoteById(Integer noteId) {
        this.noteRepo.delete(this.noteRepo.findById(noteId)
                .orElseThrow(()->new RessourceNotFoundException("note not found!!")
        ));

    }
}
