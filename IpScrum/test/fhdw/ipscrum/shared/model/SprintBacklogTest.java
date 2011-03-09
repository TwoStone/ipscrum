package fhdw.ipscrum.shared.model;

import java.util.Date;

import org.junit.Test;

public class SprintBacklogTest extends SetUpTestData {

	@Override
	public void gwtSetUp() throws Exception {
		super.gwtSetUp();
	}

	@Test
	public void testGetEffortByDayForProject1Release1() {
		//EffortsByDay Sprint1 from Project1 Release1
		assertEquals(15, this.pro1rel1spr1.getSprintBacklog().getEffortByDay(new Date(2011 -1900,2-1,1)));
		assertEquals(12, this.pro1rel1spr1.getSprintBacklog().getEffortByDay(new Date(2011 -1900,2-1,2)));
		assertEquals(8, this.pro1rel1spr1.getSprintBacklog().getEffortByDay(new Date(2011 -1900,2-1,3)));
		assertEquals(5, this.pro1rel1spr1.getSprintBacklog().getEffortByDay(new Date(2011 -1900,2-1,4)));

		//EffortsByDay Sprint2 from Project1 Release1
		assertEquals(24, this.pro1rel1spr2.getSprintBacklog().getEffortByDay(new Date(2011 -1900,3-1,12)));
		assertEquals(22, this.pro1rel1spr2.getSprintBacklog().getEffortByDay(new Date(2011 -1900,3-1,13)));
		assertEquals(15, this.pro1rel1spr2.getSprintBacklog().getEffortByDay(new Date(2011 -1900,3-1,14)));

		//EffortsByDay Sprint3 from Project1 Release1
		assertEquals(35, this.pro1rel1spr3.getSprintBacklog().getEffortByDay(new Date(2011 -1900,1-1,3)));
		assertEquals(21, this.pro1rel1spr3.getSprintBacklog().getEffortByDay(new Date(2011 -1900,1-1,4)));

		//EffortsByDay Sprint4 from Project1 Release1
		assertEquals(17, this.pro1rel1spr4.getSprintBacklog().getEffortByDay(new Date(2011 -1900,2-1,28)));
		assertEquals(12, this.pro1rel1spr4.getSprintBacklog().getEffortByDay(new Date(2011 -1900,3-1,1)));
		assertEquals(8, this.pro1rel1spr4.getSprintBacklog().getEffortByDay(new Date(2011 -1900,3-1,2)));

		//EffortsByDay Sprint5 from Project1 Release1
		assertEquals(21, this.pro1rel1spr5.getSprintBacklog().getEffortByDay(new Date(2011 -1900,3-1,1)));
		assertEquals(16, this.pro1rel1spr5.getSprintBacklog().getEffortByDay(new Date(2011 -1900,3-1,2)));
		assertEquals(13, this.pro1rel1spr5.getSprintBacklog().getEffortByDay(new Date(2011 -1900,3-1,3)));
		assertEquals(9, this.pro1rel1spr5.getSprintBacklog().getEffortByDay(new Date(2011 -1900,3-1,4)));
		assertEquals(2, this.pro1rel1spr5.getSprintBacklog().getEffortByDay(new Date(2011 -1900,3-1,10)));
	}

	@Test
	public void testGetEffortByDayForProject1Release2() {
		//EffortsByDay Sprint1 from Project1 Release2
		assertEquals(32, this.pro1rel2spr1.getSprintBacklog().getEffortByDay(new Date(2011 -1900,3-1,1)));
		assertEquals(24, this.pro1rel2spr1.getSprintBacklog().getEffortByDay(new Date(2011 -1900,3-1,2)));

		//EffortsByDay Sprint2 from Project1 Release2
		assertEquals(23, this.pro1rel2spr2.getSprintBacklog().getEffortByDay(new Date(2011 -1900,2-1,1)));
		assertEquals(20, this.pro1rel2spr2.getSprintBacklog().getEffortByDay(new Date(2011 -1900,2-1,13)));
		assertEquals(17, this.pro1rel2spr2.getSprintBacklog().getEffortByDay(new Date(2011 -1900,3-1,6)));

		//EffortsByDay Sprint3 from Project1 Release2
		assertEquals(35, this.pro1rel2spr3.getSprintBacklog().getEffortByDay(new Date(2011 -1900,3-1,1)));
		assertEquals(18, this.pro1rel2spr3.getSprintBacklog().getEffortByDay(new Date(2011 -1900,3-1,4)));
		assertEquals(10, this.pro1rel2spr3.getSprintBacklog().getEffortByDay(new Date(2011 -1900,3-1,20)));

		//EffortsByDay Sprint4 from Project1 Release2
		assertEquals(13, this.pro1rel2spr4.getSprintBacklog().getEffortByDay(new Date(2011 -1900,3-1,1)));
		assertEquals(11, this.pro1rel2spr4.getSprintBacklog().getEffortByDay(new Date(2011 -1900,3-1,2)));
		assertEquals(2, this.pro1rel2spr4.getSprintBacklog().getEffortByDay(new Date(2011 -1900,3-1,3)));
		assertEquals(1, this.pro1rel2spr4.getSprintBacklog().getEffortByDay(new Date(2011 -1900,3-1,4)));

		//EffortsByDay Sprint5 from Project1 Release2
		assertEquals(40, this.pro1rel2spr5.getSprintBacklog().getEffortByDay(new Date(2011 -1900,3-1,1)));
		assertEquals(40, this.pro1rel2spr5.getSprintBacklog().getEffortByDay(new Date(2011 -1900,3-1,2)));
		assertEquals(40, this.pro1rel2spr5.getSprintBacklog().getEffortByDay(new Date(2011 -1900,3-1,3)));
		assertEquals(40, this.pro1rel2spr5.getSprintBacklog().getEffortByDay(new Date(2011 -1900,3-1,4)));
		assertEquals(40, this.pro1rel2spr5.getSprintBacklog().getEffortByDay(new Date(2011 -1900,3-1,10)));
	}

	@Test
	public void testGetEffortByDayForProject2Release1() {
		//EffortsByDay Sprint1 from Project2 Release1
		assertEquals(22, this.pro2rel1spr1.getSprintBacklog().getEffortByDay(new Date(2011 -1900,2-1,1)));
		assertEquals(11, this.pro2rel1spr1.getSprintBacklog().getEffortByDay(new Date(2011 -1900,3-1,1)));
		assertEquals(11, this.pro2rel1spr1.getSprintBacklog().getEffortByDay(new Date(2011 -1900,4-1,1)));
		assertEquals(0, this.pro2rel1spr1.getSprintBacklog().getEffortByDay(new Date(2011 -1900,5-1,1)));

		//EffortsByDay Sprint2 from Project2 Release1
		assertEquals(15, this.pro2rel1spr2.getSprintBacklog().getEffortByDay(new Date(2011 -1900,2-1,1)));
		assertEquals(15, this.pro2rel1spr2.getSprintBacklog().getEffortByDay(new Date(2011 -1900,3-1,1)));
		assertEquals(12, this.pro2rel1spr2.getSprintBacklog().getEffortByDay(new Date(2011 -1900,3-1,15)));
		assertEquals(9, this.pro2rel1spr2.getSprintBacklog().getEffortByDay(new Date(2011 -1900,3-1,30)));
		assertEquals(6, this.pro2rel1spr2.getSprintBacklog().getEffortByDay(new Date(2011 -1900,4-1,6)));

		//EffortsByDay Sprint3 from Project2 Release1
		assertEquals(20, this.pro2rel1spr3.getSprintBacklog().getEffortByDay(new Date(2011 -1900,3-1,1)));
		assertEquals(17, this.pro2rel1spr3.getSprintBacklog().getEffortByDay(new Date(2011 -1900,3-1,4)));
		assertEquals(17, this.pro2rel1spr3.getSprintBacklog().getEffortByDay(new Date(2011 -1900,4-1,1)));
		assertEquals(9, this.pro2rel1spr3.getSprintBacklog().getEffortByDay(new Date(2011 -1900,6-1,20)));

		//EffortsByDay Sprint4 from Project2 Release1
		assertEquals(26, this.pro2rel1spr4.getSprintBacklog().getEffortByDay(new Date(2011 -1900,3-1,1)));
		assertEquals(26, this.pro2rel1spr4.getSprintBacklog().getEffortByDay(new Date(2011 -1900,3-1,17)));
		assertEquals(25, this.pro2rel1spr4.getSprintBacklog().getEffortByDay(new Date(2011 -1900,3-1,23)));
		assertEquals(25, this.pro2rel1spr4.getSprintBacklog().getEffortByDay(new Date(2011 -1900,3-1,24)));

		//EffortsByDay Sprint5 from Project2 Release1
		assertEquals(21, this.pro2rel1spr5.getSprintBacklog().getEffortByDay(new Date(2011 -1900,2-1,6)));
		assertEquals(21, this.pro2rel1spr5.getSprintBacklog().getEffortByDay(new Date(2011 -1900,3-1,7)));
		assertEquals(18, this.pro2rel1spr5.getSprintBacklog().getEffortByDay(new Date(2011 -1900,3-1,8)));
		assertEquals(18, this.pro2rel1spr5.getSprintBacklog().getEffortByDay(new Date(2011 -1900,3-1,14)));
		assertEquals(5, this.pro2rel1spr5.getSprintBacklog().getEffortByDay(new Date(2011 -1900,6-1,10)));
	}

	@Test
	public void testGetEffortByDayForProject2Release2() {
		//EffortsByDay Sprint1 from Project2 Release2
		assertEquals(25, this.pro2rel2spr1.getSprintBacklog().getEffortByDay(new Date(2011 -1900,2-1,1)));
		assertEquals(25, this.pro2rel2spr1.getSprintBacklog().getEffortByDay(new Date(2011 -1900,3-1,2)));
		assertEquals(25, this.pro2rel2spr1.getSprintBacklog().getEffortByDay(new Date(2011 -1900,4-1,1)));
		assertEquals(25, this.pro2rel2spr1.getSprintBacklog().getEffortByDay(new Date(2011 -1900,6-1,2)));
		assertEquals(20, this.pro2rel2spr1.getSprintBacklog().getEffortByDay(new Date(2011 -1900,7-1,1)));
		assertEquals(20, this.pro2rel2spr1.getSprintBacklog().getEffortByDay(new Date(2011 -1900,8-1,2)));

		//EffortsByDay Sprint2 from Project2 Release2
		assertEquals(25, this.pro2rel2spr2.getSprintBacklog().getEffortByDay(new Date(2011 -1900,2-1,1)));
		assertEquals(25, this.pro2rel2spr2.getSprintBacklog().getEffortByDay(new Date(2011 -1900,2-1,11)));
		assertEquals(20, this.pro2rel2spr2.getSprintBacklog().getEffortByDay(new Date(2011 -1900,2-1,12)));
		assertEquals(15, this.pro2rel2spr2.getSprintBacklog().getEffortByDay(new Date(2011 -1900,3-1,1)));
		assertEquals(10, this.pro2rel2spr2.getSprintBacklog().getEffortByDay(new Date(2011 -1900,3-1,6)));

		//EffortsByDay Sprint3 from Project2 Release2
		assertEquals(25, this.pro2rel2spr3.getSprintBacklog().getEffortByDay(new Date(2011 -1900,1-1,1)));
		assertEquals(20, this.pro2rel2spr3.getSprintBacklog().getEffortByDay(new Date(2011 -1900,1-1,2)));
		assertEquals(15, this.pro2rel2spr3.getSprintBacklog().getEffortByDay(new Date(2011 -1900,1-1,9)));
		assertEquals(15, this.pro2rel2spr3.getSprintBacklog().getEffortByDay(new Date(2011 -1900,1-1,11)));
		assertEquals(10, this.pro2rel2spr3.getSprintBacklog().getEffortByDay(new Date(2011 -1900,1-1,12)));
		assertEquals(10, this.pro2rel2spr3.getSprintBacklog().getEffortByDay(new Date(2011 -1900,1-1,20)));

		//EffortsByDay Sprint4 from Project2 Release2
		assertEquals(25, this.pro2rel2spr4.getSprintBacklog().getEffortByDay(new Date(2011 -1900,2-1,14)));
		assertEquals(25, this.pro2rel2spr4.getSprintBacklog().getEffortByDay(new Date(2011 -1900,2-1,28)));
		assertEquals(25, this.pro2rel2spr4.getSprintBacklog().getEffortByDay(new Date(2011 -1900,3-1,1)));
		assertEquals(0, this.pro2rel2spr4.getSprintBacklog().getEffortByDay(new Date(2011 -1900,3-1,4)));
		assertEquals(0, this.pro2rel2spr4.getSprintBacklog().getEffortByDay(new Date(2011 -1900,3-1,10)));
		assertEquals(0, this.pro2rel2spr4.getSprintBacklog().getEffortByDay(new Date(2011 -1900,3-1,18)));

		//EffortsByDay Sprint5 from Project2 Release2
		assertEquals(25, this.pro2rel2spr5.getSprintBacklog().getEffortByDay(new Date(2011 -1900,2-1,25)));
		assertEquals(25, this.pro2rel2spr5.getSprintBacklog().getEffortByDay(new Date(2011 -1900,2-1,26)));
		assertEquals(25, this.pro2rel2spr5.getSprintBacklog().getEffortByDay(new Date(2011 -1900,2-1,27)));
		assertEquals(15, this.pro2rel2spr5.getSprintBacklog().getEffortByDay(new Date(2011 -1900,2-1,28)));
		assertEquals(15, this.pro2rel2spr5.getSprintBacklog().getEffortByDay(new Date(2011 -1900,3-1,1)));
		assertEquals(15, this.pro2rel2spr5.getSprintBacklog().getEffortByDay(new Date(2011 -1900,3-1,2)));
		assertEquals(10, this.pro2rel2spr5.getSprintBacklog().getEffortByDay(new Date(2011 -1900,3-1,3)));
		assertEquals(5, this.pro2rel2spr5.getSprintBacklog().getEffortByDay(new Date(2011 -1900,3-1,4)));
		assertEquals(5, this.pro2rel2spr5.getSprintBacklog().getEffortByDay(new Date(2011 -1900,3-1,5)));
		assertEquals(5, this.pro2rel2spr5.getSprintBacklog().getEffortByDay(new Date(2011 -1900,3-1,6)));
		assertEquals(5, this.pro2rel2spr5.getSprintBacklog().getEffortByDay(new Date(2011 -1900,3-1,7)));
		assertEquals(0, this.pro2rel2spr5.getSprintBacklog().getEffortByDay(new Date(2011 -1900,3-1,8)));
		assertEquals(0, this.pro2rel2spr5.getSprintBacklog().getEffortByDay(new Date(2011 -1900,3-1,9)));
		assertEquals(0, this.pro2rel2spr5.getSprintBacklog().getEffortByDay(new Date(2011 -1900,3-1,10)));
		assertEquals(0, this.pro2rel2spr5.getSprintBacklog().getEffortByDay(new Date(2011 -1900,3-1,11)));
	}


	@Test
	public void testCalculateOverallTaskEffort() {

		//Overall Task Efforts of Sprint 1 to Sprint 5 from Project1 Release1
		assertEquals(15, this.pro1rel1spr1.getSprintBacklog().calculateOverallTaskEffort());
		assertEquals(24, this.pro1rel1spr2.getSprintBacklog().calculateOverallTaskEffort());
		assertEquals(35, this.pro1rel1spr3.getSprintBacklog().calculateOverallTaskEffort());
		assertEquals(17, this.pro1rel1spr4.getSprintBacklog().calculateOverallTaskEffort());
		assertEquals(21, this.pro1rel1spr5.getSprintBacklog().calculateOverallTaskEffort());

		//Overall Task Efforts of Sprint 1 to Sprint 5 from Project1 Release2
		assertEquals(32, this.pro1rel2spr1.getSprintBacklog().calculateOverallTaskEffort());
		assertEquals(23, this.pro1rel2spr2.getSprintBacklog().calculateOverallTaskEffort());
		assertEquals(35, this.pro1rel2spr3.getSprintBacklog().calculateOverallTaskEffort());
		assertEquals(13, this.pro1rel2spr4.getSprintBacklog().calculateOverallTaskEffort());
		assertEquals(40, this.pro1rel2spr5.getSprintBacklog().calculateOverallTaskEffort());

		//Overall Task Efforts of Sprint 1 to Sprint 5 from Projekt2 Release1
		assertEquals(22, this.pro2rel1spr1.getSprintBacklog().calculateOverallTaskEffort());
		assertEquals(15, this.pro2rel1spr2.getSprintBacklog().calculateOverallTaskEffort());
		assertEquals(20, this.pro2rel1spr3.getSprintBacklog().calculateOverallTaskEffort());
		assertEquals(26, this.pro2rel1spr4.getSprintBacklog().calculateOverallTaskEffort());
		assertEquals(21, this.pro2rel1spr5.getSprintBacklog().calculateOverallTaskEffort());

		//Overall Task Efforts of Sprint 1 to Sprint 5 from Project2 Release1
		assertEquals(25, this.pro2rel2spr1.getSprintBacklog().calculateOverallTaskEffort());
		assertEquals(25, this.pro2rel2spr2.getSprintBacklog().calculateOverallTaskEffort());
		assertEquals(25, this.pro2rel2spr3.getSprintBacklog().calculateOverallTaskEffort());
		assertEquals(25, this.pro2rel2spr4.getSprintBacklog().calculateOverallTaskEffort());
		assertEquals(25, this.pro2rel2spr5.getSprintBacklog().calculateOverallTaskEffort());

	}

}
