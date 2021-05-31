package com.ptit.mad.coreading.ui.newsfeed;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.ptit.mad.coreading.R;

public class NewsFeedFragment extends Fragment {

    private NewsFeedViewModel newsFeedViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        newsFeedViewModel =
                new ViewModelProvider(this).get(NewsFeedViewModel.class);
        View root = inflater.inflate(R.layout.fragment_news_feed, container, false);
        return root;
    }
}