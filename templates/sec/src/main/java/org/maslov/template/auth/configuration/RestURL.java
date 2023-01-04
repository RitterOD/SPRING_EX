package org.maslov.template.auth.configuration;

public interface RestURL {
    String API_V1 = "/api/v1";
    String API_V1_AUTH_REL = "/auth";

    String API_V1_DIAG_REL = "/diag";

    String API_V1_HOME_REL = "/home";
    String API_V1_CREATE_REL = "/create";

    String API_V1_AUTH = API_V1 + API_V1_AUTH_REL;
    String API_V1_AUTH_CREATE = API_V1 + API_V1_AUTH_REL + API_V1_CREATE_REL;
    String API_V1_DIAG = API_V1 + API_V1_DIAG_REL;
    String API_V1_HOME = API_V1 + API_V1_HOME_REL;



}
