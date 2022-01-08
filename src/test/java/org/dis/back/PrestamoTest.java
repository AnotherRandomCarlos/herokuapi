package org.dis.back;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PrestamoTest {

    @Test
    void test1Prestamo() {

        Prestamo prestamo = new Prestamo(1, 17, 15, "15-05-2021", "15-06-2021",
                "15-07-2021","Nada");

        assertEquals(prestamo.getEquipoID(),15);
    }

    @Test
    void test2Prestamo(){
        Prestamo prestamo = new Prestamo(1, 17, 15, "15-05-2021", "15-06-2021",
                "15-07-2021","Nada");
        Prestamo prestamo2 = new Prestamo(2, 19, 20, "20-05-2021", "27-06-2021",
                "28-07-2021","Nada");

        prestamo.modificarPrestamo(prestamo2);

        assertEquals(prestamo.getFechaFin(),"27-06-2021");
    }

}
