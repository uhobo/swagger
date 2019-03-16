package il.co.main.model;

public class InputOption {
    private String name;
    private String description;
    private Boolean required;
    private String defaultValue;

    public InputOption() {}

    public InputOption(String name, String description, String defaultValue, Boolean required) {
        this.name = name;
        this.description = description;
        this.defaultValue = defaultValue;
        this.required = required;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getRequired() {
        return required;
    }

    public void setRequired(Boolean required) {
        this.required = required;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }
}