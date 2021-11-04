package ru.demetriuzz.sb.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.demetriuzz.sb.service.api.Message;

import javax.servlet.ServletRequest;

@RestController
@RequestMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE)
public class SbServiceController {

    private final Logger logger = LoggerFactory.getLogger(SbServiceController.class);

    @GetMapping(path = {"/", "/hello"})
    public Message getHello(ServletRequest request) {
        logger.info("getHello: from host [{}] port [{}]", request.getRemoteHost(), request.getRemotePort());
        return new Message(request.getRemoteHost() + ":" + request.getRemotePort() + ". Hello!");
    }

}
