package com.example.marse;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private List<ImagesResponse> imagesResponsesList = new ArrayList<>();
    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycler);
      //      CustomAdapter adapter = new CustomAdapter(imagesResponsesList,MainActivity.this);
    //    recyclerView.setAdapter();
        getAllImages();
    }




    public void getAllImages() {
        Call<List<ImagesResponse>> imagesResponse = ApiClient.getInterface().getAllImages();

        imagesResponse.enqueue(new Callback<List<ImagesResponse>>() {
            @Override
            public void onResponse(Call<List<ImagesResponse>> call, Response<List<ImagesResponse>> response) {
                if (response.isSuccessful()) {

                    String massage = "Success..";
                    Toast.makeText(MainActivity.this, "Message", Toast.LENGTH_SHORT).show();

                    imagesResponsesList=response.body();

                   recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

                    CustomAdapter customAdapter=new CustomAdapter(imagesResponsesList,MainActivity.this);
                   recyclerView.setAdapter();




                } else {
                    String massage = "An error..";
                    Toast.makeText(MainActivity.this, "Message", Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<List<ImagesResponse>> call, Throwable t) {


                String massage = t.getLocalizedMessage();
                Toast.makeText(MainActivity.this, "Message", Toast.LENGTH_SHORT).show();


            }
        });
    }

    public class CustomAdapter extends BaseAdapter {
        private List<ImagesResponse> imagesResponseList;
        private Context context;
        private LayoutInflater layoutInflater;

        public CustomAdapter(List<ImagesResponse> imagesResponseList, Context context) {
            this.imagesResponseList = imagesResponseList;
            this.context = context;
            this.layoutInflater = (LayoutInflater) context.getSystemService(LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() {
            return imagesResponseList.size();
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = layoutInflater.inflate(R.layout.row_recycler_items, viewGroup, false);
            }
            ImageView imageView = view.findViewById(R.id.imageView);
            TextView textView = view.findViewById(R.id.tv);
            textView.setText(imagesResponseList.get(i).getId());

            Glide.with(context).
                    load(imagesResponseList.get(i).
                            getImg_src()).into(imageView);
            return view;

        }
    }
}