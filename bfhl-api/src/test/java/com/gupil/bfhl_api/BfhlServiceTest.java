package com.gupil.bfhl_api;

import com.gupil.bfhl_api.dto.BfhlRequest;
import com.gupil.bfhl_api.dto.BfhlResponse;
import com.gupil.bfhl_api.serviceimpl.BfhlServiceImpl;
import org.junit.jupiter.api.Test;

import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class BfhlServiceTest {
    @Test

    void testExampleA() {
        BfhlServiceImpl service = new BfhlServiceImpl();

        BfhlRequest request = new BfhlRequest();
        request.setData(List.of("a", "1", "334", "4", "R", "$"));

        BfhlResponse response = service.processData(request);

        assertTrue(response.isIs_success());
        assertEquals(List.of("1"), response.getOdd_numbers());
        assertEquals(List.of("334", "4"), response.getEven_numbers());
        assertEquals(List.of("A", "R"), response.getAlphabets());
        assertEquals(List.of("$"), response.getSpecial_characters());
        assertEquals("339", response.getSum());
        assertEquals("Ra", response.getConcat_string());
    }
}
