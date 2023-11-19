package es.bulkynaden.common.helpers.bidirectional_helper;

import lombok.NonNull;

import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * <strong>BidirectionalHelper</strong>
 *
 * <p> The BidirectionalHelper class provides static utility methods for managing various types of
 * bidirectional relationships between entities. It encapsulates the complexity of linking
 * and unlinking entities in singular, one-to-many, many-to-one, and many-to-many relationships.
 *
 * <p> This class leverages specialized linker classes for each type of relationship,
 * ensuring a clean separation of concerns and adherence to the Single Responsibility Principle.
 *
 * <p> The methods in this class are designed to be generic and can work with any types of entities
 * as long as they are compatible with the provided functions and consumers.
 *
 * @author Javier Tomás Acín
 * @version 1.0
 * @since 2023-11-19
 */
public final class BidirectionalHelper {
    private static final SingularLinker SINGULAR_LINKER = new SingularLinker();
    private static final OneToManyLinker ONE_TO_MANY_LINKER = new OneToManyLinker();
    private static final ManyToOneLinker MANY_TO_ONE_LINKER = new ManyToOneLinker();
    private static final ManyToManyLinker MANY_TO_MANY_LINKER = new ManyToManyLinker();

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
    public static <T, U> void linkSingular(@NonNull T entityOne, @NonNull U entityTwo,
                                           Function<T, U> getCurrentEntityTwoFromOne,
                                           BiConsumer<T, U> setInternalEntityTwoToOne,
                                           BiConsumer<U, T> setInternalEntityOneToTwo) {
        SINGULAR_LINKER.link(entityOne, entityTwo, getCurrentEntityTwoFromOne, setInternalEntityTwoToOne, setInternalEntityOneToTwo);
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
    public static <T, U> void unLinkSingular(
            @NonNull T entityOne,
            Function<T, U> getCurrentEntityTwoFromOne,
            BiConsumer<T, U> setInternalEntityTwoToOne,
            BiConsumer<U, T> setInternalEntityOneToTwo) {
        SINGULAR_LINKER.unlink(entityOne, getCurrentEntityTwoFromOne, setInternalEntityTwoToOne, setInternalEntityOneToTwo);
    }

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
    public static <T, U> void linkOneToMany(
            @NonNull T entityOne, @NonNull U entityTwo,
            BiConsumer<T, U> addInternalEntityTwoToOne,
            BiConsumer<T, U> removeInternalEntityTwoFromCurrentOne,
            Function<U, T> getCurrentEntityFromTwo,
            BiConsumer<U, T> setInternalEntityTwoToOne) {
        ONE_TO_MANY_LINKER.link(entityOne, entityTwo, addInternalEntityTwoToOne, removeInternalEntityTwoFromCurrentOne, getCurrentEntityFromTwo, setInternalEntityTwoToOne);
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
    public static <T, U> void unlinkOneToMany(
            @NonNull T entityOne, @NonNull U entityTwo,
            BiConsumer<T, U> removeInternalEntityTwoFromOne,
            BiConsumer<U, T> setInternalEntityTwoToOne) {
        ONE_TO_MANY_LINKER.unlink(entityOne, entityTwo, removeInternalEntityTwoFromOne, setInternalEntityTwoToOne);
    }

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
    public static <T, U> void linkManyToOne(
            @NonNull T entityOne, @NonNull U entityTwo,
            BiConsumer<U, T> addInternalEntityOneToTwo,
            BiConsumer<U, T> removeInternalEntityTwoFromCurrentOne,
            Function<T, U> getCurrentEntityTwoFromOne,
            BiConsumer<T, U> setInternalEntityTwoToOne) {
        MANY_TO_ONE_LINKER.link(entityOne, entityTwo, addInternalEntityOneToTwo, removeInternalEntityTwoFromCurrentOne, getCurrentEntityTwoFromOne, setInternalEntityTwoToOne);
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
    public static <T, U> void unlinkManyToOne(
            @NonNull T entityOne, Function<T, U> getEntityTwoFromOne,
            BiConsumer<U, T> removeInternalEntityOneFromTwo,
            BiConsumer<T, U> setInternalEntityTwoToOne) {
        MANY_TO_ONE_LINKER.unlink(entityOne, getEntityTwoFromOne, removeInternalEntityOneFromTwo, setInternalEntityTwoToOne);
    }

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
    public static <T, U> void linkManyToMany(
            @NonNull T entityOne, @NonNull U entityTwo,
            BiConsumer<T, U> addInternalEntityTwoToOne,
            BiConsumer<U, T> addInternalEntityOneToTwo) {
        MANY_TO_MANY_LINKER.link(entityOne, entityTwo, addInternalEntityTwoToOne, addInternalEntityOneToTwo);
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
    public static <T, U> void unlinkManyToMany(
            @NonNull T entityOne, @NonNull U entityTwo,
            BiConsumer<T, U> removeInternalEntityTwoFromOne,
            BiConsumer<U, T> removeInternalEntityOneFromTwo) {
        MANY_TO_MANY_LINKER.unlink(entityOne, entityTwo, removeInternalEntityTwoFromOne, removeInternalEntityOneFromTwo);
    }
}