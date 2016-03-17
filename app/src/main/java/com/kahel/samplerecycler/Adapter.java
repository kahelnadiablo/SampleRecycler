package com.kahel.samplerecycler;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;



/**
 * Created by Mark on 8/20/2015.
 */
public class Adapter extends RecyclerView.Adapter<Adapter.MainViewHolder> {

    Context context;

    public Adapter(Context context){
        this.context = context;
    }

    @Override
    public int getItemCount() {
        return 5; //SET THE SIZE OF YOUR LIST HERE
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MainViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if(viewType==1) {
            return new ContentHolder(LayoutInflater.from(context).inflate(R.layout.content, parent, false));
        }else{
            return new HeaderHolder(LayoutInflater.from(context).inflate(R.layout.header, parent, false));
        }
    }

    @Override
    public int getItemViewType(int position) {
        if(position==0){
            return 0;
        }else {
            return 1;
        }
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MainViewHolder holder, final int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element

        if(getItemViewType(position)==0) {
            setHeader(holder, position);
        }else {
            setContent(holder, position);
        }
    }

    public void setHeader(MainViewHolder holder, final int position){
        HeaderHolder headerHolder = (HeaderHolder) holder;
        //headerHolder.imageView.setImageResource(R.drawable.YOUR_IMAGE); //SET YOUR IMAGE HERE
    }

    public void setContent(MainViewHolder holder, final int position){
        ContentHolder contentHolder = (ContentHolder) holder;
        //contentHolder.imageView.setImageResource(R.drawable.YOUR_IMAGE); //SET YOUR IMAGE HERE
    }



    public class MainViewHolder extends  RecyclerView.ViewHolder {
        public MainViewHolder(View v) {
            super(v);
        }
    }

    public class HeaderHolder extends MainViewHolder {
        ImageView imageView;
        public HeaderHolder(View view) {
            super(view);
           imageView = (ImageView) view.findViewById(R.id.img_view);
        }
    }

    public class ContentHolder extends MainViewHolder {
        ImageView imageView;
        public ContentHolder(View view) {
            super(view);
            imageView = (ImageView) view.findViewById(R.id.img_view);
        }
    }




}
