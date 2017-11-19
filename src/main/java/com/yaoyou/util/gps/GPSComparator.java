package com.yaoyou.util.gps;

import java.math.BigDecimal;
import java.util.Comparator;

/**
 * Created by song on 16/8/14.
 */
public class GPSComparator implements Comparator<GPS> {

    private BigDecimal x;
    private BigDecimal y;

    public GPSComparator(BigDecimal x, BigDecimal y){
        this.x = x;
        this.y = y;
    }
    @Override
    public int compare(GPS o1, GPS o2) {
//         double pk = (double)(180 / 3.14169);
        double pk = (double)1;
        double ox = x.doubleValue() / pk;
        double oy = y.doubleValue() / pk;
        double ax = o1.getGpsX().doubleValue() / pk;
        double ay = o1.getGpsY().doubleValue() / pk;
        double bx = o2.getGpsX().doubleValue() / pk;
        double by = o2.getGpsX().doubleValue() / pk;
        double tt1 = gpsDistance(ax,ay,ox,oy);
        double tt2 = gpsDistance(bx,by,ox,oy);
        if(tt1 > tt2)
            return 1;
        else if(tt1 == tt2)
            return 0;
        else
            return -1;
    }

    double gpsDistance(double ax, double ay, double ox, double oy){
        double t11 = Math.cos(ax) * Math.cos(ay) * Math.cos(ox) * Math.cos(oy);
        double t12 = Math.cos(ax) * Math.sin(ay) * Math.cos(ox) * Math.sin(oy);
        double t13 = Math.sin(ax) * Math.sin(ox);
        return Math.acos(t11 + t12 + t13);
    }

}
