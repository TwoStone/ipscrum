package fhdw.ipscrum.client.utils;

import java.util.ArrayList;
import java.util.Date;

import com.google.gwt.user.datepicker.client.CalendarUtil;

/**
 *	Useful utilities for dealing with date and time. Extends CalendarUtil which holds some helpful operations as well.
 */
public class CalendarUtils extends CalendarUtil {

	/**
	 * Generates a random date of the current month.
	 * @return random date of this month
	 */
	public static Date getRandomDateOfThisMonth() {
		Date date = new Date();
		setToFirstDayOfMonth(date);
		addDaysToDate(date, (int) (Math.random()*28));
		return date;
	}

	/**
	 * Generates a random enddate to the given begindate.
	 * The duration is set to a random value between 5 and 26.
	 * @param sprintBeginDate a begindate
	 * @return a random enddate (begindate+(5--26))
	 */
	public static Date getRandomSprintEnddate(Date beginDate) {
		Date endDate = copyDate(beginDate);
		CalendarUtil.addDaysToDate(endDate, (int) (Math.random() * 21 + 5));
		return endDate;
	}

	/**
	 * This is used to obtain a List of Dates in the range from <code>param1</code> to <code>param2</code>.
	 * @param param1 startdate
	 * @param param2 enddate
	 * @return list of dates
	 */
	public static ArrayList<Date> getAListOfDatesFromParam1ToParam2(Date param1, Date param2) {
		ArrayList<Date> result = new ArrayList<Date>();
		Date tempDate = copyDate(param1);
		while (!tempDate.after(param2)) {
			result.add(copyDate(tempDate));
			addDaysToDate(tempDate, 1);
		}
		return result;
	}
}
