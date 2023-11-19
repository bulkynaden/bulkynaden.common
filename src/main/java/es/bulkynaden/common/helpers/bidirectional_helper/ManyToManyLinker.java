package es.bulkynaden.common.helpers.bidirectional_helper;

import lombok.NonNull;

import java.util.function.BiConsumer;

/**
 * <strong>ManyToManyLinker</strong>
 *
 * <p> Manages many-to-many bidirectional links between entities in a many-to-many relationship.
 * This class provides the functionality to establish and break links between two entities.
 *
 * <p> The link and unlink operations are designed to maintain the integrity of relationships,
 * ensuring that previous links are properly removed before establishing new ones.
 * This is particularly useful in scenarios where entities are tightly coupled,
 * such as in domain models with bidirectional relationships.
 *
 * @author Javier Tomás Acín
 * @version 1.0
 * @since 2023-11-19
 */
public class ManyToManyLinker {
    /**
     * Establishes a many-to-many bidirectional link between two entities. This method is used when
     * entities of one type (entityOne) can be linked to multiple entities of another type (entityTwo) and vice versa.
     *
     * @param <T>                       The type of the first entity in the relationship.
     * @param <U>                       The type of the second entity in the relationship.
     * @param entityOne                 The first entity in the relationship.
     * @param entityTwo                 The second entity in the relationship.
     * @param addInternalEntityTwoToOne A consumer that adds entityTwo to the collection within entityOne.
     * @param addInternalEntityOneToTwo A consumer that adds entityOne to the collection within entityTwo.
     * @throws NullPointerException if any of the non-nullable parameters are null.
     */
    public <T, U> void link(@NonNull T entityOne, @NonNull U entityTwo,
                            BiConsumer<T, U> addInternalEntityTwoToOne,
                            BiConsumer<U, T> addInternalEntityOneToTwo) {
        addInternalEntityTwoToOne.accept(entityOne, entityTwo);
        addInternalEntityOneToTwo.accept(entityTwo, entityOne);
    }

    /**
     * Breaks an existing many-to-many bidirectional link between two entities. This method is used
     * to remove the links between entityOne and entityTwo, effectively dissociating them from each other.
     *
     * @param <T>                            The type of the first entity in the relationship.
     * @param <U>                            The type of the second entity in the relationship.
     * @param entityOne                      The first entity in the relationship.
     * @param entityTwo                      The second entity in the relationship.
     * @param removeInternalEntityTwoFromOne A consumer that removes entityTwo from the collection within entityOne.
     * @param removeInternalEntityOneFromTwo A consumer that removes entityOne from the collection within entityTwo.
     * @throws NullPointerException if any of the non-nullable parameters are null.
     */
    public <T, U> void unlink(@NonNull T entityOne, @NonNull U entityTwo,
                              BiConsumer<T, U> removeInternalEntityTwoFromOne,
                              BiConsumer<U, T> removeInternalEntityOneFromTwo) {
        removeInternalEntityTwoFromOne.accept(entityOne, entityTwo);
        removeInternalEntityOneFromTwo.accept(entityTwo, entityOne);
    }
}