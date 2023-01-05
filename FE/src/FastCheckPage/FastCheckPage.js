import React from "react";
import Main from "../FastCheckPage/FastCheckMain";
import Footer from "./FastCheckFooter";
import "./FastCheckPage.css";
import LeftSeat from "../MainPage/LeftSeat";

// import { useSelector } from "react-redux";
const FastCheckPage = () => {
  // const floor = useSelector((state) => state.counter.value)
  // useEffect(() => {
  //   console.log("floor : " + floor);
  // });
  return (
    <div className="FastCheckPage">
      <LeftSeat />
      <Main />
      <Footer />
    </div>
  );
};

export default FastCheckPage;
