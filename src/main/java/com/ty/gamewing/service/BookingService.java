package com.ty.gamewing.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.gamewing.dao.BookingDao;
import com.ty.gamewing.dao.CourtDao;
import com.ty.gamewing.dao.UserDao;
import com.ty.gamewing.dto.Booking;
import com.ty.gamewing.dto.Court;
import com.ty.gamewing.dto.User;
import com.ty.gamewing.entity.ResponseStructure;
import com.ty.gamewing.exception.NoSuchBookingFoundException;
import com.ty.gamewing.exception.NoSuchClubExistException;
import com.ty.gamewing.exception.NoSuchCourtFoundException;
import com.ty.gamewing.exception.NoSuchUserFoundException;

@Service
public class BookingService {

	@Autowired
	private BookingDao dao;
	@Autowired
	private CourtDao courtDao;

	@Autowired
	private UserDao userDao;

	public ResponseEntity<ResponseStructure<Booking>> saveBooking(int courtId, String email, Booking booking) {
		Court court = courtDao.findCourtById(courtId);

		if (court != null) {
			ArrayList<Booking> list = new ArrayList<Booking>();
			Booking booking1 = dao.saveBooking(booking);
			User user = userDao.findUserByEmail(email);
			if (user != null) {
				booking.setUser(user);
			} else {
				throw new NoSuchUserFoundException();
			}

			List<Booking> bookings = court.getBookings();
			if (bookings != null) {
				bookings.add(booking);
				court.setBookings(bookings);
			} else {
				list.add(booking1);
				court.setBookings(list);
			}

			courtDao.saveCourt(court);

			ResponseStructure<Booking> structure = new ResponseStructure<Booking>();
			structure.setStatusCode(HttpStatus.CREATED.value());
			structure.setData(booking1);
			structure.setMessage("Success");

			return new ResponseEntity<ResponseStructure<Booking>>(structure, HttpStatus.CREATED);
		} else {
			throw new NoSuchClubExistException();
		}
	}

	public ResponseEntity<ResponseStructure<Booking>> findBookingById(int id) {
		Booking booking = dao.findBookingById(id);
		if (booking != null) {
			ResponseStructure<Booking> structure = new ResponseStructure<Booking>();
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setData(booking);
			structure.setMessage("Success");

			return new ResponseEntity<ResponseStructure<Booking>>(structure, HttpStatus.OK);
		} else {
			throw new NoSuchBookingFoundException();
		}
	}

	public ResponseEntity<ResponseStructure<List<Booking>>> findAllBooking() {
		List<Booking> bookings = dao.findAllBooking();
		if (bookings != null) {
			ResponseStructure<List<Booking>> structure = new ResponseStructure<List<Booking>>();
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setData(bookings);
			structure.setMessage("Success");

			return new ResponseEntity<ResponseStructure<List<Booking>>>(structure, HttpStatus.OK);
		} else {
			throw new NoSuchBookingFoundException();
		}
	}

	public ResponseEntity<ResponseStructure<List<Booking>>> findBookingByUserId(int userId) {
		User user = userDao.findUserById(userId);
		if (user != null) {
			List<Booking> bookings = user.getBookings();
			if (bookings != null) {
				ResponseStructure<List<Booking>> structure = new ResponseStructure<List<Booking>>();
				structure.setStatusCode(HttpStatus.OK.value());
				structure.setData(bookings);
				structure.setMessage("Success");

				return new ResponseEntity<ResponseStructure<List<Booking>>>(structure, HttpStatus.OK);
			} else {
				throw new NoSuchBookingFoundException();
			}
		} else {
			throw new NoSuchUserFoundException();
		}
	}

	public ResponseEntity<ResponseStructure<List<Booking>>> findBookingByCourtId(int courtId) {
		Court court = courtDao.findCourtById(courtId);
		if (court != null) {
			List<Booking> bookings = court.getBookings();
			if (bookings != null) {
				ResponseStructure<List<Booking>> structure = new ResponseStructure<List<Booking>>();
				structure.setStatusCode(HttpStatus.OK.value());
				structure.setData(bookings);
				structure.setMessage("Success");

				return new ResponseEntity<ResponseStructure<List<Booking>>>(structure, HttpStatus.OK);
			} else {
				throw new NoSuchBookingFoundException();
			}
		} else {
			throw new NoSuchCourtFoundException();
		}
	}

}
