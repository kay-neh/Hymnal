package com.example.hymnal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class SearchableActivity extends AppCompatActivity {

    Toolbar toolbar;
    TextView searchTxt;
    SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searchable);

        toolbar = findViewById(R.id.toolbar);
        searchTxt = findViewById(R.id.searchable_textview);

        //Get query from Explicit Intent and use it
        handleIntent(getIntent());

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //Get the Searchview and set the searchable configuration
        MenuItem searchItem = toolbar.getMenu().findItem(R.id.action_search);
        SearchManager searchManager = (SearchManager) SearchableActivity.this.getSystemService(Context.SEARCH_SERVICE);
        searchView = (SearchView) searchItem.getActionView();
        searchView.setSearchableInfo(searchManager.getSearchableInfo(SearchableActivity.this.getComponentName()));
    }

    @Override
    public void onBackPressed() {
        if(!searchView.isIconified()){
            toolbar.getMenu().findItem(R.id.action_search).collapseActionView();
        }else{
            super.onBackPressed();
        }
    }

    public void handleIntent(Intent intent){
        if(Intent.ACTION_SEARCH.equals(intent.getAction())){
            String query = intent.getStringExtra(SearchManager.QUERY);
            toolbar.setTitle(query);
            searchTxt.setText("Search result for "+query);
        }
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        handleIntent(intent);
    }
}