package aplicacion;

import dominio.Articulo;
import dominio.Catedratico;
import dominio.ProfesorTitular;
import dominio.Proyecto;

public class Principal {
    public static void main(String[] args) {
        //El primer parámetro del constructor es el título y, el
        //segundo, el índice de impacto.
        Articulo articulo1 = new Articulo("El gran invento", 1.367);
        Articulo articulo2 = new Articulo("Lo nunca visto", 2.765);
        Articulo articulo3 = new Articulo("Pasen y vean", 1.987);
        Articulo articulo4 = new Articulo("El no va más del " +"qué se yo", 2.134);
    

        
        //El primer parámetro del constructor es el título y, el
        //segundo, la financiación con la que ha contado el
        //proyecto.
        Proyecto proyecto1 = new Proyecto("El puente de Villar del Río", 1000000);
        Proyecto proyecto2 = new Proyecto("El acueducto de Villar del Campo", 2000000);
        Proyecto proyecto3 = new Proyecto("El sistema de información de Villar del Río", 1200000);

        ProfesorTitular pt1 = new ProfesorTitular("Juan Manuel");

        // Add published articles to the professor
        pt1.annadirMerito(articulo1);
        pt1.annadirMerito(articulo2);

        // Add the project the professor has participated in
        pt1.annadirMerito(proyecto1);

        // Proceed with the professor in the same way as with the titular professor
        Catedratico ct1 = new Catedratico("José Antonio");
        ct1.annadirMerito(articulo3);
        ct1.annadirMerito(articulo4);
        ct1.annadirMerito(proyecto2);
        ct1.annadirMerito(proyecto3);

        // Display the rating of both the titular professor and the professor
        System.out.println("La valoración de profesor titular pt1 es " + pt1.calcularValoracion());
        System.out.println("La valoración del catedrático ct1 es " + ct1.calcularValoracion());
            
            
            }
}

