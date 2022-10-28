package com.tkachev.patientappointmentsystem.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "patient")
public class Patient extends Person {

    @ToString.Exclude
    @OneToMany(mappedBy = "patient", cascade = {CascadeType.DETACH, CascadeType.REFRESH})
    private Set<Appointment> appointments;
}
