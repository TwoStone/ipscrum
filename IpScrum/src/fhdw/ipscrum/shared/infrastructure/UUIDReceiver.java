package fhdw.ipscrum.shared.infrastructure;

import java.util.ArrayList;
import java.util.List;

/**
 * UUID Receiver has a list of UUIDs and can return them step by step if needed.
 */
public class UUIDReceiver implements UUIDManager {

	/**
	 * represent the copyed uuids.
	 */
	private final List<String> uuids;

	/**
	 * represent the original uuids.
	 */
	private final List<String> originalUuids;

	/**
	 * constructor of the uuidReceiver.
	 * 
	 * @param originalUuids
	 *            are the given uuids
	 */
	public UUIDReceiver(final List<String> originalUuids) {
		super();
		this.uuids = this.copyUUIDs(originalUuids);
		this.originalUuids = this.copyUUIDs(originalUuids);
	}

	/**
	 * copys the uuids.
	 * 
	 * @param uuidsToCopy
	 *            to copy
	 * @return the copy
	 */
	private List<String> copyUUIDs(final List<String> uuidsToCopy) {
		final List<String> res = new ArrayList<String>();
		for (final String current : uuidsToCopy) {
			res.add(current);
		}

		return res;
	}

	@Override
	public String nextID() {
		if (this.uuids.size() > 0) {
			final String id = this.uuids.get(0);
			this.uuids.remove(0);
			return id;
		}
		return null;
	}

	@Override
	public List<String> getAllUUIDs() {
		return this.originalUuids;
	}

}
