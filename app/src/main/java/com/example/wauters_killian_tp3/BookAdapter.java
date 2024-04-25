package com.example.wauters_killian_tp3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import Model.Book;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BookViewHolder> {

    private List<Book> bookList;
    private int numColumns;

    // Constructeur pour un nombre de colonnes donné
    public BookAdapter(List<Book> bookList, int numColumns) {
        this.bookList = bookList;
        this.numColumns = numColumns;
    }

    // Méthode pour déterminer le type de vue en fonction de la position
    @Override
    public int getItemViewType(int position) {
        // Ici, nous avons un seul type de vue, donc nous retournons toujours 0
        return 0;
    }

    @NonNull
    @Override
    public BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Infléchir le bon layout en fonction du viewType (qui est toujours 0 ici)
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_book, parent, false);
        return new BookViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull BookViewHolder holder, int position) {
        Book book = bookList.get(position);
        holder.bind(book);
        
    }

    @Override
    public int getItemCount() {
        // Retourner le nombre d'éléments dans la liste de livres divisé par le nombre de colonnes
        return (int) Math.ceil((double) bookList.size() / numColumns);
    }

    // ViewHolder
    static class BookViewHolder extends RecyclerView.ViewHolder {
        private TextView nameTextView;
        private ImageView star1, star2, star3;

        public BookViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.nameTextView);
            star1 = itemView.findViewById(R.id.star1);
            star2 = itemView.findViewById(R.id.star2);
            star3 = itemView.findViewById(R.id.star3);
        }

        public void bind(Book book) {
            nameTextView.setText(book.getTitle());
            int starRating = book.getStarRating();
            switch (starRating) {
                case 1:
                    star1.setImageResource(R.drawable.filled_star_24);
                    star2.setImageResource(R.drawable.empty_star_24);
                    star3.setImageResource(R.drawable.empty_star_24);
                    break;
                case 2:
                    star1.setImageResource(R.drawable.filled_star_24);
                    star2.setImageResource(R.drawable.filled_star_24);
                    star3.setImageResource(R.drawable.empty_star_24);
                    break;
                case 3:
                    star1.setImageResource(R.drawable.filled_star_24);
                    star2.setImageResource(R.drawable.filled_star_24);
                    star3.setImageResource(R.drawable.filled_star_24);
                    break;
                default:
                    star1.setImageResource(R.drawable.empty_star_24);
                    star2.setImageResource(R.drawable.empty_star_24);
                    star3.setImageResource(R.drawable.empty_star_24);
            }
        }

    }
}

