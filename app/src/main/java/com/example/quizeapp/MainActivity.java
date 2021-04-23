package com.example.quizeapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

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
    AlertDialog.Builder mBuilder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        Initialize();

    }

    private void Initialize() {
        mRecyclerView = mActivityMainBinding.recycleView;
        String jsonString = loadJSONFromAsset(this, "questionList");
        Questionlistresponce questionlistresponce = new Gson().fromJson(jsonString, Questionlistresponce.class);

        mArrayList = questionlistresponce.getQuestionList();
        mLinearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        mRecyclerView.setLayoutManager(mLinearLayoutManager);

        mQuestionlistAdapter = new QuestionlistAdapter(mArrayList, this);
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.iteam_menu, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.submit:
                Toast.makeText(this, "Result", Toast.LENGTH_SHORT).show();
                break;
        }


        return super.onOptionsItemSelected(item);
    }


}