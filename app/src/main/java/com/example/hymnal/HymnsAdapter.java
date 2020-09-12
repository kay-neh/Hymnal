package com.example.hymnal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hymnal.POJO.Hymns;

import java.util.List;

public class HymnsAdapter extends RecyclerView.Adapter<HymnsAdapter.HymnsVH>{

    public interface ListItemClickListener {
        void onListItemClick(int index);
    }

    final private ListItemClickListener mOnclickListener;
    private List<Hymns> hymns;

    public HymnsAdapter(ListItemClickListener mOnclickListener) {
        this.mOnclickListener = mOnclickListener;
    }

    class HymnsVH extends RecyclerView.ViewHolder {

        TextView index, title;

        public HymnsVH(@NonNull View itemView) {
            super(itemView);
            index = itemView.findViewById(R.id.hymn_index);
            title = itemView.findViewById(R.id.hymn_title);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int index = getAdapterPosition();
                    mOnclickListener.onListItemClick(index);
                }
            });
        }

    }

    @NonNull
    @Override
    public HymnsVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(R.layout.recycler_view_list_items, parent, false);
        return new HymnsVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HymnsVH holder, int position) {
        if (hymns != null) {
            Hymns currentHymn = hymns.get(position);

            holder.index.setText(String.valueOf(currentHymn.getHymnNo()));
            holder.title.setText(currentHymn.getHymnTitle());
        }
    }

    @Override
    public int getItemCount() {
        if (hymns != null)
            return hymns.size();
        else return 0;
    }

    public void setHymns(List<Hymns> hymnsList) {
        hymns = hymnsList;
        notifyDataSetChanged();
    }

    public String getHymnItemId(int index) {
        return hymns.get(index).getHymnId();
    }

    public int getHymnItemNo(int index) {
        return hymns.get(index).getHymnNo();
    }

    public String getHymnItemTitle(int index) {
        return hymns.get(index).getHymnTitle();
    }
}
