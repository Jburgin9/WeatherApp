package org.quietlip.classexercises.model;

import java.util.List;

public class AerisWeatherResponse {
    private boolean success;
    private List<FirstResponse> response;

    public boolean getSuccess() {
        return success;
    }

    public List<FirstResponse> getResponse() {
        return response;
    }
}
