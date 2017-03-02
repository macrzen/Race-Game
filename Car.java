import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

public class Car extends Rectangle{

    //    private int engine, suspension, boost, weight, playerNum;
//    private boolean isBoosted;

    private double x, y;
    private int distanceTraveled;
    private ArrayList<Location> stops;
    private Location start, end, currentLocation;


    public Car(double x, double y, Location start, Location end) {
        super(x, y, 10, 10);
        this.setFill(Color.BLUE);
        this.start = start;
        this.end = end;
        distanceTraveled = 0;
        stops = new ArrayList<Location>();
        stops.add(start);

    }

    public Location getEnd() { return end; }

    public Location getStart() { return start; }

    public Location getCurrentLocation() { return currentLocation; }

    public boolean getVisited(Location location) { return stops.contains(location); }

    public void newLocation(Location location, int distanceToAdd) {
        currentLocation = location;
        stops.add(location);
        distanceTraveled += distanceToAdd;
    }

}