package es.bulkynaden.common.helpers.bidirectional_helper;

import lombok.NonNull;

import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * <strong>ManyToOneLinker</strong>
 *
 * <p> Manages many-to-one bidirectional links between entities in a many-to-one relationship.
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
public class ManyToOneLinker {

    /**
     * Establishes a many-to-one bidirectional link between two entities. This method is used when
     * multiple entities of one type (entityOne) can be linked to a single entity of another type (entityTwo),
     * with each entityOne linked to only one entityTwo.
     *
     * @param <T>                                   The type of the entities that can be linked to only one entity.
     * @param <U>                                   The type of the entity that can link to multiple entities.
     * @param entityOne                             The entity to be linked to entityTwo.
     * @param entityTwo                             The entity that can link to multiple entities.
     * @param addInternalEntityOneToTwo             A consumer that adds entityOne to the collection within entityTwo.
     * @param removeInternalEntityTwoFromCurrentOne A consumer that removes entityOne from its current entityTwo, if any.
     * @param getCurrentEntityTwoFromOne            A function to get the current entityTwo linked to entityOne.
     * @param setInternalEntityTwoToOne             A consumer that sets the link of entityOne to entityTwo.
     * @throws NullPointerException if any of the non-nullable parameters are null.
     */
    public <T, U> void link(@NonNull T entityOne, @NonNull U entityTwo,
                            BiConsumer<U, T> addInternalEntityOneToTwo,
                            BiConsumer<U, T> removeInternalEntityTwoFromCurrentOne,
                            Function<T, U> getCurrentEntityTwoFromOne,
                            BiConsumer<T, U> setInternalEntityTwoToOne) {
        U currentEntityTwo = getCurrentEntityTwoFromOne.apply(entityOne);

        if (currentEntityTwo != null && !currentEntityTwo.equals(entityOne)) {
            removeInternalEntityTwoFromCurrentOne.accept(currentEntityTwo, entityOne);
        }

        addInternalEntityOneToTwo.accept(entityTwo, entityOne);
        setInternalEntityTwoToOne.accept(entityOne, entityTwo);
    }

    /**
     * Breaks an existing many-to-one bidirectional link between two entities. This method is used
     * to remove an entity (entityOne) from the collection of linked entities in entityTwo.
     *
     * @param <T>                            The type of the entities that can be linked to only one entity.
     * @param <U>                            The type of the entity that can link to multiple entities.
     * @param entityOne                      The entity to be unlinked from entityTwo.
     * @param getEntityTwoFromOne            A function to get the current entityTwo linked to entityOne.
     * @param removeInternalEntityOneFromTwo A consumer that removes entityOne from the collection within entityTwo.
     * @param setInternalEntityTwoToOne      A consumer that removes the link of entityOne to entityTwo.
     * @throws NullPointerException if any of the non-nullable parameters are null.
     */
    public <T, U> void unlink(@NonNull T entityOne, Function<T, U> getEntityTwoFromOne,
                              BiConsumer<U, T> removeInternalEntityOneFromTwo,
                              BiConsumer<T, U> setInternalEntityTwoToOne) {
        U currentEntity = getEntityTwoFromOne.apply(entityOne);

        if (currentEntity != null) {
            removeInternalEntityOneFromTwo.accept(currentEntity, entityOne);
        }

        setInternalEntityTwoToOne.accept(entityOne, null);
    }
}