package io.dualbit.wordpressclient.query;

import com.google.gson.annotations.SerializedName;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.Builder;


@Builder
public class Query {

    /**
     * Scope under which the request is made; determines fields present in response.
     * <p>Default: view</p>
     * <p>One of: view, embed, edit</p>
     */
    String context;

    /**
     * Current page of the collection.
     * <p>Default: 1</p>
     */
    Integer page;

    /**
     * Maximum number of items to be returned in result set.
     * <p>Default: 10</p>
     */
    @SerializedName("per_page") Integer perPage;

    /**
     * Limit results to those matching a string.
     */
    String search;

    /**
     * Ensure result set excludes specific IDs.
     */
    List<Integer> exclude;

    /**
     * Limit result set to specific IDs.
     */
    List<Integer> include;

    /**
     * Order sort attribute ascending or descending.
     * <p>Default: desc</p>
     * <p>One of: asc, desc</p>
     */
    String order;

    /**
     * Sort collection by object attribute.
     * <p><b>Default</b><br>
     * Posts: date<br>
     * Categories: name<br>
     * Tags: name<br>
     * Pages: date<br>
     * Comments: date_gmt<br>
     * Media: date</p>
     * <p><b>One of</b><br>
     * Posts: date, relevance, id, include, title, slug<br>
     * Categories: id, include, name, slug, term_group, description, count<br>
     * Tags: id, include, name, slug, term_group, description, count<br>
     * Pages: date, relevance, id, include, title, slug, menu_order<br>
     * Comments: date, date_gmt, id, include, post, parent, type<br>
     * Media: date, relevance, id, include, title, slug<br></p>
     */
    @SerializedName("orderby") String orderBy;

    /**
     * Whether to hide terms not assigned to any resources.
     */
    @SerializedName("hide_empty") Boolean hideEmpty;

    /**
     * The password for the resource if it is password protected.
     */
    String password;

    /**
     * Limit response to resources published after a given ISO8601 compliant date.
     */
    String after;

    /**
     * Limit result set to resources assigned to specific authors.
     */
    List<Integer> author;

    /**
     * Ensure result set excludes resources assigned to specific authors.
     */
    @SerializedName("author_exclude") List<Integer> authorExclude;

    /**
     * Limit response to resources published before a given ISO8601 compliant date.
     */
    String before;

    /**
     * Offset the result set by a specific number of items.
     */
    Integer offset;

    /**
     * Limit result set to resources assigned a specific status.
     * <p><b>Default</b><br>
     * Posts: publish<br>
     * Pages: publish<br>
     * Comments: approve</p>
     * <p><b>One of</b><br>
     * Pages: publish, future, draft, pending, private, trash, auto-draft, inherit, any</p>
     */
    String status;

    /**
     * Limit result set to resources assigned one or more statuses.
     */
    @SerializedName("status") List<String> statusList;

    /**
     * Limit result set to resources of specific parent ids.
     */
    Integer parent;

    /**
     * Limit result set to resources assigned to a specific parent ids.
     */
    @SerializedName("parent") List<Integer> parentList;

    /**
     * Ensure result set excludes specific parent ids.
     */
    @SerializedName("parent_exclude") List<Integer> parentExcludeList;

    /**
     * Limit result set to that from a specific author email. Requires authorization.
     */
    @SerializedName("author_email") String authorEmail;

    /**
     * Limit result set to that of a particular comment karma. Requires authorization.
     */
    Integer karma;

    /**
     * Limit result set to terms assigned to a specific post.
     */
    Integer post;

    /**
     * Limit result set to resources assigned to specific post ids.
     */
    @SerializedName("post") List<Integer> postList;

    /**
     * Limit result set to resources assigned a specific type.
     * <p>Default (Comments): comment</p>
     */
    String type;

    /**
     * Limit result set to resources with a specific menu_order value.
     */
    @SerializedName("menu_order") Integer menuOrder;

    /**
     * Limit result set to posts with one or more specific slugs.
     */
    List<String> slug;

    /**
     * Use WP Query arguments to modify the response; private query vars require appropriate authorization.
     */
    List<String> filter; // todo how to do

    /**
     * Limit result set to all items that have the specified term assigned in the categories taxonomy.
     */
    List<Integer> categories;

    /**
     * Limit result set to all items except those that have the specified term assigned in the categories taxonomy.
     */
    @SerializedName("categories_exclude") List<Integer> categoriesExclude;

    /**
     * Limit result set to all items that have the specified term assigned in the tags taxonomy.
     */
    List<Integer> tags;

    /**
     * Limit result set to all items except those that have the specified term assigned in the tags taxonomy.
     */
    @SerializedName("tags_exclude") List<Integer> tagsExclude;

    /**
     * Limit result set to items that are sticky.
     */
    Boolean sticky;

    /**
     * Limit result set to attachments of a particular media type.
     * <p>One of: image, video, audio, application</p>
     */
    @SerializedName("media_type") String mediaType;

    /**
     * Limit result set to attachments of a particular MIME type.
     */
    @SerializedName("mime_type") String mimeType;

    /**
     * Limit result set to users matching at least one specific role provided. Accepts csv list or single role.
     */
    List<String> roles;

    public Map asMap() {

        Map<String, Object> retMap = new HashMap<>();

        for (Field field: this.getClass().getDeclaredFields()) {
            try {
                if (!field.isSynthetic()) {
                    SerializedName serializedName = field.getAnnotation(SerializedName.class);
                    String jsonName = serializedName != null ? serializedName.value() : null;

                    String key = jsonName != null ? jsonName : field.getName();
                    if (field.getType() == List.class) {
                        key = key + "[]";
                        String value = generateQueryStringArray(field, key);
                        if (!value.isEmpty()) {
                            retMap.put(key, value);
                        }
                    } else {
                        Object value = field.get(this);
                        if (value != null) {
                            retMap.put(key, value);
                        }
                    }
                }
            } catch (IllegalAccessException ignore) {
            }
        }

        return retMap;
    }

    private String generateQueryStringArray(Field field, String key) {
        StringBuilder string = new StringBuilder();

        try {
            field.setAccessible(true);
            List list = (List)field.get(this);
            field.setAccessible(false);

            if (list != null) {
                for (int i = 0; i < list.size(); i++) {
                    Object entry = list.get(i);
                    string.append(entry);
                    if ((i + 1) != list.size()) {
                        string.append("&").append(key).append("=");
                    }
                }
            }
        } catch (IllegalAccessException ignore) {
        }

        return string.toString();
    }
}
