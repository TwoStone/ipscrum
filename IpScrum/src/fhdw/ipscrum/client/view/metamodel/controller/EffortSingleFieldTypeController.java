package fhdw.ipscrum.client.view.metamodel.controller;

import java.io.IOException;
import java.text.ParseException;

import com.google.gwt.text.shared.Parser;
import com.google.gwt.text.shared.Renderer;

import fhdw.ipscrum.client.presenter.GenericTicketPresenter;
import fhdw.ipscrum.client.view.metamodel.ComplexSingleValueFieldWidget;
import fhdw.ipscrum.client.view.metamodel.SingleFieldWidget;
import fhdw.ipscrum.shared.exceptions.model.NoValidValueException;
import fhdw.ipscrum.shared.model.Model;
import fhdw.ipscrum.shared.model.metamodel.fields.SingleField;
import fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes.Ticket;
import fhdw.ipscrum.shared.model.nonMeta.Effort;

/**
 * Represents the EffortSingleFieldTypeController needed for editing tickets.
 */
public class EffortSingleFieldTypeController extends SingleFieldTypeController<Effort> {

	private final ComplexSingleValueFieldWidget<Effort> widget;
	private final Renderer<Effort> renderer = new Renderer<Effort>() {

		@Override
		public void render(final Effort object, final Appendable appendable)
				throws IOException {
			appendable.append(this.render(object));
		}

		@Override
		public String render(final Effort object) {
			if (object != null) {
				return object.toString();
			} else {
				return "0";
			}
		}
	};
	private final Parser<Effort> parser = new Parser<Effort>() {

		@Override
		public Effort parse(final CharSequence text) throws ParseException {
			final int parseInt = Integer.parseInt(text.toString());
			try {
				return new Effort(parseInt);
			} catch (final NoValidValueException e) {
				throw new ParseException(text.toString(), 0);
			}
		}
	};

	/**
	 * Constructor of the EffortSingleFieldTypeController.
	 * 
	 * @param presenter
	 *            the controller is created in
	 * @param field
	 *            the controller is related to
	 * @param ticket
	 *            the controller is related to
	 */
	public EffortSingleFieldTypeController(final Ticket ticket,
			final GenericTicketPresenter presenter, final SingleField<Effort> field) {
		super(ticket, presenter, field);
		this.widget =
				new ComplexSingleValueFieldWidget<Effort>(this.parser, this.renderer);
		this.initialize();
	}

	@Override
	public void updateWidget(final Model model) {
		this.getWidget().setValue(this.getField().getValue());
	}

	@Override
	public SingleFieldWidget<Effort> getWidget() {
		return this.widget;
	}
}
