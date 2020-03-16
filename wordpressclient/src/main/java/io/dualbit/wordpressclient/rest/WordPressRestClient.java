package io.dualbit.wordpressclient.rest;

import org.jetbrains.annotations.Nullable;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import io.dualbit.wordpressclient.model.*;
import io.dualbit.wordpressclient.query.Query;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class WordPressRestClient {

    private WordPressService apiService;

    public WordPressRestClient(@Nullable OkHttpClient httpClient, String baseUrl) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(httpClient != null ? httpClient : getDefaultOkHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        apiService = retrofit.create(WordPressService.class);
    }

    private OkHttpClient getDefaultOkHttpClient() {
        return new OkHttpClient.Builder()
                .addNetworkInterceptor(new WordPressNetworkInterceptor())
                .build();
    }

    public List<Post> getPosts(Query query) {
        Call call = apiService.getPosts(query.asMap());
        return (List<Post>)executeSafeCall(call);
    }

    public Post getPost(int id, Query query) {
        Call call = apiService.getPost(id, query.asMap());
        return (Post)executeSafeCall(call);
    }

    public List<Category> getCategories(Query query) {
        Call call = apiService.getCategories(query.asMap());
        return (List<Category>)executeSafeCall(call);
    }

    public Category getCategory(int id, Query query) {
        Call call = apiService.getCategory(id, query.asMap());
        return (Category)executeSafeCall(call);
    }

    public List<Tag> getTags(Query query) {
        Call call = apiService.getTags(query.asMap());
        return (List<Tag>)executeSafeCall(call);
    }

    public Tag getTag(int id, Query query) {
        Call call = apiService.getTag(id, query.asMap());
        return (Tag)executeSafeCall(call);
    }

    public List<Comment> getComments(Query query) {
        Call call = apiService.getComments(query.asMap());
        return (List<Comment>)executeSafeCall(call);
    }

    public Comment getComment(int id, Query query) {
        Call call = apiService.getComment(id, query.asMap());
        return (Comment)executeSafeCall(call);
    }

    public List<Page> getPages(Query query) {
        Call call = apiService.getPages(query.asMap());
        return (List<Page>)executeSafeCall(call);
    }

    public Page getPage(int id, Query query) {
        Call call = apiService.getPage(id, query.asMap());
        return (Page)executeSafeCall(call);
    }

    public Map<String, Taxonomy> getTaxonomies(Query query) {
        Call call = apiService.getTaxonomies(query.asMap());
        return (Map<String, Taxonomy>)executeSafeCall(call);
    }

    public Taxonomy getTaxonomy(String taxonomy, Query query) {
        Call call = apiService.getTaxonomy(taxonomy, query.asMap());
        return (Taxonomy)executeSafeCall(call);
    }

    public List<Media> getMediaList(Query query) {
        Call call = apiService.getMediaList(query.asMap());
        return (List<Media>)executeSafeCall(call);
    }

    public Media getMedia(int id, Query query) {
        Call call = apiService.getMedia(id, query.asMap());
        return (Media)executeSafeCall(call);
    }

    public List<User> getUsers(Query query) {
        Call call = apiService.getUsers(query.asMap());
        return (List<User>)executeSafeCall(call);
    }

    public User getUser(int id, Query query) {
        Call call = apiService.getUser(id, query.asMap());
        return (User)executeSafeCall(call);
    }

    public Map<String, PostType> getPostTypes(Query query) {
        Call call = apiService.getPostTypes(query.asMap());
        return (Map<String, PostType>)executeSafeCall(call);
    }

    public PostType getPostType(String postType, Query query) {
        Call call = apiService.getPostType(postType, query.asMap());
        return (PostType)executeSafeCall(call);
    }

    public Map<String, PostStatus> getPostStatuses(Query query) {
        Call call = apiService.getPostStatuses(query.asMap());
        return (Map<String, PostStatus>)executeSafeCall(call);
    }

    public PostStatus getPostStatus(String postStatus, Query query) {
        Call call = apiService.getPostStatus(postStatus, query.asMap());
        return (PostStatus)executeSafeCall(call);
    }

    private static Object executeSafeCall(Call call) {
        try {
            return call.execute().body();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
