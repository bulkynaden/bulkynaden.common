package es.bulkynaden.common.helpers.bidirectional_helper.examples.many_to_many;

import es.bulkynaden.common.helpers.bidirectional_helper.BidirectionalHelper;
import lombok.Getter;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.Collection;

@Getter
public class Post {
    private final Collection<User> users = new ArrayList<>();

    public void addUser(@NonNull User user) {
        BidirectionalHelper.linkManyToMany(this, user,
                Post::addUserInternal,
                User::addPostInternal
        );
    }

    public void removeUser(@NonNull User user) {
        BidirectionalHelper.unlinkManyToMany(this, user,
                Post::removeUserInternal,
                User::removePostInternal
        );
    }

    void addUserInternal(User user) {
        users.add(user);
    }

    void removeUserInternal(User user) {
        users.remove(user);
    }
}