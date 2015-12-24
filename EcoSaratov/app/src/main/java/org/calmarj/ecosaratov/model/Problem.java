package org.calmarj.ecosaratov.model;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

@Table(name = "Problems")
public class Problem extends Model {

    @Column(name = "coordinates")
    private String coordinates;

    @Column(name = "description")
    private String description;

    @Column(name = "status")
    private String status;

    public Problem() {
        super();
    }

    public Problem(String coordinates, String description, String status) {
        super();
        this.coordinates = coordinates;
        this.description = description;
        this.status = status;
    }

    public String getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(String coordinates) {
        this.coordinates = coordinates;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}