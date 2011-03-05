package fhdw.ipscrum.phase3.gruppe3;

import java.util.Date;
import fhdw.ipscrum.shared.model.interfaces.ITaskState;
import fhdw.ipscrum.shared.model.ProductBacklog;
import java.util.Iterator;
import fhdw.ipscrum.shared.model.interfaces.IPerson;
import fhdw.ipscrum.shared.model.ProductBacklogItem;
import fhdw.ipscrum.shared.model.Bug;
import fhdw.ipscrum.shared.model.Person;
import org.junit.*;
import fhdw.ipscrum.shared.exceptions.NoValidValueException;
import fhdw.ipscrum.shared.model.Task;
import static org.junit.Assert.*;

/**
 * The class <code>TaskTest</code> contains tests for the class <code>{@link Task}</code>.
 *
 * @generatedBy CodePro at 05.03.11 11:25
 * @author wolf
 * @version $Revision: 1.0 $
 */
public class TaskTest {
	/**
	 * Run the Task(String,String) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 05.03.11 11:25
	 */
	@Test(expected = fhdw.ipscrum.shared.exceptions.NoValidValueException.class)
	public void testTask_1()
		throws Exception {
		String name = "";
		String description = "";

		Task result = new Task(name, description);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the Task(String,String) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 05.03.11 11:25
	 */
	@Test(expected = fhdw.ipscrum.shared.exceptions.NoValidValueException.class)
	public void testTask_2()
		throws Exception {
		String name = "";
		String description = "";

		Task result = new Task(name, description);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the Task(String,String) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 05.03.11 11:25
	 */
	@Test(expected = fhdw.ipscrum.shared.exceptions.NoValidValueException.class)
	public void testTask_3()
		throws Exception {
		String name = "";
		String description = "";

		Task result = new Task(name, description);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the void addPBI(ProductBacklogItem) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 05.03.11 11:25
	 */
	@Test
	public void testAddPBI_1()
		throws Exception {
		Task fixture = new Task("", "");
		ProductBacklogItem pbi = new Bug("", "", (ProductBacklog) null);

		fixture.addPBI(pbi);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    fhdw.ipscrum.shared.exceptions.NoValidValueException: Es muss ein vollständiger Name angegeben werden.
		//       at fhdw.ipscrum.shared.model.Task.doSetName(Task.java:77)
		//       at fhdw.ipscrum.shared.model.TaskUnassigned.setName(TaskUnassigned.java:25)
		//       at fhdw.ipscrum.shared.model.Task.setName(Task.java:161)
		//       at fhdw.ipscrum.shared.model.Task.<init>(Task.java:35)
	}

	/**
	 * Run the void addPBI(ProductBacklogItem) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 05.03.11 11:25
	 */
	@Test
	public void testAddPBI_2()
		throws Exception {
		Task fixture = new Task("", "");
		ProductBacklogItem pbi = new Bug("", "", (ProductBacklog) null);

		fixture.addPBI(pbi);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    fhdw.ipscrum.shared.exceptions.NoValidValueException: Es muss ein vollständiger Name angegeben werden.
		//       at fhdw.ipscrum.shared.model.Task.doSetName(Task.java:77)
		//       at fhdw.ipscrum.shared.model.TaskUnassigned.setName(TaskUnassigned.java:25)
		//       at fhdw.ipscrum.shared.model.Task.setName(Task.java:161)
		//       at fhdw.ipscrum.shared.model.Task.<init>(Task.java:35)
	}

	/**
	 * Run the void finish() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 05.03.11 11:25
	 */
	@Test
	public void testFinish_1()
		throws Exception {
		Task fixture = new Task("", "");

		fixture.finish();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    fhdw.ipscrum.shared.exceptions.NoValidValueException: Es muss ein vollständiger Name angegeben werden.
		//       at fhdw.ipscrum.shared.model.Task.doSetName(Task.java:77)
		//       at fhdw.ipscrum.shared.model.TaskUnassigned.setName(TaskUnassigned.java:25)
		//       at fhdw.ipscrum.shared.model.Task.setName(Task.java:161)
		//       at fhdw.ipscrum.shared.model.Task.<init>(Task.java:35)
	}

	/**
	 * Run the void finish() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 05.03.11 11:25
	 */
	@Test
	public void testFinish_2()
		throws Exception {
		Task fixture = new Task("", "");

		fixture.finish();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    fhdw.ipscrum.shared.exceptions.NoValidValueException: Es muss ein vollständiger Name angegeben werden.
		//       at fhdw.ipscrum.shared.model.Task.doSetName(Task.java:77)
		//       at fhdw.ipscrum.shared.model.TaskUnassigned.setName(TaskUnassigned.java:25)
		//       at fhdw.ipscrum.shared.model.Task.setName(Task.java:161)
		//       at fhdw.ipscrum.shared.model.Task.<init>(Task.java:35)
	}

	/**
	 * Run the String getDescription() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 05.03.11 11:25
	 */
	@Test
	public void testGetDescription_1()
		throws Exception {
		Task fixture = new Task("", "");

		String result = fixture.getDescription();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    fhdw.ipscrum.shared.exceptions.NoValidValueException: Es muss ein vollständiger Name angegeben werden.
		//       at fhdw.ipscrum.shared.model.Task.doSetName(Task.java:77)
		//       at fhdw.ipscrum.shared.model.TaskUnassigned.setName(TaskUnassigned.java:25)
		//       at fhdw.ipscrum.shared.model.Task.setName(Task.java:161)
		//       at fhdw.ipscrum.shared.model.Task.<init>(Task.java:35)
		assertNotNull(result);
	}

	/**
	 * Run the Date getFinishDate() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 05.03.11 11:25
	 */
	@Test
	public void testGetFinishDate_1()
		throws Exception {
		Task fixture = new Task("", "");

		Date result = fixture.getFinishDate();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    fhdw.ipscrum.shared.exceptions.NoValidValueException: Es muss ein vollständiger Name angegeben werden.
		//       at fhdw.ipscrum.shared.model.Task.doSetName(Task.java:77)
		//       at fhdw.ipscrum.shared.model.TaskUnassigned.setName(TaskUnassigned.java:25)
		//       at fhdw.ipscrum.shared.model.Task.setName(Task.java:161)
		//       at fhdw.ipscrum.shared.model.Task.<init>(Task.java:35)
		assertNotNull(result);
	}

	/**
	 * Run the String getName() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 05.03.11 11:25
	 */
	@Test
	public void testGetName_1()
		throws Exception {
		Task fixture = new Task("", "");

		String result = fixture.getName();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    fhdw.ipscrum.shared.exceptions.NoValidValueException: Es muss ein vollständiger Name angegeben werden.
		//       at fhdw.ipscrum.shared.model.Task.doSetName(Task.java:77)
		//       at fhdw.ipscrum.shared.model.TaskUnassigned.setName(TaskUnassigned.java:25)
		//       at fhdw.ipscrum.shared.model.Task.setName(Task.java:161)
		//       at fhdw.ipscrum.shared.model.Task.<init>(Task.java:35)
		assertNotNull(result);
	}

	/**
	 * Run the Iterator<ProductBacklogItem> getPBIIterator() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 05.03.11 11:25
	 */
	@Test
	public void testGetPBIIterator_1()
		throws Exception {
		Task fixture = new Task("", "");

		Iterator<ProductBacklogItem> result = fixture.getPBIIterator();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    fhdw.ipscrum.shared.exceptions.NoValidValueException: Es muss ein vollständiger Name angegeben werden.
		//       at fhdw.ipscrum.shared.model.Task.doSetName(Task.java:77)
		//       at fhdw.ipscrum.shared.model.TaskUnassigned.setName(TaskUnassigned.java:25)
		//       at fhdw.ipscrum.shared.model.Task.setName(Task.java:161)
		//       at fhdw.ipscrum.shared.model.Task.<init>(Task.java:35)
		assertNotNull(result);
	}

	/**
	 * Run the Integer getPlanEffort() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 05.03.11 11:25
	 */
	@Test
	public void testGetPlanEffort_1()
		throws Exception {
		Task fixture = new Task("", "");

		Integer result = fixture.getPlanEffort();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    fhdw.ipscrum.shared.exceptions.NoValidValueException: Es muss ein vollständiger Name angegeben werden.
		//       at fhdw.ipscrum.shared.model.Task.doSetName(Task.java:77)
		//       at fhdw.ipscrum.shared.model.TaskUnassigned.setName(TaskUnassigned.java:25)
		//       at fhdw.ipscrum.shared.model.Task.setName(Task.java:161)
		//       at fhdw.ipscrum.shared.model.Task.<init>(Task.java:35)
		assertNotNull(result);
	}

	/**
	 * Run the IPerson getResponsiblePerson() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 05.03.11 11:25
	 */
	@Test
	public void testGetResponsiblePerson_1()
		throws Exception {
		Task fixture = new Task("", "");

		IPerson result = fixture.getResponsiblePerson();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    fhdw.ipscrum.shared.exceptions.NoValidValueException: Es muss ein vollständiger Name angegeben werden.
		//       at fhdw.ipscrum.shared.model.Task.doSetName(Task.java:77)
		//       at fhdw.ipscrum.shared.model.TaskUnassigned.setName(TaskUnassigned.java:25)
		//       at fhdw.ipscrum.shared.model.Task.setName(Task.java:161)
		//       at fhdw.ipscrum.shared.model.Task.<init>(Task.java:35)
		assertNotNull(result);
	}

	/**
	 * Run the ITaskState getState() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 05.03.11 11:25
	 */
	@Test
	public void testGetState_1()
		throws Exception {
		Task fixture = new Task("", "");

		ITaskState result = fixture.getState();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    fhdw.ipscrum.shared.exceptions.NoValidValueException: Es muss ein vollständiger Name angegeben werden.
		//       at fhdw.ipscrum.shared.model.Task.doSetName(Task.java:77)
		//       at fhdw.ipscrum.shared.model.TaskUnassigned.setName(TaskUnassigned.java:25)
		//       at fhdw.ipscrum.shared.model.Task.setName(Task.java:161)
		//       at fhdw.ipscrum.shared.model.Task.<init>(Task.java:35)
		assertNotNull(result);
	}

	/**
	 * Run the boolean hasResponsiblePerson() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 05.03.11 11:25
	 */
	@Test
	public void testHasResponsiblePerson_1()
		throws Exception {
		Task fixture = new Task("", "");

		boolean result = fixture.hasResponsiblePerson();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    fhdw.ipscrum.shared.exceptions.NoValidValueException: Es muss ein vollständiger Name angegeben werden.
		//       at fhdw.ipscrum.shared.model.Task.doSetName(Task.java:77)
		//       at fhdw.ipscrum.shared.model.TaskUnassigned.setName(TaskUnassigned.java:25)
		//       at fhdw.ipscrum.shared.model.Task.setName(Task.java:161)
		//       at fhdw.ipscrum.shared.model.Task.<init>(Task.java:35)
		assertTrue(result);
	}

	/**
	 * Run the boolean hasResponsiblePerson() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 05.03.11 11:25
	 */
	@Test
	public void testHasResponsiblePerson_2()
		throws Exception {
		Task fixture = new Task("", "");

		boolean result = fixture.hasResponsiblePerson();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    fhdw.ipscrum.shared.exceptions.NoValidValueException: Es muss ein vollständiger Name angegeben werden.
		//       at fhdw.ipscrum.shared.model.Task.doSetName(Task.java:77)
		//       at fhdw.ipscrum.shared.model.TaskUnassigned.setName(TaskUnassigned.java:25)
		//       at fhdw.ipscrum.shared.model.Task.setName(Task.java:161)
		//       at fhdw.ipscrum.shared.model.Task.<init>(Task.java:35)
		assertTrue(result);
	}

	/**
	 * Run the boolean isFinished() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 05.03.11 11:25
	 */
	@Test
	public void testIsFinished_1()
		throws Exception {
		Task fixture = new Task("", "");

		boolean result = fixture.isFinished();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    fhdw.ipscrum.shared.exceptions.NoValidValueException: Es muss ein vollständiger Name angegeben werden.
		//       at fhdw.ipscrum.shared.model.Task.doSetName(Task.java:77)
		//       at fhdw.ipscrum.shared.model.TaskUnassigned.setName(TaskUnassigned.java:25)
		//       at fhdw.ipscrum.shared.model.Task.setName(Task.java:161)
		//       at fhdw.ipscrum.shared.model.Task.<init>(Task.java:35)
		assertTrue(result);
	}

	/**
	 * Run the boolean isFinished() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 05.03.11 11:25
	 */
	@Test
	public void testIsFinished_2()
		throws Exception {
		Task fixture = new Task("", "");

		boolean result = fixture.isFinished();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    fhdw.ipscrum.shared.exceptions.NoValidValueException: Es muss ein vollständiger Name angegeben werden.
		//       at fhdw.ipscrum.shared.model.Task.doSetName(Task.java:77)
		//       at fhdw.ipscrum.shared.model.TaskUnassigned.setName(TaskUnassigned.java:25)
		//       at fhdw.ipscrum.shared.model.Task.setName(Task.java:161)
		//       at fhdw.ipscrum.shared.model.Task.<init>(Task.java:35)
		assertTrue(result);
	}

	/**
	 * Run the void removePBI(ProductBacklogItem) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 05.03.11 11:25
	 */
	@Test
	public void testRemovePBI_1()
		throws Exception {
		Task fixture = new Task("", "");
		ProductBacklogItem pbi = new Bug("", "", (ProductBacklog) null);

		fixture.removePBI(pbi);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    fhdw.ipscrum.shared.exceptions.NoValidValueException: Es muss ein vollständiger Name angegeben werden.
		//       at fhdw.ipscrum.shared.model.Task.doSetName(Task.java:77)
		//       at fhdw.ipscrum.shared.model.TaskUnassigned.setName(TaskUnassigned.java:25)
		//       at fhdw.ipscrum.shared.model.Task.setName(Task.java:161)
		//       at fhdw.ipscrum.shared.model.Task.<init>(Task.java:35)
	}

	/**
	 * Run the void removePBI(ProductBacklogItem) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 05.03.11 11:25
	 */
	@Test
	public void testRemovePBI_2()
		throws Exception {
		Task fixture = new Task("", "");
		ProductBacklogItem pbi = new Bug("", "", (ProductBacklog) null);

		fixture.removePBI(pbi);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    fhdw.ipscrum.shared.exceptions.NoValidValueException: Es muss ein vollständiger Name angegeben werden.
		//       at fhdw.ipscrum.shared.model.Task.doSetName(Task.java:77)
		//       at fhdw.ipscrum.shared.model.TaskUnassigned.setName(TaskUnassigned.java:25)
		//       at fhdw.ipscrum.shared.model.Task.setName(Task.java:161)
		//       at fhdw.ipscrum.shared.model.Task.<init>(Task.java:35)
	}

	/**
	 * Run the void setDescription(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 05.03.11 11:25
	 */
	@Test(expected = fhdw.ipscrum.shared.exceptions.NoValidValueException.class)
	public void testSetDescription_1()
		throws Exception {
		Task fixture = new Task("", "");
		String description = "";

		fixture.setDescription(description);

		// add additional test code here
	}

	/**
	 * Run the void setDescription(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 05.03.11 11:25
	 */
	@Test(expected = fhdw.ipscrum.shared.exceptions.NoValidValueException.class)
	public void testSetDescription_2()
		throws Exception {
		Task fixture = new Task("", "");
		String description = "";

		fixture.setDescription(description);

		// add additional test code here
	}

	/**
	 * Run the void setDescription(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 05.03.11 11:25
	 */
	@Test(expected = fhdw.ipscrum.shared.exceptions.NoValidValueException.class)
	public void testSetDescription_3()
		throws Exception {
		Task fixture = new Task("", "");
		String description = "";

		fixture.setDescription(description);

		// add additional test code here
	}

	/**
	 * Run the void setName(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 05.03.11 11:25
	 */
	@Test(expected = fhdw.ipscrum.shared.exceptions.NoValidValueException.class)
	public void testSetName_1()
		throws Exception {
		Task fixture = new Task("", "");
		String name = "";

		fixture.setName(name);

		// add additional test code here
	}

	/**
	 * Run the void setName(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 05.03.11 11:25
	 */
	@Test(expected = fhdw.ipscrum.shared.exceptions.NoValidValueException.class)
	public void testSetName_2()
		throws Exception {
		Task fixture = new Task("", "");
		String name = "";

		fixture.setName(name);

		// add additional test code here
	}

	/**
	 * Run the void setName(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 05.03.11 11:25
	 */
	@Test(expected = fhdw.ipscrum.shared.exceptions.NoValidValueException.class)
	public void testSetName_3()
		throws Exception {
		Task fixture = new Task("", "");
		String name = "";

		fixture.setName(name);

		// add additional test code here
	}

	/**
	 * Run the void setResponsibility(IPerson) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 05.03.11 11:25
	 */
	@Test
	public void testSetResponsibility_1()
		throws Exception {
		Task fixture = new Task("", "");
		IPerson responsiblePerson = new Person("", "");

		fixture.setResponsibility(responsiblePerson);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    fhdw.ipscrum.shared.exceptions.NoValidValueException: Es muss ein vollständiger Name angegeben werden.
		//       at fhdw.ipscrum.shared.model.Task.doSetName(Task.java:77)
		//       at fhdw.ipscrum.shared.model.TaskUnassigned.setName(TaskUnassigned.java:25)
		//       at fhdw.ipscrum.shared.model.Task.setName(Task.java:161)
		//       at fhdw.ipscrum.shared.model.Task.<init>(Task.java:35)
	}

	/**
	 * Run the void setResponsibility(IPerson) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 05.03.11 11:25
	 */
	@Test
	public void testSetResponsibility_2()
		throws Exception {
		Task fixture = new Task("", "");
		IPerson responsiblePerson = new Person("", "");

		fixture.setResponsibility(responsiblePerson);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    fhdw.ipscrum.shared.exceptions.NoValidValueException: Es muss ein vollständiger Name angegeben werden.
		//       at fhdw.ipscrum.shared.model.Task.doSetName(Task.java:77)
		//       at fhdw.ipscrum.shared.model.TaskUnassigned.setName(TaskUnassigned.java:25)
		//       at fhdw.ipscrum.shared.model.Task.setName(Task.java:161)
		//       at fhdw.ipscrum.shared.model.Task.<init>(Task.java:35)
	}

	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *         if the initialization fails for some reason
	 *
	 * @generatedBy CodePro at 05.03.11 11:25
	 */
	@Before
	public void setUp()
		throws Exception {
		// add additional set up code here
	}

	/**
	 * Perform post-test clean-up.
	 *
	 * @throws Exception
	 *         if the clean-up fails for some reason
	 *
	 * @generatedBy CodePro at 05.03.11 11:25
	 */
	@After
	public void tearDown()
		throws Exception {
		// Add additional tear down code here
	}

	/**
	 * Launch the test.
	 *
	 * @param args the command line arguments
	 *
	 * @generatedBy CodePro at 05.03.11 11:25
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(TaskTest.class);
	}
}