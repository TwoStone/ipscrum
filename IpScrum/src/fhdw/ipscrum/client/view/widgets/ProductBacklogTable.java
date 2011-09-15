package fhdw.ipscrum.client.view.widgets;

import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.TextColumn;

import fhdw.ipscrum.shared.constants.TextConstants;
import fhdw.ipscrum.shared.model.nonMeta.ProductBacklog;
import fhdw.ipscrum.shared.model.nonMeta.ProductBacklogItem;

public class ProductBacklogTable extends CellTable<ProductBacklogItem> {

	public ProductBacklogTable() {
		final TextColumn<ProductBacklogItem> colName =
				new TextColumn<ProductBacklogItem>() {

					@Override
					public String getValue(final ProductBacklogItem object) {
						return object.getName();
					}

				};
		this.addColumn(colName, TextConstants.PRODUCTBACKLOG_TEXT);

		final TextColumn<ProductBacklogItem> colEfford =
				new TextColumn<ProductBacklogItem>() {

					@Override
					public String getValue(final ProductBacklogItem object) {
						if (object.getManDayCosts() != null) {
							return object.getManDayCosts().toString();
						}
						return "";
					}

				};
		this.addColumn(colEfford, TextConstants.MAN_DAYS);

		final TextColumn<ProductBacklogItem> colSprint =
				new TextColumn<ProductBacklogItem>() {

					@Override
					public String getValue(final ProductBacklogItem object) {
						if (object.getSprint() != null) {
							return object.getSprint().getDescription();
						}
						return "";
					}

				};
		this.addColumn(colSprint, TextConstants.FIELDTYPE_SPRINT);

		final TextColumn<ProductBacklogItem> colType =
				new TextColumn<ProductBacklogItem>() {

					@Override
					public String getValue(final ProductBacklogItem object) {
						return object.getTicketType().getTypeName();
					}

				};
		this.addColumn(colType, TextConstants.PBI_TYPE);
	}

	public void setProductBacklog(final ProductBacklog backlog) {
		this.setRowData(backlog.getItems());
	}

}
