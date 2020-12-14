import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Controller {
    private Scanner reader;
    private Vortaro vortaro;

    public Controller(String file) throws FileNotFoundException {
        reader = new Scanner(new FileInputStream(file), "UTF-8");
        vortaro = new Vortaro();
    }

    public void read() throws FileNotFoundException{
        while (reader.hasNextLine()) {
            String linio = reader.nextLine();
            String[] vortaroj = linio.split(",", 2);
            vortaro.add(vortaroj[1].toLowerCase(), vortaroj[0].toLowerCase());
        }
    }

    public BorderPane addComponents() {
        HBox angla = new HBox();
        angla.setPadding(new Insets(10, 10, 10, 10));
        angla.setSpacing(10);

        HBox esperanta = new HBox();
        esperanta.setPadding(new Insets(10, 10, 10, 10));
        esperanta.setSpacing(10);

        BorderPane pane = new BorderPane();

        TextField anglaVorto = new TextField();
        TextField esperantaVorto = new TextField();
        Button translateBtn = new Button("Translate English!");
        Button tradukiBtn = new Button("Translate Esperanto!");
        Label anglaEtikedo = new Label("English Word: ");
        Label esperantaEtikedo = new Label("Esperanta Vorto: ");

        angla.getChildren().addAll(anglaEtikedo, anglaVorto, translateBtn);
        esperanta.getChildren().addAll(esperantaEtikedo, esperantaVorto, tradukiBtn);
        pane.setTop(angla);
        pane.setCenter(esperanta);

        tradukiBtn.setOnAction((event) -> {
            String vorto = vortaro.troviVorton(esperantaVorto.getText());
            esperantaVorto.setText(esperantaVorto.getText());
            anglaVorto.setText(vorto.substring(0, 1).toUpperCase() + vorto.substring(1));
        });

        translateBtn.setOnAction((event) -> {
            String word = vortaro.troviVorton(anglaVorto.getText());
            anglaVorto.setText(anglaVorto.getText());
            esperantaVorto.setText(word.substring(0, 1).toUpperCase() + word.substring(1));
        });
        return pane;
    }
}
