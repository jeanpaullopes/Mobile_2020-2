package br.edu.uniritter.mobile.minhaprimeiraapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
//É preciso criar uma classe Static especializando RecyclerViewHolder para ser usada pelo Adapter
public class MeuAdapter extends RecyclerView.Adapter<MeuAdapter.MeuViewHolder> {

    //criamos um atributo para ser a coleção de dados do Adapter
    private String[] dataset;



    public static class MeuViewHolder extends RecyclerView.ViewHolder {
        // os dados do Exemplo serão simples String e serão colocadas em um TextView
        public View fragmento;
        public MeuViewHolder(View v) {
            super(v);
            fragmento = v;
        }
    }


    // Construtor do Adapter, com a entrada do dataset (sempre adequado ao que ele vai manipular
    public MeuAdapter(String[] dados) {
        dataset = dados;
    }

    // Agora implementa-se os métodos abstratos da classe RecyclerView

    @NonNull
    @Override
    //este cria as novas view
    public MeuAdapter.MeuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // create a new view
        View v = (View) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_recycler, parent, false);

        MeuViewHolder vh = new MeuViewHolder(v);
        return vh;
    }

    @Override
    // altera o conteúdo das view apresentadas
    public void onBindViewHolder(@NonNull MeuViewHolder holder, int position) {
        // - obtem o elemento do dataset de acordo com a sua posição (paramentro position)
        // - e atualiza o conteúdo do da view com o elemento ou seus valores
        TextView tv = holder.fragmento.findViewById(R.id.textViewFragmento);
        tv.setText(dataset[position]);
    }

    @Override
    // Este é fácil de entender, retorna a quantidade de elementos do dataset
    public int getItemCount() {
        return dataset.length;
    }

}
