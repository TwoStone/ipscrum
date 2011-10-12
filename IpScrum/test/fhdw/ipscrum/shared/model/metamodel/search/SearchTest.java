package fhdw.ipscrum.shared.model.metamodel.search;

import java.io.File;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import fhdw.ipscrum.client.IDGenerator;
import fhdw.ipscrum.server.ServerContext;
import fhdw.ipscrum.server.TestUtils;
import fhdw.ipscrum.shared.model.Model;

/**
 * tests the search.
 */
public class SearchTest {

	/**
	 * represents the model needed for the use of the IPScrum.
	 */
	private Model model;

	/**
	 * sets up the date before evey test.
	 * 
	 * @throws Exception
	 *             Exception if the use of one of the methods fails
	 */
	@Before
	public void setUp() throws Exception {
		TestUtils.deleteFolderContent(new File("output"));
		ServerContext.resetServerContext();
		this.model = ServerContext.getInstance().getPersistenceManager().getCurrentModel();
		this.model.setUuidManager(new IDGenerator());
	}

	/**
	 * Run the Search(Model,String,SearchExpression) constructor test.
	 * 
	 * @throws Exception
	 *             Exception
	 * 
	 */
	@Test
	public void testSearch1() throws Exception {
		final String name = "";
		final SearchExpression expression = new And(this.model);

		final Search result = new Search(this.model, name, expression);
		Assert.assertNotNull(result);
	}

	/**
	 * Run the ISearchExpression getExpression() method test.
	 * 
	 * @throws Exception
	 *             Exception
	 * 
	 */
	@Test
	public void testGetExpression1() throws Exception {
		final Search fixture = new Search(this.model, "", new And(this.model));
		fixture.setName("");

		final ISearchExpression result = fixture.getExpression();
		Assert.assertNotNull(result);
	}

	/**
	 * Run the String getName() method test.
	 * 
	 * @throws Exception
	 *             Exception
	 * 
	 */
	@Test
	public void testGetName1() throws Exception {
		final Search fixture = new Search(this.model, "", new And(this.model));
		fixture.setName("");

		final String result = fixture.getName();
		Assert.assertNotNull(result);
	}

	/**
	 * Run the void setName(String) method test.
	 * 
	 * @throws Exception
	 *             Exception
	 * 
	 */
	@Test
	public void testSetName1() throws Exception {
		final Search fixture = new Search(this.model, "", new And(this.model));
		fixture.setName("");
		final String name = "";

		fixture.setName(name);
	}
}
