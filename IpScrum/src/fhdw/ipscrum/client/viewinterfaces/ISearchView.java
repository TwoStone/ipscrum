package fhdw.ipscrum.client.viewinterfaces;

import java.util.List;

import fhdw.ipscrum.client.architecture.events.EventArgs;
import fhdw.ipscrum.client.architecture.events.EventHandler;
import fhdw.ipscrum.client.architecture.events.IEvent;
import fhdw.ipscrum.client.architecture.view.IView;
import fhdw.ipscrum.client.eventargs.CreateLogicalOperatorArgs;
import fhdw.ipscrum.client.eventargs.DeleteEventArgs;
import fhdw.ipscrum.client.eventargs.EffortSearchCriterionArgs;
import fhdw.ipscrum.client.eventargs.LastEditorSearchCriterionArgs;
import fhdw.ipscrum.client.eventargs.PBITypSearchCriterionArgs;
import fhdw.ipscrum.client.eventargs.ProjectSearchCriterionEventArgs;
import fhdw.ipscrum.client.eventargs.RelationTypeSearchCriterionArgs;
import fhdw.ipscrum.client.eventargs.ReleaseSearchCriterionArgs;
import fhdw.ipscrum.client.eventargs.SearchEventArgs;
import fhdw.ipscrum.client.eventargs.StatusSearchCriterionArgs;
import fhdw.ipscrum.client.eventargs.SystemSearchCriterionArgs;
import fhdw.ipscrum.client.eventargs.TextSearchCriterionArgs;
import fhdw.ipscrum.shared.model.metamodel.search.Search;
import fhdw.ipscrum.shared.model.nonMeta.Person;
import fhdw.ipscrum.shared.model.nonMeta.Project;
import fhdw.ipscrum.shared.model.nonMeta.RelationType;
import fhdw.ipscrum.shared.model.nonMeta.System;

/**
 * Represents the Interface of the View which is related to this presenter. It's the interface to the ({@link}
 * fhdw.ipscrum.client.view.SearchView).
 */
@SuppressWarnings("deprecation")
public interface ISearchView extends IView {
	/**
	 * Returns the event fired when the object shell be saved.
	 * 
	 * @return the save Event
	 */
	IEvent<SearchEventArgs> getSave();

	/**
	 * handler which fires the event to saves the searches.
	 * 
	 * @param handler
	 *            which handles the event and knows the search
	 */
	void registerSaveHandler(EventHandler<SearchEventArgs> handler);

	/**
	 * handler which fires the event to search.
	 * 
	 * @param handler
	 *            which handles the event and knows the search
	 */
	void registerDoSearchHandler(EventHandler<SearchEventArgs> handler);

	/**
	 * Returns the event fired when a search.
	 * 
	 * @return the event fires
	 */
	IEvent<SearchEventArgs> getDoSearch();

	/**
	 * Returns the event fired when the workflow shell be aborted.
	 * 
	 * @return the event fired
	 */
	IEvent<EventArgs> getAbort();

	/**
	 * Returns the event fired when a new search criterion should be added.
	 * 
	 * @return the event fired
	 */
	IEvent<TextSearchCriterionArgs> getAddTextSearchCriterion();

	/**
	 * Returns the event fired when a logical operator should be added.
	 * 
	 * @return the Event fired when a logical operator should be added
	 */
	IEvent<CreateLogicalOperatorArgs> getAddLogicalOperator();

	/**
	 * Returns the event fired when the search-name has changed.
	 * 
	 * @return the event fired
	 */
	IEvent<EventArgs> getChangeSearchName();

	/**
	 * Returns the event fired when a searchCriterion should be added.
	 * 
	 * @return the event fired
	 */
	IEvent<PBITypSearchCriterionArgs> getAddPbiTypeSearchCriterion();

	/**
	 * Returns the event fired when a searchCriterion should be added.
	 * 
	 * @return the event fired
	 */
	IEvent<ProjectSearchCriterionEventArgs> getAddProjectSearchCriterion();

	/**
	 * Returns the event fired when a searchCriterion should be added.
	 * 
	 * @return the event fired
	 */
	IEvent<ReleaseSearchCriterionArgs> getAddReleaseSearchCriterion();

	/**
	 * Returns the event fired when a searchCriterion should be added.
	 * 
	 * @return the event fired
	 */
	IEvent<EffortSearchCriterionArgs> getAddEffortSearchCriterion();

	/**
	 * Returns the event fired when a searchCriterion should be added.
	 * 
	 * @return the event fired
	 */
	IEvent<StatusSearchCriterionArgs> getAddStateSearchCriterion();

	/**
	 * Returns the event fired when a searchCriterion should be added.
	 * 
	 * @return the event fired
	 */
	IEvent<LastEditorSearchCriterionArgs> getAddLastEditorSearchCriterion();

	/**
	 * Returns the event fired when a searchCriterion should be added.
	 * 
	 * @return the event fired
	 */
	IEvent<RelationTypeSearchCriterionArgs> getAddRelationTypeSearchCriterion();

	/**
	 * Returns the event fired when a searchCriterion should be added.
	 * 
	 * @return the event fired
	 */
	IEvent<TextSearchCriterionArgs> getAddRelationDestSearchCriterion();

	/**
	 * Returns the event fired when a searchCriterion should be added.
	 * 
	 * @return the event fired
	 */
	IEvent<SystemSearchCriterionArgs> getAddSystemSearchCriterion();

	/**
	 * Returns the event fired when a searchCriterion should be added.
	 * 
	 * @return the event fired
	 */
	IEvent<ReleaseSearchCriterionArgs> getAddVersionSearchCriterion();

	/**
	 * returns the event fired when a search criterion should be deleted.
	 * 
	 * @return the event fired
	 */
	IEvent<DeleteEventArgs> getDeleteEventArgs();

	/**
	 * Sets the Search to display.
	 * 
	 * @param search
	 *            the search to set
	 * 
	 */
	void setSearch(Search search);

	/**
	 * Sets the projects that are searchable.
	 * 
	 * @param projects
	 *            are the searchable projects
	 * 
	 */
	void setProjects(List<Project> projects);

	/**
	 * Sets the systems that are searchable.
	 * 
	 * @param systems
	 *            are the searchable persons
	 * 
	 */
	void setSystems(List<System> systems);

	/**
	 * Sets the persons that are searchable.
	 * 
	 * @param persons
	 *            are the searchable persons
	 * 
	 */
	void setPersons(List<Person> persons);

	/**
	 * Sets the relationtypes that are searchable.
	 * 
	 * @param relationtypes
	 *            are the searchable relationtypes
	 * 
	 */
	void setRelationTypes(List<RelationType> relationtypes);

	/**
	 * Updates the tree.
	 * 
	 */
	void updateTree();

}
