package application.infrastructure.security;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/h2-console")
public class H2ConsoleController {

    @GetMapping({"", "/"})
    public ResponseEntity<String> h2Console() {
        return ResponseEntity.ok("<html><body><h1>H2 Console</h1><p>Local development database console.</p></body></html>");
    }
}
