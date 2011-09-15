package fhdw.ipscrum.client.view.widgets;

import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.TextColumn;

import fhdw.ipscrum.shared.constants.TextConstants;
import fhdw.ipscrum.shared.model.nonMeta.Release;

public class ReleaseTable extends CellTable<Release> {

	DateTimeFormat format = DateTimeFormat.getFormat("dd.MM.yyyy");

	public ReleaseTable() {
		final TextColumn<Release> colName = new TextColumn<Release>() {

			@Override
			public String getValue(final Release object) {
				return "Release " + object.getVersion();
			}

		};
		this.addColumn(colName, TextConstants.FIELDTYPE_RELEASE);

		final TextColumn<Release> colReleaseDate = new TextColumn<Release>() {

			@Override
			public String getValue(final Release object) {
				return ReleaseTable.this.format.format(object.getReleaseDate());
			}

		};
		this.addColumn(colReleaseDate, TextConstants.RELEASE_TERMIN);

	}

}
