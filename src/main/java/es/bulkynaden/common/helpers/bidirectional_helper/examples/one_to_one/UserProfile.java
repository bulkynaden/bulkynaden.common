package es.bulkynaden.common.helpers.bidirectional_helper.examples.one_to_one;

import es.bulkynaden.common.helpers.bidirectional_helper.BidirectionalHelper;
import lombok.Getter;
import lombok.NonNull;

@Getter
public class UserProfile {
    private User user;

    void setUserInternal(User user) {
        this.user = user;
    }

    public void setUser(@NonNull User user) {
        BidirectionalHelper.linkSingular(
                this, user,
                UserProfile::getUser,
                UserProfile::setUserInternal,
                User::setProfileInternal);
    }

    public void removeUser() {
        BidirectionalHelper.unLinkSingular(
                this,
                UserProfile::getUser,
                UserProfile::setUserInternal,
                User::setProfileInternal
        );
    }
}