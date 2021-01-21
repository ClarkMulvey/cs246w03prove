package mulvey;

import java.util.Comparator;

// Custom comparator class - compares two city objects,
// and returns whether one has a larger max temp in the next five days' forecast
// Or if they equal the same
public class SortByMaxTemp implements Comparator<City> {
    @Override
    public int compare(City o1, City o2) {
        int isBigger = o1.getMaxTempNextFiveDays() > o2.getMaxTempNextFiveDays() ? -1 : 1 ;
        // I guess this is the best way to compare floats, if you want to know why see
        // https://stackoverflow.com/questions/1088216/whats-wrong-with-using-to-compare-floats-in-java#:~:text=This%20is%20the%20main%20reason,more%20important%20to%20avoid%20%3D%3D.
        float epsilon = (float) .00000000001;
        if (Math.abs(o1.getMaxTempNextFiveDays() - o2.getMaxTempNextFiveDays()) < epsilon) {
            isBigger = 0;
        }
        return isBigger;
    }
}
