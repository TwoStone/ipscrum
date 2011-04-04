package fhdw.ipscrum.shared.bdas;

public class OneToOne<A extends OneToOne<?, ?>, F extends BDACompare> extends
		BDABaseLogic<A, F> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6689905327321790493L;

	@SuppressWarnings("unused")
	private OneToOne() {
	}

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
