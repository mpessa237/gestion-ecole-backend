package com.example.Ecole_gestion.mapper;

import com.example.Ecole_gestion.dto.NoteReqDTO;
import com.example.Ecole_gestion.dto.NoteRespDTO;
import com.example.Ecole_gestion.entity.Note;
import org.springframework.stereotype.Component;

@Component
public class NoteMapper {

    public Note toEntity(NoteReqDTO noteReqDTO){
        Note note = new Note();
        note.setValeur(noteReqDTO.getValeur());
        note.setAppreciation(noteReqDTO.getAppreciation());

        return note;
    }

    public NoteRespDTO toDto(Note note){
        NoteRespDTO noteRespDTO = new NoteRespDTO();
        noteRespDTO.setNoteId(note.getNoteId());
        noteRespDTO.setValeur(note.getValeur());
        noteRespDTO.setAppreciation(note.getAppreciation());

        return noteRespDTO;
    }
}
