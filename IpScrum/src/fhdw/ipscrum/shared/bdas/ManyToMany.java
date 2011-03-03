package fhdw.ipscrum.shared.bdas;

import java.util.Vector;

@SuppressWarnings("unchecked")
/**
 * This element is referenced 0 or many times and references many
 */
public class ManyToMany<A extends ManyToMany, F extends BDACompare> extends
		BDABaseLogic<A, F> {

	private ManyToMany() {
	}

	public ManyToMany(final F element) {
		super(element);
	}

	@Override
	public void add(final A arg) {
		super.add(arg);
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