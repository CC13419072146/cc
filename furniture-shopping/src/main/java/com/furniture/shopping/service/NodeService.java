package com.furniture.shopping.service;

import com.furniture.shopping.model.pojo.Node;

import java.util.List;

/**
 * 节点逻辑类
 */
public interface NodeService {
    List<Node> selectByRole(Integer roleType);
}
