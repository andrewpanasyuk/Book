package Prometeus.Dijkstri;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by a_pan on 28.01.2017.
 */
public class Point implements Comparable<Point>{
    private int caunt_point;
    private Map<Integer, Integer> ways = new HashMap<>();
    private int previousPoint = -1;
    private int distance = 0;

    public Point(){

    }

    public int getCaunt_point() {
        return caunt_point;
    }

    public void setCaunt_point(int caunt_point) {
        this.caunt_point = caunt_point;
    }

    public Map<Integer, Integer> getWays() {
        return ways;
    }

    public void setWays(Map<Integer, Integer> ways) {
        this.ways = ways;
    }

    public int getPreviousPoint() {
        return previousPoint;
    }

    public void setPreviousPoint(int previousPoint) {
        this.previousPoint = previousPoint;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

//    @Override
//    public int compareTo(Point o) {
//        return distance - o.getDistance();
//    }

    @Override
    public String toString() {
//        return "Point{" +
//                "caunt_point=" + caunt_point +
//                ", previousPoint=" + previousPoint.getCaunt_point() +
//                ", distance=" + distance +
//                '}';
        return "caunt_point=" + caunt_point;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Point point = (Point) o;

        return caunt_point == point.caunt_point;

    }

    @Override
    public int hashCode() {
        return caunt_point;
    }

    @Override
    public int compareTo(Point o) {
        return 0;
    }
}
