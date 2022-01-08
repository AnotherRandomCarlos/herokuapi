package org.dis.back;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import org.springframework.core.io.ClassPathResource;


import java.io.*;


import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;


/*Indicamos que es un controlador de tipo rest*/
@RestController
public class ControladorUsuario {


    /*Hacemos que aunque nos pasen un id incorrecto, nosotros iremos poniendo ids incrementales*/
    private final AtomicInteger nextId = new AtomicInteger();


    /*Funcion para actualizar el id*/
    @GetMapping("/actualizarId")
    public void InicializarContadorId() throws IOException {


        /*------------Primera parte, obtener la lista de usuarios leyendo el json existente-----------*/

        ArrayList<Usuario> lista = obtenerListaUsuarios();

        if(lista.size()!=0){
            int idMaximo=0;

            for (Usuario user : lista) {
                if(user.getId()>idMaximo){
                    idMaximo = user.getId();
                }
            }

            nextId.set(idMaximo+1);
        }
        else{
            nextId.set(0);
        }


    }



    /*Funcion para obtener el listado de usuarios*/

    @GetMapping("/obtenerUsuarios")
    public ArrayList<Usuario> obtenerUsuarios() throws IOException {

        ArrayList<Usuario> lista = obtenerListaUsuarios();
        /*Devolvemos la lista*/
        return lista;
    }


    /*Funcion para aniadir usuario*/
    @PostMapping(path = "/nuevoUsuario",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity aniadirUsuario (@RequestBody Usuario nuevoUsuario) throws IOException {

        /*------------Primera parte, obtener la lista de usuarios leyendo el json existente-----------*/

        ArrayList<Usuario> lista = obtenerListaUsuarios();

        /* -------- Segunda parte, aniadir el usuario nuevo ---------------*/

        nuevoUsuario.setId(nextId.getAndIncrement());
        lista.add(nuevoUsuario);

        modificarJson(lista);

        return new ResponseEntity(HttpStatus.CREATED);
    }

    /*Funcion para modificar usuario*/
    @PutMapping(path = "/modificarUsuario",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity modificarUsuario (@RequestBody Usuario usuarioModificado) throws IOException {


        /*------------Primera parte, obtener la lista de usuarios leyendo el json existente-----------*/

        ArrayList<Usuario> lista = obtenerListaUsuarios();


        /*Ahora buscamos el usuario a modificar y cambiamos sus atributos */

        int id = usuarioModificado.getId();

        for (Usuario user : lista) {
            if(user.getId()==id){
                user.modificarUsuario(usuarioModificado);
            }
        }

        /*Mandamos rehacer el json*/

        modificarJson(lista);

        return new ResponseEntity(HttpStatus.ACCEPTED);
    }

    /*Funcion para eliminar usuario*/
    @DeleteMapping(path = "/eliminarUsuario/{id}")
    public ResponseEntity eliminarUsuario (@PathVariable int id) throws IOException {

        /*------------Primera parte, obtener la lista de usuarios leyendo el json existente-----------*/

        ArrayList<Usuario> lista = obtenerListaUsuarios();

        /*Eliminamos el usuario cuyo id nos han mandado*/

        lista.removeIf(usuario -> usuario.getId()==id);
        //lista.remove(id);

        /*Mandamos rehacer el json*/

        modificarJson(lista);


        return new ResponseEntity(HttpStatus.ACCEPTED);
    }


    private ArrayList<Usuario> obtenerListaUsuarios() throws IOException {

        /*------------Primera parte, obtener la lista de usuarios leyendo el json existente-----------*/

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        ArrayList<Usuario> lista;
        Type userListType = new TypeToken<ArrayList<Usuario>>(){}.getType();
        FileReader fichero = null;
        try {
            fichero = new FileReader("Usuarios.json");
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

    private void modificarJson (ArrayList<Usuario> listaNueva) {

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        FileWriter fichero = null;
        String nuevoFichero = null;
        try {
            fichero = new FileWriter("Usuarios.json");
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
