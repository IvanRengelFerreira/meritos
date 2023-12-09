package presentacion;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

import dominio.Articulo;
import dominio.Catedratico;
import dominio.Merito;
import dominio.Profesor;
import dominio.ProfesorTitular;
import dominio.Proyecto;

public class Interfaz {
    
private Scanner sc = new Scanner(System.in);
private ArrayList<Profesor> profesor;

public Interfaz(){
     leer();
}

private void leer(){
    ObjectInputStream obj;
    File file = new File("merito.txt");
        try{
            obj = new ObjectInputStream(new FileInputStream(file));
            try{
                profesor = (ArrayList<Profesor>)obj.readObject();
                obj.close();
            
        } catch(Exception e){
            System.out.println("no leido");
            profesor = new ArrayList<>();
        }
    }catch(Exception e){
          profesor = new ArrayList<>();
    }

}

public void grabar(){
    File f = new File("profesor.txt");
    try{
        ObjectOutputStream obj = new ObjectOutputStream(new FileOutputStream(f));
        obj.writeObject(profesor);
        obj.close();
    
    }catch (Exception e){
        System.out.println("Error al grabar");
    }

}

public Profesor seleccionarProfesor() {

    for (int i = 0; i < profesor.size(); i++) {
   System.out.println((i + 1) + ". " + profesor.get(i));
    }
   System.out.println("Seleccione un profesor (número): ");
   int eleccion = sc.nextInt() - 1;
   sc.nextLine(); 

   if (eleccion >= 0 && eleccion < profesor.size()) {
       return profesor.get(eleccion);
   } else {
       System.out.println("Selección inválida");
       return null;
   }
}

public void anadirProfesor(){

    System.out.println("Introduzca el nombre del profesor titular");
    String nombre = sc.nextLine();

    Profesor p = new ProfesorTitular(nombre);
    profesor.add(p);

}

public void anadirCatedratico(){

    System.out.println("Introduzca el nombre del profesor catedratico");
    String nombre = sc.nextLine();

    Profesor p = new Catedratico(nombre);
    profesor.add(p);
} 

public void anadirMerito(){

    Profesor p = seleccionarProfesor();
    System.out.println("1.Articulo \n2.Proyecto");
    String peticion = sc.nextLine();

    if (peticion.equalsIgnoreCase("1")) {
    System.out.println("Introduzca el titulo del articulo");
    String titulo = sc.nextLine();
    System.out.println("Introduzca el impacto del articulo");
    double impacto = sc.nextDouble();
    sc.nextLine();

    Merito m = new Articulo(titulo, impacto);
    p.annadirMerito(m);

    }else if (peticion.equalsIgnoreCase("2")) {
    System.out.println("Introduzca el titulo del proyecto");
    String titulo = sc.nextLine();
    System.out.println("Introduzca la financiacion del proyecto");
    double financiacion = sc.nextDouble();
    sc.nextLine();

    Merito m = new Proyecto(titulo, financiacion);
    p.annadirMerito(m);
    }
}


/*Esto fue lo que hicmos en clase pero yo ya lo habia hecho de otra forma, asi que solo lo anote
 * public void anadirMerito(){
 * String nombre = sc.nextLine();
 * int n = profesor.indexOf(new ProfesorTitular(nombre));
 * if (n == -1){
 * System.out.println("No existe el profesor");
 * }else{
 * System.out.println("Introduzca el titulo del merito");
 * String titulo = sc.nextLine();
 * System.out.println("Escoja el tipo de merito");
 * System.out.println("1. Articulo");
 * System.out.println("2. Proyecto");
 * int opcion = sc.nextInt();
 * if (opcion == 1){
 *  System.out.println("Introduzca el indice de impacto");
 * double impacto = sc.nextDouble();
 * sc.nextLine();
 * profesor.get(n).annadirMerito(new Articulo(titulo, impacto));
 * }else if (opcion == 2){
 * System.out.println("Introduzca la financiacion del proyecto");
 * double financiacion = sc.nextDouble();
 * sc.nextLine();
 * profesor.get(n).annadirMerito(new Proyecto(titulo, financiacion));
 * 
 * }else{
 *  Syetem.out.println("Opcion no valida");
 * }
 */
    
 public boolean procesarPeticion(String peticion){
    
    if (peticion.equalsIgnoreCase("1")) {
        anadirProfesor();
    }else if (peticion.equalsIgnoreCase("2")) {
        anadirCatedratico();
    }else if (peticion.equalsIgnoreCase("3")) {
        anadirMerito();
    }else if (peticion.equalsIgnoreCase("exit")) {
        grabar();
        return false;
    }else if (peticion.equalsIgnoreCase("list")) {
        mostrarProfesores();
    }else if (peticion.equalsIgnoreCase("help")) {
        System.out.println("Menu\n1.Aañadir Profesor Titular\n2.Añadir Catedratico\n3.Añadir merito\nSalir del programa = exit\nPedir lista de comandos = help\n Listar los profesores con sus meritos = list");
    }else{
        System.out.println("Peticion erronea");
    }
    System.out.println("Introduzca ´help´ para obtener una lista de comandos validos");
    return true;
}

    public void mostrarProfesores(){
        for (Profesor p : profesor){
            System.out.println(p);
        }
    }

    public String leerPeticion() {
        System.out.print("?>");
        String cadena = sc.nextLine();
        return cadena;
    }

}

