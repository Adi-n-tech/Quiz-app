package com.example.quizeapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.example.quizeapp.databinding.ActivityMainBinding;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import Models.Question;
import Models.Questionlistresponce;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding mActivityMainBinding;
    private ArrayList<Question> mArrayList = new ArrayList<>();
    private RecyclerView mRecyclerView;
    private QuestionlistAdapter mQuestionlistAdapter;
    private LinearLayoutManager mLinearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        Initialize();

    }

    private void Initialize() {
        mRecyclerView = mActivityMainBinding.recycleView;
        String jsonString = loadJSONFromAsset(this, "questionList");
        Questionlistresponce questionlistresponce= new Gson().fromJson(jsonString, Questionlistresponce.class);

        mArrayList = questionlistresponce.getQuestionList();
        mLinearLayoutManager = new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        mRecyclerView.setLayoutManager(mLinearLayoutManager);

        mQuestionlistAdapter = new QuestionlistAdapter(mArrayList,this);
        mRecyclerView.setAdapter(mQuestionlistAdapter);

    }

    public String loadJSONFromAsset(Context context, String doGetQuestion) {
        String jsonString = null;
        try {
            InputStream is = context.getAssets().open("doGetQuestion");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            jsonString = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return jsonString;
    }








}