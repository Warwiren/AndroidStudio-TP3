package com.example.wauters_killian_tp3;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.wauters_killian_tp3.databinding.FragmentBookListBinding;

import java.util.ArrayList;
import java.util.List;

import Model.Book;
import Model.BookManager;


public class BookListFragment extends Fragment {

    private FragmentBookListBinding binding;
    private BookAdapter bookAdapter;
    //private TextView textViewGetUser;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentBookListBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstaceState){
        super.onViewCreated(view, savedInstaceState);

        // Récupérer les données supplémentaires de l'intent
        String userName = requireActivity().getIntent().getStringExtra("userName");

        // Récupérer le TextView
        TextView textViewGetUser = binding.textViewGetUser;

        // Utiliser le nom de l'utilisateur pour personnaliser la vue
        textViewGetUser.setText("Bienvenue, " + userName + " !");

        // Créer une liste de livres (exemple)
        List<Book> bookList = BookManager.getInstance().getBookList();

        // Initialiser l'adaptateur de la RecyclerView
        int numColumns = 1; // Nombre de colonnes dans le GridLayoutManager
        bookAdapter = new BookAdapter(bookList, numColumns);

        // Configurer la RecyclerView
        binding.recyclerViewBooks.setLayoutManager(new GridLayoutManager(requireContext(), 1)); // Changez le deuxième paramètre pour ajuster le nombre de colonnes
        binding.recyclerViewBooks.setAdapter(bookAdapter);


    }

        // Ajouter le layout du livre à la mise en page principale
        //linearLayout.addView(bookLayout);
    }
