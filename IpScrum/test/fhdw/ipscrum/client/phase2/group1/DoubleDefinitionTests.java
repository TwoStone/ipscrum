package fhdw.ipscrum.client.phase2.group1;

import static org.junit.Assert.*;
import org.junit.Test;

import fhdw.ipscrum.shared.exceptions.ConsistencyException;
import fhdw.ipscrum.shared.exceptions.DoubleDefinitionException;
import fhdw.ipscrum.shared.exceptions.NoValidValueException;
import fhdw.ipscrum.shared.model.Feature;
import fhdw.ipscrum.shared.model.Project;

public class DoubleDefinitionTests {

	@Test
	public void test(){
		try {
			Project p = new Project("Test");
			p.getBacklog().addItem(new Feature("T1", "", p.getBacklog()));
			p.getBacklog().addItem(new Feature("T1", "", p.getBacklog()));
			
			
		} catch (NoValidValueException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ConsistencyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DoubleDefinitionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
