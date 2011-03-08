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
	 * @param sprintBeginDate minimal date
	 * @param releaseDate maximal date
	 * @return a random enddate
	 */
	public static Date getRandomSprintEnddate(Date sprintBeginDate, Date releaseDate) {
		Date endDate = copyDate(sprintBeginDate);
		int dayCount = getDaysBetween(sprintBeginDate, releaseDate);
		addDaysToDate(endDate, (int) (Math.random() * (dayCount-5) + 5));
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

	/**
	 * Generates a random releasedate.
	 * The return value will be between 30 and 60 days from today.
	 * @return random date (30-60 days in the future)
	 */
	public static Date getRandomReleaseDate() {
		Date temp = new Date();
		addDaysToDate(temp, (int) (Math.random() * 30 + 30));
		return temp;
	}

	/**
	 * Removes the given number of days from a date.
	 * 
	 * @param date the date
	 * @param days number of days
	 */
	@SuppressWarnings("deprecation") // Unfortunately GWT requires Date
	public static void removeDaysFromDate(Date date, int days) {
		date.setDate(date.getDate() - days);
	}

	/**
	 * Resets the date to have no time modifiers.
	 * 
	 * @param date the date
	 */
	@SuppressWarnings("deprecation") // Unfortunately GWT requires Date
	public static void resetTime(Date date) {
		long msec = date.getTime();
		msec = (msec / 1000) * 1000;
		date.setTime(msec);

		// Daylight savings time occurs at midnight in some time zones, so we reset
		// the time to noon instead.
		date.setHours(12);
		date.setMinutes(0);
		date.setSeconds(0);
	}
}
