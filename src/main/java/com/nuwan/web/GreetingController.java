package com.nuwan.web;

import com.nuwan.model.Greeting;
import com.nuwan.model.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class GreetingController {

    /**
     * The @MessageMapping annotation ensures that if a message is sent to destination "/hello",
     * then the greeting() method is called.
     * The return value is broadcast to all subscribers to "/topic/greetings" as specified
     * in the @SendTo annotation.
     *
     * @param message
     * @return
     * @throws Exception
     */
    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(Message message) throws Exception {
        Thread.sleep(3000);
        return new Greeting("Hello, " + message.getName() + "!");
    }

}
