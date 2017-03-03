import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

/**
 *
 */
public class Car extends Rectangle{

//    private int engine, suspension, boost, weight, playerNum;
//    private boolean isBoosted;
//    private double x, y;
//    private int distanceTraveled;

    /**
     *
     */
    private double time;

    /**
     *
     */
    private ArrayList<Location> stops;

    /**
     *
     */
    private Location start, end, currentLocation;

    /**
     *
     */
    private int id;

    /**
     *
      */
    private ArrayList<Location> gps;

    /**
     *
     */
    private String[] names = { "bug", "blue", "black", "yellow","red"};

    /**
     *
     * @param x
     * @param y
     * @param offset
     * @param start
     * @param end
     * @param id
     * @param gps
     */
    public Car(double x, double y, double offset, Location start, Location end, int id, ArrayList<Location> gps) {
        super(x, y, offset, offset);
        this.setFill(new ImagePattern(new Image("file:"+names[id%names.length] + ".png")));
//        this.setFill(Color.BLUE);
        this.start = start;
        this.end = end;
        this.id = id;
        this.gps = gps;

        gps.get(gps.indexOf(start)).setActive(false);
        gps.get(gps.indexOf(end)).setActive(false);

        stops = new ArrayList<Location>();
        stops.add(start);
    }

    /**
     *
     * @return
     */
    public Location getEnd() { return end; }

    /**
     *
     * @return
     */
    public Location getStart() { return start; }

    /**
     *
     * @return
     */
    public Location getCurrentLocation() { return currentLocation; }

    /**
     *
     * @param location
     * @return
     */
    public boolean getVisited(Location location) { return stops.contains(location); }

    /**
     *
     * @param location
     * @param distanceToAdd
     */
    public void newLocation(Location location, int distanceToAdd) {
        this.setX(location.getX());
        this.setY(location.getY());
        currentLocation = location;
        location.setActive(false);
//        gps.get(gps.indexOf(location)).setActive(false);
        stops.add(location);
    }



}