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
@Table(name = "doctor")
public class Doctor extends Person {

    @ToString.Exclude
    @OneToMany(mappedBy = "doctor", cascade = {CascadeType.ALL})
    private Set<Appointment> appointments;
}
