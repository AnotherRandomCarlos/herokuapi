package org.dis.back;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class UsuarioTest {

    @Test
    void test1Usuario() {

        Usuario usuario = new Usuario(1, "Juan", "ventas", "616909090", "correo@prueba.com", "madrid");

        assertEquals(usuario.getCorreo(),"correo@prueba.com");
    }

    @Test
    void test2Usuario(){
        Usuario usuario = new Usuario(1, "Juan", "ventas", "616909090", "correo@prueba.com", "madrid");
        Usuario usuario2 = new Usuario(1, "Carlos", "ventas", "616909090", "correo@prueba.com", "madrid");

        usuario.modificarUsuario(usuario2);

        assertEquals(usuario.getNombre(),"Carlos");
    }

}
