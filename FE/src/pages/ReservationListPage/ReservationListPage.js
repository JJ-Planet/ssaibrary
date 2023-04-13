import React from "react";
import Header from "./ReservationListHeader";
import Main from "./ReservationListMain";
import Footer from "../MainPage/Footer";
import LeftSeat from "../../components/MainPage/LeftSeat";

import "./ReservationListPage.css";
const ReservationListPage = () => {
  return (
    <div className="ReservationListPage">
      {/* <Header /> */}
      <LeftSeat></LeftSeat>
      <Main />

      <Footer />
    </div>
  );
};

export default ReservationListPage;
