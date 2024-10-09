    package edu.ucsb.cs156.spring.hello;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * A simple controller to handle HTTP requests to the application.
 */

@RestController
public class HelloController {

    /**
     * Handle a GET request to the root URL (home page)
     * 
     * @return home page content as HTML
     */

    @GetMapping("/")
    public String index() {
        return """
                <h1>Greetings from Spring Boot!</h1>
                <p>This is a simple example of a Spring Boot application.</p>
                <p><a href="/info">Developer Info</a></p>
                """;
    }

    /**
     * Handle a GET request to the /info URL
     * 
     * @return HTML content with developer info
     */

    @GetMapping("/info")
    public String info() {
        return String.format("""
                <h1>Developer Info</h1>
                <ul>
                  <li>Name: %s</li>
                  <li>Github ID: <a href="https://github.com/%s">%s</a></li>
                  <li>Team: <a href="/team">%s</a></li>
                </ul>
                """, Developer.getName(), Developer.getGithubId(), Developer.getGithubId(), Developer.getTeam().getName());
    }

    /**
     * Handle a GET request to the /team URL
     * 
     * @return Team object in JSON format
     */

    @GetMapping("/team")
    public Team team() {
        return Developer.getTeam();
    }

  

}
