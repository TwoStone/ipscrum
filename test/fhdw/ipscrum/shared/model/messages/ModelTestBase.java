package fhdw.ipscrum.shared.model.messages;

import java.util.Date;

import org.junit.Before;

import fhdw.ipscrum.client.IDGenerator;
import fhdw.ipscrum.shared.infrastructure.InitialCommand;
import fhdw.ipscrum.shared.model.Model;

/**
 * Base class for model dependend testing.
 */
public class ModelTestBase {

	/**
	 * the model.
	 */
	private Model model;

	/**
	 * @return the model the testcases use
	 */
	public Model getModel() {
		return this.model;
	}

	/**
	 * Sets up the model.
	 * 
	 * @throws Exception
	 *             if any error occurs
	 */
	@Before
	public void setUp() throws Exception {
		this.model = new Model(new Date());
		this.model.setUuidManager(new IDGenerator());
		final InitialCommand command = new InitialCommand();
		command.execute(this.model);
	}

}
