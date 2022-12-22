import React from "react";
import Header from "./ReservationHeader";
import Body from "./ReservationBody";
import Footer from "../MainPage/Footer";
import "./Reservation.css";
const Reservation = () => {
  return (
    <div className="Reservation">
      <Header />
      <Body />
      <Footer />
    </div>
  );
};

export default Reservation;
