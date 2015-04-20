package cl.dsoft.car.misc;

public class Point {  
    private double latitude;  
    private double longitude;  
  
    private Point() {  
    }  
  
    public Point(double latitude, double longitude) {  
        this.latitude = latitude;  
        this.longitude = longitude;  
    }  
  
    public double getLatitude() {  
        return latitude;  
    }  
  
    public double getLongitude() {  
        return longitude;  
    }  
  
    @Override  
    public String toString() {  
        return latitude+", "+longitude;  
    }  
  
}