package cl.dsoft.car.misc;

import java.util.List;
import java.util.TreeMap;

public class CarUtil {

	public CarUtil() {
		// TODO Auto-generated constructor stub
	}

	/** 
     * A TreeMap as, key: distante from origin to a given point in the list, value: the point 
     * 
     * The following example shows points in order: 
     * 
     * TreeMap<double, point=""> treeMap = FrameworkUtil.sortPoints(origin, points); 
     * 
     *   for (Map.Entry<double, point=""> entry : treeMap.entrySet()) { 
     *       Double key = entry.getKey(); 
     *       Point value = entry.getValue(); 
     *       System.out.println(key + " => " + value); 
     *   } 
     * 
     * @param origin 
     * @param points 
     * @return 
     */  
    public static TreeMap<Double, Point> sortPoints(Point origin, List<Point> points) {  
        //key: distance to origin, value: point to compare  
        TreeMap<Double, Point> treeMap = new TreeMap<Double, Point>();  
        /* 
         * Calculate distances and store them in a tree map. Tree map stores 
         * keys in natural order, so later I will be able to iterate It in order 
         */  
        for (Point point1 : points) {  
            double distance = CarUtil.distFrom(origin.getLatitude(), origin.getLongitude(), point1.getLatitude(), point1.getLongitude());  
            treeMap.put(distance, point1);  
        }  
  
        return treeMap;  
    }
    
    /** 
     * Distance in kilometers between two geo points. 
     * 
     * Example: 
     * 
     * double lat1 = -34.87001758635342; 
     * double lon1 = -56.16755962371826; 
     * double lat2 = -34.88487484011935; 
     * double lon2 = -56.1661434173584; 
     * 
     * double distance = distFrom(lat1, lon1, lat2, lon2); 
     * 
     * @param lat1 
     * @param lng1 
     * @param lat2 
     * @param lng2 
     * @return 
     */  
    public static double distFrom(double lat1, double lng1, double lat2, double lng2) {  
        //double earthRadius = 3958.75;//miles  
        double earthRadius = 6371;//kilometers  
        double dLat = Math.toRadians(lat2 - lat1);  
        double dLng = Math.toRadians(lng2 - lng1);  
        double sindLat = Math.sin(dLat / 2);  
        double sindLng = Math.sin(dLng / 2);  
        double a = Math.pow(sindLat, 2) + Math.pow(sindLng, 2)  
                * Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2));  
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));  
        double dist = earthRadius * c;  
  
        return dist;  
    }
}
