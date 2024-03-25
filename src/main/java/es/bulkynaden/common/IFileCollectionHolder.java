package es.bulkynaden.common;

import lombok.NonNull;

import java.util.Collection;

/**
 * The {@code IFileCollectionHolder} interface represents an object that can hold a collection of {@link IFile} objects.
 * It provides methods to retrieve, add, and remove files from the collection.
 */
public interface IFileCollectionHolder {

    /**
     * Retrieves the collection of files held by the file collection holder.
     *
     * @return A collection of {@link IFile} objects.
     */
    Collection<IFile> getFiles();

    /**
     * Sets the collection of files for the file collection holder.
     *
     * @param files The collection of files to be set.
     * @param <T>   The type of files in the collection. It must extend the {@link IFile} interface.
     */
    default <T extends IFile> void setFiles(Collection<T> files) {
        files.forEach(this::addFile);
    }

    /**
     * Adds a file to the collection of files held by the file collection holder.
     *
     * @param file The {@link IFile} object to be added to the collection.
     *             Must not be null.
     */
    void addFile(@NonNull IFile file);

    /**
     * Removes a file from the collection of files held by the file collection holder.
     *
     * @param file The {@link IFile} object to be removed from the collection.
     *             Must not be null.
     */
    void removeFile(@NonNull IFile file);
}