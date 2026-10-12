package application.adapters.useCases;

import application.domain.entities.ReturnRequest;
import application.domain.ports.in.RequestReturnUseCase;
import application.domain.ports.out.ReturnRepositoryPort;
import application.domain.services.ReturnService;

public class DefaultReturnUseCase implements RequestReturnUseCase {
    private final ReturnRepositoryPort returnRepositoryPort;
    private final ReturnService returnService;

    public DefaultReturnUseCase(
            ReturnRepositoryPort returnRepositoryPort,
            ReturnService returnService) {
        this.returnRepositoryPort = returnRepositoryPort;
        this.returnService = returnService;
    }

    @Override
    public ReturnRequest request(ReturnRequest request) {
        if (request == null) {
            throw new IllegalArgumentException("Return request is required.");
        }
        ReturnRequest validated = returnService.request(
                request.getOrder(),
                request.getProduct(),
                request.getReason(),
                request.getAmount());
        return returnRepositoryPort.save(validated);
    }
}
