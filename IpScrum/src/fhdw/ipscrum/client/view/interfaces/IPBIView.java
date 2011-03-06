package fhdw.ipscrum.client.view.interfaces;

import java.util.List;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.IEvent;
import fhdw.ipscrum.client.events.args.RemoveCriterionEventArgs;
import fhdw.ipscrum.client.events.args.RemoveHintEventArgs;
import fhdw.ipscrum.client.events.args.RemoveRelationEventArgs;
import fhdw.ipscrum.shared.exceptions.NothingSelectedException;
import fhdw.ipscrum.shared.model.AcceptanceCriterion;
import fhdw.ipscrum.shared.model.Hint;
import fhdw.ipscrum.shared.model.Relation;
import fhdw.ipscrum.shared.model.interfaces.IRelease;
import fhdw.ipscrum.shared.model.interfaces.ISprint;

public interface IPBIView extends IView {

	/**
	 * Returns the event that is fired, when the workflow should be aborted.
	 * 
	 * @return
	 */
	IEvent<EventArgs> getAbort();

	/**
	 * Returns the event that is fired, when a new criterion should be created.
	 * 
	 * @return
	 */
	IEvent<EventArgs> getCreateCriterion();

	/**
	 * Returns the event that is fired, when the selected systems should be change.
	 * 
	 * @return
	 */
	IEvent<EventArgs> getChangeSystems();

	/**
	 * Returns the event that is fired, when a new hint should be created.
	 * 
	 * @return
	 */
	IEvent<EventArgs> getCreateHint();

	/**
	 * Returns the event that is fired, when a new relation should be created.
	 * 
	 * @return
	 */
	IEvent<EventArgs> getCreateRelation();

	/**
	 * Returns the text entered in the description field.
	 * 
	 * @return
	 */
	String getDescription();

	/**
	 * Returns the selected PBI-type.
	 * 
	 * @return
	 */
	String getSelectedPBITyp();

	/**
	 * Returns the text entered in the name field.
	 * 
	 * @return
	 */
	String getName();

	/**
	 * Returns the event, fired when a criterion should be removed.
	 * 
	 * @return
	 */
	IEvent<RemoveCriterionEventArgs> getRemoveCriterion();

	/**
	 * Returns the event, fired when a hint should be removed.
	 * 
	 * @return
	 */
	IEvent<RemoveHintEventArgs> getRemoveHint();

	/**
	 * Return the event, fired when a relation should be removed.
	 * 
	 * @return
	 */
	IEvent<RemoveRelationEventArgs> getRemoveRelation();

	/**
	 * Returns the event that is fired, when the current object should be saved.
	 * 
	 * @return
	 */
	IEvent<EventArgs> getSave();

	/**
	 * Returns the currently selected {@link ISprint} object.
	 * 
	 * @return
	 * @throws NothingSelectedException Is thrown if nothing is selected.
	 */
	ISprint getSelectedSprint() throws NothingSelectedException;

	/**
	 * Returns the currently selected {@link IRelease} object.
	 * 
	 * @return
	 * @throws NothingSelectedException Is thrown if nothing is selected.
	 */
	IRelease getSelectedVersion() throws NothingSelectedException;

	/**
	 * Displays a list of {@link AcceptanceCriterion} objects in the gui.
	 * 
	 * @param criterions
	 */
	void setCriteria(List<AcceptanceCriterion> criterions);

	/**
	 * Sets description text in the user interface.
	 * 
	 * @param description
	 */
	void setDescription(String description);

	/**
	 * Displays a list of {@link Hint} objects in the gui.
	 * 
	 * @param hints
	 */
	void setHints(List<Hint> hints);

	/**
	 * Displays the name in the user interface.
	 * 
	 * @param name
	 */
	void setName(String name);

	/**
	 * Displays a list of {@link Relation} object in the gui.
	 * 
	 * @param relations
	 */
	void setRelations(List<Relation> relations);

	/**
	 * Displays a list of {@link ISprint} objects in the gui and selects the defined {@link ISprint} object.
	 * 
	 * @param sprints {@link ISprint} objects to display.
	 * @param selected {@link ISprint} object to preselect. Object <b>must</b> be included in the sprints list, otherwise it will be added.
	 */
	void setSprints(List<ISprint> sprints, ISprint selected);

	/**
	 * Displays a list of {@link IRelease} objects in the gui and selects the defined {@link IRelease} object.
	 * 
	 * @param release {@link IRelease} objects to display.
	 * @param selected {@link IRelease} object to preselect. Object <b>must</b> be included in the sprints list, otherwise it will be added.
	 */
	void setVersion(List<IRelease> releases, IRelease selected);

	/**
	 * Displays a list of {@link PBI}-Types in the gui and selects the defined {@link PBI}-type.
	 */
	void setPBITyp();

}