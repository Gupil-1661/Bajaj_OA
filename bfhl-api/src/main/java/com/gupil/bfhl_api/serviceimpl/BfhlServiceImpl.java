package com.gupil.bfhl_api.serviceimpl;

import com.gupil.bfhl_api.dto.BfhlRequest;
import com.gupil.bfhl_api.dto.BfhlResponse;
import com.gupil.bfhl_api.service.BfhlService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BfhlServiceImpl implements BfhlService {
    @Override
    public BfhlResponse processData(BfhlRequest request) {
        List<String> evenNumbers = new ArrayList<>();
        List<String> oddNumbers = new ArrayList<>();
        List<String> alphabets = new ArrayList<>();
        List<String> specialCharacters = new ArrayList<>();

        int sum = 0;
        StringBuilder allLetters = new StringBuilder();

        for (String item : request.getData()) {
            if (item.matches("\\d+")) {
                int number = Integer.parseInt(item);
                sum += number;
                if (number % 2 == 0) {
                    evenNumbers.add(item);
                } else {
                    oddNumbers.add(item);
                }
            } else if (item.matches("[a-zA-Z]+")) {
                alphabets.add(item.toUpperCase());
                allLetters.append(item);
            } else {
                specialCharacters.add(item);
            }
        }

        String reversed = allLetters.reverse().toString();
        StringBuilder concatString = new StringBuilder();

        for (int i = 0; i < reversed.length(); i++) {
            char ch = reversed.charAt(i);
            if (i % 2 == 0) {
                concatString.append(Character.toUpperCase(ch));
            } else {
                concatString.append(Character.toLowerCase(ch));
            }
        }

        return new BfhlResponse(
                true,
                "gupil_thappa_09112005",
                "gupil1661.be23@chitkara.edu.in",
                "2310991661",
                oddNumbers,
                evenNumbers,
                alphabets,
                specialCharacters,
                String.valueOf(sum),
                concatString.toString()
        );
    }
}
