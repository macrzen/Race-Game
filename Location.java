import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
//import java.util.Map;

public class Location extends Rectangle{

    private String name;

    private ArrayList<Car> cars;

//    private Map<Location, Integer> neighbors;

    public Location(double x, double y, double offset, String name) { //, Map<Location, Integer> neighbors) {
        super(x, y,offset,offset);
        this.name = name;
        this.setFill(Color.DARKORANGE);
//        this.neighbors = neighbors;
        cars = new ArrayList<>();
    }

    public String getName() { return name; }

    public void addCar(Car car) {
        cars.add(car);
    }

//    public int getDistanceToLocation(Location location) {
//        return neighbors.get(location);
//    }
}