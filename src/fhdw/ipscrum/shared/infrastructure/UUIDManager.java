package fhdw.ipscrum.shared.infrastructure;

import java.util.List;

/**
 * Interface for UUID Manager!
 */
public interface UUIDManager {

	/**
	 * Returns the next UUID.
	 * 
	 * @return a UUID
	 */
	String nextID();

	/**
	 * Returns a list of all used UUIDs.
	 * 
	 * @return all UUIDs
	 */
	List<String> getAllUUIDs();
}
