package finances.domain;

import finances.util.*;

public class Projection {
    private AccountYear[] projection;

    public Projection(int duration, AccountYear firstAccountYear) {
        this.projection = new AccountYear[duration + 1];
        projection[0] = firstAccountYear;
        for (int i = 0; i < duration; i++) {
            projection[i + 1] = projection[i].newYear();
        }
    }

    public int duration() {
        return projection.length;
    }

    public int lastYear() {
        return projection[projection.length - 1].year();
    }

    public AccountYear projectionYear(int projectionYear) {
        Require.that(projectionYear >= 0 && projectionYear < duration(),
                "projectionYear must be between 0 and  " + (duration() - 1) + " was; " + projectionYear);
        return projection[projectionYear];
    }

}