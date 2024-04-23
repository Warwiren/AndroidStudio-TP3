package com.example.wauters_killian_tp3;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wauters_killian_tp3.databinding.ActivityMainBinding;

import java.util.List;

import Model.User;
import Model.UserManager;

public class UsersActivity extends AppCompatActivity {

    private CardView cardView;
    private RecyclerView recyclerView;
    private UserAdapter userAdapter;
    private AppBarConfiguration appBarConfiguration;
    // private ActivityMainBinding binding;
    private LinearLayout userContainer;
    private UserManager userManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users);
        EdgeToEdge.enable(this);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Créez une instance de UserManager et obtenez la liste des utilisateurs
        userManager = new UserManager();
        List<User> userList = userManager.getUserList();

        // Trouvez votre RecyclerView dans le layout
        recyclerView = findViewById(R.id.recycler_users);

        // Initialisez votre RecyclerView avec un LayoutManager (LinearLayoutManager, GridLayoutManager, etc.)
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Créez une instance de UserAdapter en lui passant la liste des utilisateurs
        userAdapter = new UserAdapter(userList);

        // Définissez l'adapter pour votre RecyclerView
        recyclerView.setAdapter(userAdapter);

        //userManager = new UserManager();
        //userManager = UserManager.getInstance();

        // Trouver le conteneur parent dans le layout
        //userContainer = findViewById(R.id.userContainer);
        //recyclerView = findViewById(R.id.recycler_users);
        //recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //List<User> userList = userManager.getUserList();
        //userAdapter = new UserAdapter(userList);
        //recyclerView.setAdapter(userAdapter);
    }

    /*
        cardView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(UsersActivity.this, MainActivity.class);
            startActivity(intent);
        }
    });
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        /*
        if (id == R.id.action_settings) {
            return true;
        }
*/
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.bottomNavigationView);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }
}