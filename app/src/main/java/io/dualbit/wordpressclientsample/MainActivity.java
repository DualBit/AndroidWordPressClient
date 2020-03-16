package io.dualbit.wordpressclientsample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.List;

import io.dualbit.wordpressclient.model.Post;
import io.dualbit.wordpressclient.query.Query;
import io.dualbit.wordpressclient.rest.WordPressRestClient;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private static final String BASE_URL = "https://demo.wp-api.org/wp-json/wp/v2/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();

        new Thread(new Runnable() {
            @Override
            public void run() {
                WordPressRestClient client = new WordPressRestClient(null, BASE_URL);

                Query query = Query.builder()
                        .context("view")
                        .build();
                List<Post> posts = client.getPosts(query);

                Log.d(TAG, "list of posts is: " + posts);
                for (Post post : posts) {
                    Log.d(TAG, "post: " + post.getId());
                }
            }
        }).start();
    }
}
