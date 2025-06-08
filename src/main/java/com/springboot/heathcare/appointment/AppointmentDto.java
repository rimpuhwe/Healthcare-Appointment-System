package com.springboot.heathcare.appointment;

import jakarta.validation.constraints.Future;
import lombok.Value;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO for {@link Appointment}
 */
@Value
public class AppointmentDto  {
    @Future(message = "appointment must be in future date")
    LocalDateTime appointmentDate;
    AppointmentStatus status;
    @Length(message = "Note exceed 500 characters ", min = 0, max = 500)
    String notes;
}