package com.project.alihammoud.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    RecyclerView recyclerView;
    recyclerAdapter recyclerAdapter;
    List<data> questionsList;
    List<String> answers = new ArrayList<>();
    int questionNumber = 0;
    Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        next = findViewById(R.id.button);
        load();

        recyclerAdapter = new recyclerAdapter(questionsList,this, questionNumber);
        recyclerView = findViewById(R.id.recy);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(recyclerAdapter);
        recyclerAdapter.notifyDataSetChanged();

    }

    private String json(String file){

        String json = "";
        try {
            InputStream inputStream = getAssets().open(file);
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            json = new String(buffer, "UTF-8");
        }catch (IOException e){
            e.printStackTrace();
        }
        return json;

    }

    private void load(){
        questionsList = new ArrayList<>();
        String jsonString = json("questions.json");

        try {
            JSONObject jsonObject = new JSONObject(jsonString);
            JSONArray questions = jsonObject.getJSONArray("questions");

            for (int i = 0 ; i < questions.length() ; i++){
                JSONObject question = questions.getJSONObject(i);
                String title = question.getString("title");
                String correct = question.getString("answer");

                JSONArray options = question.getJSONArray("options");

                for (int j = 0 ; j < questions.length() ; j++){
                    answers.add(options.optString(j));
                }

                questionsList.add(new data(answers,title,correct));

            }
        }catch (JSONException e){
            e.printStackTrace();
        }

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button){

            if (questionNumber<4){
                questionNumber++;
            }
            else {
                questionNumber = 0;
            }
            recyclerAdapter.notifyDataSetChanged();
            recyclerAdapter = new recyclerAdapter(questionsList,this, questionNumber);
            recyclerView.setAdapter(recyclerAdapter);
            Toast.makeText(MainActivity.this,questionNumber+1+"",Toast.LENGTH_SHORT).show();
            recyclerAdapter = new recyclerAdapter(questionsList,this, questionNumber);
        }

    }


}