package fhdw.ipscrum.client.view.widgets;

import java.util.Date;

import com.google.gwt.cell.client.DateCell;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.TextColumn;

import fhdw.ipscrum.shared.constants.TextConstants;
import fhdw.ipscrum.shared.model.nonMeta.Sprint;

/**
 * Represents the table in which the sprints are shown.
 */
public class SprintTable extends CellTable<Sprint> {

	/**
	 * Represents the format in which the Date should be shown.
	 */
	private final DateTimeFormat format = DateTimeFormat.getFormat("dd.MM.yyyy");

	/**
	 * Constructor of the SprintTable.
	 */
	public SprintTable() {

		final TextColumn<Sprint> clmnName = new TextColumn<Sprint>() {
			@Override
			public String getValue(final Sprint object) {
				return object.getName();
			}
		};
		this.addColumn(clmnName, TextConstants.SPRINTTABLE_DESCRIPTIONHEADER);

		final Column<Sprint, Date> clmnBegin = new Column<Sprint, Date>(new DateCell(this.format)) {
			@Override
			public Date getValue(final Sprint object) {
				return object.getBegin();
			}
		};
		clmnBegin.setSortable(true);
		this.addColumn(clmnBegin, TextConstants.SPRINTTABLE_BEGINDATEHEADER);

		final Column<Sprint, Date> clmnEnd = new Column<Sprint, Date>(new DateCell(this.format)) {
			@Override
			public Date getValue(final Sprint object) {
				return object.getEnd();
			}
		};
		clmnEnd.setSortable(true);
		this.addColumn(clmnEnd, TextConstants.SPRINTTABLE_ENDDATEHEADER);

		final TextColumn<Sprint> clmnTeam = new TextColumn<Sprint>() {
			@Override
			public String getValue(final Sprint object) {
				return object.getTeam().getDescription();
			}
		};
		this.addColumn(clmnTeam, TextConstants.SPRINTTABLE_TEAMHEADER);
	}

}
