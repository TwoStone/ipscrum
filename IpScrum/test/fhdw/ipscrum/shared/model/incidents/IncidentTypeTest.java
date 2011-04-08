package fhdw.ipscrum.shared.model.incidents;

import org.junit.*;

import fhdw.ipscrum.shared.model.SetUpTestData;
import static org.junit.Assert.*;

public class IncidentTypeTest extends SetUpTestData{

	@Test
	public void testIncidentType_1()
		throws Exception {
		String name = "Hindernis";

		IncidentType result = new IncidentType(name);

		assertNotNull(result);
		assertEquals("Hindernis", result.getName());
	}

	@Test
	public void testEquals_1()
		throws Exception {
		IncidentType fixture = new IncidentType("Hindernis");
		Object obj = new IncidentType("Hinderns");

		boolean result = fixture.equals(obj);

		assertEquals(false, result);
	}
	
	@Test
	public void testEquals_1V2()
		throws Exception {
		IncidentType fixture = new IncidentType("Hindernis");
		Object obj = new IncidentType("Hindernis");

		boolean result = fixture.equals(obj);

		assertEquals(true, result);
	}

	@Test
	public void testEquals_2()
		throws Exception {
		IncidentType fixture = new IncidentType("Hindernis");
		Object obj = null;

		boolean result = fixture.equals(obj);

		assertEquals(false, result);
	}

	@Test
	public void testEquals_3()
		throws Exception {
		IncidentType fixture = new IncidentType("Hindernis");
		Object obj = new Object();

		boolean result = fixture.equals(obj);

		assertEquals(false, result);
	}

	@Test
	public void testEquals_4()
		throws Exception {
		IncidentType fixture = new IncidentType("oper");
		Object obj = new IncidentType("oper");

		boolean result = fixture.equals(obj);

		assertEquals(true, result);
	}

	@Test
	public void testEquals_5()
		throws Exception {
		IncidentType fixture = new IncidentType("Tag");
		Object obj = new IncidentType("Nacht");

		boolean result = fixture.equals(obj);

		assertEquals(false, result);
	}

	@Test
	public void testEquals_6()
		throws Exception {
		IncidentType fixture = new IncidentType("Nettigkeit");
		Object obj = new IncidentType("Netigkeit");

		boolean result = fixture.equals(obj);

		assertEquals(false, result);
	}

	@Test
	public void testGetName_1()
		throws Exception {
		IncidentType fixture = new IncidentType("Hindernis");

		String result = fixture.getName();

		assertEquals("Hindernis", result);
	}

}