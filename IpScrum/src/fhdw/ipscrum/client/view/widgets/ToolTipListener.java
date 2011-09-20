package fhdw.ipscrum.client.view.widgets;

import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.MouseListenerAdapter;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * THIS CLASS IS STOLEN BY http://www.java2s.com/Code/Java/GWT/TooltipcomponentforGWT.htm
 * .
 */

@SuppressWarnings("deprecation")
public class ToolTipListener extends MouseListenerAdapter {
	private static final String DEFAULT_TOOLTIP_STYLE = "TooltipPopup";
	private static final int DEFAULT_OFFSET_X = 10;
	private static final int DEFAULT_OFFSET_Y = 35;

	/**
	 * Constructor of the Tooltip.
	 */
	private static class Tooltip extends PopupPanel {
		private final int delay;

		public Tooltip(final Widget sender, final int offsetX, final int offsetY,
				final String text, final int delay, final String styleName) {
			super(true);

			this.delay = delay;

			final HTML contents = new HTML(text);
			this.add(contents);

			final int left = sender.getAbsoluteLeft() + offsetX;
			final int top = sender.getAbsoluteTop() + offsetY;

			this.setPopupPosition(left, top);
			this.setStyleName(styleName);
		}

		@Override
		public void show() {
			super.show();

			final Timer t = new Timer() {

				@Override
				public void run() {
					ToolTipListener.Tooltip.this.hide();
				}

			};
			t.schedule(this.delay);
		}
	}

	private Tooltip tooltip;
	private final String text;
	private String styleName;
	private final int delay;
	private int offsetX = ToolTipListener.DEFAULT_OFFSET_X;
	private int offsetY = ToolTipListener.DEFAULT_OFFSET_Y;

	/**
	 * Constructor of the ToolTipListener.
	 * 
	 * @param text
	 *            related to the listener
	 * @param delay
	 *            of the listener
	 */
	public ToolTipListener(final String text, final int delay) {
		this(text, delay, ToolTipListener.DEFAULT_TOOLTIP_STYLE);
	}

	/**
	 * Constructor of the ToolTipListener.
	 * 
	 * @param text
	 *            related to the listener
	 * @param delay
	 *            of the listener
	 * @param styleName
	 *            of the lsitener
	 */
	public ToolTipListener(final String text, final int delay, final String styleName) {
		this.text = text;
		this.delay = delay;
		this.styleName = styleName;
	}

	@Override
	public void onMouseEnter(final Widget sender) {
		if (this.tooltip != null) {
			this.tooltip.hide();
		}
		this.tooltip =
				new Tooltip(sender, this.offsetX, this.offsetY, this.text, this.delay,
						this.styleName);
		this.tooltip.show();
	}

	@Override
	public void onMouseLeave(final Widget sender) {
		if (this.tooltip != null) {
			this.tooltip.hide();
		}
	}

	/**
	 * Getter of the styleName.
	 * 
	 * @return the styleName
	 */
	public String getStyleName() {
		return this.styleName;
	}

	/**
	 * Sets the styleName.
	 * 
	 * @param styleName
	 *            to set
	 */
	public void setStyleName(final String styleName) {
		this.styleName = styleName;
	}

	/**
	 * Getter of the x offset.
	 * 
	 * @return the x offset
	 */
	public int getOffsetX() {
		return this.offsetX;
	}

	/**
	 * Sets the x offset.
	 * 
	 * @param offsetX
	 *            to set
	 */
	public void setOffsetX(final int offsetX) {
		this.offsetX = offsetX;
	}

	/**
	 * Getter of the y offset.
	 * 
	 * @return the y offset
	 */
	public int getOffsetY() {
		return this.offsetY;
	}

	/**
	 * Sets the y offset.
	 * 
	 * @param offsetY
	 *            to set
	 */
	public void setOffsetY(final int offsetY) {
		this.offsetY = offsetY;
	}
}
