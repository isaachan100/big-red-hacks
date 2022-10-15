import java.util.Comparator;

public class Point{
    private double x;
    private double y;

    public Point(double lat, double lon){
        x = lat;
        y = lon;
    }

    public double getLat(){
        return x;
    }

    public double getLon(){
        return y;
    }

    public int compareTo(Point a) {
        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        return false;
    }
}
