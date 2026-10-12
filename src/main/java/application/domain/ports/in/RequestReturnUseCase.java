package application.domain.ports.in;

import application.domain.entities.ReturnRequest;

public interface RequestReturnUseCase {
    ReturnRequest request(ReturnRequest request);
}
