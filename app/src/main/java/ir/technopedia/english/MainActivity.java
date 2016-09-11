package ir.technopedia.english;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import ir.technopedia.english.adapter.NavMenuAdapter;
import ir.technopedia.english.databinding.ActivityMainBinding;
import ir.technopedia.english.model.NavMenuModel;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    List<NavMenuModel> list;
    NavMenuAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_AUTO);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        setSupportActionBar(binding.appBar.toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        binding.appBar.setTitle("مسافر انگلیس");

        list = new ArrayList<>();
        list.add(new NavMenuModel("تست", R.drawable.ic_menu_camera));
        list.add(new NavMenuModel("تست2", R.drawable.ic_menu_gallery));
        list.add(new NavMenuModel("تست3", R.drawable.ic_menu_manage));
        list.add(new NavMenuModel("تست4", R.drawable.ic_menu_camera));
        list.add(new NavMenuModel("تست5", R.drawable.ic_menu_gallery));
        adapter = new NavMenuAdapter(list);

        binding.navList.setLayoutManager(new LinearLayoutManager(this));
        binding.navList.setAdapter(adapter);

    }

    public void onClickToggle(View view) {
        if (binding.drawerLayout.isDrawerOpen(GravityCompat.END)) {
            binding.drawerLayout.closeDrawer(GravityCompat.END);
        } else {
            binding.drawerLayout.openDrawer(GravityCompat.END);
        }
    }

    public void onClickFab(View view) {
        Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();

    }

    @Override
    public void onBackPressed() {
        if (binding.drawerLayout.isDrawerOpen(GravityCompat.END)) {
            binding.drawerLayout.closeDrawer(GravityCompat.END);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
}
