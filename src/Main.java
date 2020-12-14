import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Esperanta Vortaro // Esperanto Dictionary");

        Controller c = new Controller("src/vortaro.txt");
        c.read();
        Scene scene = new Scene(c.addComponents());
        primaryStage.setScene(scene);

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
