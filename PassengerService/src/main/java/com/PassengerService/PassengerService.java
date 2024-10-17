package com.PassengerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassengerService {
    @Autowired
    private PassengerRepository passengerRepository;

    public Passenger createPassenger(Passenger passenger) {
        return passengerRepository.save(passenger);
    }

    public Passenger getPassengerById(Long id) {
        return passengerRepository.findById(id)
                .orElse(null);
    }

    public Passenger updatePassenger(Long id, Passenger passengerDetails) {
        Passenger passenger = getPassengerById(id);
        passenger.setName(passengerDetails.getName());
        passenger.setEmail(passengerDetails.getEmail());
        passenger.setPhone(passengerDetails.getPhone());
        return passengerRepository.save(passenger);
    }

    public void deletePassenger(Long id) {
        Passenger passenger = getPassengerById(id);
        passengerRepository.delete(passenger);
    }

    public List<Passenger> getAllPassengers() {
        return passengerRepository.findAll();
    }
}
