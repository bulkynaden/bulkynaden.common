package es.bulkynaden.common.helpers.bidirectional_helper;

import lombok.NonNull;

import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * <strong>OneToManyLinker</strong>
 *
 * <p> Manages one-to-many bidirectional links between entities in a one-to-many relationship.
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
public class OneToManyLinker {
    /**
     * Establishes a one-to-many bidirectional link between two entities. This method is used when
     * one entity (entityOne) can be linked to multiple entities of another type (entityTwo), but
     * each entityTwo is linked to only one entityOne.
     *
     * @param <T>                                   The type of the entity that can link to multiple entities.
     * @param <U>                                   The type of the entities that can be linked to only one entity.
     * @param entityOne                             The entity that can link to multiple entities.
     * @param entityTwo                             The entity to be linked to entityOne.
     * @param addInternalEntityTwoToOne             A consumer that adds entityTwo to the collection within entityOne.
     * @param removeInternalEntityTwoFromCurrentOne A consumer that removes entityTwo from its current entityOne, if any.
     * @param getCurrentEntityFromTwo               A function to get the current entityOne linked to entityTwo.
     * @param setInternalEntityTwoToOne             A consumer that sets the link of entityTwo to entityOne.
     * @throws NullPointerException if any of the non-nullable parameters are null.
     */
    public <T, U> void link(@NonNull T entityOne, @NonNull U entityTwo,
                            BiConsumer<T, U> addInternalEntityTwoToOne,
                            BiConsumer<T, U> removeInternalEntityTwoFromCurrentOne,
                            Function<U, T> getCurrentEntityFromTwo,
                            BiConsumer<U, T> setInternalEntityTwoToOne) {
        T currentEntityOne = getCurrentEntityFromTwo.apply(entityTwo);

        if (currentEntityOne != null) {
            removeInternalEntityTwoFromCurrentOne.accept(currentEntityOne, entityTwo);
        }

        addInternalEntityTwoToOne.accept(entityOne, entityTwo);
        setInternalEntityTwoToOne.accept(entityTwo, entityOne);
    }

    /**
     * Breaks an existing one-to-many bidirectional link between two entities. This method is used
     * to remove an entity (entityTwo) from the collection of linked entities in entityOne.
     *
     * @param <T>                            The type of the entity that can link to multiple entities.
     * @param <U>                            The type of the entities that can be linked to only one entity.
     * @param entityOne                      The entity containing the collection of linked entities.
     * @param entityTwo                      The entity to be unlinked from entityOne.
     * @param removeInternalEntityTwoFromOne A consumer that removes entityTwo from the collection within entityOne.
     * @param setInternalEntityTwoToOne      A consumer that removes the link of entityTwo to entityOne.
     * @throws NullPointerException if any of the non-nullable parameters are null.
     */
    public <T, U> void unlink(@NonNull T entityOne, @NonNull U entityTwo,
                              BiConsumer<T, U> removeInternalEntityTwoFromOne,
                              BiConsumer<U, T> setInternalEntityTwoToOne) {
        removeInternalEntityTwoFromOne.accept(entityOne, entityTwo);
        setInternalEntityTwoToOne.accept(entityTwo, null);
    }
}