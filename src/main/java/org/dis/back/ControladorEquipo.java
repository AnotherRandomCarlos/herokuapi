package org.dis.back;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;


/*Indicamos que es un controlador de tipo rest*/
@RestController
public class ControladorEquipo {



    /*Funcion para obtener el listado de equipos*/

    @GetMapping("/obtenerEquipos")
    public ArrayList<Equipo> obtenerEquipos(){
        /*------------Primera parte, obtener la lista de equipos leyendo el json existente-----------*/

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        ArrayList<Equipo> lista;
        Type equipoListType = new TypeToken<ArrayList<Equipo>>(){}.getType();
        FileReader fichero = null;
        try {
            fichero = new FileReader("Equipos.json");
        } catch (IOException e) {
            e.printStackTrace();
        }

        lista = gson.fromJson(fichero, equipoListType);

        try {
            fichero.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return lista;
    }



}
