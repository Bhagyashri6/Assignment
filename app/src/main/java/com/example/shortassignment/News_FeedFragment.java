package com.example.shortassignment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.shortassignment.Adapter.News_feedAdapter;
import com.example.shortassignment.Model.News_feed;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class News_FeedFragment extends Fragment {
    SwipeRefreshLayout swipe_Container;
    RecyclerView rv_Items;
    private ArrayList<News_feed> news_feeds = new ArrayList<>();
    String start;
    public News_FeedFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_news__feed, container, false);



        //INIT VIEWS
        init(view);

        return view;
    }

    private void init(View view) {
        swipe_Container = view.findViewById(R.id.swipe_Container);
        rv_Items = view.findViewById(R.id.rv_Items);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        rv_Items.setLayoutManager(linearLayoutManager);

        swipe_Container.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipe_Container.setRefreshing(false);
                getData();
            }
        });


        getData();
    }

    public void getData(){
        try {

            String jsonFileString = Utils.getJsonFromAssets(getContext(), "data.json");
            JSONObject object = new JSONObject(jsonFileString);
            JSONArray array = object.getJSONArray("news_feed");




            for (int i = 0; i < array.length(); i++) {
                News_feed model = new News_feed();
                JSONObject jsonObject = array.getJSONObject(i);
                String name = jsonObject.getString("name");
                String body = jsonObject.getString("body");

                if (body.isEmpty()){
                    body ="no Data Available";
                    model.setBody(body);
                }else {
                    String filename = body;
                    if (filename.length()>100){
                        start = filename.substring(0,100);
                        model.setBody(start);

                    }

                }
                model.setName(name);
                //model.setBody(body);
                model.setFullDesc(body);
                news_feeds.add(model);
            }
            News_feedAdapter myRecyclerViewAdapter = new News_feedAdapter(news_feeds);

            rv_Items.setAdapter(myRecyclerViewAdapter);


        }catch (Exception e){
            e.printStackTrace();
        }
    }
}