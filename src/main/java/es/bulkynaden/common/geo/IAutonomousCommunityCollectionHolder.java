package es.bulkynaden.common.geo;

import lombok.NonNull;

import java.util.Collection;


/**
 * The {@code IAutonomousCommunityCollectionHolder} interface represents an object that holds a collection of autonomous communities.
 */
public interface IAutonomousCommunityCollectionHolder {

    /**
     * Retrieves a collection of autonomous communities.
     *
     * @return a collection of autonomous communities
     */
    Collection<IAutonomousCommunity> getAutonomousCommunities();

    /**
     * Sets the collection of autonomous communities.
     *
     * @param autonomousCommunities the collection of autonomous communities to be set
     * @param <T>                   the type of autonomous community
     */
    default <T extends IAutonomousCommunity> void setAutonomousCommunities(Collection<T> autonomousCommunities) {
        autonomousCommunities.forEach(this::addAutonomousCommunity);
    }

    /**
     * Adds an autonomous community to the collection.
     *
     * @param autonomousCommunity the autonomous community to be added
     */
    void addAutonomousCommunity(@NonNull IAutonomousCommunity autonomousCommunity);

    /**
     * Removes the specified autonomous community from the collection.
     *
     * @param autonomousCommunity the autonomous community to be removed
     */
    void removeAutonomousCommunity(@NonNull IAutonomousCommunity autonomousCommunity);
}