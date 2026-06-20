package com.cognizant.mockito.exercise4;

import com.cognizant.mockito.common.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;

public class VoidMethodTest {
    @Test
    public void testVoidMethod() {
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        doNothing().when(mockApi).logMessage(anyString());

        MyService service = new MyService(mockApi);
        service.log("App Started");

        verify(mockApi).logMessage("App Started");
    }
}
