package com.edw.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

/**
 * <pre>
 *     com.edw.routes.TimerRoute
 * </pre>
 *
 * @author Muhammad Edwin < edwin at redhat dot com >
 * 26 Jul 2020 17:12
 */
@Component
public class TimerRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("timer:myTimer?period=1000")
                .log("Ping")
                .to("https://run.mocky.io/v3/f7afdc9b-d3ab-488a-932c-ecd95a216e82"); // fire to echo api

        from("timer:localhostTimer?repeatCount=3&period=1000")
                .log("Warming Up")
                .to("http://127.0.0.1:8080/api/hello-world"); // warming up the app
    }
}
