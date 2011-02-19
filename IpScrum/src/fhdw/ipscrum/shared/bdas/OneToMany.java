package fhdw.ipscrum.shared.bdas;

import java.util.Vector;

@SuppressWarnings("unchecked")
/**
 * This association in a Many-to-One scenario is referenced 0/1 time and
 * references 0/many associations.
 */
public class OneToMany<A extends ManyToOne, F extends BDACompare> extends
		BDABaseLogic<A, F> {

	public OneToMany(final F element) {
		super(element);
	}

	@Override
	public void add(final A arg) {
		// If no back-association for arg is set
		if (arg.get() == null) {
			super.add(arg);
		} else {
			// if the back-association is not already connected to this
			if (!arg.getConnectTo().contains(this)) {
				// Initiate Change
				// First remove current connecction from arg.
				arg.set(null);
				// Initiate new Connection
				super.add(arg);
			}
		}
	}

	@Override
	public void remove(final A arg) {
		super.remove(arg);
	}

	@Override
	public Vector<BDACompare> getAssociations() {
		return super.getAssociations();
	}

	@Override
	public void moveDown(final A bda) {
		super.moveDown(bda);
	}

	@Override
	public void moveToBottom(final A bda) {
		super.moveToBottom(bda);
	}

	@Override
	public void moveToTop(final A bda) {
		super.moveToTop(bda);
	}

	@Override
	public void moveUp(final A bda) {
		super.moveUp(bda);
	}
}
