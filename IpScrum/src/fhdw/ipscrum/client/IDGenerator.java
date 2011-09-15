package fhdw.ipscrum.client;

import java.util.LinkedList;
import java.util.List;

import fhdw.ipscrum.shared.infrastructure.UUID;
import fhdw.ipscrum.shared.infrastructure.UUIDManager;

/**
 * represents the generator for the IDs.
 */
public class IDGenerator implements UUIDManager {

	/**
	 * represents all related UUIDs.
	 */
	private final List<String> uuids;

	/**
	 * constructor of the IDGenerator.
	 */
	public IDGenerator() {
		super();
		this.uuids = new LinkedList<String>();
	}

	@Override
	public String nextID() {
		final String id = UUID.uuid();
		this.uuids.add(id);

		return id;
	}

	@Override
	public List<String> getAllUUIDs() {
		return this.uuids;
	}

}
