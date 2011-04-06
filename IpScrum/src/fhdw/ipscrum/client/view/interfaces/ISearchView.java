package fhdw.ipscrum.client.view.interfaces;

import java.util.List;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.IEvent;
import fhdw.ipscrum.client.events.args.CreateLogicalOperatorArgs;
import fhdw.ipscrum.client.events.args.EffortSearchCriterionArgs;
import fhdw.ipscrum.client.events.args.LastEditorSearchCriterionArgs;
import fhdw.ipscrum.client.events.args.PBITypSearchCriterionArgs;
import fhdw.ipscrum.client.events.args.ProjectSearchCriterionEventArgs;
import fhdw.ipscrum.client.events.args.RelationSearchCriterionArgs;
import fhdw.ipscrum.client.events.args.ReleaseSearchCriterionArgs;
import fhdw.ipscrum.client.events.args.SearchEventArgs;
import fhdw.ipscrum.client.events.args.StatusSearchCriterionArgs;
import fhdw.ipscrum.client.events.args.SystemSearchCriterionArgs;
import fhdw.ipscrum.client.events.args.TextSearchCriterionArgs;
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
	IEvent<SearchEventArgs> getSave();

	/**
	 * Returns the event fired when a search.
	 * 
	 * @return
	 */
	IEvent<SearchEventArgs> getDoSearch();

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
	IEvent<TextSearchCriterionArgs> getAddTextSearchCriterion();

	/**
	 * Returns the event fired when a logical operator should be added.
	 * 
	 * @return
	 */
	IEvent<CreateLogicalOperatorArgs> getAddLogicalOperator();

	/**
	 * Returns the event fired when the search-name has changed.
	 * 
	 * @return
	 */
	IEvent<EventArgs> getChangeSearchName();

	/**
	 * Returns the event fired when a searchCriterion should be added.
	 * 
	 * @return
	 */
	IEvent<PBITypSearchCriterionArgs> getAddPbiTypSearchCriterion();

	/**
	 * Returns the event fired when a searchCriterion should be added.
	 * 
	 * @return
	 */
	IEvent<ProjectSearchCriterionEventArgs> getAddProjektSearchCriterion();

	/**
	 * Returns the event fired when a searchCriterion should be added.
	 * 
	 * @return
	 */
	IEvent<ReleaseSearchCriterionArgs> getAddReleaseSearchCriterion();

	/**
	 * Returns the event fired when a searchCriterion should be added.
	 * 
	 * @return
	 */
	IEvent<EffortSearchCriterionArgs> getAddAufwandSearchCriterion();

	/**
	 * Returns the event fired when a searchCriterion should be added.
	 * 
	 * @return
	 */
	IEvent<StatusSearchCriterionArgs> getAddStatusSearchCriterion();

	/**
	 * Returns the event fired when a searchCriterion should be added.
	 * 
	 * @return
	 */
	IEvent<LastEditorSearchCriterionArgs> getAddLetzterBearbeiterSearchCriterion();

	/**
	 * Returns the event fired when a searchCriterion should be added.
	 * 
	 * @return
	 */
	IEvent<RelationSearchCriterionArgs> getAddBeziehungSearchCriterion();

	/**
	 * Returns the event fired when a searchCriterion should be added.
	 * 
	 * @return
	 */
	IEvent<SystemSearchCriterionArgs> getAddSystemSearchCriterion();

	/**
	 * Returns the event fired when a searchCriterion should be added.
	 * 
	 * @return
	 */
	IEvent<ReleaseSearchCriterionArgs> getAddVersionSearchCriterion();

	/**
	 * Sets the Search to display.
	 * 
	 */
	void setSearch(Search search);

	/**
	 * Sets the projects that are searchable.
	 * 
	 */
	void setProjects(List<Project> projects);

	/**
	 * Sets the systems that are searchable.
	 * 
	 */
	void setSystems(List<System> systems);

	/**
	 * Sets the persons that are searchable.
	 * 
	 */
	void setPersons(List<IPerson> persons);

	/**
	 * Sets the relationtypes that are searchable.
	 * 
	 */
	void setRelationTypes(List<RelationType> relationtypes);

	/**
	 * Updates the tree.
	 * 
	 */
	void updateTree();

	/**
	 * Updates the searchresults.
	 * 
	 */
	void updateResults(ISearchResultView resultView);
}
