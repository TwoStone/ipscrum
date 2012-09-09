/**
 * 
 */
package fhdw.ipscrum.shared.model.messages;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import fhdw.ipscrum.shared.model.nonMeta.Project;
import fhdw.ipscrum.shared.model.nonMeta.Sprint;
import fhdw.ipscrum.shared.model.nonMeta.Team;

/**
 * 
 */
public class SprintCompletionMessageTest extends ModelTestBase {

	/**
	 * Sprint used for tests.
	 */
	private Sprint sprint;

	@Override
	public void setUp() throws Exception {
		super.setUp();
		final Project project = new Project(this.getModel(), "Test project");
		final Team team = new Team(this.getModel(), "Test team");
		team.addProject(project);
		this.sprint =
				new Sprint(this.getModel(), "Test Sprint", "This is a test sprint!", new Date(), new Date(
						new Date().getTime() + 50000), team, project);
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.model.messages.SprintCompletionMessage#SprintCompletionMessage(fhdw.ipscrum.shared.model.nonMeta.Sprint)}
	 * .
	 */
	@Test
	public final void testSprintCompletionMessage() {
		new SprintCompletionMessage(this.sprint);
	}

	/**
	 * Test method for {@link fhdw.ipscrum.shared.model.messages.SprintCompletionMessage#getSprint()}.
	 */
	@Test
	public final void testGetSprint() {
		final SprintCompletionMessage message = new SprintCompletionMessage(this.sprint);
		Assert.assertEquals(this.sprint, message.getSprint());
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.model.messages.SprintCompletionMessage#accept(fhdw.ipscrum.shared.model.messages.MessageVisitor)}
	 * .
	 */
	@Test
	public final void testAccept() {
		new SprintCompletionMessage(this.sprint).accept(new MessageStandardVisitor() {

			@Override
			public void standardHandling() {

			}
		});
	}

}
