package fhdw.ipscrum.shared.bdas;

@SuppressWarnings("unchecked")
/**
 * This association in a On-to-One scenario is referenced 0/1 time 
 * and references 1 or 0 associations.
 */
public class OneToOne<A extends OneToOne, F extends BDACompare> extends
		BDABaseLogic<A, F> {

	public OneToOne(final F element) {
		super(element);
	}

	@Override
	public final void set(final A arg) {
		if (arg != null) {
			// If arg already connected to another association
			if (arg.getConnectTo().size() > 0
					&& !arg.getConnectTo().contains(this)) {
				arg.set(null);
			}
		}
		super.set(arg);
	}

	@Override
	public final BDACompare get() {
		return super.get();
	}
}
