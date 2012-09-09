/**
 * 
 */
package fhdw.ipscrum.shared.utils;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import fhdw.ipscrum.shared.exceptions.infrastructure.NoObjectFindException;
import fhdw.ipscrum.shared.infrastructure.IdentifiableObject;
import fhdw.ipscrum.shared.model.messages.ModelTestBase;
import fhdw.ipscrum.shared.model.nonMeta.Hint;

/**
 * 
 */
public class ListUtilsTest extends ModelTestBase {

	/**
	 * @throws java.lang.Exception
	 *             an error occurred
	 */
	@Override
	@Before
	public void setUp() throws Exception {
		super.setUp();
	}

	/**
	 * Test method for {@link fhdw.ipscrum.shared.utils.ListUtils#intersection(java.util.List, java.util.List)}.
	 */
	@Test
	public final void testIntersection() {
		final Integer one = Integer.valueOf(1);
		final Integer two = Integer.valueOf(2);
		final Integer three = Integer.valueOf(3);
		final Integer four = Integer.valueOf(4);

		final List<Integer> first = new ArrayList<Integer>();
		first.add(one);
		first.add(two);
		first.add(three);
		final List<Integer> second = new ArrayList<Integer>();
		second.add(four);
		second.add(two);
		second.add(three);

		final List<Integer> intersection = ListUtils.intersection(first, second);
		Assert.assertTrue(intersection.contains(two));
		Assert.assertTrue(intersection.contains(three));
		Assert.assertFalse(intersection.contains(one));
		Assert.assertFalse(intersection.contains(four));
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.utils.ListUtils#filter(java.util.List, fhdw.ipscrum.shared.utils.ListUtils.Predicate)}
	 * .
	 */
	@Test
	public final void testFilter() {
		final Integer one = Integer.valueOf(1);
		final Integer two = Integer.valueOf(2);
		final Integer three = Integer.valueOf(3);
		final Integer four = Integer.valueOf(4);

		final List<Integer> first = new ArrayList<Integer>();
		first.add(one);
		first.add(two);
		first.add(three);
		first.add(four);

		final List<Integer> list = ListUtils.filter(first, new ListUtils.Predicate<Integer>() {

			@Override
			public boolean test(final Integer element) {
				return element.compareTo(Integer.valueOf(3)) > 0;
			}
		});
		Assert.assertEquals(1, list.size());
		Assert.assertTrue(list.contains(four));
		Assert.assertFalse(list.contains(three));

	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.utils.ListUtils#convertIdListToObjList(java.util.List, fhdw.ipscrum.shared.model.Model)}
	 * .
	 * 
	 * @throws NoObjectFindException
	 *             object not found
	 */
	@Test
	public final void testConvertIdListToObjList() throws NoObjectFindException {
		final Hint hint1 = new Hint(this.getModel(), "Hint 1");
		final Hint hint2 = new Hint(this.getModel(), "Hint 2");
		final Hint hint3 = new Hint(this.getModel(), "Hint 3");
		final Hint hint4 = new Hint(this.getModel(), "Hint 4");

		final List<String> list = new ArrayList<String>();
		list.add(hint1.getId());
		list.add(hint2.getId());
		list.add(hint3.getId());
		list.add(hint4.getId());

		final List<IdentifiableObject> objectList = ListUtils.convertIdListToObjList(list, this.getModel());
		Assert.assertTrue(objectList.contains(hint1));
		Assert.assertTrue(objectList.contains(hint2));
		Assert.assertTrue(objectList.contains(hint3));
		Assert.assertTrue(objectList.contains(hint4));

	}

	/**
	 * Test method for {@link fhdw.ipscrum.shared.utils.ListUtils#convertObjListToIdList(java.util.List)}.
	 */
	@Test
	public final void testConvertObjListToIdList() {
		final Hint hint1 = new Hint(this.getModel(), "Hint 1");
		final Hint hint2 = new Hint(this.getModel(), "Hint 2");
		final Hint hint3 = new Hint(this.getModel(), "Hint 3");
		final Hint hint4 = new Hint(this.getModel(), "Hint 4");

		final List<IdentifiableObject> list = new ArrayList<IdentifiableObject>();
		list.add(hint1);
		list.add(hint2);
		list.add(hint3);
		list.add(hint4);

		final List<String> idList = ListUtils.convertObjListToIdList(list);
		Assert.assertTrue(idList.contains(hint1.getId()));
		Assert.assertTrue(idList.contains(hint2.getId()));
		Assert.assertTrue(idList.contains(hint3.getId()));
		Assert.assertTrue(idList.contains(hint4.getId()));
	}

	/**
	 * Test method for {@link fhdw.ipscrum.shared.utils.ListUtils#difference(java.util.List, java.util.List)}.
	 */
	@Test
	public final void testDifference() {
		final Integer one = Integer.valueOf(1);
		final Integer two = Integer.valueOf(2);
		final Integer three = Integer.valueOf(3);
		final Integer four = Integer.valueOf(4);

		final List<Integer> first = new ArrayList<Integer>();
		first.add(one);
		first.add(two);
		first.add(three);
		final List<Integer> second = new ArrayList<Integer>();
		second.add(four);
		second.add(two);
		second.add(three);

		final List<Integer> difference = ListUtils.difference(first, second);
		Assert.assertTrue(difference.contains(one));
		Assert.assertFalse(difference.contains(two));
		Assert.assertFalse(difference.contains(three));
	}

}
