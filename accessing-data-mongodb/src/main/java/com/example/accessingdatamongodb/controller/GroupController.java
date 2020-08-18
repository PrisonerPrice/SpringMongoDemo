package com.example.accessingdatamongodb.controller;

import com.example.accessingdatamongodb.domain.Customer;
import com.example.accessingdatamongodb.domain.Group;
import com.example.accessingdatamongodb.service.GroupService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "Group Controller")
@RestController
@RequestMapping(value = {"/group"})
//@CrossOrigin
public class GroupController {

    @Autowired
    GroupService groupService;

    @PostMapping(value = "", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public void addAGroup(@RequestBody Group group) {
        groupService.addAGroup(group);
    }

    @GetMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Group> getAllGroups() {
        List<Group> groups = groupService.getAllGroups();
        return groups;
    }

    @GetMapping(value = "/{groupName}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Customer> getCustomersBelongToTheGroup(@PathVariable String groupName) {
        Group group = groupService.getGroupByName(groupName);
        return groupService.getCustomersBelongToTheGroup(group);
    }
}
