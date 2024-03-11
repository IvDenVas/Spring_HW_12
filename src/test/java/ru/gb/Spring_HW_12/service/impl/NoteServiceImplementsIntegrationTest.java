package ru.gb.Spring_HW_12.service.impl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import ru.gb.Spring_HW_12.model.Note;
import ru.gb.Spring_HW_12.repository.NoteRepo;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class NoteServiceImplementsIntegrationTest {

    @Autowired
    private NoteServiceImplements noteService;

    @MockBean
    private NoteRepo noteRepo;

    @Test
    public void testUpdateNote() {
        Long id = 1L;
        Note note = new Note(id, "1", "1", LocalDateTime.now());
        Note updatedNote = new Note(id, "2", "2", LocalDateTime.now());

        when(noteRepo.findById(id)).thenReturn(Optional.of(note));
        when(noteRepo.save(note)).thenReturn(updatedNote);

        Note result = noteService.updateNote(id, updatedNote);

        assertEquals(updatedNote.getTitle(), result.getTitle());
        assertEquals(updatedNote.getDescription(), result.getDescription());
        assertEquals(updatedNote.getDateTime(), result.getDateTime());
    }
}