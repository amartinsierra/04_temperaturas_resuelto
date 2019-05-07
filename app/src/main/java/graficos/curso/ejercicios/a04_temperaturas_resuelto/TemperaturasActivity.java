package graficos.curso.ejercicios.a04_temperaturas_resuelto;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.Collection;
import java.util.Map;

import modelo.GestionTemperaturas;

public class TemperaturasActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperaturas);
        mostrarTemperaturas();
    }

    public void mostrarTemperaturas(){
        GestionTemperaturas gt=new GestionTemperaturas(this);
        //crea el adaptador con el array de temperaturas
        ArrayAdapter<Integer> adp=new ArrayAdapter<Integer>(this,android.R.layout.simple_list_item_1,gt.recuperarTemperaturas());
        ((ListView)findViewById(R.id.listaTemp)).setAdapter(adp);
    }
    public void salir(View v){
        this.finish();
    }

}
