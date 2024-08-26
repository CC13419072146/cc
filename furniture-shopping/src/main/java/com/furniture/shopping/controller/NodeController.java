package com.furniture.shopping.controller;

import com.furniture.shopping.common.ApiRestResponse;
import com.furniture.shopping.model.pojo.Node;
import com.furniture.shopping.service.NodeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 节点控制器
 */
@Controller
@RequestMapping("/api/node")
public class NodeController {
    @Resource
    private NodeService nodeService;

    @GetMapping("/by/role")
    @ResponseBody
    public ApiRestResponse<?> selectByRole(@RequestParam("nodeType") Integer nodeType){
        List<Node> nodes = nodeService.selectByRole(nodeType);
        Map<String,Object> map=new LinkedHashMap<>();
        map.put("list",nodes);
        return ApiRestResponse.success(map);
    }
}
