package fhdw.ipscrum.shared.model.metamodel.search;

import java.io.File;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import fhdw.ipscrum.client.IDGenerator;
import fhdw.ipscrum.server.ServerContext;
import fhdw.ipscrum.server.TestUtils;
import fhdw.ipscrum.shared.model.Model;
import fhdw.ipscrum.shared.model.nonMeta.incidents.OneParticipantIncident;
import fhdw.ipscrum.shared.observer.Observable;

/**
 * tests the singleLogicalSearchOperator.
 */
public class SingleLogicSearchOperatorTest {

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
		this.model =
				ServerContext.getInstance().getPersistenceManager().getCurrentModel();
		this.model.setUuidManager(new IDGenerator());
	}

	/**
	 * Run the void accept(ISearchTypeVisitor) method test.
	 * 
	 * @throws Exception
	 *             Exception Exception
	 * 
	 */
	@Test
	public void testAccept1() throws Exception {
		final SingleLogicSearchOperator fixture =
				new Not(this.model, new And(this.model));
		final ISearchTypeVisitor visitor = new ISearchTypeVisitor() {

			@Override
			public void handleSingleLogicSearchOperator(
					final SingleLogicSearchOperator singleLogicSearchOperator) {

			}

			@Override
			public void handleSearchCriteria(final SearchCriteria searchCriteria) {

			}

			@Override
			public void handleMultiLogicSearchOperator(
					final MultiLogicSearchOperator multiLogicSearchOperator) {

			}
		};

		fixture.accept(visitor);
	}

	/**
	 * Run the boolean contains(ISearchExpression) method test.
	 * 
	 * @throws Exception
	 *             Exception
	 */
	@Test
	public void testContains1() throws Exception {
		final SingleLogicSearchOperator fixture =
				new Not(this.model, new And(this.model));
		final ISearchExpression expression = new And(this.model);

		final boolean result = fixture.contains(expression);
		Assert.assertFalse(result);
	}

	/**
	 * Run the boolean contains(ISearchExpression) method test.
	 * 
	 * @throws Exception
	 *             Exception
	 * 
	 */
	@Test
	public void testContains2() throws Exception {
		final SingleLogicSearchOperator fixture =
				new Not(this.model, new And(this.model));
		final ISearchExpression expression = new And(this.model);

		final boolean result = fixture.contains(expression);
		Assert.assertFalse(result);
	}

	/**
	 * Run the boolean contains(ISearchExpression) method test.
	 * 
	 * @throws Exception
	 *             Exception
	 * 
	 */
	@Test
	public void testContains3() throws Exception {
		final SingleLogicSearchOperator fixture =
				new Not(this.model, new And(this.model));
		final ISearchExpression expression = new And(this.model);

		final boolean result = fixture.contains(expression);

		Assert.assertFalse(result);
	}

	/**
	 * Run the boolean contains(ISearchExpression) method test.
	 * 
	 * @throws Exception
	 *             Exception
	 * 
	 */
	@Test
	public void testContains4() throws Exception {
		final SingleLogicSearchOperator fixture =
				new Not(this.model, new And(this.model));
		final ISearchExpression expression = new And(this.model);

		final boolean result = fixture.contains(expression);

		Assert.assertFalse(result);
	}

	/**
	 * Run the SearchExpression getArg() method test.
	 * 
	 * @throws Exception
	 *             Exception
	 * 
	 */
	@Test
	public void testGetArg1() throws Exception {
		final SingleLogicSearchOperator fixture =
				new Not(this.model, new And(this.model));

		final SearchExpression result = fixture.getArg();
		Assert.assertNotNull(result);
	}

	/**
	 * Run the void setArg(SearchExpression) method test.
	 * 
	 * @throws Exception
	 *             Exception
	 * 
	 */
	@Test
	public void testSetArg1() throws Exception {
		final SingleLogicSearchOperator fixture =
				new Not(this.model, new And(this.model));
		final SearchExpression arg = new And(this.model);

		fixture.setArg(arg);
	}

	/**
	 * Run the void setArg(SearchExpression) method test.
	 * 
	 * @throws Exception
	 *             Exception
	 * 
	 */
	@Test
	public void testSetArg2() throws Exception {
		final SingleLogicSearchOperator fixture =
				new Not(this.model, new And(this.model));
		final SearchExpression arg = new And(this.model);

		fixture.setArg(arg);
	}

	/**
	 * Run the void setArg(SearchExpression) method test.
	 * 
	 * @throws Exception
	 *             Exception
	 * 
	 */
	@Test
	public void testSetArg3() throws Exception {
		final SingleLogicSearchOperator fixture =
				new Not(this.model, new And(this.model));
		final SearchExpression arg = new And(this.model);

		fixture.setArg(arg);
	}

	/**
	 * Run the void setArg(SearchExpression) method test.
	 * 
	 * @throws Exception
	 *             Exception
	 * 
	 */
	@Test
	public void testSetArg4() throws Exception {
		final SingleLogicSearchOperator fixture =
				new Not(this.model, new And(this.model));
		final SearchExpression arg = null;

		fixture.setArg(arg);
	}

	/**
	 * Run the void setArg(SearchExpression) method test.
	 * 
	 * @throws Exception
	 *             Exception
	 * 
	 */
	@Test
	public void testSetArg5() throws Exception {
		final SingleLogicSearchOperator fixture =
				new Not(this.model, new And(this.model));
		final SearchExpression arg = null;

		fixture.setArg(arg);
	}

	/**
	 * Run the void update(Observable,Object) method test.
	 * 
	 * @throws Exception
	 *             Exception
	 * 
	 */
	@Test
	public void testUpdate1() throws Exception {
		final SingleLogicSearchOperator fixture =
				new Not(this.model, new And(this.model));
		final Observable observable = new OneParticipantIncident();
		final Object argument = new Object();

		fixture.update(observable, argument);
	}
}
