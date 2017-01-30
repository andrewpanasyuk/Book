package Prometeus.Dijkstri;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Created by a_pan on 28.01.2017.
 */
public class SearchWay {
    public static ArrayList<Point> allPoints = new ArrayList<>();
    public static ArrayList<Point> checkPoints = new ArrayList<>();
    public static Map<Integer, Point> startCollections = new HashMap<>();
    public static TreeSet<Point> qq = new TreeSet<Point>(new Comparator<Point>() {
        @Override
        public int compare(Point o1, Point o2) {
            return (o1.getDistance() - o2.getDistance());
        }
    });

    public static void main(String[] args) {
//        String fileName = "input_1_10.txt";
        String fileName = "USA-FLA.txt";
        getData(fileName);
        System.out.println(startCollections.size());
        search(1, 1070376);

    }
    public static void getDistance(int start, int finish){
        System.out.println("distance from: " + start + " to finish: " + finish + "; = " + startCollections.get(finish).getDistance());
        System.out.println(allPoints);
        System.out.println(checkPoints.size());
    }

    public static void getShotWay(int start, int finish) {
        Point fin = null;

        for (int i = 0; i < checkPoints.size(); i++) {
            if (checkPoints.get(i).getCaunt_point() == finish) {
                fin = checkPoints.get(i);
            }
        }
//        if (fin == null){
//            fin = startCollections.get(finish);
//        }
        allPoints.add(fin);
        if (start != finish && finish != -1) {
            getShotWay(start, fin.getPreviousPoint());
        }

    }

    public static void search(int currentPoint, int finish) {
        Point current = startCollections.get(currentPoint);
        current.setDistance(0);
        current.setPreviousPoint(0);
        qq.add(current);
        while (!qq.isEmpty()) {
            process(qq.pollFirst());
        }
        getShotWay(currentPoint, finish);
        getDistance(currentPoint, finish);
    }

    public static void process(Point current) {
        checkPoints.add(current);

        Set<Integer> keys = current.getWays().keySet();
            for (Integer i : keys) {
                Point p = startCollections.get(i);
                int newWay = current.getDistance() + current.getWays().get(i);
                if (qq.contains(p)){
                   if (p.getDistance() > newWay){
                       p.setDistance(newWay);
                       p.setPreviousPoint(current.getCaunt_point());
                   }
                }

                if (p.getDistance() == 0 && p.getPreviousPoint() == -1) {
                    p.setDistance(newWay);
                    p.setPreviousPoint(current.getCaunt_point());
                    qq.add(p);

                }
        }

    }

    public static void getData(String fileName) {
        String line;
        try {
            BufferedReader bfr = new BufferedReader(new FileReader("C:\\Users\\a_pan\\Documents\\My_doc\\Prometeus\\9\\" + fileName));
            int a = 0;
            while ((line = bfr.readLine()) != null) {
                if (a == 0) {
                    int points = Integer.parseInt(line.substring(0, line.indexOf(" ")));
                    for (int i = 1; i <= points; i++) {
                        Point n = new Point();
                        n.setCaunt_point(i);
                        startCollections.put(i, n);

                    }
                } else {
                    int cauntPoint = Integer.parseInt(line.substring(0, line.indexOf(" ")));
                    int nextPoint = Integer.parseInt(line.substring(line.indexOf(" ") + 1, line.lastIndexOf(" ")));
                    int distance = Integer.parseInt(line.substring(line.lastIndexOf(" ") + 1));
                    startCollections.get(cauntPoint).getWays().put(nextPoint, distance);
                }
                a++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
