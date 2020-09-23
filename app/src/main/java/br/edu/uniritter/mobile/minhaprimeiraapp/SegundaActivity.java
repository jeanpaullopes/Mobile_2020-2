package br.edu.uniritter.mobile.minhaprimeiraapp;

import android.annotation.SuppressLint;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class SegundaActivity extends AppCompatActivity {


    // criando os objetos para manipular em código o RecyclerView,
    // seu Adapter e se LeyoutManager
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;


    /**
     * Whether or not the system UI should be auto-hidden after
     * {@link #AUTO_HIDE_DELAY_MILLIS} milliseconds.
     */
    private static final boolean AUTO_HIDE = true;

    /**
     * If {@link #AUTO_HIDE} is set, the number of milliseconds to wait after
     * user interaction before hiding the system UI.
     */
    private static final int AUTO_HIDE_DELAY_MILLIS = 3000;

    /**
     * Some older devices needs a small delay between UI widget updates
     * and a change of the status and navigation bar.
     */
    private static final int UI_ANIMATION_DELAY = 300;
    private final Handler mHideHandler = new Handler();
    private View mContentView;
    private final Runnable mHidePart2Runnable = new Runnable() {
        @SuppressLint("InlinedApi")
        @Override
        public void run() {
            // Delayed removal of status and navigation bar

            // Note that some of these constants are new as of API 16 (Jelly Bean)
            // and API 19 (KitKat). It is safe to use them, as they are inlined
            // at compile-time and do nothing on earlier devices.
            mContentView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE
                    | View.SYSTEM_UI_FLAG_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        }
    };
    private View mControlsView;
    private final Runnable mShowPart2Runnable = new Runnable() {
        @Override
        public void run() {
            // Delayed display of UI elements
            ActionBar actionBar = getSupportActionBar();
            if (actionBar != null) {
                actionBar.show();
            }
            mControlsView.setVisibility(View.VISIBLE);
        }
    };
    private boolean mVisible;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_segunda);



        //ligando o objeto de manipulação ao RecyclerView do layout (XML)
        // No meu caso como substitui o layout raiz da activity por um RecyclerView, precisei
        // forçar um id no XML, inserindo 'android:id="@+id/recyclerPrincipal"' como atributo da tag raiz
        recyclerView = (RecyclerView) findViewById(R.id.recyclerPrincipal);


        // É possível usar esta configuração para melhor performance caso se saiba que a mudança no conteúdo
        // não alterará o tamanho do layout do RecyclerView
        //recyclerView.setHasFixedSize(true);

        // usar um linear layout manager
        // aqui estamos inserindo um layout em tempo de execução, ao invés de usar a ferramenta de design
        // isto te traz ideias? - tem que fazer o import do LinearLayout
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // Especifica qual o Adapter que o RecyclerView vai usar
        // como "tudo não são flores", veja que este Adapter é uma classe MeuAdapter, então vamos te que construí-la
        String[] dados = {"abc","def","ghi"};
        mAdapter = new MeuAdapter(dados);
        recyclerView.setAdapter(mAdapter);

        mVisible = true;



    }

}