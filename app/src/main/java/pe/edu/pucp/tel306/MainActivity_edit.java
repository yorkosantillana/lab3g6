package pe.edu.pucp.tel306;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity_edit extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_edit);
    }

    public void obtenerParametros (View view){
        EditText editText_trabajo = findViewById(R.id.editTextNumber_trabajo);
        String trabajo = editText_trabajo.getText().toString();
        if( trabajo.isEmpty()){
            editText_trabajo.setError("Debe ingresar un valor");
        }
        EditText editText_descanso = findViewById(R.id.editTextNumber_descanso);
        String descanso = editText_trabajo.getText().toString();
        if( descanso.isEmpty()){
            editText_trabajo.setError("Debe ingresar un valor");
        }
        EditText editText_ciclo = findViewById(R.id.editTextNumber_ciclo);
        String ciclo = editText_trabajo.getText().toString();
        if( ciclo.isEmpty()){
            editText_trabajo.setError("Debe ingresar un valor");
        }

        if(editText_trabajo.getError()== null && editText_descanso.getError() == null && editText_ciclo.getError() == null){
            Intent intent = new Intent(MainActivity_edit.this,MainActivity.class);
            Integer trabajoInt = Integer.parseInt(trabajo);
            Integer descansoInt = Integer.parseInt(descanso);
            Integer cicloInt = Integer.parseInt(ciclo);
            intent.putExtra("trabajo",trabajoInt);
            intent.putExtra("descanso", descansoInt);
            intent.putExtra("ciclo",cicloInt);
            startActivity(intent);
        }

    }
}