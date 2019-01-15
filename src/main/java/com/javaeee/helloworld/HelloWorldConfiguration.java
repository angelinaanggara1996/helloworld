package com.javaeee.helloworld;

import io.dropwizard.Configuration;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.*;

public class HelloWorldConfiguration extends Configuration {
    // TODO: implement service configuration
	@NotEmpty
    private String template;

    @NotEmpty
    private String defaultName = "Stranger";

    @NotEmpty
    private String defaultAddr = "NONE";
    
    @JsonProperty
    public String getTemplate() {
        return template;
    }

    @JsonProperty
    public void setTemplate(String template) {
        this.template = template;
    }

    @JsonProperty
    public String getDefaultName() {
        return defaultName;
    }

    @JsonProperty
    public void setDefaultName(String name) {
        this.defaultName = name;
    }

    @JsonProperty
    public String getDefaultAddr() {
        return defaultAddr;
    }

    @JsonProperty
    public void setDefaultAddr(String addr) {
        this.defaultAddr = addr;
    }
}
