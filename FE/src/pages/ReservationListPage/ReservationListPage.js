import React from "react";
import Header from "./ReservationListHeader";
import Main from "./ReservationListMain";
import Footer from "../MainPage/Footer";
import LeftSeat from "../../components/MainPage/LeftSeat";
import Floor from "../../components/Floor/Floor";
import "./ReservationListPage.css";
const ReservationListPage = () => {
  return (
    <div className="ReservationListPage">
      {/* <Header /> */}
      <LeftSeat />

      {/* 방 리스트를 불러온다. */}
      <Main />
      <Footer />
    </div>
  );
};

export default ReservationListPage;
