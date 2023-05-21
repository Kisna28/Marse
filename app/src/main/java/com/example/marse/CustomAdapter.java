package com.example.marse;


import static android.content.Context.LAYOUT_INFLATER_SERVICE;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.Viewholder> {
    private List<ImagesResponse> imagesResponseList;
    private Context context;
    private LayoutInflater layoutInflater;
    ImageView imageView;
    TextView textView;

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        this.imagesResponseList = imagesResponseList;
        this.context = context;

        LayoutInflater inflater = null;

        LayoutInflater inflater1= LayoutInflater.from(parent.getContext());
           View view = layoutInflater.inflate(R.layout.row_recycler_items, parent, false);

        this.layoutInflater = (LayoutInflater) context.getSystemService(LAYOUT_INFLATER_SERVICE);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
        ImagesResponse data = imagesResponseList.get(position);
        textView.setText(imagesResponseList.get(position).getId());
        Glide.with(context).
                load(imagesResponseList.get(position).
                        getImg_src()).into(imageView);
    }

    @Override
    public int getItemCount() {
        return imagesResponseList.size();
    }

    class Viewholder extends RecyclerView.ViewHolder {

        public Viewholder(@NonNull View itemView) {
            super(itemView);

           /* if (view == null) {
                view = layoutInflater.inflate(R.layout.row_recycler_items, viewGroup, false);
            }*/
            ImageView imageView = itemView.findViewById(R.id.imageView);
            TextView textView = itemView.findViewById(R.id.tv);
            //    textView.setText(imagesResponseList.get(i).getId());


        }
    }
}

