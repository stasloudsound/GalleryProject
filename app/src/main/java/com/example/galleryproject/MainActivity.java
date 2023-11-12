package com.example.galleryproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    Integer[] images = {
        R.mipmap.napoleon, R.mipmap.facebook,R.mipmap.napoleon,
            R.mipmap.facebook,R.mipmap.napoleon, R.mipmap.facebook
    };

    String[] textImage = {
        "napoleon", "facebook", "napoleon",
            "facebook", "napoleon", "facebook"
    };




    TextView text;
    Gallery gallery;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = findViewById(R.id.textView);

        gallery = findViewById(R.id.galleryMy);
        imageView = findViewById(R.id.imageMy);
        gallery.setAdapter(new ImageAdapter(this));



        String[] textImage = {
                "napoleon1", "facebook1", "napoleon2",
                "facebook2", "napoleon3", "facebook3"
        };

//        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, textImage);
//
//        ListView listView = findViewById(R.id.listView);
//        listView.setAdapter(adapter);
//
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

//            }
//        });






        gallery.setOnItemClickListener(new AdapterView.OnItemClickListener() {




            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                imageView.setImageResource(images[position]);

                String newText = textImage[position];
                text.setText(newText);
//                Toast.makeText(MainActivity.this, images[position], Toast.LENGTH_SHORT).show();

            }
        });






    }

    class ImageAdapter extends BaseAdapter {
        private Context context;
        private int backgrоundItem;

        public ImageAdapter(Context context) {
            this.context = context;
            TypedArray array = obtainStyledAttributes(R.styleable.my_gallery);
            backgrоundItem = array.getResourceId(R.styleable.my_gallery_android_galleryItemBackground, 0);
            array.recycle();
        }



        @Override
        public int getCount() {
            return images.length;
        }

        @Override
        public Object getItem(int position) {

            return images[position];
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int position, View view, ViewGroup viewGroup) {
            ImageView imageView1 = new ImageView(context);
            imageView1.setImageResource(images[position]);
            imageView1.setLayoutParams(new Gallery.LayoutParams(500, 500));
            imageView1.setBackgroundResource(backgrоundItem);
            return imageView1;
        }
    }
}