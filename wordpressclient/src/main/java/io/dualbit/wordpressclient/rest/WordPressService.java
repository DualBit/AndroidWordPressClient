package io.dualbit.wordpressclient.rest;

import java.util.List;
import java.util.Map;

import io.dualbit.wordpressclient.model.*;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;


interface WordPressService {

    @GET("posts")
    Call<List<Post>> getPosts(@QueryMap(encoded = true) Map<String, Object> params);

    /**
     * @param postId Id of a post.
     * @return Post
     */
    @GET("posts/{id}")
    Call<Post> getPost(@Path("id") Integer postId, @QueryMap(encoded = true) Map<String, Object> params);

    @GET("categories")
    Call<List<Category>> getCategories(@QueryMap(encoded = true) Map<String, Object> params);

    /**
     * @param categoryId Id of a category.
     * @return Category
     */
    @GET("categories/{id}")
    Call<Category> getCategory(@Path("id") Integer categoryId, @QueryMap(encoded = true) Map<String, Object> params);

    @GET("tags")
    Call<List<Tag>> getTags(@QueryMap(encoded = true) Map<String, Object> params);

    /**
     * @param tagId Id of a tag.
     * @return Tag
     */
    @GET("tags/{id}")
    Call<Tag> getTag(@Path("id") Integer tagId, @QueryMap(encoded = true) Map<String, Object> params);

    @GET("comments")
    Call<List<Comment>> getComments(@QueryMap(encoded = true) Map<String, Object> params);

    /**
     * @param commentId Id of a comment.
     * @return Comment
     */
    @GET("comments/{id}")
    Call<Comment> getComment(@Path("id") Integer commentId, @QueryMap(encoded = true) Map<String, Object> params);

    @GET("pages")
    Call<List<Page>> getPages(@QueryMap(encoded = true) Map<String, Object> params);

    /**
     * @param pageId Id of a page.
     * @return Page
     */
    @GET("pages/{id}")
    Call<Page> getPage(@Path("id") Integer pageId, @QueryMap(encoded = true) Map<String, Object> params);

    @GET("taxonomies")
    Call<Map<String, Taxonomy>> getTaxonomies(@QueryMap(encoded = true) Map<String, Object> params);

    /**
     * @param taxonomy a taxonomy.
     * @return Taxonomy
     */
    @GET("taxonomies/{taxonomy}")
    Call<Taxonomy> getTaxonomy(@Path("taxonomy") String taxonomy, @QueryMap(encoded = true) Map<String, Object> params);

    @GET("media")
    Call<List<Media>> getMediaList(@QueryMap(encoded = true) Map<String, Object> params);

    /**
     * @param mediaId Id of a media.
     * @return Media
     */
    @GET("media/{id}")
    Call<Media> getMedia(@Path("id") Integer mediaId, @QueryMap(encoded = true) Map<String, Object> params);

    @GET("users")
    Call<List<User>> getUsers(@QueryMap(encoded = true) Map<String, Object> params);

    /**
     * @param userId Id of a user.
     * @return User
     */
    @GET("users/{id}")
    Call<User> getUser(@Path("id") Integer userId, @QueryMap(encoded = true) Map<String, Object> params);

    @GET("types")
    Call<Map<String, PostType>> getPostTypes(@QueryMap(encoded = true) Map<String, Object> params);

    /**
     * @param postType a post type.
     * @return PostType
     */
    @GET("types/{type}")
    Call<PostType> getPostType(@Path("type") String postType, @QueryMap(encoded = true) Map<String, Object> params);

    @GET("statuses")
    Call<Map<String, PostStatus>> getPostStatuses(@QueryMap(encoded = true) Map<String, Object> params);

    /**
     * @param postStatus a post status.
     * @return PostStatus
     */
    @GET("statuses/{status}")
    Call<PostStatus> getPostStatus(@Path("status") String postStatus, @QueryMap(encoded = true) Map<String, Object> params);
}
