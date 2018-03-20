import static org.junit.Assert.assertTrue;

import javax.ws.rs.core.Response;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.api.rest.vo.NotesHandler;

@ContextConfiguration(locations = { "file:src/main/resources/applicationContext.xml" })
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringJUnit4ClassRunner.class)
public class NoteServiceTest {

  @Autowired
  private NotesHandler handler;

  @Test
  public void testDoDeleteNote() {
    Response response = Response.status(Response.Status.OK).build();
    response = handler.doDeleteNote(1);
    assertTrue(response.getStatus() == Response.Status.OK.getStatusCode());
  }

  @Test
  public void testDoGetNote() {
    Response response = Response.status(Response.Status.OK).build();
    response = handler.doGetNote(2);
    assertTrue(response.getStatus() == Response.Status.OK.getStatusCode());
  }

  @Test
  public void testDoPostNote() {
    Response response = Response.status(Response.Status.OK).build();
    response = handler.doPostNote("ABC");
    assertTrue(response.getStatus() == Response.Status.OK.getStatusCode());
    response = handler.doPostNote("DEF");
    assertTrue(response.getStatus() == Response.Status.OK.getStatusCode());
    response = handler.doPostNote("GHI");
    assertTrue(response.getStatus() == Response.Status.OK.getStatusCode());
  }

  @Test
  public void testDoPutNote() {
    Response response = Response.status(Response.Status.OK).build();
    response = handler.doPutNote(2, "XYZ");
    assertTrue(response.getStatus() == Response.Status.OK.getStatusCode());
  }
}
