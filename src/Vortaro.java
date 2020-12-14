import java.util.HashMap;
import java.util.Map;

public class Vortaro {
    private HashMap<String, String> vortaro;

    public Vortaro() {
        this.vortaro = new HashMap<>();
    }

    public void add(String anglaVorto, String esperantaVorto) {
        this.vortaro.put(anglaVorto, esperantaVorto);
    }

    public String troviVorton(String vorto) {
        for (Map.Entry<String, String> entry: vortaro.entrySet()) {
            if (entry.getKey().equalsIgnoreCase(vorto)) {
                return entry.getValue();
            } else if (entry.getValue().equalsIgnoreCase(vorto)) {
                return entry.getKey();
            }
        }
        return "La vorton ne trovis!";
    }
}
