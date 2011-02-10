package fhdw.ipscrum.client.view;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import com.google.gwt.cell.client.AbstractCell;
import com.google.gwt.cell.client.Cell;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.view.client.ListDataProvider;
import com.google.gwt.view.client.TreeViewModel;

import fhdw.ipscrum.shared.SessionManager;
import fhdw.ipscrum.shared.model.interfaces.IPerson;
import fhdw.ipscrum.shared.model.interfaces.ITeam;

	  /**
	   * The model that defines the nodes in the tree.
	   */
	  public class TeamTreeViewModel implements TreeViewModel {
		
		/**
	     * Check if the specified value represents a leaf node. Leaf nodes cannot be
	     * opened.
	     */
		@Override
		public boolean isLeaf(Object value) {
			// The leaf nodes are the Persons.
			if (value instanceof IPerson) {
				return true;
			}
			return false;
		}

		public TeamTreeViewModel() {
		}
		
		@Override
		public <T> NodeInfo<?> getNodeInfo(T value) {

			
			
			if (value == null) {
				// Create a data provider that provides Teams.
				ListDataProvider<ITeam> teamDataProvider = new ListDataProvider<ITeam>();
				teamDataProvider.getList().addAll(SessionManager.getInstance().getModel().getTeams());
				
				Cell<ITeam> tCell = new AbstractCell<ITeam>() {
					public void render(Context context, ITeam value, SafeHtmlBuilder sb) {
						if (value != null) {
							sb.appendEscaped(value.toString());
						}
					}
				};
				return new DefaultNodeInfo(teamDataProvider, tCell);
				
			} else if (value instanceof ITeam) {
				// Create a data provider that provides Team-Members.
				ListDataProvider<IPerson> personDataProvider = new ListDataProvider<IPerson>();
				personDataProvider.getList().addAll(((ITeam) value).getMembers());
				
				Cell<IPerson> pCell = new AbstractCell<IPerson>() {
					public void render(Context context, IPerson value, SafeHtmlBuilder sb) {
						if (value != null) {
							sb.appendEscaped(value.toString());
						}
					}
				};
				return new DefaultNodeInfo(personDataProvider, pCell);
				
			} else if (value instanceof IPerson) {
				System.out.println("p" + value.toString());
			}
			
			return null;
		}

	  }