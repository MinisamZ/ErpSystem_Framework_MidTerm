package com.example.ERP.System.model.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RestResponse extends HashMap<String, Object> {


    public static int NOT_FOUND = 404;
    public static int CLIENT_ACCOUNT_DISABLED = 403;
    public static int STATUS_OK = 200;
    public static int ALREADY_REPORTED = 208;
    public static int STATUS_VALIDATION_ERROR = 400;
    public static int STATUS_REDIRECT = 300;
    public static int STATUS_BAD_REQUEST = 400;
    public static int STATUS_UNAUTHORIZED = 401;
    public static int STATUS_FORBIDDEN = 403;
    public static int METHOD_NOT_ALLOWED = 403;
    public static int REQUEST_TIMEOUT = 408;
    public static int STATUS_INTERNAL_SERVER_ERROR = 500;
    public static int STATUS_ERROR = 520;

    public static RestResponse create(int code) {
        RestResponse response = new RestResponse();
        response.put("code", code);
        return response;
    }

    public static RestResponse ok() {
        return create(STATUS_OK);
    }

    public static RestResponse unauthorized() {
        return create(STATUS_UNAUTHORIZED);
    }

    public static RestResponse accessDenied() {
        return create(STATUS_FORBIDDEN);
    }

    public static RestResponse ok(Object data) {
        return create(STATUS_OK).addData(data);
    }

    public static RestResponse already(Object data) {
        return create(ALREADY_REPORTED).addData(data);
    }

    public static RestResponse already() {
        return create(ALREADY_REPORTED);
    }

    public static RestResponse okStatus(Object data) {
        return create(STATUS_OK).addData(new ResponseStatus(data));
    }

    public static RestResponse okStatus(Object data, boolean needChangePassword) {
        return create(STATUS_OK).addData(new ResponseStatus(data, needChangePassword));
    }

    public static RestResponse badRequest(Object data) {
        return create(STATUS_BAD_REQUEST).addData(data);
    }

    public static RestResponse serverError(Object data) {
        return create(STATUS_INTERNAL_SERVER_ERROR).addData(data);
    }

    public static RestResponse notFound() {
        return create(NOT_FOUND);
    }


    public static RestResponse validationError(Map<String, String> errors) {
        return create(STATUS_VALIDATION_ERROR).addValidationError(errors);
    }

    public static RestResponse validationError(Object errors) {
        return create(STATUS_VALIDATION_ERROR).addValidationError(errors);
    }

    public static RestResponse error(ErrorDto error) {
        return create(STATUS_ERROR).addData(error);
    }

    public static RestResponse error(Object error) {
        return create(STATUS_ERROR).addData(error);
    }


    public RestResponse addBusinessLogicError(List<String> errors) {
        put("businessLogicErrors", errors);
        return this;
    }

    public RestResponse addValidationError(Map<String, String> errors) {
        put("validationErrors", errors);
        return this;
    }

    public RestResponse addValidationError(Object errors) {
        put("validationErrors", errors);
        return this;
    }

    public RestResponse addData(Object data) {
        put("data", data);
        return this;
    }

    public RestResponse addToken(Object data) {
        put("token", data);
        return this;
    }

    public RestResponse addInfo(Object data) {
        put("info", data);
        return this;
    }

}
