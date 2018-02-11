package com.aayush.listsexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import com.aayush.listsexample.Utils.Person;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Person> people = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            JSONArray jsonArray = new JSONArray(Utils.json);
            for (int i = 0; i < jsonArray.length(); i += 1) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                people.add(new Person(
                        jsonObject.getString("lastName"),
                        jsonObject.getString("firstName"),
                        jsonObject.getString("email"),
                        jsonObject.getString("company"),
                        jsonObject.getString("bio"),
                        jsonObject.getString("avatar"),
                        jsonObject.getString("startDate")
                ));
            }

        } catch (JSONException e) {
            Log.e("json exception", e.getMessage());
        }
        Log.d("people size", "" + people.size());
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new PersonAdapter(this, people));
    }
}
