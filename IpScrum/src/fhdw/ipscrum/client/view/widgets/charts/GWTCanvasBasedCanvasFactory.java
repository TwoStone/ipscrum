package fhdw.ipscrum.client.view.widgets.charts;

import com.google.gwt.canvas.client.Canvas;
import com.google.gwt.canvas.dom.client.Context2d;
import com.google.gwt.canvas.dom.client.Context2d.LineJoin;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.Widget;
import com.googlecode.gchart.client.GChartCanvasFactory;
import com.googlecode.gchart.client.GChartCanvasLite;

/**
 *	This is a class to make GChart use the new Canvas-Implementation.
 *	It improves readability and responsiveness.
 */
public final class GWTCanvasBasedCanvasFactory implements GChartCanvasFactory {


	/**
	 * Set the chart to use the GWT Canvas
	 */
	static final class GWTCanvasBasedCanvasLite extends Widget implements GChartCanvasLite {
		Canvas canvas;
		Context2d canvasContext;

		public GWTCanvasBasedCanvasLite() {
			canvas = Canvas.createIfSupported();
			canvasContext = canvas.getContext2d();
		}
		@Override
		public Element getElement() {
			return canvas.getElement();
		}
		@Override
		public void setStrokeStyle(String cssColor) {
			// Sharp angles of default MITER can overwrite adjacent pie slices
			canvasContext.setLineJoin(LineJoin.ROUND);
			canvasContext.setStrokeStyle(cssColor);
		}
		@Override
		public void setFillStyle(String cssColor) {
			canvasContext.setFillStyle(cssColor);
		}
		@Override
		public void arc(double x, double y, double radius, double startAngle, double endAngle, boolean antiClockwise) {
			canvasContext.arc(x, y, radius, startAngle, endAngle, antiClockwise);
		}
		@Override
		public void beginPath() {
			canvasContext.beginPath();
		}
		@Override
		public void clear() {
			canvasContext.clearRect(0, 0, canvas.getCoordinateSpaceWidth(), canvas.getCoordinateSpaceHeight());
		}
		@Override
		public void closePath() {
			canvasContext.closePath();
		}
		@Override
		public void fill() {
			canvasContext.fill();
		}
		@Override
		public void lineTo(double x, double y) {
			canvasContext.lineTo(x, y);
		}
		@Override
		public void moveTo(double x, double y) {
			canvasContext.moveTo(x, y);
		}
		@Override
		public void resize(int width, int height) {
			canvas.setCoordinateSpaceWidth(width);
			canvas.setCoordinateSpaceHeight(height);
		}
		@Override
		public void setLineWidth(double width) {
			canvasContext.setLineWidth(width);
		}
		@Override
		public void stroke() {
			canvasContext.stroke();
		}
	}

	@Override
	public GChartCanvasLite create() {
		GChartCanvasLite result = new GWTCanvasBasedCanvasLite();
		return result;
	}
}
