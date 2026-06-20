package com.cognizant.mockito.exercise7;

import com.cognizant.mockito.common.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class VoidMethodExceptionTest {
    @Test
    public void testVoidMethodThrowsException() {
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        doThrow(new RuntimeException("API Failure")).when(mockApi).logMessage("FAIL");

        MyService service = new MyService(mockApi);

        RuntimeException ex = assertThrows(
            RuntimeException.class,
            () -> service.log("FAIL")
        );
        assertEquals("API Failure", ex.getMessage());
    }
}
