/**
 * 
 */
package fhdw.ipscrum.shared.utils;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * 
 */
public class ListUtilsTest {

	/**
	 * @throws java.lang.Exception
	 *             an error occurred
	 */
	@Before
	public void setUp() throws Exception {
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
	 */
	@Test
	public final void testConvertIdListToObjList() {
		Assert.fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link fhdw.ipscrum.shared.utils.ListUtils#convertObjListToIdList(java.util.List)}.
	 */
	@Test
	public final void testConvertObjListToIdList() {
		Assert.fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.utils.ListUtils#containsAlternate(java.util.List, fhdw.ipscrum.shared.infrastructure.IdentifiableObject)}
	 * .
	 */
	@Test
	public final void testContainsAlternate() {
		Assert.fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link fhdw.ipscrum.shared.utils.ListUtils#difference(java.util.List, java.util.List)}.
	 */
	@Test
	public final void testDifference() {
		Assert.fail("Not yet implemented"); // TODO
	}

}
