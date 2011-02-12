package fhdw.ipscrum.client.phase2.group1;

import static org.junit.Assert.*;
import org.junit.Test;

import fhdw.ipscrum.shared.exceptions.ConsistencyException;
import fhdw.ipscrum.shared.exceptions.DoubleDefinitionException;
import fhdw.ipscrum.shared.exceptions.NoValidValueException;
import fhdw.ipscrum.shared.exceptions.UserException;
import fhdw.ipscrum.shared.model.Feature;
import fhdw.ipscrum.shared.model.Project;

public class DoubleDefinitionTests {

	@Test
	public void test(){
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

			p.getBacklog().moveTop(f1);//Nothing should changed
			assertEquals(new Integer(0), p.getBacklog().getItemPositionInList(f1));
			assertEquals(new Integer(1), p.getBacklog().getItemPositionInList(f2));
			assertEquals(new Integer(2), p.getBacklog().getItemPositionInList(f3));

			p.getBacklog().moveBottom(f3);//Nothing should changed
			assertEquals(new Integer(0), p.getBacklog().getItemPositionInList(f1));
			assertEquals(new Integer(1), p.getBacklog().getItemPositionInList(f2));
			assertEquals(new Integer(2), p.getBacklog().getItemPositionInList(f3));

			p.getBacklog().moveUp(f1);//Nothing should changed
			assertEquals(new Integer(0), p.getBacklog().getItemPositionInList(f1));
			assertEquals(new Integer(1), p.getBacklog().getItemPositionInList(f2));
			assertEquals(new Integer(2), p.getBacklog().getItemPositionInList(f3));

			p.getBacklog().moveDown(f3);//Nothing should changed
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
}
