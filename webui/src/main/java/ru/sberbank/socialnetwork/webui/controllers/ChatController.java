package ru.sberbank.socialnetwork.webui.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChatController {
    @GetMapping("/groups")
    public String showGroups() {
        return "groups";
    }

    @GetMapping("/chats")
    public String showChats() {
        return "chats";
    }
}