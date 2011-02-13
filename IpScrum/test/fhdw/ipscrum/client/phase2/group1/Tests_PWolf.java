package fhdw.ipscrum.client.phase2.group1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Date;

import org.junit.Test;

import fhdw.ipscrum.shared.exceptions.UserException;
import fhdw.ipscrum.shared.model.Feature;
import fhdw.ipscrum.shared.model.Project;
import fhdw.ipscrum.shared.model.Release;
import fhdw.ipscrum.shared.model.Sprint;
import fhdw.ipscrum.shared.model.Team;
import fhdw.ipscrum.shared.model.interfaces.IRelease;
import fhdw.ipscrum.shared.model.interfaces.ISprint;

public class Tests_PWolf {

	@Test
	public void pblPriority() {
		try {
			Project p = new Project("Test");
			Feature f1 = new Feature("T1", "", p.getBacklog());
			Feature f2 = new Feature("T2", "", p.getBacklog());
			Feature f3 = new Feature("T3", "", p.getBacklog());

			p.getBacklog().addItem(f1);
			p.getBacklog().addItem(f2);
			p.getBacklog().addItem(f3);

			p.getBacklog().moveBottom(f1);

			assertEquals(new Integer(0), p.getBacklog().getItemPositionInList(f2));
			assertEquals(new Integer(1), p.getBacklog().getItemPositionInList(f3));
			assertEquals(new Integer(2), p.getBacklog().getItemPositionInList(f1));

			p.getBacklog().moveUp(f1);

			assertEquals(new Integer(0), p.getBacklog().getItemPositionInList(f2));
			assertEquals(new Integer(1), p.getBacklog().getItemPositionInList(f1));
			assertEquals(new Integer(2), p.getBacklog().getItemPositionInList(f3));

			p.getBacklog().moveDown(f2);

			assertEquals(new Integer(0), p.getBacklog().getItemPositionInList(f1));
			assertEquals(new Integer(1), p.getBacklog().getItemPositionInList(f2));
			assertEquals(new Integer(2), p.getBacklog().getItemPositionInList(f3));

			p.getBacklog().moveTop(f1);// Nothing should changed
			assertEquals(new Integer(0), p.getBacklog().getItemPositionInList(f1));
			assertEquals(new Integer(1), p.getBacklog().getItemPositionInList(f2));
			assertEquals(new Integer(2), p.getBacklog().getItemPositionInList(f3));

			p.getBacklog().moveBottom(f3);// Nothing should changed
			assertEquals(new Integer(0), p.getBacklog().getItemPositionInList(f1));
			assertEquals(new Integer(1), p.getBacklog().getItemPositionInList(f2));
			assertEquals(new Integer(2), p.getBacklog().getItemPositionInList(f3));

			p.getBacklog().moveUp(f1);// Nothing should changed
			assertEquals(new Integer(0), p.getBacklog().getItemPositionInList(f1));
			assertEquals(new Integer(1), p.getBacklog().getItemPositionInList(f2));
			assertEquals(new Integer(2), p.getBacklog().getItemPositionInList(f3));

			p.getBacklog().moveDown(f3);// Nothing should changed
			assertEquals(new Integer(0), p.getBacklog().getItemPositionInList(f1));
			assertEquals(new Integer(1), p.getBacklog().getItemPositionInList(f2));
			assertEquals(new Integer(2), p.getBacklog().getItemPositionInList(f3));

			p.getBacklog().moveUp(f2);
			assertEquals(new Integer(0), p.getBacklog().getItemPositionInList(f2));
			assertEquals(new Integer(1), p.getBacklog().getItemPositionInList(f1));
			assertEquals(new Integer(2), p.getBacklog().getItemPositionInList(f3));

			p.getBacklog().moveDown(f1);
			assertEquals(new Integer(0), p.getBacklog().getItemPositionInList(f2));
			assertEquals(new Integer(1), p.getBacklog().getItemPositionInList(f3));
			assertEquals(new Integer(2), p.getBacklog().getItemPositionInList(f1));

		} catch (UserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void releaseSprintPbiConsistency() {
		try {
			Project p = new Project("Test");
			Feature f1 = new Feature("T1", "", p.getBacklog());
			Feature f2 = new Feature("T2", "", p.getBacklog());
			Feature f3 = new Feature("T3", "", p.getBacklog());

			p.getBacklog().addItem(f1);
			p.getBacklog().addItem(f2);
			p.getBacklog().addItem(f3);

			ISprint sprint1 = new Sprint("", new Date(), new Date(), new Team("Test"));
			ISprint sprint2 = new Sprint("", new Date(), new Date(), new Team("Test2"));
			ISprint sprint3 = new Sprint("", new Date(), new Date(), new Team("Test3"));

			p.addSprint(sprint1);
			p.addSprint(sprint2);
			// Sprint3 wird bewusst nicht hinzugefügt

			// FIRST SPRINT<->PBI

			try {
				f1.setSprint(sprint3);
				fail();
			} catch (Exception e) {
				assertTrue(f1.getSprint() == null);
				assertFalse(sprint1.getPBIs().contains(f1));
			}

			f1.setSprint(sprint1);

			assertEquals(sprint1, f1.getSprint());
			assertTrue(sprint1.getPBIs().contains(f1));

			f1.setSprint(sprint2);
			assertEquals(sprint2, f1.getSprint());
			assertFalse(sprint1.getPBIs().contains(f1));
			assertTrue(sprint2.getPBIs().contains(f1));

			// NOW RELEASE<->PBI
			IRelease release1 = new Release("R1", new Date(), p);
			IRelease release2 = new Release("R2", new Date(2011, 10, 11), p);
			IRelease release3 = null;

			// Doppelt
			try {
				release3 = new Release("R2", new Date(2011, 10, 11), p);
				fail();
			} catch (Exception e1) {
				assertTrue(release3 == null);
				assertFalse(p.getReleasePlan().contains(release3));
			}

			assertTrue(p.getReleasePlan().contains(release1));
			assertTrue(p.getReleasePlan().contains(release2));
			assertEquals(p, release1.getProject());
			assertEquals(p, release2.getProject());

			try {
				release1.addSprint(sprint3);
				fail();
			} catch (Exception e) {
				assertTrue(sprint3.getRelease() == null);
				assertFalse(release1.getSprints().contains(sprint3));
			}

			assertFalse(sprint1.equals(sprint2));
			assertFalse(sprint1.hashCode() == sprint2.hashCode());

			release1.addSprint(sprint1);
			release1.addSprint(sprint2);

			assertEquals(release1, sprint1.getRelease());
			assertEquals(release1, sprint2.getRelease());
			assertTrue(release1.getSprints().contains(sprint1));
			assertTrue(release1.getSprints().contains(sprint2));

			release1.removeSprint(sprint1);
			assertTrue(sprint1.getRelease() == null);
			assertFalse(release1.getSprints().contains(sprint1));
			assertTrue(release1.getSprints().contains(sprint2));

		} catch (UserException e) {
			e.printStackTrace();
			fail();
		}

	}
}
