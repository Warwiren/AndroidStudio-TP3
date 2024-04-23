package com.example.wauters_killian_tp3;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.wauters_killian_tp3.databinding.ActivityMainBinding;
import com.google.android.material.navigation.NavigationBarView;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        // Inflater le layout de l'activité
        //setContentView(R.layout.activity_main);

        // Appliquer le gestionnaire de fenêtre pour ajuster les marges pour les bords système
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        replaceFragment(new BookListFragment(), null);
        // Définir le listener pour le bas de navigation
        /*
        binding.bottomNavigationView.setOnItemSelectedListener(menuItem -> {

            if (menuItem.toString().equals("Users")) {
                replaceFragment(new UsersFragment());
            } else if (menuItem.toString().equals("Profile")) {
                replaceFragment(ProfileFragment.newInstance());
            } else if (menuItem.toString().equals("Books")) {
                replaceFragment(new BookListFragment());
            } else if (menuItem.toString().equals("Authors")) {
                replaceFragment(new AuthorFragment());
            }
            return true;

             */

        binding.bottomNavigationView.setOnItemSelectedListener(menuItem -> {
            Fragment fragment;
            String title;

            switch(menuItem.toString()){
                case "Users":
                    fragment = new UsersFragment();
                    title = getString(R.string.users);
                    break;
                case "Profile":
                    fragment = new ProfileFragment();
                    title = getString(R.string.profile);
                    break;
                case "Books":
                    fragment = new BookListFragment();
                    title = getString(R.string.biblio);
                    break;
                case "Authors":
                    fragment = new AuthorFragment();
                    title = getString(R.string.authors);
                    break;
                default:
                    return false;
            }
            replaceFragment(fragment, title);
            return true;
        });
        setSupportActionBar(toolbar);
    }

    private void replaceFragment(Fragment fragment, String title) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                //.replace(R.id.fragment_container_view, fragment.getClass(), null)
                .replace(R.id.fragment_container_view, fragment)
                .setReorderingAllowed(true)
                .addToBackStack(null)
                .commit();
        setToolbarTitle(title);
    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main,menu);
        MenuItem menuItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) menuItem.getActionView();
        assert searchView != null;
        searchView.setQueryHint("Search here");

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }
    private void setToolbarTitle(String title) {
        Toolbar toolbar = findViewById(R.id.toolbarBook);
        if (title == null) {
            title = getString(R.string.biblio);
        }
        toolbar.setTitle(title);
        setSupportActionBar(toolbar);
    }
}

