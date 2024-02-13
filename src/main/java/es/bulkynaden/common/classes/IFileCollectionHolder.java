package es.bulkynaden.common.classes;

import java.util.Collection;

public interface IFileCollectionHolder {

    Collection<IFile> getFiles();

    default <T extends IFile> void setFiles(Collection<T> files) {
        files.forEach(this::addFile);
    }

    void addFile(IFile file);

    void removeFile(IFile file);
}