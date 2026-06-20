package com.cognizant.mockito.exercise6;

import com.cognizant.mockito.common.*;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;

public class InteractionOrderTest {
    @Test
    public void testOrderVerification() {
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        MyService service = new MyService(mockApi);

        service.processSession();

        InOrder inOrder = inOrder(mockApi);
        inOrder.verify(mockApi).start();
        inOrder.verify(mockApi).stop();
    }
}
