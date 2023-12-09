package dominio;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class Profesor implements Serializable{

    protected String nombre;
    protected ArrayList<Merito> meritos;

    public Profesor(String nombre) {
        meritos = new ArrayList<Merito>();
        this.nombre = nombre;
    }

    public abstract double calcularValoracion();

    public Profesor annadirMerito(Merito m) {
        meritos.add(m);
        return this;
    }

    public Merito getMerito(int i){
        return meritos.get(i);
    }

    public int size(){
        return meritos.size();
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
         this.nombre = nombre;
    }

    public boolean equals(Object o){
        Profesor p = (Profesor) o;
        return nombre.equals(p.nombre);
    }

    public void mostrarMeritos(){
        for (Merito m : meritos) {
            System.out.println(m);
        }
    }

    public String toString(){
        String m = meritos.toString();
        return "Profesor: "+nombre+"\nMeritos:"+m+"\n";
    }

}
