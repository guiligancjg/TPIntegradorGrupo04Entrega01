package TPIntegradorGrupo04Entrega01;

import java.util.ArrayList;
import java.util.List;

public class Partido {
    Equipo equipo1;
    Equipo equipo2;
    int golesEquipo1;
    int golesEquipo2;

    public Partido(){}

    public Partido(Equipo equipo1, Equipo equipo2, int golesEquipo1, int golesEquipo2) {
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
        this.golesEquipo1 = golesEquipo1;
        this.golesEquipo2 = golesEquipo2;
    }

    public ResultadoEnum resultado(int equipo1, int equipo2) {
        switch (Integer.compare(equipo1, equipo2)) {
            case 0:
                return ResultadoEnum.EMPATE;
            case 1:
                return ResultadoEnum.GANADOR;
            default:
                return ResultadoEnum.PERDEDOR;
        }
    }


}
