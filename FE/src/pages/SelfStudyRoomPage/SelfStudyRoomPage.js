import React from "react";
import Header from "../ReservationListPage/ReservationListHeader";
import RoomDetail from "../../components/SelfStudyRoom/RoomDetail";
import Footer from "../MainPage/Footer";

import styles from "./SelfStudyRoomPage.module.css";

const SelfStudyRoomPage = () => {
  return (
    <div className={styles.SelfStudyRoomPage}>
      <Header />
      <RoomDetail />
      <Footer />
    </div>
  );
};

export default SelfStudyRoomPage;
