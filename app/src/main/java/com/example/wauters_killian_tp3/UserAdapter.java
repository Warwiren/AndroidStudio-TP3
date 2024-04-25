package com.example.wauters_killian_tp3;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import Model.User;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {

    // Déclarez une liste pour stocker les utilisateurs
    private List<User> userList;

    public interface OnUserClickListener {
        void onUserClick(int userId);
    }

    // Constructeur prenant la liste des utilisateurs en argument
    public UserAdapter(List<User> userList) {
        this.userList = userList;
    }

    // Méthode appelée lorsqu'un nouveau ViewHolder doit être créé


    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Créez et renvoyez une nouvelle instance de UserViewHolder avec le layout XML approprié
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_users, parent, false);
        return new UserViewHolder(view);
    }

    // Méthode appelée lorsqu'un ViewHolder existant doit être recyclé et lié à de nouvelles données
    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        // Obtenez l'utilisateur à la position donnée
        User user = userList.get(position);
        // Appelez la méthode bind() du ViewHolder pour lier les données à la vue
        holder.bind(user);

        // Ajoutez un écouteur de clic à l'élément de vue
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Récupérez le contexte à partir de la vue
                Context context = holder.itemView.getContext();
                // Créez l'intent pour ouvrir MainActivity
                Intent intent = new Intent(context, MainActivity.class);
                // Ajoutez des données supplémentaires à l'intent si nécessaire
                intent.putExtra("userName", user.getName());
                // Démarrez l'activité MainActivity
                context.startActivity(intent);
            }
        });
    }

    // Méthode qui renvoie le nombre total d'éléments dans la liste
    @Override
    public int getItemCount() {
        return userList.size();
    }

    // Classe ViewHolder interne qui contient les éléments de vue pour chaque utilisateur
    public static class UserViewHolder extends RecyclerView.ViewHolder {

        // Déclarez les vues à l'intérieur du ViewHolder
        private TextView nameTextView;

        // Constructeur prenant la vue du layout XML comme argument
        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            // Initialisez les vues à l'intérieur du ViewHolder
            nameTextView = itemView.findViewById(R.id.nameTextView);
        }

        // Méthode pour lier les données de l'utilisateur à la vue
        public void bind(User user) {
            // Mettez à jour les vues avec les données de l'utilisateur
            nameTextView.setText(user.getName() + " " + user.getLastName());
        }
    }
}
