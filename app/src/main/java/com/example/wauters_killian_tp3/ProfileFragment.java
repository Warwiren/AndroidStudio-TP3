package com.example.wauters_killian_tp3;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.wauters_killian_tp3.databinding.FragmentProfileBinding;

import java.util.List;

import Model.User;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProfileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfileFragment extends Fragment {

    private FragmentProfileBinding binding;
    //private List<User> userList;
    private User selectedUser;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            // Récupérez l'utilisateur sélectionné à partir des arguments
            selectedUser = getArguments().getParcelable("selectedUser");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentProfileBinding.inflate(inflater, container, false);
        View rootView = binding.getRoot();

        /*
        String userName = requireActivity().getIntent().getStringExtra("userName");
        String email = requireActivity().getIntent().getStringExtra("email");
        String age = requireActivity().getIntent().getStringExtra("age");

        TextView textViewYear = binding.textViewAge;
        TextView textViewMail = binding.textViewEmail;
        TextView textViewName = binding.textViewName;
        //textViewGetUser.setText("Bienvenue, " + userName + " !");

        textViewName.setText("Name: " + userName);
        textViewMail.setText("Email: " + email);
        textViewYear.setText("Age: " + age);
         */

        // Récupérez les arguments contenant les détails de l'utilisateur sélectionné

        if (selectedUser != null) {
            binding.textViewName.setText("Name: " + selectedUser.getName());
            binding.textViewAge.setText("Age: " + selectedUser.getAge());
            binding.textViewEmail.setText("Email: " + selectedUser.getEmail());
        }

        return rootView;
    }


    // Méthode pour afficher les détails de l'utilisateur sélectionné
    /*
    private void displayUserDetails(int position) {
        if (userList != null && position >= 0 && position < userList.size()) {
            User user = userList.get(position);
            // Mettre à jour les TextView avec les détails de l'utilisateur
            binding.textViewName.setText("Name: " + user.getName());
            binding.textViewAge.setText("Age: " + user.getAge());
            binding.textViewEmail.setText("Email: " + user.getEmail());
        }
    }

     */
}