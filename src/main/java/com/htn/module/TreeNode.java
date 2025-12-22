package com.htn.module;

import java.util.List;

public interface TreeNode<T extends TreeNode<T>> {
    // id của node (codeCd, menuId, ...)
    String getCode();
    // parentCd (parentCd, parentMenuId, ...)
    String getParentCode();

    void setChildren(List<T> children);
    List<T> getChildren();
}