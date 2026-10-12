package application.adapters.rest.controllers;

import application.domain.entities.Order;
import application.domain.ports.in.RequestReturnUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/returns")
public class ReturnController {
    private final RequestReturnUseCase requestReturnUseCase;

    public ReturnController(RequestReturnUseCase requestReturnUseCase) {
        this.requestReturnUseCase = requestReturnUseCase;
    }

    @PostMapping
    public ResponseEntity<Order> request(@RequestBody Order order) {
        return ResponseEntity.ok(requestReturnUseCase.request(order));
    }
}
