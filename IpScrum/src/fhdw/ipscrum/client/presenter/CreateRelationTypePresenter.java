package fhdw.ipscrum.client.presenter;

import com.google.gwt.user.client.ui.Panel;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.utils.GwtUtils;
import fhdw.ipscrum.client.view.TextView;
import fhdw.ipscrum.client.view.interfaces.ITextView;
import fhdw.ipscrum.shared.constants.TextConstants;
import fhdw.ipscrum.shared.exceptions.DoubleDefinitionException;
import fhdw.ipscrum.shared.model.RelationType;

public class CreateRelationTypePresenter extends Presenter<ITextView> {

	private RelationType relationType;

	public CreateRelationTypePresenter(final Panel parent) {
		super(parent);

		this.registerViewEvents();
	}

	@Override
	protected ITextView createView() {
		return new TextView(TextConstants.TYPENAME);
	}

	@Override
	protected boolean onFinish() {
		try {
			this.setRelationType(RelationType
					.create(this.getView().getContent()));
		} catch (final DoubleDefinitionException e) {
			GwtUtils.displayError(e.getMessage());
			return false;
		}
		return super.onFinish();
	}

	private void registerViewEvents() {
		this.getView().abort().add(new EventHandler<EventArgs>() {

			@Override
			public void onUpdate(final Object sender, final EventArgs eventArgs) {
				CreateRelationTypePresenter.this.abort();
			}
		});

		this.getView().save().add(new EventHandler<EventArgs>() {

			@Override
			public void onUpdate(final Object sender, final EventArgs eventArgs) {
				CreateRelationTypePresenter.this.finish();
			}
		});
	}

	public void setRelationType(RelationType relationType) {
		this.relationType = relationType;
	}

	public RelationType getRelationType() {
		return relationType;
	}

}
