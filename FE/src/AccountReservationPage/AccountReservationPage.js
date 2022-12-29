import React from "react";
import Header from "./AccountReservationHeader";
import Main from "./AccountReservationMain";
import Footer from "../MainPage/Footer";
import "./AccountReservationPage.css";
const AccountReservationPage = () => {
  return (
    <div className="AccountReservation">
      <Header />
      <Main />
      <Footer />
    </div>
  );
};

export default AccountReservationPage;
