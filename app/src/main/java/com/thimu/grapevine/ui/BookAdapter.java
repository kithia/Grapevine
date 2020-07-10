package com.thimu.grapevine.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.thimu.grapevine.R;

import java.util.ArrayList;
import java.util.List;

/**
 * The book adapter
 *
 * @author Obed Ngigi
 * @version 09.07.2020
 */
public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BookHolder> implements Filterable {

    //
    private List<Book> books = new ArrayList<>();
    private List<Book> allBooks;

    /**
     * Create the adapter
     * @param parent
     * @param viewType
     * @return the adapter view
     */
    @NonNull
    @Override
    public BookHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_reads_book_item, parent, false);
        return new BookHolder(itemView); }

    @Override
    public void onBindViewHolder(@NonNull BookHolder holder, int position) {
        Book currentBook = books.get(position);
        holder.imageViewCover.setImageResource(currentBook.getCover());
        holder.textViewPublisher.setText(currentBook.getPublisher());
        holder.textViewTitle.setText(currentBook.getTitle());
        holder.textViewAuthor.setText(currentBook.getAuthors());
        holder.textViewGenre.setText(currentBook.getGenre()); }

    @Override
    public int getItemCount() {
        return books.size();
    }

    public void setBooks(List<Book> books) {
        this.books = books;
        allBooks = new ArrayList<>(books);
        notifyDataSetChanged(); }

    public Book getBookAt(int position) {
        return books.get(position); }

    @Override
    public Filter getFilter() {
        return bookFilter;
    }

    private Filter bookFilter = new Filter() {
        // Runs in background thread
        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {
            List<Book> filteredList = new ArrayList<>();

            if (charSequence.toString().trim().isEmpty()) {
                filteredList.addAll(allBooks); }
            else {
                String filterPattern = charSequence.toString().trim().toLowerCase();

                for (Book book : allBooks) {
                    if (book.getPublisher().toLowerCase().contains(filterPattern) ||
                            book.getTitle().toLowerCase().contains(filterPattern) ||
                            book.getAuthors().toLowerCase().contains(filterPattern)) {
                        filteredList.add(book); } } }

            // The result of this filtering operation is passed to the UI thread below
            FilterResults results = new FilterResults();
            results.values = filteredList;
            return results; }

        // Runs in UI thread
        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            books.clear();
            books.addAll((List) filterResults.values);
            notifyDataSetChanged(); } };

    class BookHolder extends RecyclerView.ViewHolder {
        private ImageView imageViewCover;
        private TextView textViewPublisher;
        private TextView textViewTitle;
        private TextView textViewAuthor;
        private TextView textViewGenre;

        public BookHolder(@NonNull View itemView) {
            super(itemView);
            imageViewCover = itemView.findViewById(R.id.bookCover);
            textViewPublisher = itemView.findViewById(R.id.bookPublisher);
            textViewTitle = itemView.findViewById(R.id.bookTitle);
            textViewAuthor = itemView.findViewById(R.id.bookAuthor);
            textViewGenre = itemView.findViewById(R.id.bookGenre); } }
}
