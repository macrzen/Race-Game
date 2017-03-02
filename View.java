import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.util.ArrayList;

public class View extends Application {

    public Scene scene;
    public static void main(String[] args) { launch(args); }
    public Track track;

    @Override
    public void start(final Stage stage) throws Exception {
        track = new Track();
        StartPrompt t = new StartPrompt();
        Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
        scene = new Scene(t, primaryScreenBounds.getWidth(), primaryScreenBounds.getHeight(), Color.GHOSTWHITE);
        stage.setScene(scene);
        stage.sizeToScene();
        stage.show();
    }

    public class StartPrompt extends BorderPane {

        private GridPane gp;
        private ComboBox<Integer> comboBox;
        private Text title;
        private Button button;

        public StartPrompt() {
            title = addTitle();
            comboBox = addComboBox();
            button = addStartButton();
            gp = addGridPane();
            this.setTop(new StackPane(title));
            this.getTop().setTranslateY(100);
            this.setCenter(gp);
            this.setBottom(new StackPane(button));
            this.getBottom().setTranslateY(-100);
            this.setStyle("-fx-background-color: #2c2c2c;");
        }

        private GridPane addGridPane() {
            GridPane gp = new GridPane();
            gp.setAlignment(Pos.CENTER);
            gp.add(addLabel(), 0, 0);
            gp.add(comboBox, 1, 0);
            return gp;
        }

        private Text addTitle() {
            Text text = new Text("Car Race");
            text.setFill(Color.DARKBLUE);
            text.setFont(Font.font(100));
            return text;
        }

        private Label addLabel() {
            Label players = new Label("Number of Players\t");
            players.setStyle("-fx-text-fill: #fff");
            return players;
        }

        private ComboBox<Integer> addComboBox() {
            ComboBox<Integer> comboBox = new ComboBox<Integer>();
            comboBox.getItems().addAll(2, 3, 4, 5, 30);
            comboBox.setEditable(false);
            comboBox.setValue(2);
            comboBox.setStyle("-fx-text-fill: #111111; -fx-border-color: #fff;");
//        comboBox.valueProperty().addListener((observableValue, integer, t1) -> {System.out.println(integer + " " + t1);});
            return comboBox;
        }

        private Button addStartButton() {
            Button button = new Button("Start");
            button.setStyle("-fx-background-color: black; -fx-text-fill: #fff");
            button.setOnMouseClicked(event);
            return button;
        }

        private EventHandler<MouseEvent> event = mouseEvent -> {
            comboBox.setDisable(true);
            button.setDisable(true);
            int i = comboBox.getValue() != null ? comboBox.getValue() : 2;
            System.out.println(i);
            track.setTrack(i, scene.getWidth(), scene.getHeight());
            scene.setRoot(track);
        };
    }
}

