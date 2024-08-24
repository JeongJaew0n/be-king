package com.ohell.beking.common.utils.formatter;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TimeFormatUtilTest {

    @Test
    void testGetDateFormat() throws Exception {

        String expected1 = "00:00:30";
        String result1 = TimeFormatUtil.getDateFormat(30);
        assertEquals(expected1, result1);

        String expected2 = "00:01:39";
        String result2 = TimeFormatUtil.getDateFormat(99);
        assertEquals(expected2, result2);

        String expected3 = "01:00:00";
        String result3 = TimeFormatUtil.getDateFormat(3600);
        assertEquals(expected3, result3);

        String expected4 = "23:59:59";
        String result4 = TimeFormatUtil.getDateFormat(86399);
        assertEquals(expected4, result4);

        String expected5 = "34200867:32:03";
        String result5 = TimeFormatUtil.getDateFormat(123123123123L);
        assertEquals(expected5, result5);
    }

    @Test
    void testGetDateFormatFailure() throws Exception {

        Integer illegalValue = -60;
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> TimeFormatUtil.getDateFormat(illegalValue));

        assertThat(e.getMessage()).isEqualTo("ElapsedSeconds cannot be negative: " + illegalValue);
    }
}