package fhdw.ipscrum.client.view.widgets;

import com.google.gwt.canvas.client.Canvas;
import com.google.gwt.canvas.dom.client.Context2d;
import com.google.gwt.canvas.dom.client.Context2d.LineJoin;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.Widget;
import com.googlecode.gchart.client.GChartCanvasFactory;
import com.googlecode.gchart.client.GChartCanvasLite;

/**
 * This is a class to make GChart use the new Canvas-Implementation. It improves
 * readability and responsiveness.
 */
public final class GWTCanvasBasedCanvasFactory implements GChartCanvasFactory {

	/**
	 * Set the chart to use the GWT Canvas.
	 */
	static final class GWTCanvasBasedCanvasLite extends Widget
			implements GChartCanvasLite {
		private final Canvas canvas;
		private final Context2d canvasContext;

		public GWTCanvasBasedCanvasLite() {
			this.canvas = Canvas.createIfSupported();
			this.canvasContext = this.canvas.getContext2d();
		}

		@Override
		public Element getElement() {
			return this.canvas.getElement();
		}

		@Override
		public void setStrokeStyle(final String cssColor) {
			// Sharp angles of default MITER can overwrite adjacent pie slices
			this.canvasContext.setLineJoin(LineJoin.ROUND);
			this.canvasContext.setStrokeStyle(cssColor);
		}

		@Override
		public void setFillStyle(final String cssColor) {
			this.canvasContext.setFillStyle(cssColor);
		}

		@Override
		public void arc(final double x, final double y, final double radius,
				final double startAngle, final double endAngle,
				final boolean antiClockwise) {
			this.canvasContext.arc(x, y, radius, startAngle, endAngle, antiClockwise);
		}

		@Override
		public void beginPath() {
			this.canvasContext.beginPath();
		}

		@Override
		public void clear() {
			this.canvasContext.clearRect(0, 0, this.canvas.getCoordinateSpaceWidth(),
					this.canvas.getCoordinateSpaceHeight());
		}

		@Override
		public void closePath() {
			this.canvasContext.closePath();
		}

		@Override
		public void fill() {
			this.canvasContext.fill();
		}

		@Override
		public void lineTo(final double x, final double y) {
			this.canvasContext.lineTo(x, y);
		}

		@Override
		public void moveTo(final double x, final double y) {
			this.canvasContext.moveTo(x, y);
		}

		@Override
		public void resize(final int width, final int height) {
			this.canvas.setCoordinateSpaceWidth(width);
			this.canvas.setCoordinateSpaceHeight(height);
		}

		@Override
		public void setLineWidth(final double width) {
			this.canvasContext.setLineWidth(width);
		}

		@Override
		public void stroke() {
			this.canvasContext.stroke();
		}
	}

	@Override
	public GChartCanvasLite create() {
		final GChartCanvasLite result = new GWTCanvasBasedCanvasLite();
		return result;
	}
}
