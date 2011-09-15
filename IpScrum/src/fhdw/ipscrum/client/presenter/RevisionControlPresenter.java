package fhdw.ipscrum.client.presenter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.gwt.user.client.rpc.AsyncCallback;

import fhdw.ipscrum.client.architecture.ClientContext;
import fhdw.ipscrum.client.architecture.events.DefaultEventHandler;
import fhdw.ipscrum.client.architecture.events.EventArgs;
import fhdw.ipscrum.client.architecture.events.EventHandler;
import fhdw.ipscrum.client.architecture.events.TypedEventArg;
import fhdw.ipscrum.client.architecture.presenter.ReadPresenter;
import fhdw.ipscrum.client.services.ReceiveModelService;
import fhdw.ipscrum.client.view.RevisionControlView;
import fhdw.ipscrum.client.view.RevisionControlView.RevFilterArgs;
import fhdw.ipscrum.client.viewinterfaces.IRevisionControlView;
import fhdw.ipscrum.shared.exceptions.IPScrumGeneralException;
import fhdw.ipscrum.shared.infrastructure.Revision;
import fhdw.ipscrum.shared.model.Model;
import fhdw.ipscrum.shared.model.nonMeta.Person;
import fhdw.ipscrum.shared.utils.InfrastructureUtils;

/**
 * This is to control the revision-GUI. It enables users to inspect, load and filter
 * revisons.
 */
public class RevisionControlPresenter extends ReadPresenter {

	/**
	 * inner class to provide filter-functionalities.
	 */
	public static class FilterUtils {

		/**
		 * obtains all revisions that happened in a specified time range.
		 * 
		 * @param fromDate
		 *            beginning of time range
		 * @param toDate
		 *            end of time range
		 * @param revisions
		 *            complete list of revisions
		 * @return a list of revisions that took place in a specified time range
		 */
		public static List<Revision> getRevisionsBetween(final Date fromDate,
				final Date toDate, final Collection<Revision> revisions) {
			final List<Revision> results = new ArrayList<Revision>();
			for (final Revision revision : revisions) {
				if (revision.getRevisionDate().after(fromDate)
						&& revision.getRevisionDate().before(toDate)) {
					results.add(revision);
				}
			}

			return results;
		}

		/**
		 * obtains all revisions that happened in a specified time range.
		 * 
		 * @param fromDate
		 *            beginning of time range
		 * @param revisions
		 *            list of all revisions
		 * @return a list of revisions from param1 till today (newest)
		 */
		public static List<Revision> getRevisionsFromDate(final Date fromDate,
				final Collection<Revision> revisions) {
			final List<Revision> results = new ArrayList<Revision>();
			for (final Revision revision : revisions) {
				if (!revision.getRevisionDate().before(fromDate)) {
					results.add(revision);
				}
			}

			return results;
		}

		/**
		 * obtains a list of revisions that happened in a specified time range.
		 * 
		 * @param toDate
		 *            end of range
		 * @param revisions
		 *            list of all available revisions
		 * @return a list of revisions till param2.
		 */
		public static List<Revision> getRevisionsTillDate(final Date toDate,
				final Collection<Revision> revisions) {
			final List<Revision> results = new ArrayList<Revision>();
			for (final Revision revision : revisions) {
				if (!revision.getRevisionDate().after(toDate)) {
					results.add(revision);
				}
			}

			return results;
		}
	}

	/**
	 * Represents the view which is related to and controlled from this presenter.
	 */
	private IRevisionControlView view;

	/**
	 * constructor of the ({@link}
	 * fhdw.ipscrum.client.presenter.RevisionControlPresenter).
	 * 
	 * @param context
	 *            is the ({@link} fhdw.ipscrum.client.architecture.ClientContext) which is
	 *            needed to get the model and other related classes.
	 */
	public RevisionControlPresenter(final ClientContext context) {
		super(context);
	}

	@Override
	public String getName() {
		return "Revisionsverwaltung";
	}

	@Override
	public IRevisionControlView getView() {
		if (this.view == null) {
			this.view = this.getContext().getViewFactory().createRevisionControlView();

			this.view
					.registerFilterEventHandler(new EventHandler<RevisionControlView.RevFilterArgs>() {

						@Override
						public void onUpdate(final Object sender,
								final RevFilterArgs eventArgs) {
							final Date fromDate = eventArgs.getFromDate();
							final Date toDate = eventArgs.getToDate();
							final Set<Person> editors = eventArgs.getEditors();
							RevisionControlPresenter.this.filterRevisionlist(fromDate,
									toDate, editors);
						}
					});

			this.view.registerRemoveFilterEventHandler(new DefaultEventHandler() {

				@Override
				public void onUpdate(final Object sender, final EventArgs eventArgs) {
					RevisionControlPresenter.this.updateView();
				}
			});

			this.view
					.registerRewindEventHandler(new EventHandler<TypedEventArg<Revision>>() {

						@Override
						public void onUpdate(final Object sender,
								final TypedEventArg<Revision> eventArgs) {
							RevisionControlPresenter.this.loadRevision(eventArgs
									.getObject());
						}
					});

		}

		return this.view;
	}

	/**
	 * assistance-method for filter-operations.
	 * 
	 * @param fromDate
	 *            beginnning of time range
	 * @param toDate
	 *            end of time range
	 * @param editors
	 *            list of editors for extended drill-down
	 */
	private void filterRevisionlist(final Date fromDate, final Date toDate,
			final Set<Person> editors) {
		if (fromDate == null && toDate == null
				&& (editors == null || editors.size() == 0)) {
			this.toastMessage("Bitte geben Sie zuerst mind. ein Filterkriterium an.");
		} else {
			ReceiveModelService.Util.getInstance().getAllRevisions(
					new AsyncCallback<Map<Date, Revision>>() {

						@Override
						public void onSuccess(final Map<Date, Revision> revList) {

							final List<Revision> filterList = new ArrayList<Revision>();

							if (fromDate != null && toDate != null) {
								filterList.addAll(RevisionControlPresenter.FilterUtils
										.getRevisionsBetween(fromDate, toDate,
												revList.values()));
							} else if (fromDate != null && toDate == null) {
								filterList.addAll(RevisionControlPresenter.FilterUtils
										.getRevisionsFromDate(fromDate,
												revList.values()));
							} else if (fromDate == null && toDate != null) {
								filterList.addAll(RevisionControlPresenter.FilterUtils
										.getRevisionsTillDate(toDate, revList.values()));
							} else if (fromDate == null && toDate == null) {
								filterList.addAll(revList.values());
							}

							final List<Revision> iteratorList =
									new ArrayList<Revision>();
							iteratorList.addAll(filterList);

							for (final Person editor : editors) {
								for (final Revision revision : iteratorList) {
									try {
										if (revision
												.getEditor(RevisionControlPresenter.this
														.getContext().getModel()) != editor) {
											filterList.remove(revision);
										}
									} catch (final IPScrumGeneralException e) {
										RevisionControlPresenter.this.toastMessage(e
												.getMessage());
									}
								}
							}

							RevisionControlPresenter.this
									.updateRevTableData(filterList);
							RevisionControlPresenter.this.getView()
									.setFilterResetButtonStatus(true);
						}

						@Override
						public void onFailure(final Throwable caught) {
							RevisionControlPresenter.this.toastMessage(caught
									.getMessage());
						}
					});
		}
	}

	/**
	 * this method is used to load a non-current model into the client-GUI.
	 * 
	 * @param revision
	 *            the revision to be loaded
	 */
	private void loadRevision(final Revision revision) {
		ReceiveModelService.Util.getInstance().getAllRevisions(
				new AsyncCallback<Map<Date, Revision>>() {

					@Override
					public void onSuccess(final Map<Date, Revision> result) {
						try {
							final Model revisionModel =
									InfrastructureUtils.buildSpecificModel(
											revision.getRevisionDate(), result);
							RevisionControlPresenter.this.getContext().setModel(
									revisionModel);
							InfrastructureUtils.lockModel(revisionModel);
							RevisionControlPresenter.this
									.toastMessage("Revision erfolgreich geladen!");
							RevisionControlPresenter.this.close();
						} catch (final IPScrumGeneralException e) {
							RevisionControlPresenter.this.toastMessage(e.getMessage());
						}
					}

					@Override
					public void onFailure(final Throwable caught) {
						RevisionControlPresenter.this.toastMessage(caught.getMessage());
					}

				});
	}

	@Override
	public void updateView() {
		this.getView().updateEditorList(this.getContext().getModel().getAllPersons());
		this.getView().setFilterResetButtonStatus(false);

		ReceiveModelService.Util.getInstance().getAllRevisions(
				new AsyncCallback<Map<Date, Revision>>() {

					@Override
					public void onSuccess(final Map<Date, Revision> result) {
						final List<Revision> revList =
								new ArrayList<Revision>(result.values());
						RevisionControlPresenter.this.updateRevTableData(revList);
					}

					@Override
					public void onFailure(final Throwable caught) {
						RevisionControlPresenter.this.toastMessage(caught.getMessage());
					}
				});
	}

	/**
	 * assistance-method to provide data to the revisionlist in the GUI.
	 * 
	 * @param revList
	 *            list of revisions
	 */
	private void updateRevTableData(final List<Revision> revList) {
		Collections.sort(revList, new Comparator<Revision>() {
			@Override
			public int compare(final Revision o1, final Revision o2) {
				return o2.getRevisionDate().compareTo(o1.getRevisionDate());
			}
		});

		this.getView().updateRevisionTable(revList, this.getContext().getModel());

	}

	@Override
	public void onModelUpdate() {
		this.updateView();
	}

}
