import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import net.openwebinars.springboot.restjwt.RestJwtApplication;
import net.openwebinars.springboot.restjwt.note.controller.NoteController;
import net.openwebinars.springboot.restjwt.note.model.Note;
import net.openwebinars.springboot.restjwt.note.service.NoteService;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.util.List;
@WebMvcTest(NoteController.class)
@ExtendWith(SpringExtension.class)
public class NoteControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private NoteService service;

    @Test
    public void getAllNotesTest() throws Exception{


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

        when(service.findByAuthor("cc8c43d0-651f-43ad-8827-69b1afffa524")).thenReturn(notes);

        mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk());


    }

}
