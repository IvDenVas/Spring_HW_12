package ru.gb.Spring_HW_12.service.impl;

import org.junit.jupiter.api.Test;
import ru.gb.Spring_HW_12.model.Note;
import ru.gb.Spring_HW_12.repository.NoteRepo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class NoteServiceImplementsUnitTest {

    @Test
    public void newNoteTest(){
        NoteRepo noteRepo = mock(NoteRepo.class);
        NoteServiceImplements noteServiceImplements = new NoteServiceImplements(noteRepo);
        Note note = new Note(1L,"1","1", LocalDateTime.now());
        List<Note> list = new ArrayList<>();
        list.add(note);

        when(noteRepo.save(note)).thenReturn(note);
        assertEquals(note,noteServiceImplements.newNote(note));
    }

    @Test
    public void getAllNotesTest(){
        NoteRepo noteRepo = mock(NoteRepo.class);
        NoteServiceImplements noteServiceImplements = new NoteServiceImplements(noteRepo);
        List<Note> list = new ArrayList<>();
        Note note1 = new Note(1L,"1","1", LocalDateTime.now());
        Note note2 = new Note(2L,"2","2", LocalDateTime.now());
        Note note3 = new Note(3L,"3","3", LocalDateTime.now());
        list.add(note1);
        list.add(note2);
        list.add(note3);

        when(noteRepo.findAll()).thenReturn(list);

        List<Note> result = noteServiceImplements.getAllNotes();

        assertEquals(3,result.size());
        assertEquals(note1,noteServiceImplements.getAllNotes().get(0));
        assertEquals(note2,noteServiceImplements.getAllNotes().get(1));
        assertEquals(note3,noteServiceImplements.getAllNotes().get(2));
        assertNotEquals(4,result.size());
    }

    @Test
    public void getNoteByIdTest(){
        NoteRepo noteRepo = mock(NoteRepo.class);
        NoteServiceImplements noteServiceImplements = new NoteServiceImplements(noteRepo);
        Note note = new Note(123L,"Test","Des",LocalDateTime.now());

        when(noteRepo.findById(123L)).thenReturn(Optional.of(note));
        assertEquals(note,noteServiceImplements.getNoteById(123L));
        verify(noteRepo).findById(123L);
    }

    @Test
    public void updateNoteTest(){
        NoteRepo noteRepo = mock(NoteRepo.class);
        NoteServiceImplements noteServiceImplements = new NoteServiceImplements(noteRepo);
        Long id = 1L;
        Note note = new Note(id, "1", "1", LocalDateTime.now());
        Note updatedNote = new Note(id, "2", "2", LocalDateTime.now());

        when(noteRepo.findById(id)).thenReturn(Optional.of(note));
        when(noteRepo.save(note)).thenReturn(note);

        Note result = noteServiceImplements.updateNote(id, updatedNote);

        assertEquals(updatedNote.getTitle(), result.getTitle());
        assertEquals(updatedNote.getDescription(), result.getDescription());
        assertEquals(updatedNote.getDateTime(), result.getDateTime());
    }
}