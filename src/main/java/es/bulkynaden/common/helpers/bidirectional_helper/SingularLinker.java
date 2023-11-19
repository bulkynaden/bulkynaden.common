package es.bulkynaden.common.helpers.bidirectional_helper;

import lombok.NonNull;

import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * <strong>SingularLinker</strong>
 *
 * <p> Manages singular bidirectional links between entities in a one-to-one relationship.
 * This class provides the functionality to establish and break links between two entities,
 * ensuring that each entity is linked to no more than one other entity.
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
public class SingularLinker {

    /**
     * Establishes a singular bidirectional link between two entities. This method ensures
     * that each entity in the pair is only linked to one other entity, forming a one-to-one relationship.
     * It automatically unlinks any existing relationship before establishing the new one.
     *
     * @param <T>                        The type of the first entity in the relationship.
     * @param <U>                        The type of the second entity in the relationship.
     * @param entityOne                  The first entity in the relationship.
     * @param entityTwo                  The second entity in the relationship.
     * @param getCurrentEntityTwoFromOne A function to retrieve the current entity of type U linked to entityOne.
     * @param setInternalEntityTwoToOne  A consumer that sets entityTwo within entityOne.
     * @param setInternalEntityOneToTwo  A consumer that sets entityOne within entityTwo.
     * @throws NullPointerException if any of the non-nullable parameters are null.
     */
    public <T, U> void link(@NonNull T entityOne, @NonNull U entityTwo,
                            Function<T, U> getCurrentEntityTwoFromOne,
                            BiConsumer<T, U> setInternalEntityTwoToOne,
                            BiConsumer<U, T> setInternalEntityOneToTwo) {
        U currentEntityTwo = getCurrentEntityTwoFromOne.apply(entityOne);

        if (currentEntityTwo != null) {
            setInternalEntityOneToTwo.accept(currentEntityTwo, null);
        }

        setInternalEntityTwoToOne.accept(entityOne, entityTwo);
        setInternalEntityOneToTwo.accept(entityTwo, entityOne);
    }

    /**
     * Breaks an existing singular bidirectional link between two entities. This method is used
     * to undo the linkage established by the link method in a one-to-one relationship.
     * It sets the linked entity reference in each entity to null, effectively removing the relationship.
     *
     * @param <T>                        The type of the first entity in the relationship.
     * @param <U>                        The type of the second entity in the relationship.
     * @param entityOne                  The first entity in the relationship.
     * @param getCurrentEntityTwoFromOne A function to retrieve the current entity of type U linked to entityOne.
     * @param setInternalEntityTwoToOne  A consumer that removes the link to entityTwo within entityOne.
     * @param setInternalEntityOneToTwo  A consumer that removes the link to entityOne within entityTwo.
     * @throws NullPointerException if any of the non-nullable parameters are null.
     */
    public <T, U> void unlink(@NonNull T entityOne,
                              Function<T, U> getCurrentEntityTwoFromOne,
                              BiConsumer<T, U> setInternalEntityTwoToOne,
                              BiConsumer<U, T> setInternalEntityOneToTwo) {
        setInternalEntityTwoToOne.accept(entityOne, null);

        U currentEntity = getCurrentEntityTwoFromOne.apply(entityOne);
        if (currentEntity != null) {
            setInternalEntityOneToTwo.accept(currentEntity, null);
        }
    }
}