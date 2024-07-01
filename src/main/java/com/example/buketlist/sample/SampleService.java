package com.example.buketlist.sample;

import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@ToString
@Log4j2
@Service
@RequiredArgsConstructor
public class SampleService {

    private final SampleDAO sampleDAO;
}
