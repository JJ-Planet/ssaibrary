import React from "react";
import Header from "./ReservationListHeader";
import Main from "./ReservationListMain";
import Footer from "../MainPage/Footer";
import "./ReservationListPage.css";
const ReservationListPage = () => {
  return (
    <div className="ReservationListPage">
      <Header />
      <Main />
      <Footer />
    </div>
  );
};

export default ReservationListPage;
