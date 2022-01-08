package org.dis.back;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;


/*Indicamos que es un controlador de tipo rest*/
@RestController
public class ControladorPrestamo {


    /*Hacemos que aunque nos pasen un id incorrecto, nosotros iremos poniendo ids incrementales*/
    private final AtomicInteger nextId = new AtomicInteger();

    /*Funcion para obtener el listado de equipos*/

    @GetMapping("/obtenerPrestamos")
    public ArrayList<Prestamo> obtenerPrestamos(){
        /*------------Primera parte, obtener la lista de usuarios leyendo el json existente-----------*/

        ArrayList<Prestamo> lista = obtenerListaPrestamos();

        return lista;
    }

    /*Funcion para aniadir prestamos*/
    @PostMapping(path = "/nuevoPrestamo",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity aniadirPrestamos (@RequestBody Prestamo nuevoPrestamo){

        /*------------Primera parte, obtener la lista de usuarios leyendo el json existente-----------*/

        ArrayList<Prestamo> lista = obtenerListaPrestamos();

        nuevoPrestamo.setId(nextId.getAndIncrement());

        lista.add(nuevoPrestamo);

        /*Mandamos rehacer el json*/

        modificarJson(lista);

        return new ResponseEntity(HttpStatus.ACCEPTED);
    }

    /*Funcion para modificar prestamos*/
    @PutMapping(path = "/modificarPrestamo",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity modificarPrestamo (@RequestBody Prestamo prestamoModificado){

        /*------------Primera parte, obtener la lista de usuarios leyendo el json existente-----------*/

        ArrayList<Prestamo> lista = obtenerListaPrestamos();


        /*Ahora buscamos el usuario a modificar y cambiamos sus atributos */

        int id = prestamoModificado.getId();

        for (Prestamo prestamo : lista) {
            if(prestamo.getId()==id){
                prestamo.modificarPrestamo(prestamoModificado);
            }
        }

        /*Mandamos rehacer el json*/

        modificarJson(lista);


        return new ResponseEntity(HttpStatus.ACCEPTED);
    }

    private ArrayList<Prestamo> obtenerListaPrestamos(){

        /*------------Primera parte, obtener la lista de prestamos leyendo el json existente-----------*/

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        ArrayList<Prestamo> lista;
        Type userListType = new TypeToken<ArrayList<Prestamo>>(){}.getType();
        FileReader fichero = null;
        try {
            fichero = new FileReader("Prestamos.json");
        } catch (IOException e) {
            e.printStackTrace();
        }

        lista = gson.fromJson(fichero, userListType);

        try {
            fichero.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return lista;

    }

    private void modificarJson (ArrayList<Prestamo> listaNueva){

        Gson gson = new GsonBuilder().setPrettyPrinting().create();;
        FileWriter fichero = null;
        try {
            fichero = new FileWriter("Prestamos.json");
        } catch (IOException e) {
            e.printStackTrace();
        }

        gson.toJson(listaNueva, fichero);



        try {
            fichero.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
