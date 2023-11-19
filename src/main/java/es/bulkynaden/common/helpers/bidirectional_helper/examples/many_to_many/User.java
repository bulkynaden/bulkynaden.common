package es.bulkynaden.common.helpers.bidirectional_helper.examples.many_to_many;

import es.bulkynaden.common.helpers.bidirectional_helper.BidirectionalHelper;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Collection;

@Getter
public class User {
    private final Collection<Post> posts = new ArrayList<>();

    public void addPost(Post post) {
        BidirectionalHelper.linkManyToMany(this, post,
                User::addPostInternal,
                Post::addUserInternal
        );
    }

    public void removePost(Post post) {
        BidirectionalHelper.unlinkManyToMany(this, post,
                User::removePostInternal,
                Post::removeUserInternal
        );
    }

    void addPostInternal(Post post) {
        posts.add(post);
    }

    void removePostInternal(Post post) {
        posts.remove(post);
    }
}