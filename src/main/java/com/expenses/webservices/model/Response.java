package com.expenses.webservices.model;

import com.fasterxml.jackson.annotation.*;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "response")
@JsonRootName("response")
@JsonTypeName("response")
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.WRAPPER_OBJECT)
public class Response<T> {

    private List<String> errors = new ArrayList<String>();
    private List<T> result = new ArrayList<T>();

    public List<String> getErrors() {
        return errors;
    }

    public void addResult(T aResult){
        result.add(aResult);
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }

    @JsonProperty("results")
    @JsonTypeInfo(
            use = JsonTypeInfo.Id.NAME,
            include = JsonTypeInfo.As.WRAPPER_OBJECT
    )
    @XmlElementWrapper(name = "results")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @XmlElementRefs({@XmlElementRef(type = XmlElementRef.DEFAULT.class)})
    public List<T> getResult() {
        return result;
    }

    public void setResult(List<T> result) {
        this.result = result;
    }
}
