package com.ptit.mad.coreading.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ptit.mad.coreading.R;
import com.ptit.mad.coreading.ui.model.Book;

import java.util.List;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.ImageViewHolder> {

    private Context mContext;
    private List<Book> mBooks;
    private boolean isFragment;

    public BookAdapter(Context context, List<Book> books, boolean isFragment) {
        mContext = context;
        mBooks = books;
        this.isFragment = isFragment;
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.book_item, parent, false);
        return new BookAdapter.ImageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, int position) {


    }

    @Override
    public int getItemCount() {
        return mBooks.size();
    }

    public class ImageViewHolder extends RecyclerView.ViewHolder {
        public TextView bookName;
        public TextView author;
        public TextView publisher;
        public TextView publishedYear;
        public TextView rate;
        public TextView description;
        public TextView category;

        public ImageViewHolder(@NonNull View itemView) {
            super(itemView);
            bookName = itemView.findViewById(R.id.bookName);
            author = itemView.findViewById(R.id.author);
        }
    }

    private void isInLibrary(final Integer bookId, final Button button) {
        button.setText("Add");
    }
}
