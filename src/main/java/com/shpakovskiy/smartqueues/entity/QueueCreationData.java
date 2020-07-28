package com.shpakovskiy.smartqueues.entity;

import lombok.Data;

@Data
public class QueueCreationData {
    private String title;
    private int maxPlaces;
    private String startDate;
    private String startTime;
}
