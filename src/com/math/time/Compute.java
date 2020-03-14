package com.math.time;

import java.time.Duration;

public class Compute {
    private int h;
    private int min;

    Duration duration;

    public Compute(int h, int min) {
        this.h = h;
        this.min = min;
    }

    public int getH() {
        return this.h;
    }

    public int getMin() {
        return this.min;
    }

    public void setH(int h) {
        this.h = h;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public Duration getDuration() {
        return this.duration = duration.ofHours(h).plusMinutes(min);
    }

    public Duration getSubDuration() {
        return this.duration = duration.minusHours(h).minusMinutes(min);
    }

    @Override
    public String toString() {
        return this.h + " hr" + " : " + this.min + " min";
    }
}
