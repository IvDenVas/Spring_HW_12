package ru.gb.Spring_HW_12.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.Spring_HW_12.aspect.TrackUserAction;
import ru.gb.Spring_HW_12.model.Note;
import ru.gb.Spring_HW_12.repository.NoteRepo;
import ru.gb.Spring_HW_12.service.NoteService;
import java.util.List;

@Service
@AllArgsConstructor
public class NoteServiceImplements implements NoteService {

    private NoteRepo noteRepo;
    @Override
    public List<Note> getAllNotes() {
        return noteRepo.findAll();
    }

    @Override
    public Note getNoteById(Long id) {
        return noteRepo.findById(id).get();
    }
    @TrackUserAction
    @Override
    public Note updateNote(Long id, Note note) {
        Note updateNote = noteRepo.findById(id).get();
        updateNote.setTitle(note.getTitle());
        updateNote.setDescription(note.getDescription());
        updateNote.setDateTime(note.getDateTime());
        return noteRepo.save(updateNote);
    }
    @TrackUserAction
    @Override
    public Note newNote(Note note) {
        return noteRepo.save(note);
    }
    @TrackUserAction
    @Override
    public void deleteNoteById(Long id) {
        Note note = getNoteById(id);
        noteRepo.delete(note);
    }
}