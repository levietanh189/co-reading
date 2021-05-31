package com.ptit.mad.coreading.ui.search;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.ptit.mad.coreading.R;
import com.ptit.mad.coreading.ui.adapter.BookAdapter;
import com.ptit.mad.coreading.ui.model.Book;

import java.util.ArrayList;
import java.util.List;

public class SearchFragment extends Fragment {
    private RecyclerView recyclerView;
    private BookAdapter bookAdapter;
    private List<Book> bookList;

    EditText search_bar;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.search_fragment, container, false);

        recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        search_bar = view.findViewById(R.id.search_bar);

        bookList = new ArrayList<>();
        bookAdapter = new BookAdapter(getContext(), bookList, true);
        recyclerView.setAdapter(bookAdapter);

        readBooks();
        search_bar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                searchBooks(s.toString().toLowerCase());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        return view;
    }

    private void searchBooks(String s) {
        bookList.clear();
        bookList.add(new Book(4, s, "Author 4", "Publisher 4",
                2020, 5, "Description 4", "Arts"));
        bookAdapter.notifyDataSetChanged();
    }

    private void readBooks() {

        Book book1 = new Book(1, "Book 1", "Author 1", "Publisher 1",
                2019, 5, "Description 1", "Sciences");
        Book book2 = new Book(2, "Book 2", "Author 2", "Publisher 2",
                2019, 5, "Description 2", "Stories");
        Book book3 = new Book(3, "Book 3", "Author 3", "Publisher 3",
                2019, 4, "Description 3", "Arts");

        bookList.clear();
        bookList.add(book1);
        bookList.add(book2);
        bookList.add(book3);

        bookAdapter.notifyDataSetChanged();
    }
}