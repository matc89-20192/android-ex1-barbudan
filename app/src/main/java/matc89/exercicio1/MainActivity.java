package matc89.exercicio1;

import android.content.SharedPreferences;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText) findViewById(R.id.editNome);
        textView = (TextView) findViewById(R.id.labelMensagem);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);

        outState.putString("texto",textView.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);

        textView.setText(savedInstanceState.getString("texto"));
    }

    public void cumprimentar(View v){
        /*textView.setText(String.format("%s%s%s",
                                                getResources().getString(R.string.alo),
                                                editText.getText().toString(),
                                                getResources().getString(R.string.exclamacao)));
        */
        textView.setText("Alô, "+editText.getText().toString()+"!");
    }


}
