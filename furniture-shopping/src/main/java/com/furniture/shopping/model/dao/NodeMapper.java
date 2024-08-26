package com.furniture.shopping.model.dao;

import com.furniture.shopping.model.pojo.Node;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NodeMapper {
    List<Node> selectByRole(Integer nodeType);
}
