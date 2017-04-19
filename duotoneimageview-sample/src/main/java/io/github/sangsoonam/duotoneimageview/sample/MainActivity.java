package io.github.sangsoonam.duotoneimageview.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView image1View = (ImageView) findViewById(R.id.image1);
        ImageView image2View = (ImageView) findViewById(R.id.image2);
        String imageUrl = "https://images.unsplash.com/photo-1460924089785-8467346e18ea?ixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=1080&fit=max&s=ae572d0e8fc1bbb7a671e5c63aca361f";

        Picasso.with(this).load(imageUrl).fit().into(image1View);
        Picasso.with(this).load(imageUrl).fit().into(image2View);
    }
}
