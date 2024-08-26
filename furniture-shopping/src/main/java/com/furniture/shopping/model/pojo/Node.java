package com.furniture.shopping.model.pojo;

public class Node {
    private Integer nodeId;

    private Integer nodeType;

    private String nodeDesc;

    private String nodeUrl;

    private String nodeIcon;

    public String getNodeIcon() {
        return nodeIcon;
    }

    public void setNodeIcon(String nodeIcon) {
        this.nodeIcon = nodeIcon;
    }

    public Integer getNodeId() {
        return nodeId;
    }

    public void setNodeId(Integer nodeId) {
        this.nodeId = nodeId;
    }

    public Integer getNodeType() {
        return nodeType;
    }

    public void setNodeType(Integer nodeType) {
        this.nodeType = nodeType;
    }

    public String getNodeDesc() {
        return nodeDesc;
    }

    public void setNodeDesc(String nodeDesc) {
        this.nodeDesc = nodeDesc;
    }

    public String getNodeUrl() {
        return nodeUrl;
    }

    public void setNodeUrl(String nodeUrl) {
        this.nodeUrl = nodeUrl;
    }
}
