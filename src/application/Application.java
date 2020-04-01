package application;

import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class Application extends javafx.application.Application {
    public Label game = new Label("ajsdlöfjöalsdjflöaj");

    @Override
    public void start(Stage stage) throws Exception {
        game.setStyle("-fx-font-family: 'monospaced';");
        setup(stage);
    }

    private void setup(Stage stage) {
        VBox root = new VBox();
        root.getChildren().add(game);
    }

    private void menu(VBox root, Stage stage) {
        MenuBar bar = new MenuBar();
        Menu file = new Menu("File");
        MenuItem openFile = new MenuItem("Open...");
        openFile.setOnAction(actionEvent -> {
            FileChooser chooser = new FileChooser();
            File file1 = chooser.showOpenDialog(stage);
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}
