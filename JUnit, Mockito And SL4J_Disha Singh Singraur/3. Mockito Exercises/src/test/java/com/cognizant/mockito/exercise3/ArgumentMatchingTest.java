package com.cognizant.mockito.exercise3;

import com.cognizant.mockito.common.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class ArgumentMatchingTest {
    @Test
    public void testArgumentMatchers() {
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        when(mockApi.fetchDetails(anyInt())).thenReturn("Details for ID");

        MyService service = new MyService(mockApi);
        String result = service.getDetails(105);

        assertEquals("Details for ID", result);
        verify(mockApi).fetchDetails(eq(105));
    }
}
