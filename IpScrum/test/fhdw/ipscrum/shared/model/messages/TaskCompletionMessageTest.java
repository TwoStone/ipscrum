/**
 * 
 */
package fhdw.ipscrum.shared.model.messages;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import fhdw.ipscrum.shared.exceptions.IPScrumGeneralException;
import fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes.TaskTicketType;
import fhdw.ipscrum.shared.model.nonMeta.Project;
import fhdw.ipscrum.shared.model.nonMeta.Sprint;
import fhdw.ipscrum.shared.model.nonMeta.Task;
import fhdw.ipscrum.shared.model.nonMeta.Team;

/**
 * 
 */
public class TaskCompletionMessageTest extends ModelTestBase {

	/**
	 * The task used for tests.
	 */
	private Task task;

	@Override
	public void setUp() throws IPScrumGeneralException {
		super.setUp();

		final Project project = new Project(this.getModel(), "Test project");
		final Team team = new Team(this.getModel(), "Test team");
		team.addProject(project);
		final Sprint sprint =
				new Sprint(this.getModel(), "Test Sprint", "This is a test sprint!",
						new Date(), new Date(new Date().getTime() + 50000), team,
						project);
		this.task =
				new Task(this.getModel(), new TaskTicketType(this.getModel(),
						"TestTaskType", "This is a test task type!"), "TestTask",
						"This is a test task", sprint.getSprintBacklog());
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.model.messages.TaskCompletionMessage#TaskCompletionMessage(fhdw.ipscrum.shared.model.nonMeta.Task)}
	 * .
	 */
	@Test
	public final void testTaskCompletionMessage() {
		new TaskCompletionMessage(this.task);
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.model.messages.TaskCompletionMessage#getTask()}.
	 */
	@Test
	public final void testGetTask() {
		final TaskCompletionMessage message = new TaskCompletionMessage(this.task);
		Assert.assertEquals(this.task, message.getTask());
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.model.messages.TaskCompletionMessage#accept(fhdw.ipscrum.shared.model.messages.MessageVisitor)}
	 * .
	 */
	@Test
	public final void testAccept() {
		new TaskCompletionMessage(this.task).accept(new MessageStandardVisitor() {

			@Override
			public void standardHandling() {

			}
		});
	}

}
