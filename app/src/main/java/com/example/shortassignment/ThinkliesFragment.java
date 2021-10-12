package com.example.shortassignment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.shortassignment.Adapter.ThinkliesAdapter;
import com.example.shortassignment.Model.Thinklies;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class ThinkliesFragment extends Fragment {
    SwipeRefreshLayout swipe_Container;
    RecyclerView rv_Items;
    String start;
    private ArrayList<Thinklies> thinklies = new ArrayList<>();
    public ThinkliesFragment() {
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
        View view = inflater.inflate(R.layout.fragment_thinklies, container, false);

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
            JSONArray array = object.getJSONArray("thinklies");
            for (int i = 0; i < array.length(); i++) {
                Thinklies model = new Thinklies();
                JSONObject jsonObject = array.getJSONObject(i);
                String name = jsonObject.getString("name");
                if (jsonObject.has("body")) {
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
                    model.setFullDesc(body);
                }else if (jsonObject.has("Boston Tea Party")) {
                    String Boston_Tea_Party = jsonObject.getString("Boston Tea Party");
                    if (Boston_Tea_Party.isEmpty()){
                        Boston_Tea_Party ="no Data Available";
                        model.setBody(Boston_Tea_Party);
                    }else {
                        String filename = Boston_Tea_Party;
                        if (filename.length()>100){
                            start = filename.substring(0,100);
                            model.setBostonTeaParty(start);

                        }

                    }
                    model.setFullDesc(Boston_Tea_Party);
                }


                if (name.isEmpty()){
                    model.setName("Boston Tea Party");
                }else {
                    model.setName(name);
                }

                thinklies.add(model);
            }

            ThinkliesAdapter adapter = new ThinkliesAdapter(thinklies);
            rv_Items.setAdapter(adapter);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}