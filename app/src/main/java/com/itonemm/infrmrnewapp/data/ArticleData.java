package com.itonemm.infrmrnewapp.data;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.itonemm.infrmrnewapp.controller.AppController;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import androidx.recyclerview.widget.RecyclerView;

public class ArticleData {


    ArrayList<Article> articles=new ArrayList<Article>();

    String url="https://newsapi.org/v2/everything?sources=abc-news&apiKey=6307604bda9d47868c00dcc060da0bfe";

    public void getNewList(final ArticleListAsynResponse callback)
    {
        JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(Request.Method.GET,
                url,null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {
                    JSONArray jsonArray=response.getJSONArray("articles");
                    for(int i=0;i<jsonArray.length();i++)
                    {
                        JSONObject object=jsonArray.getJSONObject(i);
                        Article article=new Article();
                        article.author=object.getString("author");
                        article.title=object.getString("title");
                        article.imageUrl=object.getString("urlToImage");
                        article.publishedDate=object.getString("publishedAt");
                        article.description=object.getString("description");
                        article.setNewsUrl(object.getString("url"));
                        articles.add(article);

                    }

                    if(callback!=null)
                    {
                        callback.processFinish(articles);
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        AppController.getInstance().addToRequestQueue(jsonObjectRequest);
    }

}
