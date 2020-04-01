package application;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class Application extends javafx.application.Application {

    @Override
    public void start(Stage stage) throws Exception {
        VBox root = new VBox();
        stage.setScene(new Scene(root, 600, 400));

        //Menu
        MenuItem openFile = new MenuItem("Open...");
        openFile.setOnAction(actionEvent -> {
            FileChooser chooser = new FileChooser();
            File file1 = chooser.showOpenDialog(stage);
        });
        Menu fileMenu = new Menu("File", null, openFile);
        MenuBar bar = new MenuBar(fileMenu);


        //Content
        Label game = new Label("test\n....\n----\n||||");
        game.setStyle("-fx-font-family: 'monospaced';");

        root.getChildren().addAll(game);

        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
