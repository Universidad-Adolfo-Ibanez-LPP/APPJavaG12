package com.uai.app.logic;

import com.uai.app.dominio.Libro;
import com.uai.app.dominio.enums.Tittles;
import com.uai.app.ui.utils.AppUtils;
import org.apache.commons.text.CaseUtils;
import org.apache.commons.text.similarity.LevenshteinDistance;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class SearchManager {

    //lo que me servira para medir las distancias entre dos strings
    private static LevenshteinDistance lv = new LevenshteinDistance();

    private static SearchManager instance;

    //todos los singletons
    // tienen constructores privados
    private SearchManager(){

    }

    public static SearchManager getInstance(){
        if (instance == null){
            instance = new SearchManager();
        }
        return instance;
    }

    /*
    * Esto usa la distancia de leven*
     */
    public HashSet<Libro> buscarlibroportitulo(Tittles title, String theSearch){
        //ahora instancio un mapa con esas claves
        HashSet<Libro> data = DataManager.getInstance().getData();;
        HashSet<Libro> libros = new HashSet<Libro>();
        for (Libro p : data){
            //Uso lo mismo que en el data manager
            Class<?> classObj = p.getClass();
            Method printMessage = null;
            try {
                String camelCase = CaseUtils.toCamelCase(title.getVal(), true);
                printMessage = classObj.getDeclaredMethod("get"+camelCase);
                String filterName = String.valueOf(printMessage.invoke(p));

                // si es un numero entonces no uso distancia de leventeihns
                if (printMessage.getReturnType().isPrimitive() ||
                        printMessage.getReturnType().isAssignableFrom(Integer.class)){
                    if (theSearch.trim().equalsIgnoreCase(filterName)){
                        libros.add(p);
                    }
                } else {
                    //Con una distancia de 3 estamos bien cubiertos
                    if (lv.apply(theSearch, filterName) < 4){
                        libros.add(p);
                    }
                }


            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }

        }
        return libros;
    }
    public Map<String, Set<Libro>> getPeopleByColum(Tittles columName){
        //ahora instancio un mapa con esas claves
        Map<String, Set<Libro>> resultados = new HashMap<>();
        HashSet<Libro> data = DataManager.getInstance().getData();;
        for (Libro p : data){
            //primero debo saber que atributo
            // es para saber a que get llamare
            // esto se denomina llamar
            // a metodos por reflexion
            Class<?> classObj = p.getClass();
            Method printMessage = null;
            try {
                String camelCase = CaseUtils.toCamelCase(columName.getVal(), true);
                printMessage = classObj.getDeclaredMethod("get"+camelCase);
                String filterName = String.valueOf(printMessage.invoke(p));
                Set<Libro> ciudadanos = resultados.get(filterName);
                //Significa que debo crear si es true
                if (AppUtils.isNull(ciudadanos)){
                    //uso un set para evitar repetidos
                    ciudadanos = new HashSet<Libro>();
                }
                ciudadanos.add(p);
                resultados.put(filterName, ciudadanos);

            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }

        }
        return resultados;
    }
}
