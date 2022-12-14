import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import javafx.scene.input.KeyCode;

import java.util.ArrayList;

public class bombCreate {
    public ArrayList<KeyCode> bomby = new ArrayList<>();

    public ArrayList<KeyCode> getBomby() {
        return bomby;
    }

    public void setBomby(ArrayList<KeyCode> bomby) {
        this.bomby = bomby;
    }

    public bombCreate() {
        setBombs();
    }

    void setBombs(){
        int howManyBombs = 3;
        KeyCode[] klawiszeWGrze = {KeyCode.A, KeyCode.B, KeyCode.C, KeyCode.D, KeyCode.E, KeyCode.F, KeyCode.G, KeyCode.H, KeyCode.I, KeyCode.J, KeyCode.K, KeyCode.L, KeyCode.M, KeyCode.N, KeyCode.O, KeyCode.P, KeyCode.Q, KeyCode.R, KeyCode.S, KeyCode.T, KeyCode.U, KeyCode.V, KeyCode.W, KeyCode.X, KeyCode.Y, KeyCode.Z};
        for (int i = 0; i <= howManyBombs; i++){
            bomby.add(klawiszeWGrze[0 + (int)(Math.random() * ((25 - 0) + 1))]);
        }
    }
}
