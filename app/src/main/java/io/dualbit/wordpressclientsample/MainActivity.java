package io.dualbit.wordpressclientsample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Html;

import java.util.List;

import io.dualbit.wordpressclient.model.Category;
import io.dualbit.wordpressclient.model.Post;
import io.dualbit.wordpressclient.model.User;
import io.dualbit.wordpressclient.query.Query;
import io.dualbit.wordpressclient.rest.WordPressClient;
import io.dualbit.wordpressclientsample.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private static final boolean HTTP_LOGGING = true;

    private static final String BASE_URL = "https://demo.wp-api.org/wp-json/wp/v2/";

    private ActivityMainBinding viewBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(viewBinding.getRoot());
    }

    @Override
    protected void onResume() {
        super.onResume();

        new Thread(() -> {

            getCategories();
            getPosts();
            getUsers();

        }).start();
    }

    private void getCategories() {
        WordPressClient client = new WordPressClient(null, BASE_URL, HTTP_LOGGING);
        Query query = Query.builder()
                .context("view")
                .perPage(100)
                .build();
        List<Category> categories = client.getCategories(query);

        if (categories != null) {
            runOnUiThread(() -> {
                viewBinding.logTextView.append(Html.fromHtml("<b>Categories:</b><br/>"));
                for (Category category : categories) {
                    viewBinding.logTextView.append("- Category: " + category.getId() + " - " + category.getName() + "\n");
                }
            });
        } else {
            runOnUiThread(() -> viewBinding.logTextView.append(Html.fromHtml("<b>Cannot retrieve Categories<br/>")));
        }
    }

    private void getPosts() {
        WordPressClient client = new WordPressClient(null, BASE_URL, HTTP_LOGGING);
        Query query = Query.builder()
                .context("view")
                .build();
        List<Post> posts = client.getPosts(query);

        if (posts != null) {
            runOnUiThread(() -> {
                viewBinding.logTextView.append(Html.fromHtml("<b>Posts:</b><br/>"));
                for (Post post : posts) {
                    viewBinding.logTextView.append("- Post: " + post.getId() + " - " + post.getTitle().getRendered() + "\n");
                }
            });
        } else {
            runOnUiThread(() -> viewBinding.logTextView.append(Html.fromHtml("<b>Cannot retrieve Posts<br/>")));
        }
    }

    private void getUsers() {
        WordPressClient client = new WordPressClient(null, BASE_URL, HTTP_LOGGING);
        Query query = Query.builder()
                .context("view")
                .build();
        List<User> users = client.getUsers(query);

        if (users != null) {
            runOnUiThread(() -> {
                viewBinding.logTextView.append(Html.fromHtml("<b>Users:</b><br/>"));
                for (User user : users) {
                    viewBinding.logTextView.append("- User: " + user.getId() + " - " + user.getUsername() + " - " + user.getEmail() + "\n");
                }
            });
        } else {
            runOnUiThread(() -> viewBinding.logTextView.append(Html.fromHtml("<b>Cannot retrieve Users<br/>")));
        }
    }
}
