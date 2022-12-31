import React from "react";
import Main from "../ReservationListPage/ReservationListMain";
import Footer from "./FastCheckFooter";
import "./FastCheckPage.css";
import LeftSeat from "../MainPage/LeftSeat";
const FastCheckPage = () => {
  return (
    <div className="FastCheckPage">
      <LeftSeat />
      <Main />
      <Footer />
    </div>
  );
};

export default FastCheckPage;
