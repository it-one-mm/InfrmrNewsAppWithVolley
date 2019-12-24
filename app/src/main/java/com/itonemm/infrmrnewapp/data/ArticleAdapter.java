package com.itonemm.infrmrnewapp.data;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.itonemm.infrmrnewapp.NewDetailsActivity;
import com.itonemm.infrmrnewapp.R;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ArticleAdapter  extends RecyclerView.Adapter<ArticleAdapter.RecyclerHolder> {

    ArrayList<Article> articles=new ArrayList<Article>();
    Context context;

    public ArticleAdapter(ArrayList<Article> articles,Context context) {
        this.articles = articles;
        this.context=context;
    }

    @NonNull
    @Override
    public RecyclerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.newsrow,parent,false);
        RecyclerHolder recyclerHolder=new RecyclerHolder(view);
        return recyclerHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerHolder holder, int position) {

        final Article article=articles.get(position);
        holder.newsDate.setText(article.getPublishedDate());
        holder.newsTitle.setText(article.title);
        holder.newsDescription.setText(article.description);
        holder.newsAuthor.setText(article.getAuthor());
        holder.newslayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, NewDetailsActivity.class);
                NewDetailsActivity.link=article.newsUrl;
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });
        Glide.with(context)
                .load(article.imageUrl)
                .into(holder.newsImage);

    }

    @Override
    public int getItemCount() {
        return articles.size();
    }

    public class RecyclerHolder extends RecyclerView.ViewHolder{
        ImageView newsImage;
        RelativeLayout newslayout;
        TextView  newsTitle,newsAuthor,newsDescription,newsDate;
        public RecyclerHolder(@NonNull View itemView) {
            super(itemView);
            this.newsImage=itemView.findViewById(R.id.newsImageId);
            this.newsTitle=itemView.findViewById(R.id.newsTitle);
            this.newsAuthor=itemView.findViewById(R.id.newsAuthor);
            this.newsDescription=itemView.findViewById(R.id.newsDetails);
            this.newsDate=itemView.findViewById(R.id.date);
            this.newslayout=itemView.findViewById(R.id.newslayout);
        }
    }
}
