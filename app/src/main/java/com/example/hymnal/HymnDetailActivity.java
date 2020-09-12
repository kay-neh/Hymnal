package com.example.hymnal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.hymnal.Network.RetrofitClient;
import com.example.hymnal.Network.RetrofitInterface;
import com.example.hymnal.POJO.Category;
import com.example.hymnal.POJO.HymnBody;
import com.example.hymnal.databinding.ActivityHymnDetailBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HymnDetailActivity extends AppCompatActivity {

    ActivityHymnDetailBinding binding;
    HymnDetailAdapter hymnDetailAdapter;
    String itemId,itemTitle;
    int itemNo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_hymn_detail);

        //Getting data from intent
        Intent intent = getIntent();
        itemId = intent.getStringExtra("item_id");
        itemTitle = intent.getStringExtra("item_title");
        itemNo = intent.getIntExtra("item_no",0);

        binding.toolbar.setTitle(itemNo +".  " +itemTitle);

        initAdapter();
        fetchHymnBody();

        binding.toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if(item.getItemId() == R.id.fav_menu_item){
                    //handle cases of adding and removing favourites
                    if(item.getIcon().getConstantState().equals(getResources().getDrawable(R.drawable.ic_favorite_border).getConstantState())){
                        item.setIcon(R.drawable.ic_favorite_filled);
                    }else{
                        item.setIcon(R.drawable.ic_favorite_border);
                    }

                }
                //handle any other menu item case
                return false;
            }
        });

        binding.toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    public void initAdapter() {
        LinearLayoutManager llm = new LinearLayoutManager(HymnDetailActivity.this);
        int spacing = 0;
        //binding.hymnsRecyclerView.setPadding(0,spacing,0,spacing);
        binding.hymnDetailRecyclerView.setClipToPadding(false);
        binding.hymnDetailRecyclerView.setClipChildren(false);
        binding.hymnDetailRecyclerView.addItemDecoration(new ItemDecoration(spacing));
        binding.hymnDetailRecyclerView.setLayoutManager(llm);
        binding.hymnDetailRecyclerView.setHasFixedSize(true);
        hymnDetailAdapter = new HymnDetailAdapter();
        binding.hymnDetailRecyclerView.setAdapter(hymnDetailAdapter);
    }

    public void fetchHymnBody(){
        RetrofitInterface service = RetrofitClient.getRetrofitInstance().create(RetrofitInterface.class);
        Call<HymnBody> call = service.getHymnsById(itemId);

        call.enqueue(new Callback<HymnBody>() {
            @Override
            public void onResponse(Call<HymnBody> call, Response<HymnBody> response) {
                if (response.body() != null) {
                    hymnDetailAdapter.setVerses(response.body().getVerses());
                }
                if (response.body().getChorus() != null) {
                    binding.chorusTextview.setText(response.body().getChorus().getHymnChorus());
                    binding.chorusView.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onFailure(Call<HymnBody> call, Throwable t) {
                Toast.makeText(HymnDetailActivity.this, "Unable to load hymn", Toast.LENGTH_SHORT).show();
            }
        });
    }

}