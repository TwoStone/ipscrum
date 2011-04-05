package fhdw.ipscrum.client.view.interfaces;

import java.util.Collection;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.IEvent;
import fhdw.ipscrum.client.events.args.CreateLogicalOperatorArgs;
import fhdw.ipscrum.shared.model.Project;
import fhdw.ipscrum.shared.model.RelationType;
import fhdw.ipscrum.shared.model.System;
import fhdw.ipscrum.shared.model.interfaces.IPerson;
import fhdw.ipscrum.shared.model.search.Search;

public interface ISearchView extends IView {
	/**
	 * Returns the event fired when the object shell be saved.
	 * 
	 * @return
	 */
	IEvent<EventArgs> getSave();

	/**
	 * Returns the event fired when the workflow shell be aborted.
	 * 
	 * @return
	 */
	IEvent<EventArgs> getAborted();

	/**
	 * Returns the event fired when a new search criterion should be added.
	 * 
	 * @return
	 */
	IEvent<EventArgs> getAddNewSearchCriterion();

	/**
	 * Returns the event fired when a logical operator should be added.
	 * 
	 * @return
	 */
	IEvent<CreateLogicalOperatorArgs> getAddLogicalOperator();

	//
	// /**
	// * Returns the Search.
	// *
	// */
	// Search getSearch();

	/**
	 * Sets the Search to display.
	 * 
	 */
	void setSearch(Search search);

	/**
	 * Sets the projects that are searchable.
	 * 
	 */
	void setProjects(Collection<Project> projects);

	/**
	 * Sets the systems that are searchable.
	 * 
	 */
	void setSystems(Collection<System> systems);

	/**
	 * Sets the persons that are searchable.
	 * 
	 */
	void setPersons(Collection<IPerson> persons);

	/**
	 * Sets the relationtypes that are searchable.
	 * 
	 */
	void setRelationTypes(Collection<RelationType> relationtypes);

	/**
	 * Updates the tree.
	 * 
	 */
	void updateTree();
}
