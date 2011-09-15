package fhdw.ipscrum.shared.model.messages;

import org.junit.Assert;
import org.junit.Test;

import fhdw.ipscrum.shared.exceptions.IPScrumGeneralException;
import fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes.FeatureTicketType;
import fhdw.ipscrum.shared.model.nonMeta.Feature;
import fhdw.ipscrum.shared.model.nonMeta.ProductBacklogItem;
import fhdw.ipscrum.shared.model.nonMeta.Project;

/**
 * Test cases for the {@link PBICompletionMessage} class.
 */
public class PBICompletionMessageTest extends ModelTestBase {

	/**
	 * PBI for tests.
	 */
	private ProductBacklogItem item;

	@Override
	public void setUp() throws IPScrumGeneralException {
		super.setUp();
		final Project project = new Project(this.getModel(), "TestProject");
		this.item =
				new Feature(this.getModel(), new FeatureTicketType(this.getModel(),
						"TestFeatureType", "A Feature for testing!"), "TestFeature",
						"This is a test feature!", project.getBacklog());
	}

	/**
	 * Tests the method
	 * {@link PBICompletionMessage#PBICompletionMessage(ProductBacklogItem)}.
	 */
	@Test
	public void testPBICompletionMessage() {
		new PBICompletionMessage(this.item);
	}

	/**
	 * Tests the method {@link PBICompletionMessage#accept(MessageVisitor)}.
	 */
	@Test
	public void testAccept() {
		final PBICompletionMessage message = new PBICompletionMessage(this.item);
		message.accept(new MessageStandardVisitor() {

			@Override
			public void standardHandling() {

			}
		});
	}

	/**
	 * Tests the method {@link PBICompletionMessage#getPBI()}.
	 */
	@Test
	public void testGetPBI() {
		final PBICompletionMessage message = new PBICompletionMessage(this.item);
		Assert.assertEquals(this.item, message.getPBI());
	}

}
