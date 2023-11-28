package dominio;

import java.util.ArrayList;

public abstract class  Profesor{

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


}
