package com.example.wauters_killian_tp3;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.wauters_killian_tp3.databinding.ActivityBookBinding;
import com.google.android.material.navigation.NavigationBarView;

public class BookFragment extends AppCompatActivity {

    private ActivityBookBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_book);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        binding = ActivityBookBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.bottomNavigationView.setOnItemReselectedListener(new NavigationBarView.OnItemReselectedListener() {
            @Override
            public void onNavigationItemReselected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()){
                    case R.id.users:
                        replaceFragment(new UsersFragment());
                        break;
                    case R.id.profile:
                        replaceFragment(new ProfileFragment());
                        break;
                    case R.id.books:
                        replaceFragment(new BookFragment());
                        break;
                    case R.id.authors:
                        replaceFragment(new AuthorFragment());
                        break;

                }
            }
        });
    }

    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.commit();
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
}