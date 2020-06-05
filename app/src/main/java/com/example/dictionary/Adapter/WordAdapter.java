package com.example.dictionary.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dictionary.R;
import com.example.dictionary.Word;

import java.util.ArrayList;

import static com.example.dictionary.R.layout.item;

public class WordAdapter extends RecyclerView.Adapter<WordAdapter.ViewHolder> {
    private ArrayList<Word> myWord;
    OnWordListener globalListener;


    public WordAdapter(ArrayList<Word> w, OnWordListener onWordListener){
        myWord = w;
        globalListener = onWordListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();

        LayoutInflater inflater = LayoutInflater.from(context);

        View WordView  = inflater.inflate(item, parent, false);

        ViewHolder viewHolder = new ViewHolder(WordView, globalListener);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull WordAdapter.ViewHolder holder, int position) {
        Word word = myWord.get(position);

        TextView kr = holder.kr, en = holder.en, audio = holder.audio;

        en.setText(word.getEn());
        kr.setText(word.getKr());
        audio.setText(word.getAudioResourceId());
    }

    @Override
    public int getItemCount() {
        return myWord.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView en, kr, audio;
        OnWordListener viewOnWordListener;

        public ViewHolder(@NonNull View itemView, OnWordListener onWordListener)  {
            super(itemView);
            en = itemView.findViewById(R.id.en);
            kr = itemView.findViewById(R.id.kr);
            audio = itemView.findViewById(R.id.sound);
            viewOnWordListener = onWordListener;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            viewOnWordListener.onWordClick(getAdapterPosition());
        }
    }

    public interface OnWordListener{
        public void onWordClick(int position);
    }
}
