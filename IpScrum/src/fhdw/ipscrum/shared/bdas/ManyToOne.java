package fhdw.ipscrum.shared.bdas;

public class ManyToOne<A extends OneToMany<?, ?>, F extends BDACompare> extends
		BDABaseLogic<A, F> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4241282566454466117L;

	@SuppressWarnings("unused")
	private ManyToOne() {
	}

	public ManyToOne(final F element) {
		super(element);
	}

	@Override
	public void set(final A arg) {
		super.set(arg);
	}

	@Override
	public BDACompare get() {
		return super.get();
	}
}
