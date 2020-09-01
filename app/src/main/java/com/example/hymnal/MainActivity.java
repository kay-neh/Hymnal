package com.example.hymnal;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.core.view.GravityCompat;
import androidx.databinding.DataBindingUtil;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.example.hymnal.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        adjustBottomNavGravity(binding.bottomNavBar);

        NavController controller = Navigation.findNavController(this, R.id.my_nav_host_fragment);
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration
                .Builder(R.id.allhymnsFragment, R.id.favouriteFragment, R.id.contactFragment, R.id.entranceHymnFragment,
                R.id.offertoryHymnsFragment, R.id.consecrationHymnsFragment, R.id.communionHymnsFragment, R.id.closingHymnsFragment, R.id.indegenousHymnFragment)
                .setDrawerLayout(binding.drawerLayout).build();

        //Toolbar
        NavigationUI.setupWithNavController(binding.tool, controller, appBarConfiguration);
        //Bottom NavBar
        NavigationUI.setupWithNavController(binding.bottomNavBar, controller);
        //Nav View
        NavigationUI.setupWithNavController(binding.navView, controller);

        //To prevent spamming active tab
        binding.bottomNavBar.setOnNavigationItemReselectedListener(new BottomNavigationView.OnNavigationItemReselectedListener() {
            @Override
            public void onNavigationItemReselected(@NonNull MenuItem item) {
                //Do nothing
            }
        });

        binding.navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.allhymnsFragment) {
                    binding.bottomNavBar.setSelectedItemId(R.id.allhymnsFragment);
                    controller.navigate(R.id.allhymnsFragment);
                    binding.drawerLayout.closeDrawer(GravityCompat.START);

                } else if (item.getItemId() == R.id.entranceHymnFragment) {
                    binding.bottomNavBar.setSelectedItemId(R.id.allhymnsFragment);
                    controller.navigate(R.id.entranceHymnFragment);
                    binding.drawerLayout.closeDrawer(GravityCompat.START);

                } else if (item.getItemId() == R.id.offertoryHymnsFragment) {
                    binding.bottomNavBar.setSelectedItemId(R.id.allhymnsFragment);
                    controller.navigate(R.id.offertoryHymnsFragment);
                    binding.drawerLayout.closeDrawer(GravityCompat.START);

                } else if (item.getItemId() == R.id.consecrationHymnsFragment) {
                    binding.bottomNavBar.setSelectedItemId(R.id.allhymnsFragment);
                    controller.navigate(R.id.consecrationHymnsFragment);
                    binding.drawerLayout.closeDrawer(GravityCompat.START);

                } else if (item.getItemId() == R.id.communionHymnsFragment) {
                    binding.bottomNavBar.setSelectedItemId(R.id.allhymnsFragment);
                    controller.navigate(R.id.communionHymnsFragment);
                    binding.drawerLayout.closeDrawer(GravityCompat.START);

                } else if (item.getItemId() == R.id.closingHymnsFragment) {
                    binding.bottomNavBar.setSelectedItemId(R.id.allhymnsFragment);
                    controller.navigate(R.id.closingHymnsFragment);
                    binding.drawerLayout.closeDrawer(GravityCompat.START);

                } else if (item.getItemId() == R.id.indegenousHymnFragment) {
                    binding.bottomNavBar.setSelectedItemId(R.id.allhymnsFragment);
                    controller.navigate(R.id.indegenousHymnFragment);
                    binding.drawerLayout.closeDrawer(GravityCompat.START);
                }
                return false;
            }
        });

        //Get the Searchview and set the searchable configuration
        MenuItem searchItem = binding.tool.getMenu().findItem(R.id.action_search);
        SearchManager searchManager = (SearchManager) MainActivity.this.getSystemService(Context.SEARCH_SERVICE);
        searchView = (SearchView) searchItem.getActionView();
        searchView.setSearchableInfo(searchManager.getSearchableInfo(MainActivity.this.getComponentName()));

        controller.addOnDestinationChangedListener(new NavController.OnDestinationChangedListener() {
            @Override
            public void onDestinationChanged(@NonNull NavController controller, @NonNull NavDestination destination, @Nullable Bundle arguments) {
                if (destination.getId() == R.id.favouriteFragment || destination.getId() == R.id.contactFragment) {
                    binding.tool.getMenu().findItem(R.id.action_search).setVisible(false);
                } else {
                    binding.tool.getMenu().findItem(R.id.action_search).setVisible(true);
                }
                //Highlighting the correct Nav Drawer items
                if (destination.getId() == R.id.allhymnsFragment){
                    binding.navView.getMenu().findItem(R.id.allhymnsFragment).setChecked(true);
                }
                if (destination.getId() == R.id.entranceHymnFragment){
                    binding.navView.getMenu().findItem(R.id.entranceHymnFragment).setChecked(true);
                }
                if (destination.getId() == R.id.offertoryHymnsFragment){
                    binding.navView.getMenu().findItem(R.id.offertoryHymnsFragment).setChecked(true);
                }
                if (destination.getId() == R.id.consecrationHymnsFragment){
                    binding.navView.getMenu().findItem(R.id.consecrationHymnsFragment).setChecked(true);
                }
                if (destination.getId() == R.id.communionHymnsFragment){
                    binding.navView.getMenu().findItem(R.id.communionHymnsFragment).setChecked(true);
                }
                if (destination.getId() == R.id.closingHymnsFragment){
                    binding.navView.getMenu().findItem(R.id.closingHymnsFragment).setChecked(true);
                }
                if (destination.getId() == R.id.indegenousHymnFragment){
                    binding.navView.getMenu().findItem(R.id.indegenousHymnFragment).setChecked(true);
                }

            }
        });

    }

    @Override
    public void onBackPressed() {
        if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            binding.drawerLayout.closeDrawer(GravityCompat.START);
        } else if (!searchView.isIconified()) {
            binding.tool.getMenu().findItem(R.id.action_search).collapseActionView();
        }else {
            super.onBackPressed();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (!searchView.isIconified()) {
            binding.tool.getMenu().findItem(R.id.action_search).collapseActionView();
        }
    }

    private static void adjustBottomNavGravity(View v) {
        if (v.getId() == com.google.android.material.R.id.smallLabel) {
            ViewGroup parent = (ViewGroup) v.getParent();
            parent.setPadding(0, 0, 0, 0);

            FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) parent.getLayoutParams();
            params.gravity = Gravity.CENTER;
            parent.setLayoutParams(params);
        }

        if (v instanceof ViewGroup) {
            ViewGroup vg = (ViewGroup) v;

            for (int i = 0; i < vg.getChildCount(); i++) {
                adjustBottomNavGravity(vg.getChildAt(i));
            }
        }
    }

}