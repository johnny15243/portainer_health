package de.jpb_edv.java.portainer_health.Model;

import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ContainerModel {
    @JsonProperty("Image")
    public String image;
    @JsonProperty("State")
    public String state;
    @JsonProperty("Status")
    public String status;
    @JsonProperty("Names")
    public List<String> names;

    public ContainerModel() {
    }

    public ContainerModel(String image, String state, String status, List<String> names) {
        this.image = image;
        this.state = state;
        this.status = status;
        this.names = names;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<String> getNames() {
        return this.names;
    }

    public void setNames(List<String> names) {
        this.names = names;
    }

    public ContainerModel image(String image) {
        setImage(image);
        return this;
    }

    public ContainerModel state(String state) {
        setState(state);
        return this;
    }

    public ContainerModel status(String status) {
        setStatus(status);
        return this;
    }

    public ContainerModel names(List<String> names) {
        setNames(names);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ContainerModel)) {
            return false;
        }
        ContainerModel containerModel = (ContainerModel) o;
        return Objects.equals(image, containerModel.image) && Objects.equals(state, containerModel.state) && Objects.equals(status, containerModel.status) && Objects.equals(names, containerModel.names);
    }

    @Override
    public int hashCode() {
        return Objects.hash(image, state, status, names);
    }

    @Override
    public String toString() {
        return "{" +
            " image='" + getImage() + "'" +
            ", state='" + getState() + "'" +
            ", status='" + getStatus() + "'" +
            ", names='" + getNames() + "'" +
            "}";
    }

}
