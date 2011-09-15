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

	public ToolTipListener(final String text, final int delay) {
		this(text, delay, ToolTipListener.DEFAULT_TOOLTIP_STYLE);
	}

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

	public String getStyleName() {
		return this.styleName;
	}

	public void setStyleName(final String styleName) {
		this.styleName = styleName;
	}

	public int getOffsetX() {
		return this.offsetX;
	}

	public void setOffsetX(final int offsetX) {
		this.offsetX = offsetX;
	}

	public int getOffsetY() {
		return this.offsetY;
	}

	public void setOffsetY(final int offsetY) {
		this.offsetY = offsetY;
	}
}
