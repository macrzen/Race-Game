import javafx.geometry.BoundingBox;
import javafx.scene.Group;

import java.util.ArrayList;
import java.util.Random;

public class Track extends Group {

    private ArrayList<Location> locations;
    private ArrayList<Car> cars;

    public Track(ArrayList<Location> locations, ArrayList<Car> cars) {
        this.locations = locations;
        this.cars = cars;
        for(Location location : locations) this.getChildren().add(location);
        for(Car car : cars) this.getChildren().add(car);
   }

    public Track() {
        locations = new ArrayList<>();
        cars = new ArrayList<>();
    }

    public void setTrack(int i, double sceneX, double sceneY) {
        ArrayList<Location> locations = new ArrayList<>();
        ArrayList<Car> cars = new ArrayList<>();
        Random rand = new Random();
        int numLocation = (i & 1) == 1 ? i + 3 : i + 4;
        double offset = 20;

        for (int k = 0; k < numLocation; k++) {
            double x = rand.nextInt((int)sceneX-((int)offset*2));
            double y = rand.nextInt((int)sceneY-((int)offset*2));
            for (Location lo : locations) {
                if (lo.intersects(new BoundingBox(x, y, offset * 2, offset * 2))) {
                    x = rand.nextInt((int)sceneX-((int)offset*2));
                    y = rand.nextInt((int)sceneY-((int)offset*2));
                }
            }
            locations.add(new Location(x, y, offset, "Location " + k));
        }

        ArrayList<Integer> forStart = new ArrayList<>();
        ArrayList<Integer> forEnd = new ArrayList<>();

        for (int j = 0; j < i; j++) {
            int start = rand.nextInt(locations.size());
            int end = rand.nextInt(locations.size());
            while (forStart.contains(start)) start = rand.nextInt(locations.size());
            while (forEnd.contains(end)) end = rand.nextInt(locations.size());
            forStart.add(start);
            forEnd.add(end);
            Location s = locations.get(start);
            Location e = locations.get(end);
            cars.add(new Car(s.getX(), s.getY(), s, e));
        }
//        track = new Track(locations, cars);
//        View.scene.setRoot(track);
        for(Location location : locations) this.getChildren().add(location);
        for(Car car : cars) this.getChildren().add(car);
    }



}