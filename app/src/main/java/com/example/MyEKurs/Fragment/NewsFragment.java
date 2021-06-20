package com.example.MyEKurs.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.MyEKurs.ApiClient;
import com.example.MyEKurs.Model.Articles;
import com.example.MyEKurs.Model.Headlines;
import com.example.MyEKurs.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewsFragment extends Fragment {

    RecyclerView recyclerView;
    final String API_KEY = "b03ed405ee6c4ddfa31414457ec2adf9";
    Adapter adapter;
    List<Articles> articles = new ArrayList<>();

    public NewsFragment() {
        // Required empty public constructor
    }

    /** TODO
     * benerin error RecyclerView: No adapter attached; skipping layout (LogCat)
     * dan kemungkinan toast tdk keluar (line 73)
     */

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_news, container, false);
        recyclerView = rootView.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        String country = getCountry();
        retrieveJson(country,API_KEY);

        return rootView;
    }

    public void retrieveJson(String country, String apiKey) {

        Call<Headlines> call = ApiClient.getInstance().getApi().getHeadlines(country,apiKey);
        call.enqueue(new Callback<Headlines>() {
            @Override
            public void onResponse(Call<Headlines> call, Response<Headlines> response) {
                if (response.isSuccessful() && response.body().getArticles() != null){
                    articles.clear();
                    articles = response.body().getArticles();
                    adapter = new Adapter(getActivity(),articles);
                    recyclerView.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<Headlines> call, Throwable t) {
                Toast.makeText(getActivity(), t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }
    public String getCountry() {
        Locale locale = Locale.getDefault();
        String country = locale.getCountry();
        return country.toLowerCase();
    }
}