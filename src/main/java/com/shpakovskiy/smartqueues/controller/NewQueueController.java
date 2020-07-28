package com.shpakovskiy.smartqueues.controller;

import com.shpakovskiy.smartqueues.entity.QueueCreationData;
import com.shpakovskiy.smartqueues.service.QueueService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NewQueueController {

    private final QueueService queueService;

    public NewQueueController(QueueService queueService) {
        this.queueService = queueService;
    }

    @RequestMapping("/")
    private String redirectToNew() {
        return "redirect:/new";
    }

    @RequestMapping("/new")
    private String newQueue(Model model) {
        QueueCreationData queueCreationData = new QueueCreationData();
        model.addAttribute("creationData", queueCreationData);
        return "new-queue";
    }

    @RequestMapping("/create")
    private String createRoom(@ModelAttribute("creationData") QueueCreationData creationData) {
        return "redirect:/queue/" + queueService.createNewQueue(creationData);
    }
}