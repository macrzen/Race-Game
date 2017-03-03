import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
//import java.util.Map;

public class Location extends Rectangle{

    /**
     *
     */
    private String name;

    /**
     *
     */
    private ArrayList<Car> cars;

    /**
     *
     */
    private boolean clicked, active;
//    private Map<Location, Integer> neighbors;

    /**
     *
     * @param x
     * @param y
     * @param offset
     * @param name
     */
    public Location(double x, double y, double offset, String name) { //, Map<Location, Integer> neighbors) {
        super(x, y,offset,offset);
        this.name = name;
//        this.setFill(Color.DARKORANGE);
        this.setFill(new ImagePattern(new Image("file:loader2.gif")));
//        this.neighbors = neighbors;

        clicked = false;
        active = true;
        cars = new ArrayList<>();
    }

    /**
     *
     * @return
     */
    public String getName() { return name; }

    /**
     *
     * @param car
     */
    public void addCar(Car car) {
        cars.add(car);
    }

    /**
     *
     * @return
     */
    public boolean isActive() { return active; }

    /**
     *
     * @return
     */
    public boolean getClicked() { return clicked; }

    /**
     *
     * @param in
     */
    public void setClicked(boolean in) { clicked = in; }

    /**
     *
     * @param in
     */
    public void setActive(boolean in) { active = in; }

//    public int getDistanceToLocation(Location location) {
//        return neighbors.get(location);
//    }
}