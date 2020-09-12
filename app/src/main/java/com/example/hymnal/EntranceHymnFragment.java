package com.example.hymnal;

import android.content.Intent;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.hymnal.Network.RetrofitInterface;
import com.example.hymnal.Network.RetrofitClient;
import com.example.hymnal.POJO.Category;
import com.example.hymnal.databinding.FragmentEntranceHymnBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EntranceHymnFragment extends Fragment {

    FragmentEntranceHymnBinding binding;
    HymnsAdapter hymnsAdapter;

    public EntranceHymnFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_entrance_hymn, container, false);

        initAdapter();
        fetchEntranceHymns();

        return binding.getRoot();
    }

    public void initAdapter() {
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        int spacing = 0;
        //binding.hymnsRecyclerView.setPadding(0,spacing,0,spacing);
        binding.hymnsRecyclerView.setClipToPadding(false);
        binding.hymnsRecyclerView.setClipChildren(false);
        binding.hymnsRecyclerView.addItemDecoration(new ItemDecoration(spacing));
        binding.hymnsRecyclerView.setLayoutManager(llm);
        binding.hymnsRecyclerView.setHasFixedSize(true);
        hymnsAdapter = new HymnsAdapter(new HymnsAdapter.ListItemClickListener() {
            @Override
            public void onListItemClick(int index) {
                //NAVIGATE TO HYMN DETAIL ACTIVITY
                Intent intent = new Intent(getActivity(),HymnDetailActivity.class);
                intent.putExtra("item_id", hymnsAdapter.getHymnItemId(index));
                intent.putExtra("item_no", hymnsAdapter.getHymnItemNo(index));
                intent.putExtra("item_title", hymnsAdapter.getHymnItemTitle(index));
                startActivity(intent);
            }
        });
        binding.hymnsRecyclerView.setAdapter(hymnsAdapter);
    }

    public void fetchEntranceHymns(){
        RetrofitInterface service = RetrofitClient.getRetrofitInstance().create(RetrofitInterface.class);
        Call<Category> call = service.getHymnsByCategory("5ee2017e21aad32af0caad83");

        call.enqueue(new Callback<Category>() {
            @Override
            public void onResponse(Call<Category> call, Response<Category> response) {
                if (response.body() != null) {
                    hymnsAdapter.setHymns(response.body().getHymns());
                }
            }

            @Override
            public void onFailure(Call<Category> call, Throwable t) {
                Toast.makeText(getActivity(), "Unable to load entrance category", Toast.LENGTH_SHORT).show();
            }
        });
    }
}