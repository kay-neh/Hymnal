package com.example.hymnal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.example.hymnal.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationMenuView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.internal.BaselineLayout;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);

        adjustBottomNavGravity(binding.bottomNavBar);

        NavController controller = Navigation.findNavController(this,R.id.my_nav_host_fragment);
        NavigationUI.setupWithNavController(binding.bottomNavBar, controller);

        NavigationUI.setupWithNavController(binding.tool,controller,binding.drawerLayout);
        NavigationUI.setupWithNavController(binding.navView,controller);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController controller = Navigation.findNavController(this,R.id.my_nav_host_fragment);
        return NavigationUI.navigateUp(controller,binding.drawerLayout);
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