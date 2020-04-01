package application;

import javafx.animation.AnimationTimer;
import javafx.event.EventType;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import map.Map;
import renderer.Agent;

import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

public class Application extends javafx.application.Application {
    private AnimationTimer timer;
    private Label game;


    @Override
    public void start(Stage stage) throws Exception {
        System.out.println((char)217);
        VBox root = new VBox();
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        root.getStylesheets().add(getClass().getResource("./style/style.css").toExternalForm());

        //Content
        game = new Label("");
        game.setId("game");

        stage.show();

        //Menu
        MenuItem openFile = new MenuItem("Open...");
        openFile.setOnAction(actionEvent -> {
            FileChooser chooser = new FileChooser();
            File file1 = chooser.showOpenDialog(stage);
            //startGame(file1);
        });
        Menu fileMenu = new Menu("File", null, openFile);
        MenuBar bar = new MenuBar(fileMenu);


        root.getChildren().addAll(bar, game);
        startGame(new File("test.txt"), stage);

    }

    public void startGame (File f, Stage stage) {

        try {
            final Agent agent = new Agent(2, 2, 0, Map.parse(f.getAbsolutePath()));
            stage.getScene().setOnKeyPressed(agent::keyPressed);
            stage.getScene().setOnKeyReleased(agent::keyReleased);
            timer = new AnimationTimer() {
                @Override
                public void handle(long l) {
                    game.setText(agent.getRender(Math.PI * 0.5, 50, 100));
                    stage.sizeToScene();
                }
            };
            timer.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}
