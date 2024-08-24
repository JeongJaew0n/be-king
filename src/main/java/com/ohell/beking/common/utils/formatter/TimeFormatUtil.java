package com.ohell.beking.common.utils.formatter;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TimeFormatUtil {
    public static String getDateFormat(Long elapsedSeconds) {
        if (elapsedSeconds < 0) {
            throw new IllegalArgumentException("ElapsedSeconds cannot be negative: " + elapsedSeconds);
        }
        return String.format("%02d:%02d:%02d", elapsedSeconds / 3600, (elapsedSeconds / 60) % 60,  elapsedSeconds % 60);
    }

    public static String getDateFormat(Integer elapsedSeconds) {
        return getDateFormat(elapsedSeconds.longValue());
    }
}
