package com.dee.basekit.mvc;

import java.util.List;

public interface ITreeModel<T> {
    String getId();

    String getParentId();

    List<T> getChildren();

    void setChildren(List<T> list);
}
