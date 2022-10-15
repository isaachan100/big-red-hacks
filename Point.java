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

    public double distanceTo(Point a) {
        final int R = 6371;
        double latDistance = Math.toRadians(a.getLat() - x);
        double lonDistance = Math.toRadians(a.getLon() - y);
        double b = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(x)) * Math.cos(Math.toRadians(a.getLat()))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(b), Math.sqrt(1 - b));
        return R * c * 1000;
    }

    @Override
    public String toString() {
        return "("+x+","+y+")";
    }
}
