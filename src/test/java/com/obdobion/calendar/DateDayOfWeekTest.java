package com.obdobion.calendar;

import org.junit.Assert;
import org.junit.Test;

/**
 * <p>
 * DateDayOfWeekTest class.
 * </p>
 *
 * @author Chris DeGreef fedupforone@gmail.com
 * @since 1.0.1
 */
public class DateDayOfWeekTest
{
    /**
     * <p>
     * Constructor for DateDayOfWeekTest.
     * </p>
     */
    public DateDayOfWeekTest()
    {

    }

    /**
     * <p>
     * at_BOW.
     * </p>
     *
     * @throws java.lang.Exception if any.
     */
    @Test
    public void at_BOW()
            throws Exception
    {
        CalendarFactoryHelper.startExpectedComputed("=2dayofweek =20ms", "-1d =20ms", "=bdayofweek");
    }

    /**
     * <p>
     * at_EOW.
     * </p>
     *
     * @throws java.lang.Exception if any.
     */
    @Test
    public void at_EOW()
            throws Exception
    {
        CalendarFactoryHelper.startExpectedComputed(
                "=1dayofweek =20ms", "+6d =23h =59mi =59s =999999999n", "=edayofweek", true);
    }

    /**
     * <p>
     * next_BOW_NextDayInNextWeek.
     * </p>
     *
     * @throws java.lang.Exception if any.
     */
    @Test
    public void next_BOW_NextDayInNextWeek()
            throws Exception
    {
        CalendarFactoryHelper.startExpectedComputed("=6dayofweek =btime", "+7d =1dayofweek", ">bdayofweek");
    }

    /**
     * <p>
     * next_DAY_NextDayInNextWeek.
     * </p>
     *
     * @throws java.lang.Exception if any.
     */
    @Test
    public void next_DAY_NextDayInNextWeek()
            throws Exception
    {
        CalendarFactoryHelper.startExpectedComputed("=6dayofweek =btime", "+7d", ">6dayofweek");
    }

    /**
     * <p>
     * next_DAY_NextDayInSameWeek.
     * </p>
     *
     * @throws java.lang.Exception if any.
     */
    @Test
    public void next_DAY_NextDayInSameWeek()
            throws Exception
    {
        CalendarFactoryHelper.startExpectedComputed("=5dayofweek =btime", "+1d", ">6dayofweek");
    }

    /**
     * <p>
     * next_EOW_NextDayInNextWeek.
     * </p>
     *
     * @throws java.lang.Exception if any.
     */
    @Test
    public void next_EOW_NextDayInNextWeek()
            throws Exception
    {
        CalendarFactoryHelper.startExpectedComputed("=7dayofweek =etime", "+7d =7dayofweek =etime", ">edayofweek");
    }

    /**
     * <p>
     * nextEq_BOW_NextDayInNextWeek.
     * </p>
     *
     * @throws java.lang.Exception if any.
     */
    @Test
    public void nextEq_BOW_NextDayInNextWeek()
            throws Exception
    {
        CalendarFactoryHelper.startExpectedComputed("=2dayofweek =btime", "+7d =1dayofweek", ">=bdayofweek");
    }

    /**
     * <p>
     * nextEq_BOW_NextDayInSameWeek.
     * </p>
     *
     * @throws java.lang.Exception if any.
     */
    @Test
    public void nextEq_BOW_NextDayInSameWeek()
            throws Exception
    {
        CalendarFactoryHelper.startExpectedComputed("=1dayofweek =btime", "", ">=bdayofweek");
    }

    /**
     * <p>
     * nextEq_DAY_NextDayInNextWeek.
     * </p>
     *
     * @throws java.lang.Exception if any.
     */
    @Test
    public void nextEq_DAY_NextDayInNextWeek()
            throws Exception
    {
        CalendarFactoryHelper.startExpectedComputed("=5dayofweek =btime", "+7d -1d", ">=4dayofweek");
    }

    /**
     * <p>
     * nextEq_DAY_NextDayInSameWeek.
     * </p>
     *
     * @throws java.lang.Exception if any.
     */
    @Test
    public void nextEq_DAY_NextDayInSameWeek()
            throws Exception
    {
        CalendarFactoryHelper.startExpectedComputed("=5dayofweek =btime", "+1d", ">=6dayofweek");
    }

    /**
     * <p>
     * nextEq_DAY_ThisDayIsOk.
     * </p>
     *
     * @throws java.lang.Exception if any.
     */
    @Test
    public void nextEq_DAY_ThisDayIsOk()
            throws Exception
    {
        CalendarFactoryHelper.startExpectedComputed("=6dayofweek =btime", "", ">=6dayofweek");
    }

    /**
     * <p>
     * nextEq_EOW_NextDayInSameWeek.
     * </p>
     *
     * @throws java.lang.Exception if any.
     */
    @Test
    public void nextEq_EOW_NextDayInSameWeek()
            throws Exception
    {
        /*
         * Wed=3, SUN=7
         */
        CalendarFactoryHelper.startExpectedComputed("=3dayofweek ", "=7dayofweek =etime", ">=edayofweek");
    }

    /**
     * <p>
     * nextEq_EOW_NextDayIsOK.
     * </p>
     *
     * @throws java.lang.Exception if any.
     */
    @Test
    public void nextEq_EOW_NextDayIsOK()
            throws Exception
    {
        CalendarFactoryHelper.startExpectedComputed("=7dayofweek ", "=etime", ">=edayofweek");
    }

    /**
     * <p>
     * plus_BOW_error.
     * </p>
     *
     * @throws java.lang.Exception if any.
     */
    @Test
    public void plus_BOW_error()
            throws Exception
    {
        try
        {
            CalendarFactoryHelper.startExpectedComputed("", "", "+bdayofweek");
            Assert.fail("expected invalid direction in data adjustment: ADD");

        } catch (final Exception e)
        {
            Assert.assertEquals("invalid direction in data adjustment: ADD", e.getMessage());
        }
    }

    /**
     * <p>
     * plus_DayOfWeek.
     * </p>
     *
     * @throws java.lang.Exception if any.
     */
    @Test
    public void plus_DayOfWeek()
            throws Exception
    {
        try
        {
            CalendarFactoryHelper.startExpectedComputed("=btime", "+24Hours", "+1dayofweek");
        } catch (final Exception e)
        {
            Assert.assertEquals("invalid direction in data adjustment: ADD", e.getMessage());
        }
    }

    /**
     * <p>
     * plus_EOW_error.
     * </p>
     *
     * @throws java.lang.Exception if any.
     */
    @Test
    public void plus_EOW_error()
            throws Exception
    {
        try
        {
            CalendarFactoryHelper.startExpectedComputed("", "", "+edayofweek");
            Assert.fail("expected invalid direction in data adjustment: ADD");

        } catch (final Exception e)
        {
            Assert.assertEquals("invalid direction in data adjustment: ADD", e.getMessage());
        }
    }

    /**
     * <p>
     * prev_BOW_PrevDayInPrevWeek.
     * </p>
     *
     * @throws java.lang.Exception if any.
     */
    @Test
    public void prev_BOW_PrevDayInPrevWeek()
            throws Exception
    {
        CalendarFactoryHelper.startExpectedComputed("=1dayofweek =btime", "-7d =et", "<bdayofweek");
    }

    /**
     * <p>
     * prev_BOW_PrevDayInSameWeek.
     * </p>
     *
     * @throws java.lang.Exception if any.
     */
    @Test
    public void prev_BOW_PrevDayInSameWeek()
            throws Exception
    {
        CalendarFactoryHelper.startExpectedComputed("=2dayofweek =btime", "-1d =et", "<bdayofweek");
    }

    /**
     * <p>
     * prev_DAY_PrevDayInPrevWeek.
     * </p>
     *
     * @throws java.lang.Exception if any.
     */
    @Test
    public void prev_DAY_PrevDayInPrevWeek()
            throws Exception
    {
        CalendarFactoryHelper.startExpectedComputed("=6dayofweek =btime", "-7d =et", "<6dayofweek");
    }

    /**
     * <p>
     * prev_DAY_PrevDayInSameWeek.
     * </p>
     *
     * @throws java.lang.Exception if any.
     */
    @Test
    public void prev_DAY_PrevDayInSameWeek()
            throws Exception
    {
        CalendarFactoryHelper.startExpectedComputed("=6dayofweek =btime", "-1d =et", "<5dayofweek");
    }

    /**
     * <p>
     * prev_EOW_PrevDayInPrevWeek.
     * </p>
     *
     * @throws java.lang.Exception if any.
     */
    @Test
    public void prev_EOW_PrevDayInPrevWeek()
            throws Exception
    {
        CalendarFactoryHelper.startExpectedComputed("=7dayofweek", "-7d =etime", "<edayofweek");
    }

    /**
     * <p>
     * prevEq_BOW_PrevDayInSameWeek.
     * </p>
     *
     * @throws java.lang.Exception if any.
     */
    @Test
    public void prevEq_BOW_PrevDayInSameWeek()
            throws Exception
    {
        CalendarFactoryHelper.startExpectedComputed("=2dayofweek =btime", "-1d =et", "<=bdayofweek");
    }

    /**
     * <p>
     * prevEq_BOW_ThisDayIsOk.
     * </p>
     *
     * @throws java.lang.Exception if any.
     */
    @Test
    public void prevEq_BOW_ThisDayIsOk()
            throws Exception
    {
        CalendarFactoryHelper.startExpectedComputed("=1dayofweek =btime", "-7d =et", "<=bdayofweek");
    }

    /**
     * <p>
     * prevEq_DAY_PrevDayInPrevWeek.
     * </p>
     *
     * @throws java.lang.Exception if any.
     */
    @Test
    public void prevEq_DAY_PrevDayInPrevWeek()
            throws Exception
    {
        CalendarFactoryHelper.startExpectedComputed("=4dayofweek =btime", "-7d +1d =et", "<=5dayofweek");
    }

    /**
     * <p>
     * prevEq_DAY_PrevDayInSameWeek.
     * </p>
     *
     * @throws java.lang.Exception if any.
     */
    @Test
    public void prevEq_DAY_PrevDayInSameWeek()
            throws Exception
    {
        CalendarFactoryHelper.startExpectedComputed("=6dayofweek =btime", "-1d =et", "<=5dayofweek");
    }

    /**
     * <p>
     * prevEq_DAY_ThisDayIsOk.
     * </p>
     *
     * @throws java.lang.Exception if any.
     */
    @Test
    public void prevEq_DAY_ThisDayIsOk()
            throws Exception
    {
        CalendarFactoryHelper.startExpectedComputed("=6dayofweek =btime", "=et", "<=6dayofweek");
    }

    /**
     * <p>
     * prevEq_EOW_PrevDayInSameWeek.
     * </p>
     *
     * @throws java.lang.Exception if any.
     */
    @Test
    public void prevEq_EOW_PrevDayInSameWeek()
            throws Exception
    {
        CalendarFactoryHelper.startExpectedComputed("=7dayofweek", "=etime", "<=edayofweek");
    }

    /**
     * <p>
     * prevEq_EOW_ThisDayIsOk.
     * </p>
     *
     * @throws java.lang.Exception if any.
     */
    @Test
    public void prevEq_EOW_ThisDayIsOk()
            throws Exception
    {
        CalendarFactoryHelper.startExpectedComputed("=7dayofweek", "=etime", "<=edayofweek");
    }

    /**
     * <p>
     * subtract_BOW_error.
     * </p>
     *
     * @throws java.lang.Exception if any.
     */
    @Test
    public void subtract_BOW_error()
            throws Exception
    {
        try
        {
            CalendarFactoryHelper.startExpectedComputed("", "", "-bdayofweek");
            Assert.fail("expected invalid direction in data adjustment: SUBTRACT");

        } catch (final Exception e)
        {
            Assert.assertEquals("invalid direction in data adjustment: SUBTRACT", e.getMessage());
        }
    }

    /**
     * <p>
     * subtract_DayOfWeek.
     * </p>
     *
     * @throws java.lang.Exception if any.
     */
    @Test
    public void subtract_DayOfWeek()
            throws Exception
    {
        try
        {
            CalendarFactoryHelper.startExpectedComputed("=btime", "-1day", "-1dayofweek");
        } catch (final Exception e)
        {
            Assert.assertEquals("invalid direction in data adjustment: SUBTRACT", e.getMessage());
        }
    }

    /**
     * <p>
     * subtract_EOW_error.
     * </p>
     *
     * @throws java.lang.Exception if any.
     */
    @Test
    public void subtract_EOW_error()
            throws Exception
    {
        try
        {
            CalendarFactoryHelper.startExpectedComputed("", "", "-edayofweek");
            Assert.fail("expected invalid direction in data adjustment: SUBTRACT");

        } catch (final Exception e)
        {
            Assert.assertEquals("invalid direction in data adjustment: SUBTRACT", e.getMessage());
        }
    }
}
