package fhdw.ipscrum.shared.model.nonMeta;

import java.io.File;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import fhdw.ipscrum.client.IDGenerator;
import fhdw.ipscrum.server.ServerContext;
import fhdw.ipscrum.server.TestUtils;
import fhdw.ipscrum.shared.exceptions.model.NoValidValueException;
import fhdw.ipscrum.shared.model.Model;

/**
 * The class <code>HintTest</code> contains tests for the class <code>{@link Hint}</code>.
 */
public class EffortTest {

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
	 * Run the Effort constructor test.
	 * 
	 * @throws Exception
	 *             Exception
	 */
	@Test(expected = NoValidValueException.class)
	public void testEffort() throws Exception {
		new Effort(-1);
	}

	/**
	 * Run the method test.
	 * 
	 * @throws Exception
	 *             Exception
	 */
	@Test
	public void testSetValue1() throws Exception {
		final Effort e = new Effort(1);
		e.setValue(0);
		Assert.assertEquals(Integer.valueOf(0), e.getValue());
	}

	/**
	 * Run the method test.
	 * 
	 * @throws Exception
	 *             Exception
	 */
	@Test(expected = NoValidValueException.class)
	public void testSetValue2() throws Exception {
		final Effort e = new Effort(1);
		e.setValue(-3);
	}

	/**
	 * Run the method test.
	 * 
	 * @throws Exception
	 *             Exception
	 */
	public void testToStringAndEqualsAndHashCode() throws Exception {
		final Effort e = new Effort(1);
		Assert.assertEquals(Integer.valueOf(1).toString(), e.toString());
		Assert.assertEquals(Integer.valueOf(1).hashCode(), e.hashCode());
		Assert.assertEquals(true, e.equals(e));
		Assert.assertEquals(true, e.equals(new Effort(1)));
		Assert.assertEquals(false, e.equals(new Effort(0)));
		Assert.assertFalse(e.equals(null));
		Assert.assertEquals(false, e.equals(new Object()));
	}
}
