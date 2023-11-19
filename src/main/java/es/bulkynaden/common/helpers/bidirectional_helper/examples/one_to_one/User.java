package es.bulkynaden.common.helpers.bidirectional_helper.examples.one_to_one;

import es.bulkynaden.common.helpers.bidirectional_helper.BidirectionalHelper;
import lombok.Getter;
import lombok.NonNull;

@Getter
public class User {
    private UserProfile profile;

    public void setProfile(@NonNull UserProfile profile) {
        BidirectionalHelper.linkSingular(
                this, profile,
                User::getProfile,
                User::setProfileInternal,
                UserProfile::setUserInternal);
    }

    public void removeProfile() {
        BidirectionalHelper.unLinkSingular(
                this,
                User::getProfile,
                User::setProfileInternal,
                UserProfile::setUserInternal
        );
    }

    void setProfileInternal(UserProfile profile) {
        this.profile = profile;
    }

    public void removeUserProfile() {
        BidirectionalHelper.unLinkSingular(
                this,
                User::getProfile,
                User::setProfileInternal,
                UserProfile::setUserInternal
        );
    }
}