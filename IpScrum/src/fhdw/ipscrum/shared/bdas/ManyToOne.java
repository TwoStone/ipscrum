package fhdw.ipscrum.shared.bdas;

@SuppressWarnings("unchecked")
/**
 * This association in a Many-to-One scenario is referenced 0/many times 
 * and references 1 or 0 associations.
 */
public class ManyToOne<A extends OneToMany, F extends BDACompare> extends
		BDABaseLogic<A, F> {

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
