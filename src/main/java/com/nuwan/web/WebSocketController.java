package com.nuwan.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * WebSocket is a very thin, lightweight layer above TCP.
 */
@Controller
@RequestMapping(value = "/web-socket-support/web-socket-support")
public class WebSocketController {

  /**
   * Serve the main page
   */
  @RequestMapping(value = "", method = RequestMethod.GET)
  public String home() {
    return "websocket/basic-greeting/home";
  }

}
