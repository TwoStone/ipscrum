package fhdw.ipscrum.shared.model;


import java.util.Date;
import java.util.Iterator;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fhdw.ipscrum.shared.bdas.BDACompare;
import fhdw.ipscrum.shared.exceptions.DoubleDefinitionException;
import fhdw.ipscrum.shared.model.incidents.Incident;

public class IncidentTest extends TestCase{
	
	private Project p1;
	private Date absenceDate;
	private Incident i1;
	
	@Before
	public void setUp() throws Exception {
		this.p1 = new Project("Integrationsprojekt");
		this.absenceDate = new Date();
		this.i1 = Incident.createIllnessIncident(new Person("Hans", "Hase"), absenceDate, absenceDate);
	}
	/**
	 * testing bidirectional association many to many
	 */
	@Test
	public void test_IsIncidentInProject1(){
		try {
			this.p1.addIncident(this.i1);
		} catch (DoubleDefinitionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Iterator<BDACompare> incidentIterator = this.p1.getIncidentAssoc().getAssociations().iterator();
		Incident current = (Incident)incidentIterator.next();
		if (current!=null){
			assertEquals(this.i1, current);
		}else{
			fail();
		}
	}
	/**
	 * testing bidirectional association many to many
	 */
	@Test
	public void test_IsIncidentInProject2(){
		this.i1.addProject(this.p1);
		Iterator<BDACompare> incidentIterator = this.p1.getIncidentAssoc().getAssociations().iterator();
		Incident current = (Incident)incidentIterator.next();
		if (current!=null){
			assertEquals(this.i1, current);
		}else{
			fail();
		}
	}
	
	/**
	 * testing bidirectional association many to many
	 */
	@Test
	public void test_IsProjectInIncident1(){
		try {
			this.p1.addIncident(this.i1);
		} catch (DoubleDefinitionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Iterator<BDACompare> projectIterator = this.i1.getProjectAssoc().getAssociations().iterator();
		Project current = (Project)projectIterator.next();
		if (current!=null){
			assertEquals(this.p1, current);
		} else {
			fail();
		}
	}
	/**
	 * testing bidirectional association many to many
	 */
	@Test
	public void test_IsProjectInIncident2(){
		this.i1.addProject(this.p1);
		Iterator<BDACompare> projectIterator = this.i1.getProjectAssoc().getAssociations().iterator();
		Project current = (Project)projectIterator.next();
		if (current!=null){
			assertEquals(this.p1, current);
		} else {
			fail();
		}
	}
	/**
	 * testing doublets: add p1 to i1 twice
	 */
	@Test
	public void test_DoubleDefinition1(){
		i1.addProject(p1);
		i1.addProject(p1);
		int iAct = i1.getProjectAssoc().getAssociations().size();
		int iExp = 1;
		assertEquals(iExp, iAct);
	}
	/**
	 * testing doublets: add i1 to p1 twice
	 */
	@Test
	public void test_DoubleDefinition2(){
		try {
			p1.addIncident(i1);
		} catch (DoubleDefinitionException e) {
			fail();
		}
		try {
			p1.addIncident(i1);
		} catch (DoubleDefinitionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int iAct = p1.getIncidentAssoc().getAssociations().size();
		int iExp = 1;
		assertEquals(iExp, iAct);
	}

	@After
	public void tearDown() throws Exception {
	}
	
	
}
