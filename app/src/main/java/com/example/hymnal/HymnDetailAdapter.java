package com.example.hymnal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hymnal.POJO.Verses;

import java.util.List;

public class HymnDetailAdapter extends RecyclerView.Adapter<HymnDetailAdapter.HymnDetailVH> {

    private List<Verses> verses;

    public HymnDetailAdapter() {
    }

    class HymnDetailVH extends RecyclerView.ViewHolder {

        TextView index, verse;

        public HymnDetailVH(@NonNull View itemView) {
            super(itemView);
            index = itemView.findViewById(R.id.hymn_verse_index);
            verse = itemView.findViewById(R.id.hymn_verse);
        }
    }

    @NonNull
    @Override
    public HymnDetailVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(R.layout.recycler_view_list_item_detail, parent, false);
        return new HymnDetailVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HymnDetailVH holder, int position) {
        if (verses != null) {
            Verses currentVerse = verses.get(position);
            holder.verse.setText(currentVerse.getHymnVerse());
            holder.index.setText(String.valueOf(position+1));
        }
    }

    @Override
    public int getItemCount() {
        if (verses != null)
            return verses.size();
        else return 0;
    }

    public void setVerses(List<Verses> versesList) {
        verses = versesList;
        notifyDataSetChanged();
    }
}
