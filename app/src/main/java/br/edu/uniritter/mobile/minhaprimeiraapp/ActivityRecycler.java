package br.edu.uniritter.mobile.minhaprimeiraapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class ActivityRecycler extends AppCompatActivity {

    // criando os objetos para manipular em código o RecyclerView,
    // seu Adapter e se LeyoutManager
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

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
    }
}