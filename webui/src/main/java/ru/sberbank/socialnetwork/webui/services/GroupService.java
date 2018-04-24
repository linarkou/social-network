package ru.sberbank.socialnetwork.webui.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.sberbank.socialnetwork.webui.client.ChatServiceClient;
import ru.sberbank.socialnetwork.webui.models.Group;

import java.util.ArrayList;
import java.util.List;

@Service
public class GroupService {
    @Autowired
    ChatServiceClient chatServiceClient;

    public static List<Group> getGroups(String userEmail) {
        List<Group> groups = new ArrayList<>();
        Group group = new Group();
        group.setAmount(5);
        group.setGroupName("Java");
        group.setId("1");
        groups.add(group);
        return groups;
    }

    public static Group createGroup(String authToken, Group group) {
        return new Group();
    }
}