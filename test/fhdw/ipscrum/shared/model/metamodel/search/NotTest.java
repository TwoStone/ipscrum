package fhdw.ipscrum.shared.model.metamodel.search;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import fhdw.ipscrum.client.IDGenerator;
import fhdw.ipscrum.server.ServerContext;
import fhdw.ipscrum.server.TestUtils;
import fhdw.ipscrum.shared.exceptions.IPScrumGeneralException;
import fhdw.ipscrum.shared.model.Model;
import fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes.BugTicketType;
import fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes.Ticket;
import fhdw.ipscrum.shared.model.nonMeta.Bug;
import fhdw.ipscrum.shared.model.nonMeta.ProductBacklog;
import fhdw.ipscrum.shared.model.nonMeta.Project;
import fhdw.ipscrum.shared.model.nonMeta.Release;

/**
 * The class <code>NotTest</code> contains tests for the class <code>{@link Not}</code>.
 */
public class NotTest {

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
	 * Run the Not(Model,SearchExpression) constructor test.
	 * 
	 * @throws Exception
	 *             Exception
	 */
	@Test
	public void testNot1() throws Exception {
		final SearchExpression arg = new And(this.model);

		final Not result = new Not(this.model, arg);
		Assert.assertNotNull(result);
	}

	/**
	 * Run the boolean search(Ticket) method test.
	 * 
	 * @throws Exception
	 *             Exception
	 */
	@Test
	public void testSearch1() throws Exception {
		final Not fixture = new Not(this.model, new And(this.model));
		final Project p = new Project(this.model, "jkl");
		final ProductBacklog pbl = new ProductBacklog(this.model, p);
		final Release r = new Release(this.model, "2", new Date(), p);
		final Ticket ticket = new Bug(this.model, new BugTicketType(this.model, "uio", "asd"), "dfg", "qwe", pbl, r);

		final boolean result = fixture.search(ticket);
		Assert.assertFalse(result);
	}

	/**
	 * Run the boolean search(Ticket) method test.
	 * 
	 * @throws Exception
	 *             Exception
	 */
	@Test
	public void testSearch2() throws Exception {
		final Not fixture = new Not(this.model, new And(this.model));
		final Project p = new Project(this.model, "jkl");
		final ProductBacklog pbl = new ProductBacklog(this.model, p);
		final Release r = new Release(this.model, "2", new Date(), p);
		final Ticket ticket = new Bug(this.model, new BugTicketType(this.model, "uio", "asd"), "dfg", "qwe", pbl, r);

		final boolean result = fixture.search(ticket);
		Assert.assertFalse(result);
	}

	/**
	 * Run the boolean search(Ticket) method test.
	 * 
	 * @throws Exception
	 *             Exception
	 */
	@Test
	public void testSearch3() throws Exception {
		final Not fixture = new Not(this.model, new And(this.model));
		final Project p = new Project(this.model, "jkl");
		final ProductBacklog pbl = new ProductBacklog(this.model, p);
		final Release r = new Release(this.model, "2", new Date(), p);
		final Ticket ticket = new Bug(this.model, new BugTicketType(this.model, "uio", "asd"), "dfg", "qwe", pbl, r);

		final boolean result = fixture.search(ticket);
		Assert.assertFalse(result);
	}

	/**
	 * Run the String toString() method test.
	 * 
	 * @throws Exception
	 *             Exception
	 */
	@Test
	public void testToString1() throws Exception {
		final Not fixture = new Not(this.model, new And(this.model));
		final String result = fixture.toString();
		Assert.assertNotNull(result);
	}

	/**
	 * test to search with the not operator.
	 * 
	 * @throws IPScrumGeneralException
	 *             if something fails.
	 */
	@Test
	public void testSearch() throws IPScrumGeneralException {
		final ArrayList<SearchExpression> collection = new ArrayList<SearchExpression>();
		Assert.assertNotNull(collection);
	}
}
