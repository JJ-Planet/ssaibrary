import React from "react";
import Main from "../FastCheckPage/FastCheckMain";
import Footer from "./FastCheckFooter";
import "./FastCheckPage.css";
import LeftSeat from "../../components/MainPage/LeftSeat";

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
