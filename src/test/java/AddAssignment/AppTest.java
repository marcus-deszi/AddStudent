package AddAssignment;

import org.junit.Test;
import repository.TemaXMLRepository;
import service.Service;
import validation.TemaValidator;

/**
 * Unit test for simple App.
 */
public class AppTest {
    private TemaXMLRepository fileRepository2 =
            new TemaXMLRepository(new TemaValidator(), "teme.xml");
    private Service service = new Service(null, fileRepository2, null);

    @Test
    public void addAssignmentWithEmptyId() {
        assert 1 == service.saveTema("", "Scurt.", 10, 2);
    }

    @Test
    public void addAssignmentWithOkId() {
        assert 0 == service.saveTema("1", "Scurt.", 10, 2);
    }

    @Test
    public void addAssignmentWithEmptyDescription() {
        assert 1 == service.saveTema("2", "", 10, 2);
    }

    @Test
    public void addAssignmentWithOkDescription() {
        assert 0 == service.saveTema("2", "Scurt/2.", 10, 2);
    }

    @Test
    public void addAssignmentWithInvalidStartlines() {
        assert 1 == service.saveTema("3", "Scurt/2.", 10, -1);
        assert 1 == service.saveTema("3", "Scurt/2.", 10, 15);
    }

    @Test
    public void addAssignmentWithInvalidDeadlines() {
        assert 1 == service.saveTema("3", "Scurt/2.", -1, 1);
        assert 1 == service.saveTema("3", "Scurt/2.", 15, 1);
    }

    @Test
    public void addAssignmentWithIncorrectInverval() {
        assert 1 == service.saveTema("3", "Scurt/2.", 1, 7);
    }

    @Test
    public void addAssignmentWithOkInterval() {
        assert 0 == service.saveTema("3", "Scurt/2.", 6, 2);
    }
}
