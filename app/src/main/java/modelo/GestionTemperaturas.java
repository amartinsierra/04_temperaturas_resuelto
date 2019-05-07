package modelo;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Map;



/**
 * Created by antonio on 20/09/2017.
 */

public class GestionTemperaturas {
    Context ctx;

    public GestionTemperaturas(Context ctx) {
        this.ctx = ctx;
    }

    public void guardarTemperatura(String mes, int temp){
        SharedPreferences sp=ctx.getSharedPreferences("temperaturas", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sp.edit();


        editor.putInt(mes, temp);
        editor.commit();
    }
    public ArrayList<Integer> recuperarTemperaturas(){
        SharedPreferences sp=ctx.getSharedPreferences("temperaturas",Context.MODE_PRIVATE);
        Map<String, ?> todas=sp.getAll();
        ArrayList<Integer> temps=new ArrayList<>();
        //extrae los valores de temperaturas
        // como un objeto Collection
        //y lo convierte en arraylist de enteros
        Collection<?> valores=todas.values();
        for(Object n:valores){
            temps.add((Integer)n);
        }
        /*
        //convierte en un array de Integer
        return valores.toArray(new Integer[0]);
         */

        temps.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return a-b;
            }
        });
        return temps;
    }
}
