package org.dis.back;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class EquipoTest {

    @Test
    void test1Equipo() {

        Equipo equipo = new Equipo(1, "Sobremesa", "HP", "ventas", "12.6", "Windows",
                "i7",16,2400,"SSD", 512,27,
                "1920x1080","Adobe","2.1","Edicion",
                "Gimp","21.3");

        assertEquals(equipo.getCapacidadDiscoDuro(),512);
    }


}