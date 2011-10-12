package fhdw.ipscrum.shared.model.nonMeta;

import java.io.File;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import fhdw.ipscrum.client.IDGenerator;
import fhdw.ipscrum.server.ServerContext;
import fhdw.ipscrum.server.TestUtils;
import fhdw.ipscrum.shared.model.Model;

/**
 * The class <code>AcceptanceCriterionTest</code> contains tests for the class <code>{@link AcceptanceCriterion}</code>.
 */
public class AcceptanceCriterionTest {

	/**
	 * represents the model needed for the use of the IPScrum.
	 */
	private Model model;

	/**
	 * sets up the date before evey test.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Before
	public void setUp() throws Exception {
		TestUtils.deleteFolderContent(new File("output"));
		ServerContext.resetServerContext();
		this.model = ServerContext.getInstance().getPersistenceManager().getCurrentModel();
		this.model.setUuidManager(new IDGenerator());
	}

	/**
	 * Run the AcceptanceCriterion(Model,String) constructor test.
	 * 
	 * @throws Exception
	 *             Exception
	 */
	@Test
	public void testAcceptanceCriterion1() throws Exception {
		final String content = "";
		final AcceptanceCriterion result = new AcceptanceCriterion(this.model, content);
		Assert.assertNotNull(result);
	}

	/**
	 * Run the String getContent() method test.
	 * 
	 * @throws Exception
	 *             Exception
	 */
	@Test
	public void testGetContent1() throws Exception {
		final AcceptanceCriterion fixture = new AcceptanceCriterion(this.model, "");
		final String result = fixture.getContent();
		Assert.assertNotNull(result);
	}

	/**
	 * Run the void setContent(String) method test.
	 * 
	 * @throws Exception
	 *             Exception
	 */
	@Test
	public void testSetContent1() throws Exception {
		final AcceptanceCriterion fixture = new AcceptanceCriterion(this.model, "");
		final String content = "";
		fixture.setContent(content);
	}
}
