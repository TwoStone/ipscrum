package fhdw.ipscrum.shared.utils;

import java.util.ArrayList;
import java.util.Date;

import com.google.gwt.user.client.Random;
import com.google.gwt.user.datepicker.client.CalendarUtil;

/**
 * Useful utilities for dealing with date and time. Extends CalendarUtil which holds some helpful operations as well.
 */
public final class CalendarUtils extends CalendarUtil {

	/**
	 * Five.
	 */
	private static final int WORKDAY_IN_WEEK = 5;
	/**
	 * Thirty.
	 */
	private static final int THIRTY = 30;
	/**
	 * Days in month.
	 */
	private static final int MID_DAYS_OF_MONTH = 29;
	/**
	 * Noon.
	 */
	private static final int NOON = 12;
	/**
	 * Thousand.
	 */
	private static final int THOUSANDS = 1000;

	/**
	 * Hiding the default constructor to prevent instantiation.
	 */
	private CalendarUtils() {

	}

	/**
	 * Generates a random date of the current month.
	 * 
	 * @return random date of this month
	 */
	public static Date getRandomDateOfThisMonth() {
		final Date date = new Date();
		CalendarUtil.setToFirstDayOfMonth(date);
		CalendarUtil.addDaysToDate(date, Random.nextInt(CalendarUtils.MID_DAYS_OF_MONTH));
		return date;
	}

	/**
	 * Generates a random enddate to the given begindate. The duration is set to a random value between 5 and 26.
	 * 
	 * @param sprintBeginDate
	 *            minimal date
	 * @param releaseDate
	 *            maximal date
	 * @return a random enddate
	 */
	public static Date getRandomSprintEnddate(final Date sprintBeginDate, final Date releaseDate) {
		final Date endDate = CalendarUtil.copyDate(sprintBeginDate);
		final int dayCount = CalendarUtil.getDaysBetween(sprintBeginDate, releaseDate);
		CalendarUtil.addDaysToDate(endDate,
				(int) (Math.random() * (dayCount - CalendarUtils.WORKDAY_IN_WEEK) + CalendarUtils.WORKDAY_IN_WEEK));
		return endDate;
	}

	/**
	 * This is used to obtain a List of Dates in the range from <code>param1</code> to <code>param2</code>.
	 * 
	 * @param param1
	 *            startdate
	 * @param param2
	 *            enddate
	 * @return list of dates
	 */
	public static ArrayList<Date> getAListOfDatesFromParam1ToParam2(final Date param1, final Date param2) {
		final ArrayList<Date> result = new ArrayList<Date>();
		final Date tempDate = CalendarUtil.copyDate(param1);
		while (!tempDate.after(param2)) {
			result.add(CalendarUtil.copyDate(tempDate));
			CalendarUtil.addDaysToDate(tempDate, 1);
		}
		return result;
	}

	/**
	 * Generates a random releasedate. The return value will be between 30 and 60 days from today.
	 * 
	 * @return random date (30-60 days in the future)
	 */
	public static Date getRandomReleaseDate() {
		final Date temp = new Date();
		CalendarUtil.addDaysToDate(temp, (int) (Math.random() * CalendarUtils.THIRTY + CalendarUtils.THIRTY));
		return temp;
	}

	/**
	 * Removes the given number of days from a date.
	 * 
	 * @param date
	 *            the date
	 * @param days
	 *            number of days
	 */
	@SuppressWarnings("deprecation")
	public static void removeDaysFromDate(final Date date, final int days) {
		date.setDate(date.getDate() - days);
	}

	/**
	 * Resets the date to have no time modifiers.
	 * 
	 * @param date
	 *            the date
	 */
	@SuppressWarnings("deprecation")
	public static void resetTime(final Date date) {
		long msec = date.getTime();
		msec = msec / CalendarUtils.THOUSANDS * CalendarUtils.THOUSANDS;
		date.setTime(msec);

		// Daylight savings time occurs at midnight in some time zones, so we reset
		// the time to noon instead.
		date.setHours(CalendarUtils.NOON);
		date.setMinutes(0);
		date.setSeconds(0);
	}

	/**
	 * Copies a date.
	 * 
	 * @param date
	 *            the date
	 * @return the copy
	 */
	public static Date copy(final Date date) {
		if (date == null) {
			return null;
		}
		return new Date(date.getTime());
	}

}
