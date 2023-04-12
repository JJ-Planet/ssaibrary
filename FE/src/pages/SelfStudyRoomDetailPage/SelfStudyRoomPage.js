import React from "react";
import Header from "../ReservationListPage/ReservationListHeader";
import Main from "./SelfStudyRoom";
import Footer from "../MainPage/Footer";
import "./NoticePage.css";


const SelfStudyRoomPage = () => {
  return (
    <div className="NoticePage">
      <Header />
      <Main />
      <Footer />
    </div>
  );
};

export default SelfStudyRoomPage;
 