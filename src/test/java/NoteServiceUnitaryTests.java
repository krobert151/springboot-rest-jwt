import net.openwebinars.springboot.restjwt.note.model.Note;
import net.openwebinars.springboot.restjwt.note.repo.NoteRepository;
import net.openwebinars.springboot.restjwt.note.service.NoteService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class NoteServiceUnitaryTests {

    @Mock
    private NoteRepository repository;

    @InjectMocks
    private NoteService noteService;


    @Test
    void notesGroupedByTagsDtoList_unitaryTest(){

        List<Note> notes = List.of(
                Note.builder()
                         .title("Manolo Note")
                         .content("Manolo Note Content")
                         .author("cc8c43d0-651f-43ad-8827-69b1afffa524")
                         .important(true)
                         .createdAt(LocalDateTime.now())
                         .tags(List.of("AA","BB","CC"))
                         .build(),
                Note.builder()
                        .title("Manolo Note2")
                        .content("Manolo Note Content2")
                        .author("cc8c43d0-651f-43ad-8827-69b1afffa524")
                        .important(true)
                        .createdAt(LocalDateTime.now())
                        .tags(List.of("AA","CC"))
                        .build(),
                Note.builder()
                        .title("Manolo Note3")
                        .content("Manolo Note Content3")
                        .author("cc8c43d0-651f-43ad-8827-69b1afffa524")
                        .important(true)
                        .createdAt(LocalDateTime.now())
                        .tags(List.of("BB","CC"))
                        .build(),
                Note.builder()
                        .title("Manolo Note4")
                        .content("Manolo Note Content4")
                        .author("cc8c43d0-651f-43ad-8827-69b1afffa524")
                        .important(true)
                        .createdAt(LocalDateTime.now())
                        .tags(List.of("CC"))
                        .build(),
                Note.builder()
                        .title("Manolo Note5")
                        .content("Manolo Note Content5")
                        .author("cc8c43d0-651f-43ad-8827-69b1afffa524")
                        .important(true)
                        .createdAt(LocalDateTime.now())
                        .tags(List.of("AA"))
                        .build()
        );

        Mockito.when(repository.findByAuthor("Manolo")).thenReturn(notes);

        Assertions.assertEquals(3,noteService.notesGroupedByTagsDtoList("Manolo").size());

    }

    @Test
    void notesGroupedByTagsDtoList_returnsNull(){
        List<Note> notes = new ArrayList<>();

        Mockito.when(repository.findByAuthor("cc8c43d0-651f-43ad-8827-69b1afffa524")).thenReturn(notes);

        Assertions.assertNull(noteService.notesGroupedByTagsDtoList("cc8c43d0-651f-43ad-8827-69b1afffa524"));

    }

    @Test
    void notesGroupedByTagsDtoList_unitaryTestWithOneVoid(){

        List<Note> notes = List.of(
                Note.builder()
                        .title("Manolo Note")
                        .content("Manolo Note Content")
                        .author("cc8c43d0-651f-43ad-8827-69b1afffa524")
                        .important(true)
                        .createdAt(LocalDateTime.now())
                        .tags(List.of("AA","BB","CC"))
                        .build(),
                Note.builder()
                        .title("Manolo Note4")
                        .content("Manolo Note Content4")
                        .author("cc8c43d0-651f-43ad-8827-69b1afffa524")
                        .important(true)
                        .createdAt(LocalDateTime.now())
                        .tags(List.of())
                        .build()
        );

        Mockito.when(repository.findByAuthor("cc8c43d0-651f-43ad-8827-69b1afffa524")).thenReturn(notes);

        Assertions.assertEquals(3,noteService.notesGroupedByTagsDtoList("cc8c43d0-651f-43ad-8827-69b1afffa524").size());
        Assertions.assertEquals(1,noteService.notesGroupedByTagsDtoList("cc8c43d0-651f-43ad-8827-69b1afffa524").get(0).notes().size());

    }



}
