package com.itonemm.infrmrnewapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.itonemm.infrmrnewapp.data.Article;
import com.itonemm.infrmrnewapp.data.ArticleAdapter;
import com.itonemm.infrmrnewapp.data.ArticleData;
import com.itonemm.infrmrnewapp.data.ArticleListAsynResponse;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArticleAdapter articleAdapter;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       new ArticleData().getNewList(new ArticleListAsynResponse() {
           @Override
           public void processFinish(ArrayList<Article> articles) {
               recyclerView=findViewById(R.id.news);
               articleAdapter=new ArticleAdapter(articles,getApplicationContext());
               recyclerView.setAdapter(articleAdapter);
               recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false));
           }
       });
    }
}
