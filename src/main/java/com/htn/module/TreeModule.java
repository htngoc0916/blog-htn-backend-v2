package com.htn.module;

import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@NoArgsConstructor
public class TreeModule {
    public static <T extends TreeNode<T>> List<T> buildTree(List<T> nodes) {

        if (nodes == null || nodes.isEmpty()) {
            return List.of();
        }

        // Group theo parentCd (null hoặc blank coi là root)
        Map<String, List<T>> mapByParent = nodes.stream()
                .collect(Collectors.groupingBy(
                        node -> {
                            String parentCd = node.getParentCode();
                            return (parentCd == null || parentCd.isBlank()) ? "" : parentCd;
                        }
                ));

        // Root nodes: parentCd = null hoặc ""
        List<T> roots = mapByParent.getOrDefault("", List.of());

        // Build children đệ quy
        roots.forEach(root -> buildChildren(root, mapByParent));

        return roots;
    }

    private static <T extends TreeNode<T>> void buildChildren(T parent, Map<String, List<T>> mapByParent) {
        // Lấy danh sách các con theo parentCd
        List<T> children = mapByParent.getOrDefault(parent.getCode(), List.of());
        parent.setChildren(children);

        // Đệ quy cho từng con
        children.forEach(child -> buildChildren(child, mapByParent));
    }
}
