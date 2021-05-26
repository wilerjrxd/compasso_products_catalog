package br.com.compasso.desafio.productscatalog.model;

public class ErrorModel {

    private Integer status_code;
    private String message;

    public ErrorModel(Integer status_code, String message) {
        this.status_code = status_code;
        this.message = message;
    }

    public ErrorModel() {
    }

    public Integer getStatus_code() {
        return status_code;
    }

    public void setStatus_code(Integer status_code) {
        this.status_code = status_code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
