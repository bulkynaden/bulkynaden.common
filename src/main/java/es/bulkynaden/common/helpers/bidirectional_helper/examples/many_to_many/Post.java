package es.bulkynaden.common.helpers.bidirectional_helper.examples.many_to_many;

import es.bulkynaden.common.helpers.bidirectional_helper.BidirectionalHelper;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

import java.util.Collection;

@Getter
@ToString(of = {"comment"})
@EqualsAndHashCode(of = {"comment"})
public class Post {
    private Collection<User> users;
    private String comment;

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