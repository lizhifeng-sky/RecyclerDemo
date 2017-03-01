package lzf.recycler.demo;

import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class NextActivity extends AppCompatActivity {

    public static void launch(AppCompatActivity activity, View transitionView, int resId) {
        Intent intent = new Intent(activity, NextActivity.class);
        intent.putExtra("resId", R.mipmap.ic_launcher);

        ActivityOptionsCompat options = ActivityOptionsCompat
                .makeSceneTransitionAnimation(activity, transitionView, "image");
        ActivityCompat.startActivity(activity, intent, options.toBundle());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_next);
        ImageView imageView = (ImageView) findViewById(R.id.image);
        imageView.setImageResource(getIntent().getIntExtra("resId", R.mipmap.ic_launcher));
        ViewCompat.setTransitionName(imageView, "image");
    }
}
