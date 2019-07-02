package senac.turismo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.preference.PreferenceManager;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.prefs.PreferenceChangeEvent;

public class ScrollingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        // comando usado para buscar o nome e mostrar no toobar.
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        String name = sharedPreferences.getString("signature", "Fulano");
        getSupportActionBar().setTitle("Bem vindo: " + name);

        final boolean email = sharedPreferences.getBoolean("sync", false); // usado para mostrar mensagem de email se esta sincronizando - teste local.


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                        Snackbar.make(view, email ? "Email sincronizado" : "Sem sincronismo", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {                                // chamando toda vez que a atividade for chamada
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_scrolling, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {                         //
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.app_bar_search){
            // Se clicar ap pesquisar
            return true;

        }


        if (id == R.id.action_settings) {

            Intent intent = new Intent(this, SettingsActivity.class ); // usado para chamar outra Telinha
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
