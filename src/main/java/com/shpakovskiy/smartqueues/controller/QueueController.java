package com.shpakovskiy.smartqueues.controller;

import com.shpakovskiy.smartqueues.entity.Queue;
import com.shpakovskiy.smartqueues.service.QueueService;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class QueueController {

    private final QueueService queueService;
    private final SimpMessagingTemplate simpMessagingTemplate;

    public QueueController(QueueService queueService,
                           SimpMessagingTemplate simpMessagingTemplate) {

        this.queueService = queueService;
        this.simpMessagingTemplate = simpMessagingTemplate;
    }

    @RequestMapping("/queue/{queueId}")
    private String showQueue(Model model,
                             @PathVariable String queueId) {

        Queue queue = queueService.getQueueByAccessLink(queueId);
        System.out.println(queue);

        model.addAttribute("queue", queue);

        return "queue";
    }

    @MessageMapping("/switch")
    public void switchLampState(Queue queue) {
        System.out.println(queue);
        simpMessagingTemplate.convertAndSend("/room/switch-state/" + queue.getAccessLink(), queue);
    }
}
