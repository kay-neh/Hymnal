package com.example.hymnal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.hymnal.databinding.ActivitySearchableBinding;

public class SearchableActivity extends AppCompatActivity {

    ActivitySearchableBinding binding;

    SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_searchable);

        //Get query from Explicit Intent and use it
        handleIntent(getIntent());

        binding.toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //Get the Searchview and set the searchable configuration
        MenuItem searchItem = binding.toolbar.getMenu().findItem(R.id.action_search);
        SearchManager searchManager = (SearchManager) SearchableActivity.this.getSystemService(Context.SEARCH_SERVICE);
        searchView = (SearchView) searchItem.getActionView();
        searchView.setSearchableInfo(searchManager.getSearchableInfo(SearchableActivity.this.getComponentName()));
    }

    @Override
    public void onBackPressed() {
        if(!searchView.isIconified()){
            binding.toolbar.getMenu().findItem(R.id.action_search).collapseActionView();
        }else{
            super.onBackPressed();
        }
    }

    public void handleIntent(Intent intent){
        if(Intent.ACTION_SEARCH.equals(intent.getAction())){
            String query = intent.getStringExtra(SearchManager.QUERY);
            binding.toolbar.setTitle(query);
            binding.searchableTextview.setText("Search result for "+query);
        }
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        handleIntent(intent);
    }
}