package AddStudentMV;

import domain.Nota;
import domain.Student;
import domain.Tema;
import org.junit.Test;
import repository.NotaXMLRepository;
import repository.StudentXMLRepository;
import repository.TemaXMLRepository;
import service.Service;
import validation.NotaValidator;
import validation.StudentValidator;
import validation.TemaValidator;
import validation.Validator;

/**
 * Unit test for simple App.
 */
public class AppTest {
    private Validator<Student> studentValidator = new StudentValidator();
    private Validator<Tema> temaValidator = new TemaValidator();
    private Validator<Nota> notaValidator = new NotaValidator();

    private StudentXMLRepository fileRepository1;
    private NotaXMLRepository fileRepository3;

    private Service service;

    @Test
    public void addAssignmentWithEmptyId() {

        TemaXMLRepository fileRepository2 = new TemaXMLRepository(temaValidator, "teme.xml");
        service = new Service(fileRepository1, fileRepository2, fileRepository3);

        int result = service.saveTema("", "Scurt.", 10, 2);
        assert result == 1;
    }

    @Test
    public void addStudentTestCase2() {
        int result = service.saveStudent("200", "Gigica", 1);
        assert result == 1;
    }
}
