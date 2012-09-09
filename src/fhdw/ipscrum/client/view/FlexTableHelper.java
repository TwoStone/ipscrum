package fhdw.ipscrum.client.view;

import java.util.HashSet;
import java.util.Set;

import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.FlexTable;

/**
 * When {@link com.google.gwt.user.client.ui.FlexTable.FlexCellFormatter#setRowSpan(int, int, int)} is used, it causes
 * unexpected shifting for cells on rows below spanned one, because {@link FlexTable#prepareCell(int, int)} is naive and
 * does not take into account fact of spanning (well, often <code>setRowSpan()</code> is invoked after adding cells, so
 * may be we should say that <code>setRowSpan()</code> is guilty).
 * <p>
 * See http://groups.google.com/group/Google-Web-Toolkit/browse_thread/thread/8 a76929f78946c00 for discussion about
 * this problem.
 * <p>
 * In any case, this helper class tried to fix row span problem that that {@link FlexTable} can be used as normal grid
 * with arbitrary col/row spanning.
 * 
 * @author scheglov_ke
 */
public final class FlexTableHelper {

	/**
	 * constructor of the FlexTableHelper.
	 */
	private FlexTableHelper() {

	}

	/**
	 * Fixes problem with {@link com.google.gwt.user.client.ui.FlexTable.FlexCellFormatter#setRowSpan(int, int, int)} ,
	 * see comment for {@link #FlexTableHelper}.
	 * 
	 * @param flexTable
	 *            is the flex table
	 */
	public static void fixRowSpan(final FlexTable flexTable) {
		final Set<Element> tdToRemove = new HashSet<Element>();
		{
			final int rowCount = flexTable.getRowCount();
			for (int row = 0; row < rowCount; row++) {
				final int cellCount = flexTable.getCellCount(row);
				// System.out.println("\tcellCount: " + row + " " + cellCount);
				for (int cell = 0; cell < cellCount; cell++) {
					final int colSpan = flexTable.getFlexCellFormatter().getColSpan(row, cell);
					final int rowSpan = flexTable.getFlexCellFormatter().getRowSpan(row, cell);
					if (rowSpan != 1) {
						final int column = FlexTableHelper.getColumnOfCell(flexTable, row, cell);
						for (int row2 = row + 1; row2 < row + rowSpan; row2++) {
							final int baseCell2 = FlexTableHelper.getCellOfColumn(flexTable, row2, column);
							for (int cell2 = baseCell2; cell2 < baseCell2 + colSpan; cell2++) {
								if (cell2 != -1) {
									/*
									 * System.out.println("remove (row,cell,column): " + row2 + " " + cell2 + " " +
									 * column);
									 */
									final Element td = flexTable.getCellFormatter().getElement(row2, cell2);
									tdToRemove.add(td);
								}
							}
						}
					}
				}
			}
		}
		// remove TD elements
		for (final Element td : tdToRemove) {
			final Element tr = DOM.getParent(td);
			DOM.removeChild(tr, td);
		}
	}

	private static int getColumnOfCell(final FlexTable flexTable, final int row, final int cell) {
		int column = 0;
		for (int _cell = 0; _cell < cell; _cell++) {
			final int colSpan = FlexTableHelper.getColSpan(flexTable, row, _cell);
			column += colSpan;
		}
		return column;
	}

	private static int getCellOfColumn(final FlexTable flexTable, final int row, final int column) {
		final int cellCount = flexTable.getCellCount(row);
		int currentColumn = 0;
		for (int cell = 0; cell < cellCount; cell++) {
			final int colSpan = FlexTableHelper.getColSpan(flexTable, row, cell);
			if (currentColumn == column) {
				return cell;
			}
			currentColumn += colSpan;
		}
		return -1;
	}

	private static int getColSpan(final FlexTable flexTable, final int row, final int cell) {
		return flexTable.getFlexCellFormatter().getColSpan(row, cell);
	}
}
