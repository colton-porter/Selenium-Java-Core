package com.orasi.core.angular;

import org.openqa.selenium.WebDriverException;

/*
 * Original Code from https://github.com/paul-hammant/ngWebDriver
 */

@SuppressWarnings("serial")
public class VariableNotInScopeException extends WebDriverException {
    public VariableNotInScopeException(String msg) {
        super(msg);
    }
}
