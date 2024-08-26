package com.furniture.shopping.service.impl;

import com.furniture.shopping.model.dao.NodeMapper;
import com.furniture.shopping.model.pojo.Node;
import com.furniture.shopping.service.NodeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional(propagation = Propagation.NOT_SUPPORTED,readOnly = true)
public class NodeServiceImpl implements NodeService {
    @Resource
    private NodeMapper nodeMapper;

    @Override
    public List<Node> selectByRole(Integer roleType){
        List<Node> nodes = nodeMapper.selectByRole(roleType);
        return nodes;
    }
}
