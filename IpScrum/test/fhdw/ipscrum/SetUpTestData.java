package fhdw.ipscrum;


import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

public abstract class SetUpTestData {

	@BeforeClass
	public static void SetUpBeforeClass() throws Exception {
	}


	@Before
	public void setUp() throws Exception {
//		this.timestamp = System.currentTimeMillis();
//		
//		this.konto1 = Konto.createKonto();
//		this.konto2 = Konto.createKonto();
//		this.konto3 = Konto.createKonto();
//		this.konto4 = Konto.createKonto();
//		this.konto5 = Konto.createKonto();
//		
//		this.konto1.setSaldo(Geldbetrag.createGeldbetrag(modelConstants.InitializationConstants.KontoInitialSaldo));
//		this.konto2.setSaldo(Geldbetrag.createGeldbetrag(modelConstants.InitializationConstants.KontoInitialSaldo));
//		this.konto3.setSaldo(Geldbetrag.createGeldbetrag(modelConstants.InitializationConstants.KontoInitialSaldo));
//		this.konto4.setSaldo(Geldbetrag.createGeldbetrag(modelConstants.InitializationConstants.KontoInitialSaldo));
//		this.konto5.setSaldo(Geldbetrag.createGeldbetrag(modelConstants.InitializationConstants.KontoInitialSaldo));
	}

	@After
	public void tearDown() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
}
