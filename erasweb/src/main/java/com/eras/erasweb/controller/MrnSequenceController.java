package com.eras.erasweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.eras.erasweb.service.impl.MrnSequenceService;

@RestController
public class MrnSequenceController {

    @Autowired
    private MrnSequenceService mrnSequenceService;

    @GetMapping("/ajax/get-next-sequence")
    public Integer getNextSequence(@RequestParam String mrnNo) {
        return mrnSequenceService.getCurrentMaxSequenceNumber(mrnNo) + 1;
    }
}