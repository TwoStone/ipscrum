package fhdw.ipscrum.shared.bdas;

public interface BDACompare {

	/**
	 * Implement here the hashCode() Operation for
	 * all required attributes <b>but not</b> for the
	 * bidirectional associations. 
	 * @return
	 */
	public abstract int indirectHashCode();
	
	public abstract boolean indirectEquals(Object obj);
}
