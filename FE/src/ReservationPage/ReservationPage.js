import React from "react";
import Header from "./ReservationHeader";
import Main from "./ReservationMain";
import Footer from "../MainPage/Footer";
import "./Reservation.css";
const ReservationPage = () => {
  return (
    <div className="Reservation">
      <Header />
      <Main />
      <Footer />
    </div>
  );
};

export default ReservationPage;
