package AddStudentMV;

import org.junit.Test;
import repository.StudentXMLRepository;
import service.Service;
import validation.StudentValidator;

/**
 * Unit test for simple App.
 */
public class AppTest {
    StudentXMLRepository fileRepository1 =
            new StudentXMLRepository(new StudentValidator(), "studenti.xml");
    Service service= new Service(fileRepository1, null, null);

    @Test
    public void addStudentTestCase1() {
        assert 1 == service.saveStudent("-1", "Maria", 2);
    }

    @Test
    public void addStudentTestCase2() {
        assert  1 == service.saveStudent("200", "Gigica", 1);
    }
}
