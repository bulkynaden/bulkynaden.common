package es.bulkynaden.common.helpers.bidirectional_helper.examples.one_to_many;

import es.bulkynaden.common.helpers.bidirectional_helper.BidirectionalHelper;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

@Getter
@ToString(of = {"comment"})
@EqualsAndHashCode(of = {"comment"})
public class Post {
    private User user;
    private String comment;

    public void setUser(@NonNull User user) {
        BidirectionalHelper.linkManyToOne(
                this, user,
                User::addPostInternal,
                User::removePostInternal,
                Post::getUser,
                Post::setUserInternal
        );
    }

    public void removeUser() {
        BidirectionalHelper.unlinkManyToOne(this,
                Post::getUser,
                User::removePostInternal,
                Post::setUserInternal);
    }

    void setUserInternal(User user) {
        this.user = user;
    }
}