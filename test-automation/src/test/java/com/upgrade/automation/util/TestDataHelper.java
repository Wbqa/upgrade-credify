package com.upgrade.automation.util;

import org.apache.commons.lang3.RandomStringUtils;

public class TestDataHelper {

    public String generateRandomFirstName(){
        return RandomStringUtils.randomAlphabetic(6);
    }
}
