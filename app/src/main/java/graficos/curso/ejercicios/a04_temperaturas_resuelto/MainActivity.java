package graficos.curso.ejercicios.a04_temperaturas_resuelto;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import modelo.GestionTemperaturas;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void registrarTemp(View v){
        GestionTemperaturas gt=new GestionTemperaturas(this);
        String mes=((EditText)findViewById(R.id.txtmes)).getText().toString();
        int temp=Integer.parseInt(((EditText)findViewById(R.id.txttemp)).getText().toString());
        gt.guardarTemperatura(mes,temp);
    }
    public void mostrarTemp(View v){
        Intent intent=new Intent(this,TemperaturasActivity.class);
        this.startActivity(intent);
    }

}
